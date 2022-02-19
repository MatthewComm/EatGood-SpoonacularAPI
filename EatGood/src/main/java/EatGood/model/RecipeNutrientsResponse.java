package EatGood.model;

import lombok.*;

import java.util.ArrayList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class RecipeNutrientsResponse {
    private String calories;
    private String carbs;
    private String fat;
    private String protein;
    private ArrayList<RecipeNutrientsResult> bad;
    private ArrayList<RecipeNutrientsResult> good;
}
