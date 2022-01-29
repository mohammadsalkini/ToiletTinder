package at.asd.toilettinder.container;

import at.asd.toilettinder.model.Toilet;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class ToiletDistanceContainer {
    private  double distance;
    private Toilet toilet;
}
