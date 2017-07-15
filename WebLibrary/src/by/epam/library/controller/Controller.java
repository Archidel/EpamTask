package by.epam.library.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.library.controller.command.Command;
import by.epam.library.controller.command.CommandName;
import by.epam.library.controller.command.CommandProvider;

public final class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccessRequest(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		proccessRequest(request, response);
	}

	private void proccessRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommandProvider provider = CommandProvider.getInstance();
		String commandName = request.getParameter(CommandName.COMMAND.name().toLowerCase());
		Command command = provider.getCommand(commandName);
		try{
			command.executeCommand(request, response);			
		}catch (IOException e) {
//			LOGGER.error(e);
		}
	}
	
}
