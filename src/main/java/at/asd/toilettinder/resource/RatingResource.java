package at.asd.toilettinder.resource;

import at.asd.toilettinder.dto.RatingDto;
import at.asd.toilettinder.service.RatingService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    private RatingService ratingService;

    public RatingResource(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    @CrossOrigin
    @PostMapping("/createRating")
    public void createRating(@RequestBody RatingDto ratingDto) {
        ratingService.createRating(ratingDto);
    }
}
