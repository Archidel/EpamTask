package by.epam.library.controller.listener;

import java.io.IOException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import by.epam.library.controller.command.Command;
import by.epam.library.controller.command.CommandName;
import by.epam.library.controller.command.CommandProvider;

public class InitializationSourceListener implements ServletContextListener  {

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		CommandProvider provider = CommandProvider.getInstance();
		Command command = provider.getCommand(CommandName.INITIALIZATION_SOURCE.name());
		try {
			command.executeCommand(null, null);
		} catch (IOException e) {
//			LOGGER.error(e);
		}		
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		CommandProvider provider = CommandProvider.getInstance();
		Command command = provider.getCommand(CommandName.DESTROY_SOURCE.name());
		try {
			command.executeCommand(null, null);
		} catch (IOException e) {
//			LOGGER.error(e);
		}	
	}

}
