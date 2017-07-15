package by.epam.library.dao;

import java.util.List;

import by.epam.library.bean.Book;
import by.epam.library.dao.exception.DAOException;

public interface BookDAO {
	void addNewBook(String title, String authro, String genre, String year, int quantity) throws DAOException;
	void addEditBook(String title, String genre, String author, String year, int quantity, int idBook) throws DAOException;
	List<Book> getBooklist() throws DAOException;
}
