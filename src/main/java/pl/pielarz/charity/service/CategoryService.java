package pl.pielarz.charity.service;

import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.Category;

import java.util.List;

@Service
public interface CategoryService {
    List<Category> findAll();
    Category save(Category category);
    Category findById(long id);
    void deleteById(long id);
}
