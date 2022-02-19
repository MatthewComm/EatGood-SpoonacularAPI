package EatGood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecipeNutrientsResult implements Serializable {
    private String title;
    private String amount;
    private boolean intended;
    private float percentOfDailyNeeds;
}
