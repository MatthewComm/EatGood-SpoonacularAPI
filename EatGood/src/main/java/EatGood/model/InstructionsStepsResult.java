package EatGood.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class InstructionsStepsResult implements Serializable {
    private String step;
    private String number;
    private ArrayList<EquipmentResult> equipment;
    private ArrayList<EquipmentResult> ingredients;
}
