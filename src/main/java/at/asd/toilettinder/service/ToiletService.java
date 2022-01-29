package at.asd.toilettinder.service;

import at.asd.toilettinder.container.ToiletDistanceContainer;
import at.asd.toilettinder.model.Toilet;
import at.asd.toilettinder.repository.ToiletRepository;
import org.apache.lucene.util.SloppyMath;
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
        if (!toiletIdsToSkip.isEmpty()){
            removeToilets(toilets, toiletIdsToSkip);
        }
        for (Toilet toilet : toilets) {
            double distanceToToilet = distance(latitude, Double.parseDouble(toilet.getLatitude()), longitude, Double.parseDouble(toilet.getLongitude()));
            toiletDistanceContainers.add(new ToiletDistanceContainer(distanceToToilet, toilet));
        }
        List<ToiletDistanceContainer> sortedContainer = toiletDistanceContainers.stream().sorted(Comparator.comparingDouble(ToiletDistanceContainer::getDistance)).collect(Collectors.toList());
        sortedContainer = sortedContainer.subList(0, 3);
        List<Toilet> result = new ArrayList<>();
        sortedContainer.forEach(c -> result.add(c.getToilet()));
        return result;
    }

    private void removeToilets(List<Toilet> allToilets, List<Long> idsToRemove) {
        idsToRemove.forEach(id -> toiletRepository.findById(id).ifPresent(allToilets::remove));
    }

    private static double distance(double lat1, double lat2, double lon1, double lon2) {
        return SloppyMath.haversinMeters(lat1, lon1, lat2, lon2);
    }

    @Autowired
    public void setToiletRepository(ToiletRepository toiletRepository) {
        this.toiletRepository = toiletRepository;
    }
}
