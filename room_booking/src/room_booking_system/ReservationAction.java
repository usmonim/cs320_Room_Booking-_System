package room_booking_system;

//java.sql package in the Java SE class library enables us to work with databases from SQL.
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReservationActions {

	int room_id;
	int user_id;
	
	Connection conn;
	Statement stmt;
	
	public ReservationActions() {
		//constructor added
	}
	
	public ReservationActions(int room_id, int user_id) {
		this.room_id = room_id;
		this.user_id = user_id;
	}
	
	//Connections
	public void connections(Connection conn, Statement stmt ) {
			this.conn = conn;
			this.stmt = stmt;
	}
	
	public static void main(String[] args) {
		System.out.println("..............MMMMMMM..............");

	}
	
	public void rommhist() throws Exception {
		
		String getRoom_hist = "select room_id, room_name, user_name from room, reserves, user where room.id = reserves.room_id and reserves.user_id = user.id and reserves.room_id = " + room_id + ";";
		ResultSet rs =  stmt.executeQuery(getRoom_hist);
		if(!rs.isBeforeFirst()) {
			System.out.println("Room " + room_id + " has never been reserved.");
		}
		else {
		   while(rs.next()) {
			String room_name = rs.getString("room_name"); 
			String user_name = rs.getString("user_name");
				
			System.out.print("|  Room Name: " +room_name); 
			System.out.println("|  User Name: " + user_name);
			}
		}
	}
	
	public void roomreserv() throws Exception {
		
		String get_status = "select reservation_status from room where id = " + room_id + ";";
		//String get_roomNameForcheck = "select room_name from room where id = " + room_id + ";";
		ResultSet rs =  stmt.executeQuery(get_status);
		//ResultSet rsRoom_name =  stmt.executeQuery(get_roomNameForcheck);
		
	}
	
	
}
