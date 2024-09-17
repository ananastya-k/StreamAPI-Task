package by.clevertec.utils;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

public class TestUtils {

    public static String catchSystemOut(Runnable runnable){

        PrintStream consoleStream = System.out;
        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream newStream = new PrintStream(output);

        System.setOut(newStream);

        try{
            runnable.run();
        } finally {
            System.setOut(consoleStream);
        }

        return output.toString();

    }
}
