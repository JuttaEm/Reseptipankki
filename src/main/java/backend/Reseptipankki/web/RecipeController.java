package backend.Reseptipankki.web;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping("/addrecipe")
	public String recipeAdded(@Valid Recipe recipe, BindingResult bindingResult, Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		if (bindingResult.hasErrors()) {
			return "addrecipe";
		} else {
			model.addAttribute("recipe", recipe);
			recipeRepository.save(recipe);
			return "redirect:recipelist";
		}
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/delete/{id}", method = RequestMethod.GET)
	public String deleteRecipe(@PathVariable("id") Long recipeId, Model model) {
		recipeRepository.deleteById(recipeId);
		return "redirect:../recipelist";
	}
	
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value="/edit/{id}")
	public String editRecipe(@PathVariable("id") Long recipeId, Model model) {
		model.addAttribute("recipe", recipeRepository.findById(recipeId));
		model.addAttribute("categories", categoryRepository.findAll());
		return "editrecipe";
	}
	
	@PostMapping("/save")
	public String save(@Valid Recipe recipe, BindingResult bindingResult, Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		if (bindingResult.hasErrors()) {
			return "editrecipe";
		} else {
			model.addAttribute("recipe", recipe);
			recipeRepository.save(recipe);
			return "redirect:recipelist";
		}
		
	}
	
	
	// REST-methods
	
	// RESTful service to get a list of all recipes
	@RequestMapping(value="/recipes", method = RequestMethod.GET)
	public @ResponseBody List<Recipe> recipeListRest() {
		return (List<Recipe>) recipeRepository.findAll();
	}
	
	// RESTful service to find a specific recipe with id
	@RequestMapping(value="/recipe/{id}", method = RequestMethod.GET)
	public @ResponseBody Optional<Recipe> findRecipeRest(@PathVariable("id") Long recipeId) {
		return recipeRepository.findById(recipeId);
	}
	
	// REST API documentation
	@RequestMapping(value = {"/restapi"}, method = RequestMethod.GET)
	public String restapiDocumentation() {
		return "restapi";
	}
	
	
	
	
	
	

}
