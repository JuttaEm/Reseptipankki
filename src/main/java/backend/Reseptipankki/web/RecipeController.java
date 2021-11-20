package backend.Reseptipankki.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteRecipe(@PathVariable("id") Long recipeId, Model model) {
		recipeRepository.deleteById(recipeId);
		return "redirect:../recipelist";
	}
	
	@RequestMapping(value="/edit/{id}")
	public String editRecipe(@PathVariable("id") Long recipeId, Model model) {
		model.addAttribute("recipe", recipeRepository.findById(recipeId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editrecipe";
	}
	
	

}
