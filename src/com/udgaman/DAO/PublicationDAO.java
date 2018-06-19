package com.udgaman.DAO;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.udgaman.entity.Publication;
import com.udgaman.repository.PublicationRepository;

@Repository
public class PublicationDAO implements PublicationRepository {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public Publication getPublicationByName(String name) {
		Query query = em.createQuery("select a from Publication a where a.publication =:n");
		query.setParameter("n", name);
		List<Publication> publication = query.getResultList();
		if(publication != null && publication.size() != 0)
			return publication.get(0);
		else
			return null;
	}

}
