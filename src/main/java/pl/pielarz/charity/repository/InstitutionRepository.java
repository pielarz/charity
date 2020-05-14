package pl.pielarz.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.pielarz.charity.model.Institution;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
