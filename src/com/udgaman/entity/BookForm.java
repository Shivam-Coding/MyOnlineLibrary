package com.udgaman.entity;

import javax.validation.constraints.Min;

import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.web.multipart.MultipartFile;

import com.udgaman.util.NoData;


public class BookForm {
	
	@Min(value=4)
	private int pages;
	
	@NotEmpty(message="Name is a required field !")
	private String name;
	
	@NotEmpty(message="Author is a required field !")
	private String author;
	
	@NotEmpty(message="Suject is a required field !")
	private String subject;
	
	@NotEmpty
	private String type="PDF";
	
	@NotEmpty(message="Publication is a required field !")
	private String publication;
	
	@NoData(message="Please upload PDF file !!!")
	private MultipartFile file;

	public int getPages() {
		return pages;
	}

	public void setPages(int pages) {
		this.pages = pages;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getPublication() {
		return publication;
	}

	public void setPublication(String publication) {
		this.publication = publication;
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}	
	
}