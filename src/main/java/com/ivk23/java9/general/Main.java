package main.java.com.ivk23.java9.general;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        // As of release 9, '_' is a keyword, and may not be used as an identifier
        // int _ = 4;

        // try-with-resources
        BufferedReader reader = new BufferedReader(new FileReader("test.txt"));

        try (reader) {
            // read :)
        }
    }
}
