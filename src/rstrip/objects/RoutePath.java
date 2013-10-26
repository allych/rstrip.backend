package rstrip.objects;

public class RoutePath {

	private Integer id;
	private Integer id_route;
	private Integer id_poi;
	private Integer id_step;
	private String transport;
	private String time;
	private Float distance;
	private Boolean payment_required;
	private Short quality;
	private Short complexity;
	private Boolean overnight_stay;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdRoute() {
		return id_route;
	}
	public void setIdRoute(Integer id_route) {
		this.id_route = id_route;
	}
	public Integer getIdStep() {
		return id_step;
	}
	public void setIdStep(Integer id_step) {
		this.id_step = id_step;
	}
	public Integer getIdPoi() {
		return id_poi;
	}
	public void setIdPoi(Integer id_poi) {
		this.id_poi = id_poi;
	}
	public String getTransport() {
		return transport;
	}
	public void setTransport(String transport) {
		this.transport = transport;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Float getDistance() {
		return distance;
	}
	public void setDistance(Float distance) {
		this.distance = distance;
	}
	public Boolean getPaymentRequired() {
		return payment_required;
	}
	public void setPaymentRequired(Boolean payment_required) {
		this.payment_required = payment_required;
	}
	public Short getQuality() {
		return quality;
	}
	public void setQuality(Short quality) {
		this.quality = quality;
	}
	public Short getComplexity() {
		return complexity;
	}
	public void setComplexity(Short complexity) {
		this.complexity = complexity;
	}
	public Boolean getOvernightStay() {
		return overnight_stay;
	}
	public void setOvernightStay(Boolean overnight_stay) {
		this.overnight_stay = overnight_stay;
	}
	
}
