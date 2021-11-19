package backend.Reseptipankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long recipeId;
	private String header;
	private String description;
	private boolean tried;
	private int rating;
	
	@ManyToOne
	@JsonIgnoreProperties("recipes")
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
	// Constructors
	public Recipe() {
		super();
		this.recipeId = 0;
		this.header = null;
		this.description = null;
		this.tried = true;
		this.rating = 0;
		this.category = null;
	}
	
	public Recipe(String header, String description, Boolean tried, int rating) {
		super();
		this.recipeId = 0;
		this.header = header;
		this.description = description;
		this.tried = tried;
		this.rating = rating;
	}
	
	public Recipe(String header, String description, Boolean tried, int rating, Category category) {
		super();
		this.recipeId = 0;
		this.header = header;
		this.description = description;
		this.tried = tried;
		this.rating = rating;
		this.category = category;
	}
	
	public Recipe(String header, String description, int rating, Category category) {
		super();
		this.recipeId = 0;
		this.header = header;
		this.description = description;
		this.rating = rating;
		this.category = category;
	}
	
	
	// Getters, setters and toString-method for each attribute
	public long getRecipeId() {
		return recipeId;
	}
	public void setRecipeId(long recipeId) {
		this.recipeId = recipeId;
	}
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isTried() {
		return tried;
	}
	public void setTried(boolean tried) {
		this.tried = tried;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Recipe [recipeId=" + recipeId + ", header=" + header + ", description=" + description + ", tried="
				+ tried + ", rating=" + rating + "]";
	}
	
	
	

}
