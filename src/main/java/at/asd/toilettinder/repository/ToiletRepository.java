package at.asd.toilettinder.repository;

import at.asd.toilettinder.model.Toilet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ToiletRepository extends JpaRepository<Toilet, Long> {
    Toilet findById(long id);
}
