package assignment1RoomReservation;
import java.sql.*;
import java.util.Scanner;

public class RoomActions {

	//Room variables 
	String room_name;
	int building_id;
	int capacity;
	String property_string;
	int room_id;
	
	String not_occupied = "Not occupied";
	
  	Connection conn;
	Statement stmt;

	
	
	//Connections
	public void connections(Connection conn, Statement stmt ) {
		this.conn = conn;
		this.stmt = stmt;
	}
	
	public RoomActions() {
	//Empty Constructor 
		}
	
	//Creation Constructor 
	public RoomActions(String room_name, int building_id, int capacity, String property_string) {
		this.room_name = room_name;
		this.building_id = building_id;
		this.capacity = capacity;
		this.property_string = property_string;
//		this.conn = conn;
		// TODO Auto-generated constructor stub
	}
	//Deletion COnstructor
	public RoomActions(int room_id ) {
		this.room_id = room_id;
//		this.stmt = stmt;
		// TODO Auto-generated constructor stub
	}
	public void creation() throws Exception {
		
		PreparedStatement preparedStatement = conn.prepareStatement("insert into room (room_name, building_id, capacity, property_string, reservation_status) values(?, ?, ?, ?, ?)");
		preparedStatement.setString(1, room_name);
		preparedStatement.setInt(2, building_id);
		preparedStatement.setInt(3, capacity);
		preparedStatement.setString(4, property_string);
		preparedStatement.setString(5, not_occupied); //When the room in created i set its reservation_status: Not Occupied. Status changes to "Occupied" when we reserve a room.
		preparedStatement.executeUpdate();
		System.out.println("Room " + room_name + " has been created succesfully.");
		
	}
	public void deletion() throws Exception {
		
		String get_reserveIfexist = "select* from reserves where room_id = " + room_id + ";";
		ResultSet rs =  stmt.executeQuery(get_reserveIfexist);
		if(!rs.isBeforeFirst()) {
                //System.out.println("reserve do not exist");
			PreparedStatement preparedStatement = conn.prepareStatement("delete from room where id = ?");
			preparedStatement.setInt(1, room_id);
			preparedStatement.executeUpdate();
			System.out.println("Room has been removed.");
		}
		else {
//			System.out.println("reserve exist");
			PreparedStatement preparedStatement = conn.prepareStatement("delete from reserves where room_id = ?;");
			preparedStatement.setInt(1, room_id);
			preparedStatement.executeUpdate();
			
			PreparedStatement preparedStatement2 = conn.prepareStatement("delete from room where id = ?");
			preparedStatement2.setInt(1, room_id);
			preparedStatement2.executeUpdate();
			System.out.println("Room has been removed.");
			
		}
	}
	
  }
