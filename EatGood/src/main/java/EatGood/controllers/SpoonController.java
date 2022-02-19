package EatGood.controllers;

import EatGood.model.*;
import EatGood.service.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@Slf4j
public class SpoonController {
    private RecipeService recipeService;

    public SpoonController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    //Method that interacts with Spoonacular
        @GetMapping(path = "/search/{diet}/{intolerances}/{type}")
        public ResponseEntity<RecipeResponse> getRecipe(@PathVariable String diet, @PathVariable String intolerances, @PathVariable String type){
            log.info("***************CONTROLLER STARTING SEARCH****************");
            log.info(diet);
            HttpStatus status = HttpStatus.OK;

            RecipeResponse response = recipeService.SpoonRequestSearch(diet, intolerances, type);
            log.info(response.toString());
            return ResponseEntity.status(status).body(response); //returning to the front end
        }

    //Method to get a recipe summary from spoonacular
        @GetMapping(path = "/recipeSummary/{id}")
        public ResponseEntity<RecipeSummary> getRecipeSummary(@PathVariable String id){
            log.info("****************CONTROLLER STARTING SUMMARY*******************");
            log.info("ID: " + id);
            HttpStatus status = HttpStatus.OK;

            RecipeSummary recipeSummary = recipeService.SpoonRequestSummary(id);
            return ResponseEntity.status(status).body(recipeSummary);
        }

    //Method for getting recipe nutrients
        @GetMapping(path = "/recipeNutrients/{id}")
        public ResponseEntity<RecipeNutrientsResponse> getRecipeNutrients(@PathVariable String id){
            log.info("***********CONTROLLER STARTING NUTRIENTS*************");
            HttpStatus status = HttpStatus.OK;

            RecipeNutrientsResponse response = recipeService.SpoonRequestNutrients(id);
            return ResponseEntity.status(status).body(response);
        }

    //Method for getting recipe ingredients
        @GetMapping(path = "/recipeIngredients/{id}")
        public ResponseEntity<IngredientsResponse> getIngredients(@PathVariable String id){
            log.info("*************CONTROLLER STARTING INGREDIENTS");
            HttpStatus status = HttpStatus.OK;
            IngredientsResponse response = recipeService.SpoonRequestIngredients(id);
            return ResponseEntity.status(status).body(response);
        }

    //Method for getting recipe instructions
        @GetMapping(path = "/recipeInstructions/{id}")
        public ResponseEntity<InstructionsResponse[]> getInstructions(@PathVariable String id){
            log.info("***************Controller starting INSTRUCTIONS*******************");
            HttpStatus status = HttpStatus.OK;
            InstructionsResponse[] response = recipeService.SpoonRequestSteps(id);
            return ResponseEntity.status(status).body(response);
        }
}
