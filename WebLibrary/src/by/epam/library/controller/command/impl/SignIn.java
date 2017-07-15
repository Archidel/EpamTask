package by.epam.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.library.controller.AttributeName;
import by.epam.library.controller.PageName;
import by.epam.library.controller.ParameterName;
import by.epam.library.controller.command.Command;
import by.epam.library.service.UserService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class SignIn implements Command {

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String login = request.getParameter(ParameterName.USER_LOGIN);
		String password = request.getParameter(ParameterName.USER_PASSWORD);
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		UserService userService = serviceFactory.getUserService();

		try {
			userService.signIn(login, password);
			HttpSession session = request.getSession();
			session.setAttribute(AttributeName.LOGGED, true);
			response.sendRedirect(request.getContextPath() + PageName.INDEX_PAGE);			
		} catch (ServiceException e) {
			response.sendRedirect(request.getContextPath() + PageName.REDIRECT_SIGN_IN_ERROR);
//			LOGGER.error(e);
		}
	}

}
