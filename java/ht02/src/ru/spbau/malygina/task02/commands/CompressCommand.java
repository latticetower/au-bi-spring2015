package ru.spbau.malygina.task02.commands;

import ru.spbau.malygina.task02.util.StreamUtils;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;


public class CompressCommand implements ArchiveCommand {

    private static final String HTTP_PREFIX = "http://";

    private final File targetFile;
    private final List<String> sources;
    private DataOutputStream stream;

    public CompressCommand(String file, List<String> sources) {
        this.targetFile = new File(file);
        this.sources = new ArrayList<String>(sources);
    }

    @Override
    public void run() throws IOException {

        // todo: check if we can create output file

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // todo: substitute with FileOutputStream wrapped in ZipInputStream
        stream = new DataOutputStream(out);

        for (String source : sources) {
            if (source.startsWith(HTTP_PREFIX)) {
                addUrl(new URL(source));
            } else {
                File file = new File(source);
                if (file.isFile()) {
                    addFile(file);
                } else if (file.isDirectory()) {
                    addDir(file);
                } else {
                    System.out.println("Warning: Source file not found: " + source);
                }
            }
        }

        stream.close();
        byte[] bytes = out.toByteArray();
        System.out.println(new String(bytes));

        ByteArrayInputStream in = new ByteArrayInputStream(bytes);
        DataInputStream din = new DataInputStream(in);

        System.out.println("-------------------------------");

        while (din.available() > 0) {
            String localFilename = din.readUTF();
            System.out.println(localFilename);

            long size = din.readLong();
            System.out.println(size);
            byte[] fileData = new byte[(int) size]; // todo: bad cast

            din.readFully(fileData);
            System.out.println(new String(fileData));
        }

    }

    private void addFile(File file) {
        addFile(file, file.toPath());
    }

    private void addFile(File file, Path localRoot) {
        try {
            String relativeFilePath = localRoot.relativize(file.toPath()).toString();
            stream.writeUTF(relativeFilePath);
            stream.writeLong(file.length());
            Files.copy(file.toPath(), stream);
        } catch (IOException e) {
            e.printStackTrace(); // todo: handle this
        }
    }

    private void addDir(File dir) {
        addDir(dir, dir.toPath());
    }

    private void addDir(File dir, Path localRoot) {
        for (File f : dir.listFiles()) {
            if (f.isFile()) {
                addFile(f, localRoot);
            } else if (f.isDirectory()) {
                addDir(f, localRoot);
            }
        }
    }

    private void addUrl(URL url) {
        try {
            String filename = "http/" + url.toString().substring(HTTP_PREFIX.length()).replaceAll("/", "_");
            stream.writeUTF(filename);
            URLConnection urlConnection = url.openConnection();
            long length = urlConnection.getContentLengthLong();
            stream.writeLong(length);
            InputStream inputStream = urlConnection.getInputStream();
            StreamUtils.copyStream(inputStream, stream);
        } catch (IOException e) {
            e.printStackTrace(); // todo: handle this
        }
    }

}
