package com.udgaman.repository;

import com.udgaman.entity.Publication;

public interface PublicationRepository {
	
	public Publication getPublicationByName(String name);

}
