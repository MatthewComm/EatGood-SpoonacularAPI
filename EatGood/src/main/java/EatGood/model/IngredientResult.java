package EatGood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class IngredientResult implements Serializable {
    private String image;
    private String name;
    private Amount amount;
}