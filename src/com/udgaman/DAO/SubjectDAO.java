package com.udgaman.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.udgaman.entity.Author;
import com.udgaman.entity.Subject;
import com.udgaman.repository.SubjectRepository;

@Repository
public class SubjectDAO implements SubjectRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Subject getSubjectByName(String name) {
		Query query = em.createQuery("select s from Subject s where s.subject =:n");
		query.setParameter("n", name);
		List<Subject> subject = query.getResultList();
		if(subject != null && subject.size() != 0)
			return subject.get(0);
		else
			return null;
	}

}
