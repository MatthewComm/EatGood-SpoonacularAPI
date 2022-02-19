package EatGood.service;

import EatGood.model.*;
import EatGood.repo.RecipeRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RecipeService{
    private RestTemplate restTemplate = null;
    private final RecipeRepo recipeRepo;

    public RecipeService(RestTemplate restTemplate, RecipeRepo recipeRepo) {
        this.restTemplate = restTemplate;
        this.recipeRepo = recipeRepo;
    }

    //Method to return recipe response
        public RecipeResponse SpoonRequestSearch(String UserDiet, String UserIntolerances, String UserType){
            log.info("=================SERVER STARTING SEARCHING==================");
            log.info(UserDiet);
            String url = "https://api.spoonacular.com/recipes/complexSearch?apiKey=caaf6ff3cc614b248345f62936ac3f05&diet="+UserDiet+"&number=20"+"&intolerances="+
                    UserIntolerances+"&type="+UserType;
            RecipeResponse recipeResponse = restTemplate.getForObject(url, RecipeResponse.class);
            log.info(recipeResponse.toString());

            //Looping through ResultsList and saving it to the RecipeRepo
            for(int i = 0; i < recipeResponse.getResults().size(); i++){
                recipeRepo.save(recipeResponse.getResults().get(i));
                log.info(recipeResponse.getResults().get(i).getTitle());
            }

            log.info(recipeRepo.findAll().toString());
            return recipeResponse;
        }

      //Method to get a recipe summary
        public RecipeSummary SpoonRequestSummary(String recipeID){
            log.info("===================Server Starting SUMMARY===================");
            log.info("RECIPE ID: " + recipeID);
            String url = "https://api.spoonacular.com/recipes/"+recipeID+"/summary?apiKey=caaf6ff3cc614b248345f62936ac3f05";
            RecipeSummary recipeSummary = restTemplate.getForObject(url, RecipeSummary.class);
            log.info("RECIPE SUMMARY: " + recipeSummary.toString());
            return recipeSummary;
        }

    //Method to get recipe nutrients
        public RecipeNutrientsResponse SpoonRequestNutrients(String recipeID){
            log.info("=================Server Starting NUTRIENTS=================");
            log.info("RECIPE ID: " + recipeID);
            String url = "https://api.spoonacular.com/recipes/"+recipeID+"/nutritionWidget.json?apiKey=caaf6ff3cc614b248345f62936ac3f05";
            RecipeNutrientsResponse recipeNutrients = restTemplate.getForObject(url, RecipeNutrientsResponse.class);
            log.info(recipeNutrients.toString());
            return recipeNutrients;
        }

    //Method to get recipe ingredients
        public IngredientsResponse SpoonRequestIngredients(String recipeID){
            log.info("=================Server Starting INGREDIENTS=================");
            String url = "https://api.spoonacular.com/recipes/"+recipeID+"/ingredientWidget.json?apiKey=caaf6ff3cc614b248345f62936ac3f05";
            IngredientsResponse response = restTemplate.getForObject(url, IngredientsResponse.class);
            log.info(response.toString());
            return response;
        }

    //Method to get the recipe step instructions
        public InstructionsResponse[] SpoonRequestSteps(String recipeID){
            log.info("===================Server starting INSTRUCTIONS=================");
            String url = "https://api.spoonacular.com/recipes/"+recipeID+"/analyzedInstructions?apiKey=caaf6ff3cc614b248345f62936ac3f05&stepBreakdown=false";
            InstructionsResponse[] response = restTemplate.getForObject(url, InstructionsResponse[].class);
            log.info(response.toString());
            log.info(String.valueOf(response.length));

            return response;
        }
}
