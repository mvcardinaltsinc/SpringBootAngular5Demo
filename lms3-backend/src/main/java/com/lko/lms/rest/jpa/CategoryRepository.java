package com.lko.lms.rest.jpa;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.lko.lms.rest.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {

}
