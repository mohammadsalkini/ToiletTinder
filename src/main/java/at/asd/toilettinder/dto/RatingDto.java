package at.asd.toilettinder.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class RatingDto {
    private String stars;
    private String comment;
}
