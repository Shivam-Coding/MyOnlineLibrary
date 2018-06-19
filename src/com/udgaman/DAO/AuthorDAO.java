package com.udgaman.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.udgaman.entity.Author;
import com.udgaman.repository.AuthorRepository;

@Repository
public class AuthorDAO implements AuthorRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Author getAuthorByName(String name) {
		Query query = em.createQuery("select a from Author a where a.author =:n");
		query.setParameter("n", name);
		List<Author> author = query.getResultList();
		Author a  = null;
		if(author != null && author.size() != 0)
			a = author.get(0);
		return a;
	}

}
