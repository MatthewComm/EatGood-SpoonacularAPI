package EatGood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecipeSummary implements Serializable {
    private String id;
    private String summary;
    private String title;
}
