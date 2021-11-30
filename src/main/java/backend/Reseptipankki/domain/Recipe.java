package backend.Reseptipankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
public class Recipe {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long recipeId;
	
	@NotNull
	@Size(min=3, max=40)
	private String header;
	private String comment;

	@Min(1)
	@Max(5)
	private float rating;
	
	@ManyToOne
	@JsonIgnoreProperties("recipes")
	@JoinColumn(name = "categoryId")
	private Category category;
	
	
	// Constructors
	public Recipe() {
		super();
	}
	
	public Recipe(String header, String comment, float rating) {
		super();
		this.recipeId = 0;
		this.header = header;
		this.comment = comment;
		this.rating = rating;
	}
	
	public Recipe(String header, String comment, float rating, Category category) {
		super();
		this.recipeId = 0;
		this.header = header;
		this.comment = comment;
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
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}

	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
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
		return "Recipe [recipeId=" + recipeId + ", header=" + header + ", comment=" + comment + ", rating="
				+ rating + ", category=" + category + "]";
	}


	
	
	

}
