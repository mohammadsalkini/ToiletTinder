package at.asd.toilettinder.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadCSV2 {

    private static final String dateiname = "src/main/resources/Toilet_input/WCANLAGE2OGD.csv";
    private String line = "";
    private String[] tempArr;

    public void csv() throws IOException {
        FileReader reader = new FileReader(dateiname);
        BufferedReader csvReader = new BufferedReader(reader);

        line = csvReader.readLine();

        while (line != null) {
            String[] value = line.split(",");
            System.out.println(value);
            line = csvReader.readLine();

        }


        /*while (line != null) {
            String[] str = line.split(",");
            String fid = str[0];*/
    }
}
