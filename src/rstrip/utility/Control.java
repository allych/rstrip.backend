package rstrip.utility;

public class Control {

	public static Boolean isUnsignedInteger(Integer value){
		if (value >= 0){
			return true;
		}
		return false;
	}
	
	public static Boolean isUnsignedFloat(Float value){
		if (value >= 0){
			return true;
		}
		return false;
	}
	
	public static Boolean isString(String value) {
		return true;
	}
	
	public static Boolean isText(String value) {
		return true;
	}
	
}
