package utils;

import exceptions.ArquivoNaoEncontradoException;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class LeitorCsv {

    public static List<String[]> readCsv(String filepath) throws IOException {
        List<String[]> records = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filepath))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");
                for (int i = 0; i < values.length; i++) {
                    values[i] = values[i].trim();
                }
                records.add(values);
            }
        } catch (IOException e) {
            throw new ArquivoNaoEncontradoException(filepath);
        }
        return records;
    }
}
