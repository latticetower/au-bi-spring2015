package ru.spbau.malygina.task02.util;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by T.Malygina on 16.03.15.
 */
public final class StreamUtils {

    public static final int BUF_SIZE = 1024 * 1024;

    private StreamUtils() {}

    public static void copyStream(InputStream input, OutputStream output) throws IOException
    {
        byte[] buffer = new byte[BUF_SIZE];
        int bytesRead;
        while ((bytesRead = input.read(buffer)) != -1)
        {
            output.write(buffer, 0, bytesRead);
        }
    }
}
