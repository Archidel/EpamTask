package by.epam.library.service.impl;

import by.epam.library.dao.InitializationDAO;
import by.epam.library.dao.exception.DAOException;
import by.epam.library.dao.factory.DAOFactory;
import by.epam.library.service.InitializationService;
import by.epam.library.service.exception.ServiceException;

public class InitializationServiceImpl implements InitializationService {

	@Override
	public void initialization() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		InitializationDAO initializationDAO = factory.getInitializationDAO();
		try {
			initializationDAO.initialization();
		} catch (DAOException e) {
			throw new ServiceException("Error initialization",e);
		}
	}

	@Override
	public void destroy() throws ServiceException {
		DAOFactory factory = DAOFactory.getInstance();
		InitializationDAO initializationDAO = factory.getInitializationDAO();
		
		try {
			initializationDAO.destroy();
		} catch (DAOException e) {
			throw new ServiceException("Error destroy",e);
		}
	}

}
