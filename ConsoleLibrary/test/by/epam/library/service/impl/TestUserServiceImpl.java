package by.epam.library.service.impl;

import org.junit.Test;

import by.epam.library.service.UserService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class TestUserServiceImpl {
/*	Зарегистрировать пользователя не получиться, т.к. мы не инициализировали ConnectionPool
 	Соответственно когда берем Connection получаем NullPointerException.
*/
	@Test (expected = NullPointerException.class)
	public void signUp() throws ServiceException{
		ServiceFactory factory = ServiceFactory.getInstance();
		UserService userService = factory.getUserService();
		userService.signUp("Dylan O'Brien", "12345678");
	}
}
