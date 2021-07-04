package guru.springframework.domain;

import lombok.*;

import java.util.Set;

@Data
@EqualsAndHashCode(exclude = {"recipes"})
public class Category {

    private Long id;
    private String description;
    private Set<Recipe> recipes;

}
