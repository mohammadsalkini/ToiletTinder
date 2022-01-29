package at.asd.toilettinder.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/toilets")
public class ToiletResource {

    @GetMapping("/getToilet")
    public String getNearestToilet() {
        return "123";
    }



}
