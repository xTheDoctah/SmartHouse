package it.xthedoctah.spring.common;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import it.xthedoctah.spring.dto.TemperatureDTO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class ParserClass {

    public static void jsonToCsv(TemperatureDTO json, String[] header, String fileName) {
        try {
            CSVWriter csvWriter = csvWriter(fileName);
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            if (br.readLine() != null) {
                csvWriter.writeNext(json.record());
            } else {
                csvWriter.writeNext(header);
                csvWriter.writeNext(json.record());
            }
            csvWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int roomAmount() {
        try {
            if (Files.exists(CommonsValue.ROOM_LIST_CSV_PATH)) {
                CSVReader csvReader = new CSVReader(Files.newBufferedReader(CommonsValue.ROOM_LIST_CSV_PATH));
                return csvReader.readAll().size();
            }else{
                Files.createFile(CommonsValue.ROOM_LIST_CSV_PATH);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public static List<String[]> roomList() {
        try {
            if (Files.exists(CommonsValue.ROOM_LIST_CSV_PATH)) {
                CSVReader csvReader = new CSVReader(Files.newBufferedReader(Paths.get(CommonsValue.ROOM_LIST_CSV)));
                List<String[]> roomList = csvReader.readAll();
                for (String[] record : roomList) {
                    //System.out.println(record[0].toString());
                }
                return roomList;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;

    }

    private static CSVWriter csvWriter(String fileName) throws IOException {
        CSVWriter csvWriter = new CSVWriter(new FileWriter(fileName, true),
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        return csvWriter;
    }

}
