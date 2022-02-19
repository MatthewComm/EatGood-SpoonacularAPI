package EatGood.model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class IngredientsResponse implements Serializable {
    private ArrayList<IngredientResult> ingredients;
}
