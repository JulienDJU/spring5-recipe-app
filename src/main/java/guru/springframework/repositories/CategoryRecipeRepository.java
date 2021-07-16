package guru.springframework.repositories;

import guru.springframework.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * Created by jt on 6/13/17.
 */
public interface CategoryRecipeRepository extends CrudRepository<Category, String> {

    Optional<Category> findByDescription(String description);
}
