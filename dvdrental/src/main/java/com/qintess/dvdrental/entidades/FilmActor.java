package com.qintess.dvdrental.entidades;

public class FilmActor {

	private Actor actor;
	private Film film;
	
	public FilmActor(Actor actor, Film film) {
		super();
		this.actor = actor;
		this.film = film;
	}

	public Actor getActor() {
		return actor;
	}

	public void setActor(Actor actor) {
		this.actor = actor;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}
	
	
	
	
	
	
}
