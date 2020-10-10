package test.tecnico.wolox.main.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@Table(name = "permissions")
@IdClass(PermissionId.class)
public class Permission implements Serializable {

	private boolean read;

	private boolean write;

	@Id
	private int albumId;

	@Id
	private int userId;

	public boolean isRead() {
		return read;
	}

	public Permission() {
	}

	public Permission(boolean read, boolean write, int albumId, int userId) {
		this.read = read;
		this.write = write;
		this.albumId = albumId;
		this.userId = userId;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public boolean isWrite() {
		return write;
	}

	public void setWrite(boolean write) {
		this.write = write;
	}

	public int getAlbumId() {
		return albumId;
	}

	public void setAlbumId(int albumId) {
		this.albumId = albumId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + albumId;
		result = prime * result + (read ? 1231 : 1237);
		result = prime * result + userId;
		result = prime * result + (write ? 1231 : 1237);
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
		Permission other = (Permission) obj;
		if (albumId != other.albumId)
			return false;
		if (read != other.read)
			return false;
		if (userId != other.userId)
			return false;
		if (write != other.write)
			return false;
		return true;
	}

}
