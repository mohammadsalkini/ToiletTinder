package at.asd.toilettinder.service;

import at.asd.toilettinder.dto.RatingDto;
import at.asd.toilettinder.model.Rating;
import at.asd.toilettinder.repository.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RatingService {

    private RatingRepository ratingRepository;

    public Rating createRating(RatingDto ratingDto) {
        //Rating rating = new Rating(stars, comment);
        Rating rating = new Rating();
        return ratingRepository.save(rating);
    }

    @Autowired
    public void setRatingRepository(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }
}
