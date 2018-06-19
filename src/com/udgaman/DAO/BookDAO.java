package com.udgaman.DAO;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.udgaman.entity.Book;
import com.udgaman.repository.BookRepository;

@Repository
public class BookDAO implements BookRepository{
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public void saveBook(Book book) {
		em.persist(book);	
	}
	
	

}
