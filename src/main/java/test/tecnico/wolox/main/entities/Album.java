package test.tecnico.wolox.main.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Album {

	@Id
	private int id;

	private int userId;

	private String title;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
