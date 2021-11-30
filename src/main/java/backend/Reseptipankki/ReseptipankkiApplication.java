package backend.Reseptipankki;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import backend.Reseptipankki.domain.Category;
import backend.Reseptipankki.domain.CategoryRepository;
import backend.Reseptipankki.domain.Collection;
import backend.Reseptipankki.domain.CollectionRepository;
import backend.Reseptipankki.domain.Recipe;
import backend.Reseptipankki.domain.RecipeRepository;
import backend.Reseptipankki.domain.User;
import backend.Reseptipankki.domain.UserRepository;

@SpringBootApplication
public class ReseptipankkiApplication {
	
	private static final Logger log = LoggerFactory.getLogger(ReseptipankkiApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ReseptipankkiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(RecipeRepository recipeRepository,
			CategoryRepository categoryRepository,
			UserRepository userRepository,
			CollectionRepository collectionRepository) {
		return (args) -> {
			
			log.info("Save demo categories");
			
			Category category1 = new Category("Vegan");
			Category category2 = new Category("Soup");
			Category category3 = new Category("TexMex");
			Category category4 = new Category("Dessert");
			Category category5 = new Category("Breakfast");
			Category category6 = new Category("Asian");
			
			categoryRepository.save(category1);
			categoryRepository.save(category2);
			categoryRepository.save(category3);
			categoryRepository.save(category4);
			categoryRepository.save(category5);
			categoryRepository.save(category6);
			
			
			log.info("Save demo recipes");
			
			recipeRepository.save(new Recipe("Makaronilaatikko", "Loistava vegaaninen ruoka!", 4, "https://www.myllynparas.fi/reseptit/liha-makaronilaatikko", category1));
			recipeRepository.save(new Recipe("Kasvissosekeitto", "Maukasta talviruokaa", 3, "https://www.martat.fi/reseptit/kasvissosekeitto/", category2));
			recipeRepository.save(new Recipe("Tortillat", "Helppoa ja herkullista :)", 5, "https://www.k-ruoka.fi/reseptit/jauhelihatortillat", category3));
			recipeRepository.save(new Recipe("Porkkanakakku", "Terveellinen vaihtoehto täytekakulle", 4, "https://www.valio.fi/reseptit/porkkanakakku-pellillinen/", category4));
			recipeRepository.save(new Recipe("Munakasrulla", "Yllättävän vaikea saada pysymään koossa", 2, "https://www.ruokajakoti.fi/Jauheliha-munakasrulla", category5));
			recipeRepository.save(new Recipe("Paistettu riisi kanalla", "Superhelppo arkiruoka", 5, "https://www.soppa365.fi/reseptit/teemu-leminen/etniset-ruuat-arjen-nopeat/paistettu-riisi", category6));
			
			log.info("Fetch all recipes");
			for (Recipe recipe : recipeRepository.findAll()) {
				log.info(recipe.toString());
			}
			
			log.info("Save demo users");
			
			User user1 = new User("User", "$2a$10$UiZRXvPASH1l0bmpw8sEe.SNeOXcf4j7nHV9kyAyc4YzoFDLyspIS", "USER");
			User admin1 = new User("Admin", "$2a$10$rjgFWjt.0zNgPipOuJ801udJLu1MdQzBzkWNoX90F4BdNKCsW4XHW", "ADMIN");
			User jutta = new User("Jutta", "$2a$10$9u13Y9GNxZ1cOJyVw/sxMuQwkyeGxHA.b9SV5mQKDsGmDEQ02TIjS", "ADMIN");
			
			userRepository.save(user1);
			userRepository.save(admin1);
			userRepository.save(jutta);
			
			
			log.info("Save demo collections");
			
			Collection blog1 = new Collection("Viimeistä murua myöten", "Kasvispainotteisia reseptejä ja retkiruokia", "https://viimeistamuruamyoten.com/");
			Collection blog2 = new Collection("Chocochili", "Elina Innasen vegaaniruokablogi", "https://chocochili.net/");
			Collection blog3 = new Collection("Half Baked Harvest", "Rustic and delicious dishes in English", "https://www.halfbakedharvest.com/");
			Collection webpage1 = new Collection("K-Ruoka reseptit", "Helppoja arkiruokia, hyvät hakutoiminnot", "https://www.k-ruoka.fi/reseptit");
			
			collectionRepository.save(blog1);
			collectionRepository.save(blog2);
			collectionRepository.save(blog3);
			collectionRepository.save(webpage1);
			
		};
	}

}
