package com.wma.wmamanager.Utils;

public enum Days {
	
	Mon("Monday"),
	Tues("Tuesday"),
	Weds("Wednesday"),
	Thurs("Thursday"),
	Fri("Friday"),
	Sat("Saturday"),
	Sun("Sunday");

	private String id;
	
	private Days(String id){
        this.id = id;
    }
	
	public String getId(){
	    return id;
	} 
}
