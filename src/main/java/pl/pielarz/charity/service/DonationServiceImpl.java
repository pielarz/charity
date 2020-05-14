package pl.pielarz.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.Donation;
import pl.pielarz.charity.repository.DonationRepository;

import java.util.List;

@Service
public class DonationServiceImpl implements DonationService {

    @Autowired
    DonationRepository donationRepository;

    @Override
    public List<Donation> findAll() {
        return donationRepository.findAll();
    }

    @Override
    public Donation save(Donation donation) {
        return donationRepository.save(donation);
    }

    @Override
    public Donation findById(long id) {
        return donationRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteById(long id) {
        donationRepository.deleteById(id);
    }

    @Override
    public Integer totalQuantityOfBags() {
        return donationRepository.totalQuantityOfBags();
    }
}
