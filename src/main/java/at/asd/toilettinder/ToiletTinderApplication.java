package at.asd.toilettinder;

import at.asd.toilettinder.service.ReadCSV2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;

@Configuration
@SpringBootApplication
public class ToiletTinderApplication {

    public static void main(String[] args) throws IOException {
//        ReadCSV2 readcsv2 = new ReadCSV2();
//        readcsv2.csv();


        SpringApplication.run(ToiletTinderApplication.class, args);
    }


}
