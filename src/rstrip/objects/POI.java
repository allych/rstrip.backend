package rstrip.objects;

public class POI {
//	  private transient int value3 = 3;
	
	private Integer id;
	private Float latitude;
	private Float longitude;
	private String creation_date;
	private String update_date;
	private String img;
	private Boolean have_excursions;
	private Integer visit_time;
	private String name;
	private String description;
	private String motivation;
	private String schedule;
	private String price;
	private String features;
	private String parking;
	private String food;
	private String website;

	public POI() {
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

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Boolean getHaveExcursions() {
		return have_excursions;
	}

	public void setHaveExcursions(Boolean have_excursions) {
		this.have_excursions = have_excursions;
	}

	public Integer getVisitTime() {
		return visit_time;
	}

	public void setVisitTime(Integer visit_time) {
		this.visit_time = visit_time;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMotivation() {
		return motivation;
	}

	public void setMotivation(String motivation) {
		this.motivation = motivation;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getFeatures() {
		return features;
	}

	public void setFeatures(String features) {
		this.features = features;
	}

	public String getParking() {
		return parking;
	}

	public void setParking(String parking) {
		this.parking = parking;
	}

	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	
}