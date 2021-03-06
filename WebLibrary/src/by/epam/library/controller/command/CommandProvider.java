package by.epam.library.controller.command;

import java.util.HashMap;
import java.util.Map;

import by.epam.library.controller.command.impl.AddEditBook;
import by.epam.library.controller.command.impl.AddNewBook;
import by.epam.library.controller.command.impl.DestroySource;
import by.epam.library.controller.command.impl.GetBookList;
import by.epam.library.controller.command.impl.SignIn;
import by.epam.library.controller.command.impl.SignUp;
import by.epam.library.controller.command.impl.InitializationSource;
import by.epam.library.controller.command.impl.Localization;
import by.epam.library.controller.command.impl.Out;
import by.epam.library.controller.command.impl.Redirect;
import by.epam.library.controller.command.impl.WrongRequest;

public final class CommandProvider {
	private static CommandProvider instance = null;
	private static final Map<CommandName, Command> repository = new HashMap<CommandName, Command>();
	
	public CommandProvider() {
		repository.put(CommandName.INITIALIZATION_SOURCE, new InitializationSource());
		repository.put(CommandName.DESTROY_SOURCE, new DestroySource());
		repository.put(CommandName.LOCALIZATION, new Localization());
		repository.put(CommandName.ADD_NEW_BOOK, new AddNewBook());
		repository.put(CommandName.SIGN_IN, new SignIn());
		repository.put(CommandName.SIGN_UP, new SignUp());
		repository.put(CommandName.ADD_EDIT_BOOK, new AddEditBook());
		repository.put(CommandName.GET_BOOKLIST, new GetBookList());
		repository.put(CommandName.WRONG_REQUEST, new WrongRequest());
		repository.put(CommandName.REDIRECT, new Redirect());
		repository.put(CommandName.OUT, new Out());
	}
	
	public static CommandProvider getInstance() {
		if(instance == null){
			instance = new CommandProvider();
		}
		return instance;
	}
	
	public Command getCommand(String key){
		CommandName commandName;
		Command command;
		
		try{
			commandName = CommandName.valueOf(key.toUpperCase());
			command = repository.get(commandName);
		}catch (IllegalArgumentException e) {
			e.printStackTrace();
//			LOGGER.error(e);
			command = repository.get(CommandName.WRONG_REQUEST);
		}
	
		return command;
	}
	
}
