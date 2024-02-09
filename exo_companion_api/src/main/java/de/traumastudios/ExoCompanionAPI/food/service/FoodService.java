package de.traumastudios.ExoCompanionAPI.food.service;

import de.traumastudios.ExoCompanionAPI.food.domain.Food;
import de.traumastudios.ExoCompanionAPI.food.exception.FoodNotFoundException;
import de.traumastudios.ExoCompanionAPI.food.repository.FoodEntity;
import de.traumastudios.ExoCompanionAPI.food.repository.FoodRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FoodService {
    private final FoodRepository foodRepository;

    public FoodService(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> findAllFoods() {
        return this.foodRepository.findAll()
                .stream()
                .map(Food::new)
                .toList();
    }

    public Optional<Food> findFoodById(Long id) {
        return this.foodRepository.findById(id)
                .map(Food::new);
    }

    public Optional<Food> findFoodByName(String name) {
        return this.foodRepository.findByName(name)
                .map(Food::new);
    }

    public Food createFood(Food food) {
        return new Food(this.foodRepository.saveAndFlush(new FoodEntity(food)));
    }

    public Food updateFood(Long id, Food food) {
        Optional<Food> existingElement = this.foodRepository.findById(id)
                .map(Food::new);

        if (existingElement.isPresent()) {
            Food updatedElement = existingElement.get();
            updatedElement.setId(food.getId());
            updatedElement.setName(food.getName());
            updatedElement.setDescription(food.getDescription());
            updatedElement.setImage(food.getImage());
            updatedElement.setManufacturer(food.getManufacturer());
            updatedElement.setAmount(food.getAmount());
            updatedElement.setPrice(food.getPrice());
            updatedElement.setAnimals(food.getAnimals());

            return new Food(this.foodRepository.saveAndFlush(new FoodEntity(updatedElement)));
        }
        else {
            throw new FoodNotFoundException("Could not find a food with id: " + id);
        }
    }

    public void deleteFood(Long id) {
        this.foodRepository.deleteById(id);
    }
}
