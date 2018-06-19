package com.udgaman.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udgaman.entity.BookType;
import com.udgaman.repository.TypeRepository;

@Repository
public class BookTypeDAO implements TypeRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public BookType getBookTypeByName(String name) {
		Query query = em.createQuery("select a from BookType a where a.type =:n");
		query.setParameter("n", name);
		List<BookType> type = query.getResultList();
		if(type != null && type.size() != 0)
			return type.get(0);
		else
			return null;
	}

}
