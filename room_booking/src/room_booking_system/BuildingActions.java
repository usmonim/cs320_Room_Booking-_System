package assignment1RoomReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class BuildingActions {
	
	int building_id;
	private String building_name;
	
	Connection conn;
	Statement stmt;

	
	
	public BuildingActions() {
		//Empty Constructor 
	}

	public BuildingActions(int building_id) {
		// TODO Auto-generated constructor stub
		this.building_id = building_id;
	}
	
	public BuildingActions(int building_id, String building_name) {
		// TODO Auto-generated constructor stub
		this.building_id = building_id;
		this.building_name = building_name;
	}
	
	
	//Connections
	public void connections(Connection conn, Statement stmt ) {
		this.conn = conn;
		this.stmt = stmt;
	}

	public static void main(String[] args) {
		System.out.println("..............MMMMMMM..............");

	}
	
	
	
	

	
	

}
