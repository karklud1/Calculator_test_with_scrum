package com.example.calculator.dal;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HistoryDAO {
    private String filePath = String.valueOf(Path.of("history.txt"));

    public void writeToFile(String string) throws IOException {
        try {
            FileWriter fw = new FileWriter(filePath, true);
            fw.write("\n"+string);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<String> readFromFile() throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        try (Scanner sc = new Scanner(new File(filePath))) {
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                lines.add(line);
            }
            return lines;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            throw new FileNotFoundException();
        }
    }
}
