package by.epam.library.service.impl;

import java.io.IOException;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import by.epam.library.dao.connection.ConnectionPool;
import by.epam.library.dao.exception.ConnectionPoolException;
import by.epam.library.service.BookService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class TestBookServiceImpl {
	private final ServiceFactory factory = ServiceFactory.getInstance();
	private final BookService bookService = factory.getBookService();
	
	@BeforeClass
	public static void initSource() throws ConnectionPoolException{
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.init();
	}

	@AfterClass
	public static void destroySource() throws ConnectionPoolException, IOException{
		ConnectionPool connectionPool = ConnectionPool.getInstance();
		connectionPool.close();
	}
	
	
	@Test  (expected = ServiceException.class)
	public void testAddNewBook() throws ServiceException{ 
		bookService.addNewBook(null, null, null, null, null);
	}

	@Test
	public void testAddEditBook(){
		try {
			bookService.addEditBook(null, "MyAuthor", "MyGenre", "2017", "10", "1");
		} catch (ServiceException e) {
			Assert.assertEquals("Incorrect data about book", e.getMessage());
		}
	}
	
}
