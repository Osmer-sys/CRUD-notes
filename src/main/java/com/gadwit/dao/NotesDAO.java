package com.gadwit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.gadwit.model.*;

public class NotesDAO {
	private conexion con;
	private Connection connection;
	
	public NotesDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) throws SQLException {
		System.out.println(jdbcURL);
		con = new conexion(jdbcURL, jdbcUsername, jdbcPassword);
	}
	public boolean insertNotes(Notas notes, int id_user) throws SQLException {
		System.out.println("inserting note...");
		String sql = "INSERT INTO notes (id_user, title, textWritten) VALUES (?,?,?)";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_user );
		statement.setString(2, notes.getTitle());
		statement.setString(3, notes.getTextWritten());

		boolean rowInserted = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowInserted;
		
	}
	public Notas byIdNotes(int id_note) throws SQLException {
		System.out.println("catching by id_note..." );
		Notas note = null;
		String sql = "SELECT id_note,title, textWritten FROM notes WHERE id_note= ? ";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, id_note);
		ResultSet res = statement.executeQuery();
		if (res.next()) {
			note = new Notas(res.getInt("id_note"), res.getString("title"), res.getString("textWritten"));
			
		}
		res.close();
		con.desconectar();
		return note;
	}

	public boolean updateNote(Notas notes) throws SQLException {
		System.out.println("updating...");
		boolean rowToUpdate = false;
		String sql = "UPDATE notes SET title=?, textWritten=? WHERE id_note=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, notes.getTitle());
		statement.setString(2, notes.getTextWritten());
		statement.setInt(3, notes.getId_note());
		
		rowToUpdate = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();
		return rowToUpdate;
		
	}
	public boolean delete(Notas note) throws SQLException {
		boolean rowEliminar = false;
		String sql = "DELETE FROM notes WHERE id_note=?";
		con.conectar();
		connection = con.getJdbcConnection();
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setInt(1, note.getId_note());

		rowEliminar = statement.executeUpdate() > 0;
		statement.close();
		con.desconectar();

		return rowEliminar;
		
	}
	
}
