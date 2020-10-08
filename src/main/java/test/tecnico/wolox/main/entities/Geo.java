package test.tecnico.wolox.main.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Geo {

	@Id
	private int id;
	
	private float lat;

	private float lng;

	public float getLat() {
		return lat;
	}

	public void setLat(float lat) {
		this.lat = lat;
	}

	public float getLng() {
		return lng;
	}

	public void setLng(float lng) {
		this.lng = lng;
	}

}
