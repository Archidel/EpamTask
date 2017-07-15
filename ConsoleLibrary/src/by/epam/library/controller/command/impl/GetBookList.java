package by.epam.library.controller.command.impl;

import java.util.List;

import by.epam.library.bean.Book;
import by.epam.library.controller.command.Command;
import by.epam.library.service.BookService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class GetBookList implements Command {

	@Override
	public String executeCommand(String request) {
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		
		List<Book> booklist = null;
		String response = null;
		try {
			booklist = bookService.getBooklist();
			response = "List of books received";
			
			//Circle just for test
			for(Book book: booklist){
				System.out.println(book.toString());
			}
		} catch (ServiceException e) {
			response = "Error getting list of books";
			//logger.log(Level.ERROR, e);
		}
		
		return response;
	}

}
