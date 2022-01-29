package at.asd.toilettinder;

import at.asd.toilettinder.model.Toilet;
import at.asd.toilettinder.parser.ToiletParser;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import java.util.*;

@Configuration
@SpringBootApplication
public class ToiletTinderApplication {

    public static void main(String[] args) {
        SpringApplication.run(ToiletTinderApplication.class, args);
    }




}
