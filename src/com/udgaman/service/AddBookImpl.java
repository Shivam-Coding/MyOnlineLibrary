package com.udgaman.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.udgaman.entity.Author;
import com.udgaman.entity.Book;
import com.udgaman.entity.BookForm;
import com.udgaman.entity.BookType;
import com.udgaman.entity.Publication;
import com.udgaman.entity.Subject;
import com.udgaman.repository.AuthorRepository;
import com.udgaman.repository.BookRepository;
import com.udgaman.repository.PublicationRepository;
import com.udgaman.repository.SubjectRepository;
import com.udgaman.repository.TypeRepository;
import com.udgaman.util.GenerateHash;

@Service
public class AddBookImpl implements IAddBook {
	
	@Autowired
	private BookRepository bookRepository;
	
	@Autowired
	private AuthorRepository authorRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private TypeRepository typeRepository;
	
	@Autowired
	private PublicationRepository publicationRepository;

	@Override
	@Transactional
	public void addBook(BookForm bookForm) {
		
		Book book = new Book();
		book.setName(bookForm.getName());
		book.setPages(bookForm.getPages());
		book.setOriginalName(bookForm.getFile().getOriginalFilename());
	
		Author author = authorRepository.getAuthorByName(bookForm.getAuthor());
		if(author == null)
		author = new Author(bookForm.getAuthor());
		
		Subject subject = subjectRepository.getSubjectByName(bookForm.getSubject());
		if(subject == null)
		subject = new Subject(bookForm.getSubject());
		
		BookType bookType = typeRepository.getBookTypeByName(bookForm.getType());
		if(bookType == null)
		bookType = new BookType(bookForm.getType());
		
		Publication publication = publicationRepository.getPublicationByName(bookForm.getPublication());
		if(publication == null)
		publication = new Publication(bookForm.getPublication());
		
		subject.getPublications().add(publication);
		publication.getSubjects().add(subject);
		author.getPublications().add(publication);
		author.getSubjects().add(subject);
		
		book.setAuthor(author);
		book.setSubject(subject);
		book.setType(bookType);
		book.setPublication(publication);
		
//		author.getBooks().add(book);
		
		try {
			book.setData(bookForm.getFile().getBytes());
			book.setHash(GenerateHash.getHash(bookForm.getFile().getBytes()));
			bookRepository.saveBook(book);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
