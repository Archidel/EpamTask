package by.epam.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.library.controller.AttributeName;
import by.epam.library.controller.PageName;
import by.epam.library.controller.ParameterName;
import by.epam.library.controller.command.Command;

public class Localization implements Command {
	
	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		request.getSession(true).setAttribute(AttributeName.LOCAL, request.getParameter(ParameterName.LOCAL));
		response.sendRedirect(request.getContextPath() + PageName.INDEX_PAGE);
	}
	 
}
