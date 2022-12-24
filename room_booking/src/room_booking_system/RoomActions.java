package room_booking_system;
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
	public void connections(Connection conn, Statement stmt) {
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
	public RoomActions(int room_id) {
		this.room_id = room_id;
//		this.stmt = stmt;
		// TODO Auto-generated constructor stub
	}
	
	// functions for creating a new room in db
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
	// functions for deleating a room in db but first it checks if this room is reserved or not. 
	public void deletion() throws Exception {

		String get_reserveIfexist = "select* from reserves where room_id = " + room_id + ";";
		ResultSet rs = stmt.executeQuery(get_reserveIfexist);
		if (!rs.isBeforeFirst()) {
			//System.out.println("reserve do not exist");
			PreparedStatement preparedStatement = conn.prepareStatement("delete from room where id = ?");
			preparedStatement.setInt(1, room_id);
			preparedStatement.executeUpdate();
			System.out.println("Room has been removed.");
		} else {
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

	// functions fro getting all occupied/reseved rooms from DB 
	public void getoccupied() throws Exception {


		String get_allstatuses = "select room.id, room_name, capacity from room where reservation_status = 'Occupied'";
		ResultSet rs = stmt.executeQuery(get_allstatuses);
		if (!rs.isBeforeFirst()) {
			System.out.println("Currently occupied rooms not found.");
		} else {
			System.out.println("Currently occupied rooms: ");
			while (rs.next()) {
				int room_id = rs.getInt("id");
				String room_name = rs.getString("room_name");
				int capacity = rs.getInt("capacity");

				System.out.print("Room ID: " + room_id);
				System.out.print("|  Room Name: " + room_name);
				System.out.println("|  Capacity: " + capacity);
			}
		}

	}
	
	//Searching a room with speciified sstring. If we want a room with laptop we give an input and it searches in rooms properties if there exist a room with laptop
	public void search(String template) throws Exception {
		String get_satusfyingRooms = "select id, room_name, building_id, capacity, reservation_status, property_string from room where property_string like '%" + template + "%';";
		ResultSet rs = stmt.executeQuery(get_satusfyingRooms);
		if (!rs.isBeforeFirst()) {
			System.out.println("Room with " + "<" + template + ">" + " was not found.");
		} else {
			while (rs.next()) {
				int room_id = rs.getInt("id");
				String room_name = rs.getString("room_name");
				int building_id = rs.getInt("building_id");
				int capacity = rs.getInt("capacity");
				String reservation_status = rs.getString("reservation_status");
				String property_string = rs.getString("property_string");

				System.out.print("Room ID: " + room_id);
				System.out.print("|  Room Name: " + room_name);
				System.out.print("|  Building ID: " + building_id);
				System.out.print("|  Capacity: " + capacity);
				System.out.print("|  Reservation Status: " + reservation_status);
				System.out.println("|  Propery: " + property_string);
			}
		}

	}
}
