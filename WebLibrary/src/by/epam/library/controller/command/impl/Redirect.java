package by.epam.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.library.controller.AttributeName;
import by.epam.library.controller.PageName;
import by.epam.library.controller.ParameterName;
import by.epam.library.controller.command.Command;

public class Redirect implements Command {
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String pageName = request.getParameter(ParameterName.PAGE_NAME);
		String message = request.getParameter(ParameterName.MESSAGE);
		request.setAttribute(AttributeName.STATUS, message);
		
		try {
			request.getRequestDispatcher(pageName).forward(request, response);
		} catch (ServletException e) {
			response.sendRedirect(request.getContextPath() + PageName.INDEX_PAGE);
//			LOGGER.error(e);
		}
	}

}
