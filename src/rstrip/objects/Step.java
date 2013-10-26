package rstrip.objects;

public class Step {
	
	private Integer id;
	private Integer id_user;
	private Float latitude;
	private Float longitude;
	private String creation_date;
	private String update_date;
	private String name;
	private String type;

	public Step() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getLatitude() {
		return latitude;
	}

	public void setLatitude(Float latitude) {
		this.latitude = latitude;
	}

	public Float getLongitude() {
		return longitude;
	}

	public void setLongitude(Float longitude) {
		this.longitude = longitude;
	}

	public String getCreationDate() {
		return creation_date;
	}

	public void setCreationDate(String creation_date) {
		this.creation_date = creation_date;
	}

	public String getUpdateDate() {
		return update_date;
	}

	public void setUpdateDate(String update_Date) {
		this.update_date = update_Date;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getIdUser() {
		return id_user;
	}

	public void setIdUser(Integer id_user) {
		this.id_user = id_user;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}