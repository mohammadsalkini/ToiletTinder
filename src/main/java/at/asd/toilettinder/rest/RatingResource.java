package at.asd.toilettinder.rest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ratings")
public class RatingResource {

    @PostMapping
    public void createRating() {
    //emtpy
    }
}
