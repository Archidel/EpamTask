package by.epam.library.service.impl;

import by.epam.library.bean.User;
import by.epam.library.dao.UserDAO;
import by.epam.library.dao.exception.DAOException;
import by.epam.library.dao.factory.DAOFactory;
import by.epam.library.service.UserService;
import by.epam.library.service.exception.ServiceException;
import by.epam.library.service.validation.ValidationData;

public class UserServiceImpl implements UserService {

	@Override
	public void signIn(String login, String password) throws ServiceException {
		if(!ValidationData.validUser(login, password)){
			System.out.println(login);
			System.out.println(password);
			throw new ServiceException("Iccorrent user's login or password");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		
		//Attention String_paswword convert to int_password(HashCode)
		try {
			User user = userDAO.signIn(login, password.hashCode());
			if(user == null){
				throw new ServiceException("User is not found");
			}
		} catch (DAOException e) {
			throw new ServiceException("Error sign in", e);
		}
	}

	@Override
	public void signUp(String login, String password) throws ServiceException {
		if(!ValidationData.validUser(login, password)){
			throw new ServiceException("Icorrent user's login or password");
		}
		
		DAOFactory daoFactory = DAOFactory.getInstance();
		UserDAO userDAO = daoFactory.getUserDAO();
		
		//Attention String_paswword convert to int_password(HashCode)
		try {
			userDAO.signUp(login, password.hashCode());
		} catch (DAOException e) {
			throw new ServiceException("Error sign up", e);
		}
	}

}
