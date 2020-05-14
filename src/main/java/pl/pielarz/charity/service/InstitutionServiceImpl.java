package pl.pielarz.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.Institution;
import pl.pielarz.charity.repository.InstitutionRepository;

import java.util.List;

@Service
public class InstitutionServiceImpl implements InstitutionService {

    @Autowired
    InstitutionRepository institutionRepository;

    @Override
    public List<Institution> findAll() {
        return institutionRepository.findAll();
    }

    @Override
    public Institution save(Institution institution) {
        return institutionRepository.save(institution);
    }

    @Override
    public Institution findById(long id) {

        return institutionRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteById(long id) {
        institutionRepository.deleteById(id);
    }
}
