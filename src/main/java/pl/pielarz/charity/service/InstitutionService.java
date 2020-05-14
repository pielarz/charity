package pl.pielarz.charity.service;

import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.Institution;

import java.util.List;
import java.util.Optional;

@Service
public interface InstitutionService {
    List<Institution> findAll();
    Institution save(Institution institution);
    Institution findById(long id);
    void deleteById(long id);
}
