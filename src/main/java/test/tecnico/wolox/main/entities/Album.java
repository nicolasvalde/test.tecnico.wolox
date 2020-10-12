package test.tecnico.wolox.main.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "albums")
@TableGenerator(name = "tabGen", initialValue = 1000)
public class Album {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "tabGen")
	private int id;

	private String title;

	@Column(name = "user_id")
	private int userId;

	@OneToMany
	@JoinColumn(name = "album_id")
	@JsonIgnore
	private List<Photo> photos;

	@OneToMany(cascade = CascadeType.ALL)
//	@JoinColumn(name = "permission_id")
//	@JsonIgnore
	private List<Permission> permissions;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public List<Photo> getPhotos() {
		return photos;
	}

	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(List<Permission> permissions) {
		this.permissions = permissions;
	}

	
}
