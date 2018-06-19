package com.udgaman.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.udgaman.entity.BookForm;
import com.udgaman.service.IAddBook;

@Controller
public class FileUploadController {
	
	@Autowired
	private IAddBook addBookService;
	
//	@RequestMapping("/")
//	public String initial(Model model){
////		model.addAttribute("book", new Book());
//		System.out.println("checked");
//		return "redirect:/addBook";
//	}
	
//	@RequestMapping("/addBook")
//	public String addBook(@RequestParam("myfile") MultipartFile file){
//		System.out.println("Reached!!!!!  "+file.getSize()+"   "+file.getOriginalFilename());
//		return "upload";
//	}
	
	@RequestMapping(value="/addBook", method=RequestMethod.GET)
	public String addNewBook(Model model){
		model.addAttribute("book", new BookForm());
		return "upload";
	}

	@RequestMapping(value="/addBook",method=RequestMethod.POST)
	public String addBook(@Valid BookForm book, BindingResult errors, Model model){ 
		
		if(errors.hasErrors()){
			model.addAttribute("book", book);
			return "upload";
		}
		
		addBookService.addBook(book);
		model.addAttribute("book", new BookForm());
//		
//		try {
//			book.setData(file.getBytes());
//		    book.setOriginalName(file.getOriginalFilename());
//		    addBookService.addBook(book);
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		return "upload";
	}
	
//	@RequestMapping(value="/addBook",  produces = "application/pdf")
//	public @ResponseBody byte[] addBook(Book book,@RequestParam("myfile") MultipartFile file){
//		try {
//			book.setBook(file.getBytes());
//		
//		addBookService.addBook(book);
//		
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return book.getBook();
//	}
	
	
	
	
}
