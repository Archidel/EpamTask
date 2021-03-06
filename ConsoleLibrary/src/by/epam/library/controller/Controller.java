package by.epam.library.controller;

import by.epam.library.controller.command.CommandProvider;
import by.epam.library.controller.command.Command;

public final class Controller {
	private final char paramDelimeter = ' ';
	
	public String executeAction(String request){
		String commandName;
		Command command;
		
		commandName = request.substring(0, request.indexOf(paramDelimeter));
		CommandProvider provider = CommandProvider.getInstance();
		command = provider.getCommand(commandName);
		String response = command.executeCommand(request);
		
		return response;
	}
}
