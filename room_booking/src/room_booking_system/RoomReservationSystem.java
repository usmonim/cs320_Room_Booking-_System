package assignment1RoomReservation;

import java.sql.*;
package room_booking_system;

import java.sql.*;
import java.util.Scanner;

public class RoomBookingSystem {

	// 1 is User 0 is Admin
	static int userType;

	public RoomBookingSystem(int userType) {
		RoomBookingSystem.userType = userType;
	}


	static final String DB_URL = "jdbc:mysql://localhost/room reservation";
	static final String USER = "root";
	static final String PASS = "u311200t";
	//Menu options Strings
	public static String menu = "Menu:";
	public static String one = "    Create Room";
	public static String two = "    Remove Room";
	public static String three = "    List all Rooms in a Building With Their Vacancy Information";
	public static String four = "    Get Currently Occupied Rooms";
	public static String five = "    Search For a Room";
	public static String six = "    Get Reservation History of a Room";
	public static String seven = "    Get Reservation History of a User";
	public static String eight = "    Reserve a Room";
	public static String nine = "    Leave a Room";
	public static String ten = "    Create Building";
	public static String zero = "    0 - Show Menu";
	public static Scanner input = new Scanner(System.in);
	public static int choose;

	public static void userMenu() {
		System.out.println(menu);
		System.out.println("1. " + three); //list
		System.out.println("2. " + four);  //get occupied
		System.out.println("3. " + five);  //search room
		System.out.println("4. " + eight);  // reserve room
		System.out.println("5. " + nine);   // leave room
		System.out.println(zero);   // menu show

	}

	public static void userSelect() throws Exception {
		Connection conn = null;
		Statement stmt = null;
		conn = DriverManager.getConnection(DB_URL, USER, PASS);
		stmt = conn.createStatement();
		int room_id;
		String room_name = "";
		int building_id;
		int capacity;
		String property_string = "";
		int user_id;
		System.out.println("select >: ");
		choose = input.nextInt();
		try {

			// Menu Option 1
			if (choose == 1) {
				System.out.println("1. List all Rooms in a Building With Their Vacancy Information");
				System.out.println("Building ID >: ");
				building_id = input.nextInt();

				BuildingActions listrooms = new BuildingActions(building_id);
				listrooms.connections(conn, stmt);
				listrooms.listRooms();

			}
			//Menu Option 2
			if (choose == 2) {
				System.out.println("2. Get Currently Occupied Rooms");
				
				RoomActions room = new RoomActions();
				room.connections(conn, stmt);
				room.getoccupied();
			}
			
			//Menu Option 3 
			if (choose == 3) {
				System.out.println(''3.Search For a Room");
						   
				String template = "";
			}
			
		}


	}



