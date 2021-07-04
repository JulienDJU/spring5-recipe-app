package guru.springframework.domain;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

@Data
@EqualsAndHashCode(exclude = {"recipe"})
@Slf4j
public class Notes {

    private String id;
    private Recipe recipe;
    private String recipeNotes;

}
