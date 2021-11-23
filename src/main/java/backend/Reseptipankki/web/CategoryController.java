package backend.Reseptipankki.web;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import backend.Reseptipankki.domain.Category;
import backend.Reseptipankki.domain.CategoryRepository;


@Controller
public class CategoryController {
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@GetMapping("/categorylist")
	public String getAllCategories(Model model) {
		model.addAttribute("categories", categoryRepository.findAll());
		return "categorylist";
	}
	
	@GetMapping("/addcategory")
	public String addCategory(Model model) {
		model.addAttribute("category", new Category());
		return "addcategory";
	}
	
	// Validation and saving a new category
	@PostMapping("/addcategory")
	public String categoryAdded(@Valid Category category, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			return "addcategory";
		} else {
			model.addAttribute("category", category);
			categoryRepository.save(category);
			return "redirect:categorylist";
		}
	}
	
	
	@RequestMapping(value="/deletecategory/{categoryid}", method = RequestMethod.GET)
	public String deleteCategory(@PathVariable("categoryid") Long categoryId, Model model) {
		categoryRepository.deleteById(categoryId);
		return "redirect:../categorylist";
	}
	
	
	// REST-method
	
	// RESTful service to get a list of all categories
	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public @ResponseBody List<Category> categoryListRest() {
		return (List<Category>) categoryRepository.findAll();
	}
	

	

}
