package backend.Reseptipankki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.Reseptipankki.domain.Category;
import backend.Reseptipankki.domain.CategoryRepository;
import backend.Reseptipankki.domain.Recipe;
import backend.Reseptipankki.domain.RecipeRepository;

@SpringBootApplication
public class ReseptipankkiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ReseptipankkiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReseptipankkiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(RecipeRepository recipeRepository, CategoryRepository categoryRepository) {
		return (args) -> {
			
			log.info("Save demo categories");
			
			Category category1 = new Category("Vegan");
			Category category2 = new Category("Soup");
			Category category3 = new Category("TexMex");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			
			
			log.info("Save demodata");
			
			recipeRepository.save(new Recipe("Makaronilaatikko", "Loistava vegaaninen ruoka!", true, 4, category1));
			recipeRepository.save(new Recipe("Kasvissosekeitto", "Maukasta talviruokaa", false, 3, category2));
			recipeRepository.save(new Recipe("Tortillat", "Helppoa ja herkullista :)", true, 5, category3));
			
			log.info("Fetch all recipes");
			for (Recipe recipe : recipeRepository.findAll()) {
				log.info(recipe.toString());
			}
			
		};
	}

}
