package com.qintess.dvdrental.entidades;

public class FilmCategory {
	
	private Film film;
	private Category category;
	
	public FilmCategory(Film film, Category category) {
		super();
		this.film = film;
		this.category = category;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	
	
}
