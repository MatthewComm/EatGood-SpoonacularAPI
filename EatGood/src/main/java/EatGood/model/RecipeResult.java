package EatGood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.redis.core.RedisHash;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@RedisHash("recipe")
@NoArgsConstructor
@Entity
@AllArgsConstructor
@Data
public class RecipeResult implements Serializable {
    @Id
    private Integer id;
    private String title;
    private String image;
    private String imageType;

}
