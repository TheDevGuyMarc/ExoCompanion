package de.traumastudios.ExoCompanionAPI.category.service;

import de.traumastudios.ExoCompanionAPI.category.domain.Category;
import de.traumastudios.ExoCompanionAPI.category.exception.CategoryNotFoundException;
import de.traumastudios.ExoCompanionAPI.category.repository.CategoryEntity;
import de.traumastudios.ExoCompanionAPI.category.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<Category> findAllCategories() {
        return this.categoryRepository.findAll()
                .stream()
                .map(Category::new)
                .toList();
    }

    public Optional<Category> findCategoryById(Long id) {
        return this.categoryRepository.findById(id)
                .map(Category::new);
    }

    public Optional<Category> findCategoryByName(String name) {
        return this.categoryRepository.findByName(name)
                .map(Category::new);
    }

    public Category createCategory(Category category) {
        return new Category(this.categoryRepository.saveAndFlush(new CategoryEntity(category)));
    }

    public Category updateCategory(Long id, Category category) {
        Optional<Category> existingCategory = this.categoryRepository.findById(id)
                .map(Category::new);

        if (existingCategory.isPresent()) {
            Category updatedElement = existingCategory.get();
            updatedElement.setId(category.getId());
            updatedElement.setName(category.getName());
            updatedElement.setDescription(category.getDescription());
            updatedElement.setPlants(category.getPlants());
            updatedElement.setLandAnimals(category.getLandAnimals());
            updatedElement.setAquaticAnimals(category.getAquaticAnimals());

            return new Category(this.categoryRepository.saveAndFlush(new CategoryEntity(updatedElement)));
        }
        else {
            throw new CategoryNotFoundException("Could not find a category with id: " + id);
        }
    }

    public void deleteCategory(Long id) {
        this.categoryRepository.deleteById(id);
    }
}
