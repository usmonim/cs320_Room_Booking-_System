package room_booking_system;

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
	
	public void creation() throws Exception {
		
		PreparedStatement preparedStatement = conn.prepareStatement("insert into building (id, building_name) values(?, ?)");
		preparedStatement.setInt(1, building_id);
		preparedStatement.setString(2, building_name);
		preparedStatement.executeUpdate();
		System.out.println("Building " + building_name + " has been created succesfully.");
		
	}
	
	// List rooms in building 
	public void listRooms() throws Exception { 
		
		String query = "select room.id, room_name, building_name, capacity, reservation_status from room, building where building.id = " + building_id + " and room.building_id = " + building_id + ";";
		
		ResultSet rs =  stmt.executeQuery(query);
		 while (rs.next()) {
			 int room_id  = rs.getInt("id");
	         String room_name = rs.getString("room_name");
	         String building_name = rs.getString("building_name");
	         int capacity = rs.getInt("capacity");
	         String reservation_status = rs.getString("reservation_status");

	         System.out.print("Room ID: " + room_id);
	         System.out.print("|  Room Name: " + room_name);
	         System.out.print("|  Building Name: " + building_name);
	         System.out.print("|  Capacity: " + capacity);
	         System.out.println("|  Reservation Status: " + reservation_status);
	      }   
		
		
	}
	
	
	
	

	
	

}
