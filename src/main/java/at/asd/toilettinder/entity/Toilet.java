package at.asd.toilettinder.entity;


import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Toilet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull private int longitude;
    @NonNull private int latitude;
    @NonNull private int district;
    @NonNull private String openingTime;
    @NonNull private boolean payed;
}
