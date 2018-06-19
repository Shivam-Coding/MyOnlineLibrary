package com.udgaman.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="subject")
public class Subject {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="subject")
	private String subject;
	
	public Subject(){
		
	}
	
	public Subject(String subject){
		this.subject = subject;
	}
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="subjects")
	Set<Author> authors = new HashSet<Author>();
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="subjects", cascade = CascadeType.ALL)
	Set<Publication> publications = new HashSet<Publication>();
	
	@OneToMany(mappedBy="subject",fetch=FetchType.LAZY)
	Set<Book> books = new HashSet<Book>();
		
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<Publication> getPublications() {
		return publications;
	}

	public void setPublications(Set<Publication> publications) {
		this.publications = publications;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	@Override
	public String toString(){
		return this.subject;
	}
 }
