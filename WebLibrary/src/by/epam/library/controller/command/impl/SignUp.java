package by.epam.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import by.epam.library.controller.PageName;
import by.epam.library.controller.ParameterName;
import by.epam.library.controller.command.Command;
import by.epam.library.service.UserService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class SignUp implements Command {

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String login = request.getParameter(ParameterName.USER_LOGIN);
		String password = request.getParameter(ParameterName.USER_PASSWORD);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		try {
			userService.signUp(login, password);
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_SIGN_UP_SUCCESS);			
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_SIGN_UP_ERROR);
//			LOGGER.error(e);
		}
	}

}
