package EatGood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EquipmentResult implements Serializable {
    private String id;
    private String image;
    private String localizedName;
    private String name;
}
