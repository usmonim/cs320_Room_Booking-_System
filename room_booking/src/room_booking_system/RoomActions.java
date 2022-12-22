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
  }
