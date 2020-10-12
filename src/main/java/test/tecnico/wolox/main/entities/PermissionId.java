package test.tecnico.wolox.main.entities;

import java.io.Serializable;

import javax.persistence.Column;

public class PermissionId implements Serializable {

	@Column(name = "user_id")
	private int user;

	@Column(name = "album_id")
	private int album;

	public PermissionId() {
		super();
		// TODO Auto-generated constructor stub
	}

	public PermissionId(int user, int album) {
		super();
		this.user = user;
		this.album = album;
	}

	public int getUser() {
		return user;
	}

	public void setUser(int user) {
		this.user = user;
	}

	public int getAlbum() {
		return album;
	}

	public void setAlbum(int album) {
		this.album = album;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + album;
		result = prime * result + user;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PermissionId other = (PermissionId) obj;
		if (album != other.album)
			return false;
		if (user != other.user)
			return false;
		return true;
	}



}
