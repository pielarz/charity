package pl.pielarz.charity.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pielarz.charity.model.Category;
import pl.pielarz.charity.repository.CategoryRepository;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(long id) {
        return categoryRepository.findById(id)
                .orElse(null);
    }

    @Override
    public void deleteById(long id) {
        categoryRepository.deleteById(id);
    }
}
