package com.udgaman.repository;

import com.udgaman.entity.BookType;

public interface TypeRepository {
	
	public BookType getBookTypeByName(String name);

}
