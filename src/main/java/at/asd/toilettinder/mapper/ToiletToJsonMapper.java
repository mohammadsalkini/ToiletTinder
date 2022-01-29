package at.asd.toilettinder.mapper;

import at.asd.toilettinder.model.Rating;
import at.asd.toilettinder.model.Toilet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class ToiletToJsonMapper {

    public static final String TOILET_ID = "id";
    public static final String TOILET_NAME = "name";
    public static final String TOILET_OPENING_HOURS = "openingHours";
    public static final String TOILET_LOCATION = "location";
    public static final String TOILET_RATINGS = "ratings";

    public static final String LOCATION_LATITUDE = "latitude";
    public static final String LOCATION_LONGITUDE = "longitude";

    public static final String RATING_ID = "id";
    public static final String RATING_GRADE = "grade";
    public static final String RATING_TEXT = "text";
    public static final String RATING_CREATION_DATE = "creatingDate";

    private ToiletToJsonMapper() {
        throw new IllegalStateException("Mapper class");
    }

    public static JSONObject map(Toilet toilet){
        JSONObject toiletJson = new JSONObject();
        toiletJson.put(TOILET_ID,toilet.getId());
        toiletJson.put(TOILET_NAME, toilet.getName());
        toiletJson.put(TOILET_OPENING_HOURS, toilet.getOpeningTime());
        toiletJson.put(TOILET_LOCATION, getLocationJSON(toilet));
        toiletJson.put(TOILET_RATINGS, getRatingJSON(toilet));
        return toiletJson;
    }

    private static JSONObject getLocationJSON(Toilet toilet) {
        JSONObject locationJson = new JSONObject();
        locationJson.put(LOCATION_LATITUDE, toilet.getLatitude());
        locationJson.put(LOCATION_LONGITUDE, toilet.getLongitude());
        return locationJson;
    }

    private static JSONArray getRatingJSON(Toilet toilet){
        if (toilet.getRatings() == null){
            return new JSONArray();
        }

        JSONArray ratings = new JSONArray();
        for (Rating rating : toilet.getRatings()){
            JSONObject ratingJson = new JSONObject();
            ratingJson.put(RATING_ID, rating.getId());
            ratingJson.put(RATING_GRADE, rating.getStars());
            ratingJson.put(RATING_TEXT, rating.getComment());
            ratingJson.put(RATING_CREATION_DATE, rating.getCreationDate());
            ratings.add(ratingJson);
        }
        return ratings;
    }

}
