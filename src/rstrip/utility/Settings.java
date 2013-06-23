package rstrip.utility;

public class Settings {

	private int serverPort;

	private String dbHost;
	private String dbUsername;
	private String dbPassword;
	private String dbName;
	
	public Settings(){
		this.init();
	}
	
	private void init(){
		this.serverPort = 8080;

		this.dbHost = "localhost";
		this.dbName = "rstrip";
		this.dbUsername = "root";
		this.dbPassword = "destructor";
	}
	
	public int getServerPort(){
		return this.serverPort;
	}
	
	public String getDbHost(){
		return this.dbHost;
	}
	
	public String getDbUsername(){
		return this.dbUsername;
	}
	
	public String getDbPassword(){
		return this.dbPassword;
	}
	
	public String getDbName(){
		return this.dbName;
	}
}

