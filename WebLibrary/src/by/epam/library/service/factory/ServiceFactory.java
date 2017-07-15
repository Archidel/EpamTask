package by.epam.library.service.factory;

import by.epam.library.service.BookService;
import by.epam.library.service.InitializationService;
import by.epam.library.service.UserService;
import by.epam.library.service.impl.BookServiceImpl;
import by.epam.library.service.impl.InitializationServiceImpl;
import by.epam.library.service.impl.UserServiceImpl;

public final class ServiceFactory {
	private static ServiceFactory instance = null;
	private final UserService userService = new UserServiceImpl();
	private final BookService bookService = new BookServiceImpl();
	private final InitializationService initializationService = new InitializationServiceImpl();
	
	private ServiceFactory() {}

	public static ServiceFactory getInstance() {
		if(instance == null){
			instance = new ServiceFactory();
		}
		return instance;
	}

	public UserService getUserService() {
		return userService;
	}

	public BookService getBookService() {
		return bookService;
	}

	public InitializationService getInitializationService() {
		return initializationService;
	}
	
}
