package by.epam.library.controller.command.impl;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import by.epam.library.controller.AttributeName;
import by.epam.library.controller.PageName;
import by.epam.library.controller.command.Command;

public class Out implements Command {

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		session.removeAttribute(AttributeName.LOGGED);
	
		try {
			response.sendRedirect(request.getContextPath() + PageName.INDEX_PAGE);
		} catch (IOException e) {
//			LOGGER.error(e);
		}

	}

}
