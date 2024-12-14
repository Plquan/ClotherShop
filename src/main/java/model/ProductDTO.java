package model;

import java.sql.Date;
import java.text.DecimalFormat;

public class ProductDTO {
	public int id;
	public String name;
	public int categoryId;
	public String description;
	public String image;
	public Double price;
	public int stock;
	public String status;
	
	
	public ProductDTO(int id, String name, int categoryId, String description, String image, Double price, int stock,
			String status) {
		this.id = id;
		this.name = name;
		this.categoryId = categoryId;
		this.description = description;
		this.image = image;
		this.price = price;
		this.stock = stock;
		this.status = status;
	}
	
	
	public ProductDTO() {
	}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	

	   	    
	
	
	
	
	
	
	
	
	
	
	
}
