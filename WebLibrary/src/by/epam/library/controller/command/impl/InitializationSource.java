package by.epam.library.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.library.controller.command.Command;
import by.epam.library.service.InitializationService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class InitializationSource implements Command {

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory factory = ServiceFactory.getInstance();
		InitializationService initializationService = factory.getInitializationService();
		
		try {
			initializationService.initialization();	
			System.out.println("Database has been initialized");
//			LOGGER.info("Database has been initialized");	
		} catch (ServiceException e) {
			System.out.println("Database has not been initialized");
//			LOGGER.info("Database has not been initialized");	
//			LOGGER.error(e);	
		}
	}

}
