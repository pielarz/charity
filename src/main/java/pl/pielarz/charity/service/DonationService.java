package pl.pielarz.charity.service;

import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.Donation;


import java.util.List;

@Service
public interface DonationService {
    List<Donation> findAll();
    Donation save(Donation donation);
    Donation findById(long id);
    void deleteById(long id);
    Integer totalQuantityOfBags();
}
