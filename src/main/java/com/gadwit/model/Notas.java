package com.gadwit.model;

public class Notas {
	private int id_user;
	private int id_note;
	private String title;
	private String textWritten;
	
	public Notas(int id_note, String title, String textWritten) {
		this.id_note=id_note;
		this.title = title;
		this.textWritten = textWritten;
	}
	
	public Notas(String title, String textWritten) {
		this.title = title;
		this.textWritten = textWritten;
	}
	public Notas(int id_user) {
		super();
		this.id_user=id_user;
	}
	
	public int getId_note() {
		return id_note;
	}

	public void setId_note(int id_note) {
		this.id_note = id_note;
	}

	public int getId_user() {
		return id_user;
	}

	public void setId_user(int id_user) {
		this.id_user = id_user;
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getTextWritten() {
		return textWritten;
	}
	public void setTextWritten(String textWritten) {
		this.textWritten = textWritten;
	}
	
	
}
