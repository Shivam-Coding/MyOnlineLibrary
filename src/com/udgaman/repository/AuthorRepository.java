package com.udgaman.repository;

import com.udgaman.entity.Author;

public interface AuthorRepository {

	public Author getAuthorByName(String name);
	
}
