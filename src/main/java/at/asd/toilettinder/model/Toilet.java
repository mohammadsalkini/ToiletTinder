package at.asd.toilettinder.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Toilet {
    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String longitude;
    @NonNull
    private String latitude;
    @NonNull
    private int district;
    @NonNull
    private String openingTime;
    @NonNull
    private boolean payed;

    @OneToMany(mappedBy="toilet", fetch = FetchType.EAGER)
    private Set<Rating> ratings;
}
