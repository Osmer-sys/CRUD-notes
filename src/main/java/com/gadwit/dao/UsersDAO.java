package com.gadwit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.gadwit.model.*;

public class UsersDAO {
	private  conexion con;
	private  Connection connection;
	private int id;
	Notas idUser;
	 
	public UsersDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}

	/*
	 * Insert users
	 */
	public boolean insertar(Usuarios user) throws SQLException {
		System.out.println("inserting user...");
		String sql = "INSERT INTO users (name, password, email) VALUES (?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, user.getName());
		statement.setString(2, user.getEmail());
		statement.setString(3, user.getPassword());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
	}

	public List<String> listarUsuarios() throws SQLException {
		List<String> listaUsuarios = new ArrayList<String>();
		String sql = "SELECT * FROM users";
		con.conectar();
		connection = con.getJdbcConnection();
		Statement statement = connection.createStatement();
		ResultSet resulSet = statement.executeQuery(sql);

		while (resulSet.next()) {
			String name = resulSet.getNString("name");
			String email = resulSet.getNString("email");
			String password = resulSet.getNString("password");
			listaUsuarios.add(name);
			listaUsuarios.add(email);
			listaUsuarios.add(password);
			/*
			 * código alternativo usando la clase Usuarios Usuarios usuarios = new
			 * Usuarios(name, password, email); listaUsuarios.add(usuarios.getName());
			 * listaUsuarios.add(usuarios.getEmail());
			 * listaUsuarios.add(usuarios.getPassword());
			 */

		}
		
		con.desconectar();
		return listaUsuarios;
	}

	public boolean validarUsuario(String email, String password) throws SQLException, ClassCastException {
		System.out.println("validating user...");
		List<String> validateUsuarios = new ArrayList<String>();
		validateUsuarios.add(email);
		validateUsuarios.add(password);

		if (listarUsuarios().containsAll(validateUsuarios)) {
			return true;
		} else {
			return false;
		}
	}

	public int idUserNotes(String password) throws SQLException {
		System.out.println("catching id_user...");
		String sql = "SELECT id FROM users WHERE password=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, password);
		ResultSet res = statement.executeQuery();
		while (res.next()) {
			id = res.getInt("id");
		}
		con.desconectar();
		return id;
		
		
	}

	

	public List<Notas> toListNotes() throws SQLException{

		System.out.println("listing...");
		List<Notas> toListNotes = new ArrayList<Notas>();
		String sql = "SELECT n.id_note, n.title, n.textWritten FROM notes AS n join users as u  on u.id = n.id_user WHERE u.id= ?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id );
		ResultSet resulSet = statement.executeQuery();
				
		while (resulSet.next()) {
			int id_note = resulSet.getInt("id_note");
			String title = resulSet.getString("title");
			String textWritten = resulSet.getString("textWritten");
			Notas notes = new Notas(id_note, title, textWritten);
			notes.setTitle(title);
			notes.setTextWritten(textWritten);
			notes.setId_note(id_note);
			toListNotes.add(notes);
			
		}
		
		con.desconectar();
		return toListNotes;
	}
	
}
