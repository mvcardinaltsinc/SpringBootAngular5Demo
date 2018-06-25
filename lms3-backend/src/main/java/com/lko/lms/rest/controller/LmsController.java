package com.lko.lms.rest.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.lko.lms.rest.domain.Book;
import com.lko.lms.rest.domain.Category;
import com.lko.lms.rest.service.LmsServiceImpl;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/example/v1/books")
@EntityScan("com.lko.lms.rest.domain")
@Api(tags = {"books"})
@CrossOrigin(origins = "http://localhost:4200")
public class LmsController extends AbstractRestHandler {

    @Autowired
    private LmsServiceImpl lmsService;

    @RequestMapping(value = "",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a paginated list of all books.", notes = "The list is paginated. You can provide a page number (default 0) and a page size (default 100)")
    public
    @ResponseBody
    List<Book> getAvailableBooks(@ApiParam(value = "The page number (zero-based)", required = true)
                                      @RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,
                                      @ApiParam(value = "Tha page size", required = true)
                                      @RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size,
                                      HttpServletRequest request, HttpServletResponse response) {
    	
    	List<Book> books = lmsService.getAvailableBooks(page, size);
    	
        return books;
    }
    
    @RequestMapping(value = "/addBook",
            method = RequestMethod.POST,
            consumes = {"application/json", "application/xml"},
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.CREATED)
    public
    @ResponseBody
    List<Book> addBook(@RequestBody Book book, HttpServletRequest request, 
    		HttpServletResponse response, 
    		@RequestParam(value = "page", required = true, defaultValue = DEFAULT_PAGE_NUM) Integer page,  
    		@RequestParam(value = "size", required = true, defaultValue = DEFAULT_PAGE_SIZE) Integer size) {
    	Book createdBook = lmsService.createNewBook(book);
    	
    	List<Book> books = lmsService.getAvailableBooks(page, size);
    	
        return books;
    	
        //response.setHeader("Location", request.getRequestURL().append("/").append(createdBook.getId()).toString());
    }
    
    @RequestMapping(value = "/categories",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    public
    @ResponseBody
    List<Category> getAvailableCategories(HttpServletRequest request, HttpServletResponse response) {
    	
    	List<Category> categories = lmsService.getAvailableCategories();
    	
        return categories;
    }

}
