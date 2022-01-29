package at.asd.toilettinder.resource;

import at.asd.toilettinder.dto.RatingDto;
import at.asd.toilettinder.model.Rating;
import at.asd.toilettinder.service.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    private RatingService ratingService;

    public RatingResource(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @PostMapping("/createRating")
    public void createRating(@RequestBody RatingDto ratingDto) {
        ratingService.createRating(ratingDto);
    }
}
