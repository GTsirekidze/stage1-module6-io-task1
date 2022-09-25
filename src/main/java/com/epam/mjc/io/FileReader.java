package com.epam.mjc.io;

import java.io.BufferedReader;
import java.io.File;

public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] splittedLine = line.split(" ");
                switch (splittedLine[0]) {
                    case "Name:":
                        profile.setName(splittedLine[1]);
                        break;
                    case "Age:":
                        profile.setAge(Integer.parseInt(splittedLine[1]));
                        break;
                    case "Email:":
                        profile.setEmail(splittedLine[1]);
                        break;
                    case "Phone:":
                        profile.setPhone(Long.valueOf(splittedLine[1]));
                        break;
                    default:
                        System.err.println("Wrong key");

                }
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return null;
        }

        return profile;
    }
}
