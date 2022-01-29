package at.asd.toilettinder.resource;

import at.asd.toilettinder.dto.DistanceToiletDto;
import at.asd.toilettinder.mapper.ToiletToJsonMapper;
import at.asd.toilettinder.model.Toilet;
import at.asd.toilettinder.service.ToiletService;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.Distance;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toilets")
public class ToiletResource {

    private ToiletService toiletService;

    @PostMapping("/getNearestThreeToilets")
    public JSONArray getNearestToilet(@RequestBody DistanceToiletDto distanceToiletDto) {
        JSONArray result = new JSONArray();
        List<Toilet> toilets = toiletService.getNearestThreeToilets(distanceToiletDto.getLongitude(), distanceToiletDto.getLatitude(), distanceToiletDto.getToiletIdstoSkip());
        toilets.forEach(t -> result.add(ToiletToJsonMapper.map(t)));
        return result;
    }

    @Autowired
    public void setToiletService(ToiletService toiletService) {
        this.toiletService = toiletService;
    }
}
