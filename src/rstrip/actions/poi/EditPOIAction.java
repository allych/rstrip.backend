package rstrip.actions.poi;

import java.sql.SQLException;
import java.util.Map;

import rstrip.Server;
import rstrip.actions.Action;
import rstrip.utility.Control;

public class EditPOIAction extends Action {

	protected EditPOIResult result;
	
	private Integer id;
	private String img;
	private Boolean have_excursions;
	private String visit_time;
	private String name;
	private String description;
	private String motivation;
	private String schedule;
	private String price;
	private String features;
	private String parking;
	private String food;
	private String website;
	
	public EditPOIAction(Map parameters) {
		super(parameters);
		this.result = new EditPOIResult();
	}
	
	protected void validateParameters(){
		this.id = Integer.parseInt(parameters.get("id").toString());
		this.img = (parameters.get("img") != null) ? parameters.get("img").toString() : null;
		if (parameters.get("have_excursions") != null) {
			this.have_excursions = parameters.get("have_excursions").toString().equals("1") ? true : false;
		}
		this.visit_time = (parameters.get("visit_time") != null) ? parameters.get("visit_time").toString() : null;
		this.name = (parameters.get("name") != null) ? parameters.get("name").toString() : null;
		this.description = (parameters.get("description") != null) ? parameters.get("description").toString() : null;
		this.motivation = (parameters.get("motivation") != null) ? parameters.get("motivation").toString() : null;
		this.schedule = (parameters.get("schedule") != null) ? parameters.get("schedule").toString() : null;
		this.price = (parameters.get("price") != null) ? parameters.get("price").toString() : null;
		this.features = (parameters.get("features") != null) ? parameters.get("features").toString() : null;
		this.parking = (parameters.get("parking") != null) ? parameters.get("parking").toString() : null;
		this.food = (parameters.get("food") != null) ? parameters.get("food").toString() : null;
		this.website = (parameters.get("website") != null) ? parameters.get("website").toString() : null;
		
		if (this.id == null){
			error = "ERROR 302 :: PARAMETER IS NOT PASSED (id)";
			return;
		}
		
		if (!Control.isUnsignedInteger(this.id)){
			error = "ERROR 40 :: NOT VALID PARAMETER (id)";
			return;
		}
		else if (this.img != null && !Control.isString(this.img)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (img)";
			return;
		}
		else if (this.visit_time != null && !Control.isString(this.visit_time)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (visit_time)";
			return;
		}
		else if (this.name != null && !Control.isString(this.name)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (name)";
			return;
		}
		else if (this.description != null && !Control.isString(this.description)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (description)";
			return;
		}
		else if (this.motivation != null && !Control.isString(this.motivation)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (motivation)";
			return;
		}
		else if (this.schedule != null && !Control.isString(this.schedule)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (schedule)";
			return;
		}
		else if (this.price != null && !Control.isString(this.price)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (price)";
			return;
		}
		else if (this.features != null && !Control.isString(this.features)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (features)";
			return;
		}
		else if (this.parking != null && !Control.isString(this.parking)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (parking)";
			return;
		}
		else if (this.food != null && !Control.isString(this.food)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (food)";
			return;
		}
		else if (this.website != null && !Control.isString(this.website)) {
			error = "ERROR 40 :: NOT VALID PARAMETER (website)";
			return;
		}
	}
	
	public void execute() throws SQLException {
		Server.database.startTransaction();
		
		String query = "";
		if (this.name != null) {
			query += ", `name`='" + this.name + "'";
		}
		if (this.description != null) {
			query += ", `description`='" + this.description + "'";
		}
		if (this.motivation != null) {
			query += ", `motivation`='" + this.motivation + "'";
		}
		if (this.schedule != null) {
			query += ", `schedule`='" + this.schedule + "'";
		}
		if (this.price != null) {
			query += ", `price`='" + this.price + "'";
		}
		if (this.features != null) {
			query += ", `features`='" + this.features + "'";
		}
		if (this.parking != null) {
			query += ", `parking`='" + this.parking + "'";
		}
		if (this.food != null) {
			query += ", `food`='" + this.food + "'";
		}
		if (this.website != null) {
			query += ", `website`='" + this.website + "'";
		}
		
		if (!query.equals("")){
			query = "UPDATE poi_localized SET " + query.substring(1) + " WHERE `id_poi`='" + this.id + "'";
			Server.database.exec(query);
		}
		
		query = "UPDATE poi SET update_date = NOW()";
		if (this.img != null) {
			query += ", `img`='" + this.img + "'";
		}
		if (this.have_excursions != null) {
			query += ", `have_excursions`='" + this.have_excursions + "'";
		}
		if (this.visit_time != null) {
			query += ", `visit_time`='" + this.visit_time + "'";
		}
		
		query += " WHERE `id`='" + this.id + "'";
		Server.database.exec(query);

		this.result.poi.setId(this.id);
		
		Server.database.endTransaction();
	}
	
	public EditPOIResult getResult() {
		return this.result;
	}
	
}
