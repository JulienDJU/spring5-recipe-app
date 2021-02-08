package guru.springframework.domain;

import java.util.Set;

public class Category {

    private Long id;
    private String description;

    private Set<Recipe> recipes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
