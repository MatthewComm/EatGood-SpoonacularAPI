package EatGood.repo;

import EatGood.model.RecipeResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepo extends JpaRepository<RecipeResult, Integer> {
}
