package backend.Reseptipankki.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import backend.Reseptipankki.domain.CategoryRepository;
import backend.Reseptipankki.domain.Recipe;
import backend.Reseptipankki.domain.RecipeRepository;

@Controller
public class RecipeController {
	
	@Autowired
	private RecipeRepository recipeRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value = {"/", "/homepage"}, method = RequestMethod.GET)
	public String homepage() {
		return "homepage";
	}
	
	@GetMapping("/recipelist")
	public String getAllRecipes(Model model) {
		model.addAttribute("recipes", recipeRepository.findAll());
		return "recipelist";
	}
	
	@GetMapping("/addrecipe")
	public String addRecipe(Model model) {
		model.addAttribute("recipe", new Recipe());
		model.addAttribute("categories", categoryRepository.findAll());
		return "addrecipe";
	}
	
	@PostMapping("/save")
	public String save(Recipe recipe) {
		recipeRepository.save(recipe);
		return "redirect:recipelist";
	}
	
	

}
