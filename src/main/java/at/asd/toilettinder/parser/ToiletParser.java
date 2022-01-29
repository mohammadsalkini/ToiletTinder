package at.asd.toilettinder.parser;

import at.asd.toilettinder.model.Toilet;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ToiletParser {

    private ToiletParser() {
    }

    @SuppressWarnings("squid:S2095")
    public static List<Toilet> asList(String path) {
        try {
            return Files.lines(Paths.get(path))
                    .skip(1)
                    .map(line -> line.split(";"))
                    .map(ToiletParser::toToilet)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @SuppressWarnings("squid:S5361")
    private static Toilet toToilet(String[] columns) {
        String name = (!columns[6].isEmpty()) ? columns[6] : columns[5];
        String point = columns[2].replaceAll("POINT \\(", "").replace(")", "");
        String longitude = point.split(" ")[0];
        String latitude = point.split(" ")[1];
        int district = Integer.parseInt(columns[4]);
        String openingTime = columns[9];
        boolean payed = columns [11].contains("nein");
        String freeEntryTime = (!columns [11].contains("nein")) ? columns [11].replaceAll(" - gratis", "") : "";

        return new Toilet(name, longitude, latitude, district, openingTime, payed, freeEntryTime);
    }
}
