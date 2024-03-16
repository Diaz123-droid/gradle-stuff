package com.inventorymanagementsystem.ims;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

@SuppressWarnings("unused")
public class Main {
    public static void main(String[] args) throws IOException {
        // String language = args[0]; // Take the first argument from cmd

        // InputStream resourceStream =
        // Main.class.getClassLoader().getResourceAsStream(language + ".txt");
        // assert resourceStream != null;
        // BufferedReader bufferedInputStream = new BufferedReader(new
        // InputStreamReader(resourceStream, StandardCharsets.UTF_8));

        // System.out.println(bufferedInputStream.readLine());

        // Create a GUI
        new Frame(); // Create the main frame
    }
}