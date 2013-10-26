package rstrip.objects;

public class Route {
	
	private Integer id;
	private Integer id_user;
	private String name;
	private String date_start;
	private String date_end;

	public Route() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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

	public String getDateStart() {
		return date_start;
	}

	public void setDateStart(String date_start) {
		this.date_start = date_start;
	}

	public String getDateEnd() {
		return date_end;
	}

	public void setDateEnd(String date_end) {
		this.date_end = date_end;
	}
	
}