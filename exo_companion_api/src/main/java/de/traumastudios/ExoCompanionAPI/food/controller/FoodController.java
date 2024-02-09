package de.traumastudios.ExoCompanionAPI.food.controller;

import de.traumastudios.ExoCompanionAPI.food.domain.Food;
import de.traumastudios.ExoCompanionAPI.food.service.FoodService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/foods")
public class FoodController {
    private final FoodService foodService;

    public FoodController(FoodService foodService) {
        this.foodService = foodService;
    }

    @GetMapping
    public List<FoodDTO> list() {
        return this.foodService.findAllFoods()
                .stream()
                .map(FoodDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public FoodDTO read(@PathVariable @Min(1) Long id) {
        return this.foodService.findFoodById(id)
                .map(FoodDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public FoodDTO readByName(@PathVariable @NotBlank String name) {
        return this.foodService.findFoodByName(name)
                .map(FoodDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public FoodDTO create(@RequestBody @Valid @NotNull @NotEmpty Food food) {
        return new FoodDTO(this.foodService.createFood(food));
    }

    @PutMapping("/{id}")
    public FoodDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Food food) {
        return new FoodDTO(this.foodService.updateFood(id, food));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.foodService.deleteFood(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
