package by.epam.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.library.controller.PageName;
import by.epam.library.controller.command.Command;

public class WrongRequest implements Command {
	
	@Override
	public void  executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException{
		response.sendRedirect(request.getContextPath() + PageName.ERROR_REQUEST_PAGE);
	}
	
}
