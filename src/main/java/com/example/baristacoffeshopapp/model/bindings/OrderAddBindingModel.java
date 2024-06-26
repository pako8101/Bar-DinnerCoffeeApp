package com.example.baristacoffeshopapp.model.bindings;

import com.example.baristacoffeshopapp.model.entities.enums.CategoryNameEnum;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class OrderAddBindingModel {
    @Size(min = 3,max = 20)
    @NotNull
    private String name;
    @Positive
    private BigDecimal price;
    @PastOrPresent
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime orderTime;
    @NotNull
    private CategoryNameEnum category;
    @Size(min = 5)
    private String description;
}
