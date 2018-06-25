package com.lko.lms.rest.vo;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lko.lms.rest.domain.Category;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class BookVO {
	
	private Long id;
	
	private String bookTitle;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public Long getActualCopies() {
		return actualCopies;
	}

	public void setActualCopies(Long actualCopies) {
		this.actualCopies = actualCopies;
	}

	public Long getCurrentCopies() {
		return currentCopies;
	}

	public void setCurrentCopies(Long currentCopies) {
		this.currentCopies = currentCopies;
	}

	public Long getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Long publicationYear) {
		this.publicationYear = publicationYear;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	private String language;
	
	private Long actualCopies;
	
	private Long currentCopies;
	
	private Long publicationYear;
	
	private Category category;

}
