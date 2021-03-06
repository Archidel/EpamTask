package by.epam.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.library.controller.PageName;
import by.epam.library.controller.ParameterName;
import by.epam.library.controller.command.Command;
import by.epam.library.service.BookService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class AddNewBook implements Command {

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		String title = request.getParameter(ParameterName.BOOK_TITLE);
		String author = request.getParameter(ParameterName.BOOK_AUTHOR);
		String genre = request.getParameter(ParameterName.BOOK_GENRE);
		String year = request.getParameter(ParameterName.BOOK_YEAR);
		String quantity = request.getParameter(ParameterName.BOOK_QUANTITY);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		
		try {
			bookService.addNewBook(title, genre, author, year, quantity);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_NEW_BOOK_SUCCESS);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ADD_NEW_BOOK_ERROR);
//			LOGGER.error(e);
		}
	}

}
