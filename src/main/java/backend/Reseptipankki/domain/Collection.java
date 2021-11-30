package backend.Reseptipankki.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collection {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long collectionId;
	private String collectionName;
	private String description;
	private String link;
	
	// Constructors
	public Collection() {
		super();
	}
	
	public Collection(String collectionName, String description, String link) {
		super();
		this.collectionName = collectionName;
		this.description = description;
		this.link = link;
	}

	
	// Getters, setters and toString-method for each attribute
	public long getCollectionId() {
		return collectionId;
	}

	public void setCollectionId(long collectionId) {
		this.collectionId = collectionId;
	}

	public String getCollectionName() {
		return collectionName;
	}

	public void setCollectionName(String collectionName) {
		this.collectionName = collectionName;
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	@Override
	public String toString() {
		return "Collection [collectionId=" + collectionId + ", collectionName=" + collectionName + ", description="
				+ description + ", link=" + link + "]";
	}

	
	

}
