package at.asd.toilettinder.model;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Rating {

    @Id
    @Column(name = "rating_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NonNull
    private String stars;
    @NonNull
    private String comment;
    @ManyToOne
    @JoinColumn(name = "toilet_id", nullable = false)
    private Toilet toilet;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate;

    public Rating(String stars, String comment, Toilet toilet, Calendar creationDate) {
        this.stars = stars;
        this.comment = comment;
        this.toilet = toilet;
        this.creationDate = creationDate;

    }
}
