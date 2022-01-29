package at.asd.toilettinder.service;

import at.asd.toilettinder.container.ToiletDistanceContainer;
import at.asd.toilettinder.model.Toilet;
import at.asd.toilettinder.repository.ToiletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ToiletService {

    private ToiletRepository toiletRepository;

    public List<Toilet> getNearestThreeToilets(double longitude, double latitude, List<Long> toiletIdsToSkip) {
        List<ToiletDistanceContainer> toiletDistanceContainers = new ArrayList<>();
        List<Toilet> toilets = toiletRepository.findAll();
        for (Toilet toilet : toilets) {
            double distanceToToilet = distance(latitude, Double.parseDouble(toilet.getLatitude()), longitude, Double.parseDouble(toilet.getLongitude()));
            toiletDistanceContainers.add(new ToiletDistanceContainer(distanceToToilet, toilet));
        }

        toiletDistanceContainers.stream().sorted(Comparator.comparingDouble(ToiletDistanceContainer::getDistance)).collect(Collectors.toList());
        List<Toilet> result = new ArrayList<>();
        toiletDistanceContainers.subList(0, 2).forEach(c -> result.add(c.getToilet()));
        return result;
    }

    private static double distance(double lat1, double lat2, double lon1, double lon2) {
        double el1 = 0.0;
        double el2 = 0.0;
        final int R = 6371; // Radius of the earth

        double latDistance = Math.toRadians(lat2 - lat1);
        double lonDistance = Math.toRadians(lon2 - lon1);
        double a = Math.sin(latDistance / 2) * Math.sin(latDistance / 2)
                + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2))
                * Math.sin(lonDistance / 2) * Math.sin(lonDistance / 2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double distance = R * c * 1000; // convert to meters

        double height = el1 - el2;

        distance = Math.pow(distance, 2) + Math.pow(height, 2);

        return Math.sqrt(distance);
    }

    @Autowired
    public void setToiletRepository(ToiletRepository toiletRepository) {
        this.toiletRepository = toiletRepository;
    }
}
