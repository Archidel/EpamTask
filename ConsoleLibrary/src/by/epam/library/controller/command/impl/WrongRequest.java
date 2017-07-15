package by.epam.library.controller.command.impl;

import by.epam.library.controller.command.Command;

public class WrongRequest implements Command {

	@Override
	public String executeCommand(String request) {
		return "Wrong request!";
	}

}
