package com.donch.task;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Util {
    public static String getInput(String fileName) {
        StringBuilder sb = new StringBuilder();
        try {
            Scanner scanner = new Scanner(new File(fileName), "UTF-8");
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append(System.lineSeparator());
            }
            scanner.close();
        } catch (IOException ex) {
            System.out.println("IO exception");
        }
        return sb.toString().trim();
    }
}
