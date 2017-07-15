package by.epam.library.controller.command.impl;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.library.bean.Book;
import by.epam.library.controller.AttributeName;
import by.epam.library.controller.PageName;
import by.epam.library.controller.command.Command;
import by.epam.library.service.BookService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class GetBookList implements Command {

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		BookService bookService = serviceFactory.getBookService();
		List<Book> booklist = null;
		
		try {
			booklist = bookService.getBooklist();
			request.setAttribute(AttributeName.LIST, booklist);
			request.getRequestDispatcher(PageName.BOOKLIST_PAGE).forward(request, response);
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_OPERATION);
//			LOGGER.error(e);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_ERROR_OPERATION);			
//			LOGGER.error(e);
		}
	}

}
