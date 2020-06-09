package com.przepisy.przepisy.auth.model;

import javax.persistence.*;
import javax.sql.rowset.serial.SerialBlob;

import com.sun.istack.NotNull;

import java.sql.Blob;
import java.util.Set;

@Entity
@Table(name = "recipe")
public class Recipe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long id;
    
    private String name;
    
    private String foodKind;

    private String lvl; //how hard it is to make this recipe
    
    private String time;
    
    @Column(name="description", length=10000)
    private String description;
    
    @OneToMany
    private Set<Ingredient> ingedients; //list of ingredients

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id", nullable = false)
    @NotNull
    private User user;
    
    @OneToMany(mappedBy = "recipe", cascade = CascadeType.REMOVE)
    private Set<Comment> comments;
    
    private Blob photo;
    
    public Long getId() {
    	return id;
    }
    
	public String getFoodKind() {
		return foodKind;
	}

	public void setFoodKind(String foodKind) {
		this.foodKind = foodKind;
	}

	public String getLvl() {
		return lvl;
	}

	public void setLvl(String lvl) {
		this.lvl = lvl;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}