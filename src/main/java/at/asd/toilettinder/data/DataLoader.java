package at.asd.toilettinder.data;

import at.asd.toilettinder.model.Toilet;
import at.asd.toilettinder.parser.ToiletParser;
import at.asd.toilettinder.repository.ToiletRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    private ToiletRepository repository;

    public DataLoader(ToiletRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<Toilet> toilets = ToiletParser.asList("src/main/resources/Toilet_input/WCANLAGE2OGD.csv");
        repository.saveAll(toilets);
    }
}
