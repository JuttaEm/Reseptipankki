package backend.Reseptipankki.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import backend.Reseptipankki.domain.Collection;
import backend.Reseptipankki.domain.CollectionRepository;

@Controller
public class CollectionController {
	
	@Autowired
	private CollectionRepository collectionRepository;
	
	@GetMapping("/collections")
	public String getAllCollections(Model model) {
		model.addAttribute("collections", collectionRepository.findAll());
		return "collections";
	}
	

	
	

}
