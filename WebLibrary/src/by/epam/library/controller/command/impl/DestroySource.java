package by.epam.library.controller.command.impl;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.epam.library.controller.command.Command;
import by.epam.library.service.InitializationService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.factory.ServiceFactory;

public class DestroySource implements Command {

	@Override
	public void executeCommand(HttpServletRequest request, HttpServletResponse response) {
		ServiceFactory factory = ServiceFactory.getInstance();
		InitializationService initializationService = factory.getInitializationService();
		
		try {
			initializationService.destroy();
			System.out.println("Database has been destroyed");
//			LOGGER.info("Database has been destroyed");	
		} catch (ServiceException e) {
			System.out.println("Database has not been destroyed");
//			LOGGER.info("Database has not been destroyed");	
//			LOGGER.error(e);	
		}
	}

}
