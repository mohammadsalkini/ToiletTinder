package at.asd.toilettinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@Getter
@Setter
public class DistanceToiletDto {

    private double longitude;
    private double latitude;
    private List<Long> toiletIdsToSkip;

}
