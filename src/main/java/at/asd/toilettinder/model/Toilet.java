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
    private boolean payed;
    private String freeEntryTime;

    @OneToMany(mappedBy="toilet", fetch = FetchType.EAGER)
    private Set<Rating> ratings;

    public Toilet(@NonNull String name, @NonNull String longitude, @NonNull String latitude, @NonNull int district, @NonNull String openingTime, boolean payed, String freeEntryTime) {
        this.name = name;
        this.longitude = longitude;
        this.latitude = latitude;
        this.district = district;
        this.openingTime = openingTime;
        this.payed = payed;
        this.freeEntryTime = freeEntryTime;
    }
}
