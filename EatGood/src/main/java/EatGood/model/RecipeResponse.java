package EatGood.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class RecipeResponse implements Serializable {
    private ArrayList<RecipeResult> results;
    private int offset;
    private int number;
    private int totalResults;

}
