package by.epam.library.controller;

public final class PageName {
	private PageName() {}

	public static final String ERROR_REQUEST_PAGE = "/errorpage";
	public static final String INDEX_PAGE = "/index";
	public static final String BOOKLIST_PAGE = "/booklist";

	public static final String REDIRECT_ERROR_OPERATION = "/Controller?command=redirect&pagename=index&message=An error occurred during the operation&status=false";
	public static final String REDIRECT_ADD_NEW_BOOK_SUCCESS = "/Controller?command=redirect&pagename=index&message=Book added successfully&status=true";
	public static final String REDIRECT_ADD_NEW_BOOK_ERROR = "/Controller?command=redirect&pagename=index&message=Failed to add book&status=false";
	public static final String REDIRECT_ADD_EDIT_BOOK_SUCCESS = "/Controller?command=redirect&pagename=index&message=Book edited successfully&status=true";
	public static final String REDIRECT_ADD_EDIT_BOOK_ERROR = "/Controller?command=redirect&pagename=index&message=Failed to edit book&status=false";
	public static final String REDIRECT_SIGN_IN_ERROR = "/Controller?command=redirect&pagename=index&message=Incorrect login or password&status=false";
	public static final String REDIRECT_SIGN_UP_SUCCESS = "/Controller?command=redirect&pagename=index&message=Registration completed successfully&status=true";
	public static final String REDIRECT_SIGN_UP_ERROR = "/Controller?command=redirect&pagename=index&message=Incorrect registration data&status=false";	
}