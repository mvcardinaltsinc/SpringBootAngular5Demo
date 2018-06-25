package com.lko.lms.rest.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.lko.lms.rest.domain.Book;
import com.lko.lms.rest.domain.Category;
import com.lko.lms.rest.jpa.BookRepository;
import com.lko.lms.rest.jpa.CategoryRepository;

@Service
@Transactional
public class LmsServiceImpl {
	
	private static final Logger log = LoggerFactory.getLogger(LmsServiceImpl.class);
	
	@Autowired
    private BookRepository bookRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	
    public List<Book> getAvailableBooks(Integer page, Integer size) {
    	Pageable pageable = new PageRequest(page, size);
        Page<Book> pageOfBooks = bookRepository.findAll(pageable);
        List<Book> books = pageOfBooks.getContent();
    	
    	return books;
    }
    
    public List<Category> getAvailableCategories(){
    	return Lists.newArrayList(categoryRepository.findAll());
    }
    
    public Book createNewBook(Book book) {
    	Category catg = categoryRepository.findById(book.getCategory().getId()).get();
    	book.setCategory(catg);
    	
    	return bookRepository.save(book);
    }

}
