package at.asd.toilettinder.service;

import at.asd.toilettinder.dto.RatingDto;
import at.asd.toilettinder.model.Rating;
import at.asd.toilettinder.model.Toilet;
import at.asd.toilettinder.repository.RatingRepository;
import at.asd.toilettinder.repository.ToiletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private RatingRepository ratingRepository;
    private ToiletRepository toiletRepository;

    public Rating createRating(RatingDto ratingDto) {
        Toilet toilet = toiletRepository.findById(ratingDto.getToiletId());
        Rating rating = new Rating(ratingDto.getStars(), ratingDto.getComment(), toilet);
        return ratingRepository.save(rating);
    }

    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Autowired
    public void setToiletRepository(ToiletRepository toiletRepository) {
        this.toiletRepository = toiletRepository;
    }
}
