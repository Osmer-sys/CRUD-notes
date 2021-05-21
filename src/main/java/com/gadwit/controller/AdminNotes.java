package com.gadwit.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gadwit.dao.*;
import com.gadwit.model.*;

/**
 * Servlet implementation class AdminNotes
 */
@WebServlet("/AdminNotes")
public class AdminNotes extends HttpServlet {
	private static final long serialVersionUID = 1L;
     UsersDAO usersDAO;
     NotesDAO notesDAO;
     int id_user;
     
	public void init() throws ServletException{
		String jdbcURL = getServletContext().getInitParameter("jdbcURL");
		String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
		String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");
		try {

			usersDAO = new UsersDAO(jdbcURL, jdbcUsername, jdbcPassword);
			notesDAO = new NotesDAO(jdbcURL, jdbcUsername, jdbcPassword);
		} catch (Exception e) {
			
		}
	}
    public AdminNotes() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 * Esto es lo primero que se ejecuta
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		doPost(request, response);
				
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		String actionPost = request.getParameter("action");
		System.out.println(actionPost);
		try {
			switch (actionPost) {
			case "login":
				login(request, response);
				break;
			case "registerUser":
				registerUser(request, response);
				break;
			case "register":
				register(request, response);
				break;
			case "about":
				about(request, response);
				break;
			case "validateUser":
				validateUser(request, response);
				break;
			case "insertNote":
				insertNote(request, response);
				break;
			case "showNotes":
				showNotes(request, response);
				break;
			case "showUpdate":
				showUpdate(request, response);
				break;
			case "update":
				toUpdate(request, response);
				break;
			case "delete":
				delete(request, response);
				break;
			case "back":
				back (request, response);
				break;
			}
		} catch (SQLException e) {
			e.getStackTrace();
		}
		
	}
	
	
	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/login.jsp");
		dispatcher.forward(request, response);
	}
	
	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/register.jsp");
		dispatcher.forward(request, response);
	}
	private void about(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/about.jsp");
		dispatcher.forward(request, response);
	}
	
	private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		Usuarios user = new Usuarios (request.getParameter("name"), request.getParameter("email"), request.getParameter("password"));
		usersDAO.insertar(user);
	}
	
	private void validateUser(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException {
		if(usersDAO.validarUsuario(request.getParameter("email"), request.getParameter("password"))) {
			id_user = usersDAO.idUserNotes(request.getParameter("password"));
			System.out.println(id_user);
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/notes.jsp");
			dispatcher.forward(request, response);
		}else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/views/error.jsp");
			dispatcher.forward(request, response);
		}
	}
	private void showNotes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
		List<Notas> listNotes= usersDAO.toListNotes();
		request.setAttribute("lista", listNotes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/showNotes.jsp");
		dispatcher.forward(request, response);
	}
	private void insertNote(HttpServletRequest request, HttpServletResponse response) throws SQLException {
		Notas notes = new Notas(request.getParameter("title"), request.getParameter("note"));
		notesDAO.insertNotes(notes, id_user );
	}
	private void showUpdate(HttpServletRequest request, HttpServletResponse response) throws NumberFormatException, SQLException, ServletException, IOException {
		Notas note =notesDAO.byIdNotes(Integer.parseInt(request.getParameter("id_note")));
		request.setAttribute("note", note);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/update.jsp");
		dispatcher.forward(request, response);
	}
	private void toUpdate(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException {
		Notas notes = new Notas(Integer.parseInt(request.getParameter("id_note")),request.getParameter("title"), request.getParameter("textWritten"));
		notesDAO.updateNote(notes);
	}
	
	private void delete(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException  {
		Notas note =notesDAO.byIdNotes(Integer.parseInt(request.getParameter("id_note")));
		notesDAO.delete(note);
		
	}
	private void back(HttpServletRequest request, HttpServletResponse response)throws SQLException, ServletException, IOException{
		RequestDispatcher dispatcher = request.getRequestDispatcher("/views/notes.jsp");
		dispatcher.forward(request, response);
		
	}
	
	
}
