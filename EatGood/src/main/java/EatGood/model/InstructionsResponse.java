package EatGood.model;

import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Data
public class InstructionsResponse implements Serializable{
    private String name;
    private ArrayList<InstructionsStepsResult> steps;
}
