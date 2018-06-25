package com.lko.lms.rest.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.lko.lms.rest.domain.Book;

/**
 * Repository can be used to delegate CRUD operations against the data source: http://goo.gl/P1J8QH
 */

@Repository
public interface BookRepository extends PagingAndSortingRepository<Book, Long> {
    Page findAll(Pageable pageable);
}
