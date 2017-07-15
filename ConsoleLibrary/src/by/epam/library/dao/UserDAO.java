package by.epam.library.dao;

import by.epam.library.bean.User;
import by.epam.library.dao.exception.DAOException;

public interface UserDAO {
	User signIn(String login, int password) throws DAOException;
	void signUp(String login, int password) throws DAOException;
}
