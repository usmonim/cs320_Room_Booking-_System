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
  }
