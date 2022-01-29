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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NonNull
    private String stars;
    @NonNull
    private String comment;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "toilet_id", nullable = false)
    private Toilet toilet;
    @Temporal(TemporalType.TIMESTAMP)
    private Calendar creationDate = Calendar.getInstance();
}
