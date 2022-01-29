package at.asd.toilettinder.resource;

import at.asd.toilettinder.mapper.ToiletToJsonMapper;
import at.asd.toilettinder.model.Toilet;
import at.asd.toilettinder.service.ToiletService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/toilets")
public class ToiletResource {

    private ToiletService toiletService;

    @GetMapping("/getNearestThreeToilets")
    public JSONArray getNearestToilet() {
        JSONArray result = new JSONArray();
        List<Toilet> toilets = toiletService.getNearestThreeToilets(12.0, 12.0, null);
        toilets.forEach(t -> result.add(ToiletToJsonMapper.map(t)));
        return result;
    }

    @Autowired
    public void setToiletService(ToiletService toiletService) {
        this.toiletService = toiletService;
    }
}
