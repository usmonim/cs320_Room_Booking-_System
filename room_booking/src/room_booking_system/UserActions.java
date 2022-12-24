package RoomBookingSystem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class UserActions {
	
	Connection conn;
	Statement stmt;
	
	int user_id;


	public UserActions() {
		// TODO Auto-generated constructor stub
	}
	
	public UserActions(int user_id_id) {
		this.user_id = user_id_id;
	
		// TODO Auto-generated constructor stub
	}

	
	
	
	
	//Connections
	public void connections(Connection conn, Statement stmt ) {
			this.conn = conn;
			this.stmt = stmt;
	}
	
	
	
	public static void main(String[] args) {
		System.out.println("..............MMMMMMM..............");

	}
	
	
	public void userhist() throws Exception {
		
		String getUser_hist = "select room_id, room_name, user_name from room, reserves, user where room.id = reserves.room_id and reserves.user_id = user.id and reserves.user_id = " + user_id + ";";
		ResultSet rs =  stmt.executeQuery(getUser_hist);
		if(!rs.isBeforeFirst()) {
			System.out.println("User " + user_id + " reservation history is empty.");
		}
		else {
			while(rs.next()) {
				 
				 String user_name = rs.getString("user_name");
				 String room_name = rs.getString("room_name"); 
				 
				 System.out.print("|  User Name: " + user_name);
				 System.out.println("|  Room Name: " +room_name); 
				
			}
		
		
		}
	}

}

