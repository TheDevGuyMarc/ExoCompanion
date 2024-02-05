package de.traumastudios.ExoCompanionAPI.category.controller;

import de.traumastudios.ExoCompanionAPI.category.domain.Category;
import de.traumastudios.ExoCompanionAPI.category.service.CategoryService;
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
@RequestMapping("/categories")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDTO> list() {
        return this.categoryService.findAllCategories()
                .stream()
                .map(CategoryDTO::new)
                .toList();
    }

    @GetMapping("/{id}")
    public CategoryDTO read(@PathVariable @Min(1) Long id) {
        return this.categoryService.findCategoryById(id)
                .map(CategoryDTO::new)
                .orElseThrow();
    }

    @GetMapping("/{name}")
    public CategoryDTO readByName(@PathVariable @NotBlank String name) {
        return this.categoryService.findCategoryByName(name)
                .map(CategoryDTO::new)
                .orElseThrow();
    }

    @PostMapping
    public CategoryDTO create(@RequestBody @Valid @NotNull @NotEmpty Category category) {
        return new CategoryDTO(this.categoryService.createCategory(category));
    }

    @PutMapping("/{id}")
    public CategoryDTO update(@PathVariable @Min(1) Long id, @RequestBody @Valid @NotNull @NotEmpty Category category) {
        return new CategoryDTO(this.categoryService.updateCategory(id, category));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable @Min(1) Long id) {
        this.categoryService.deleteCategory(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
