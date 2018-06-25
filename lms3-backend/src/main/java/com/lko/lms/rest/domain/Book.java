package com.lko.lms.rest.domain;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Book_Details")
@AttributeOverride(name="id", column=@Column(name="ISBN_Code"))
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Book {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "Book_Title")
	private String bookTitle;
	
	@Column(name = "Language")
	private String language;
	
	@Column(name = "No_Copies_Actual")
	private Long actualCopies;
	
	@Column(name = "No_Copies_Current")
	private Long currentCopies;
	
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

	@Override
	public String toString() {
		return "Book [id=" + id + ", bookTitle=" + bookTitle + ", language=" + language + ", actualCopies="
				+ actualCopies + ", currentCopies=" + currentCopies + ", category=" + category + ", publicationYear="
				+ publicationYear + "]";
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Long getPublicationYear() {
		return publicationYear;
	}

	public void setPublicationYear(Long publicationYear) {
		this.publicationYear = publicationYear;
	}

	@OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Category_id")
	private Category category;
	
	@Column(name = "Publication_year")
	private Long publicationYear;
	
	
	

}
