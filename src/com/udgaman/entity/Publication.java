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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="publication")
public class Publication {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;
	
	@Column(name="publication")
	private String publication;
	
	public Publication(){
		
	}
	
	public Publication(String publication){
		this.publication = publication;
	}
	
	@ManyToMany(fetch=FetchType.LAZY, mappedBy="publications")
	Set<Author> authors = new HashSet<Author>();
	
	@OneToMany(mappedBy="publication",fetch=FetchType.LAZY)
	Set<Book> books = new HashSet<Book>();
	
	@ManyToMany(fetch=FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name="subject_publication", joinColumns={@JoinColumn(name="publication_id")},
	           inverseJoinColumns={@JoinColumn(name="subject_id")})
	Set<Subject> subjects = new HashSet<Subject>();
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public Set<Author> getAuthors() {
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}

	@Override
	public String toString(){
		return this.publication;
	}
	
}
