package assignment1RoomReservation;

import java.sql.*;
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
			// Menu Option 0 Shows menu again  
			else if(choose == 0) {
				userMenu();
				userSelect();
			}

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
				System.out.println("Enter a template>: ");
				template = input.next();
						   
				RoomActions room = new RoomActions();
				room.connections(conn, stmt);
				room.search(template);
				
			}
			// Menu Option 4
			else if(choose == 4) {
				System.out.println("4. Reserve a Room");
				System.out.println("Enter room ID>: ");
				room_id = input.nextInt();
				System.out.println("Enter user ID>: ");
				user_id = input.nextInt();
				
				ReservationActions roomreserv = new ReservationActions(room_id, user_id);
				roomreserv.connections(conn, stmt);
				roomreserv.roomreserv();
				
			}
			// Menu Option 5
			else if(choose == 5) {
				System.out.println("5. Leave a Room");
				System.out.println("Enter room ID>: ");
				room_id = input.nextInt();
				
				ReservationActions leaving = new ReservationActions(room_id);
				leaving.connections(conn, stmt);
				leaving.leaveroom();
				
			}
						   
                        // Menu Option 0 Shows menu again  
			else if(choose == 0) {
				userMenu();
				userSelect();
			}
						   
			// If user enters number >9 or <0
			else {
				System.out.println("Please choose Menu option from 0 to 5");
				userSelect();
			}
			
			userSelect(); //Looping menu so that after we successfully done something it continues working and we can choose other option
			
			
		}
                ///HANDLING EXCEPTIONS. 		
		catch(java.sql.SQLIntegrityConstraintViolationException ex) { //EXCEPTION if we try to create 2 identical rooms in one building. 
			System.out.println("There can not 2 rooms with same name in one Building");
			userSelect();
		}

		finally{
			//finally block used to close resources
			try{
				if(stmt!=null)
					stmt.close();
			} catch(SQLException se2){
			}// nothing we can do
			try{
				if(conn!=null)
					conn.close();
			}
			catch(SQLException se){
				se.printStackTrace();
			}



	}
	}
	public static void adminMenu() {
		System.out.println(menu);
		System.out.println("1. " + one); //create
		System.out.println("2. " + two);  //remove
		System.out.println("3. " + six);  //room history
		System.out.println("4. " + seven);  // user history
		System.out.println("5. " + ten);  // create building
		System.out.println(zero);   // menu show

	}
	//Select function where we select option from Menu
	public static void adminSelect() throws Exception {
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
//		String user_name;
//		String reservation_status;
//		String not_occupied = "Not occupied";
		System.out.println("select >: ");
		choose = input.nextInt();

		try{

			// Menu Option 1 we create room
			if(choose == 1) {
				System.out.println("1. Create Room");
				input.nextLine();
				System.out.println("Room Name >: ");
				room_name = input.nextLine();

				System.out.println("Building Location >: ");
				building_id = input.nextInt();

				System.out.println("Capacity >: ");
				capacity = input.nextInt();

				input.nextLine();

				System.out.println("Property of  Room >:");
				property_string  = input.nextLine();


				RoomActions newRoom = new RoomActions(room_name, building_id, capacity, property_string);
				newRoom.connections(conn, stmt);
				newRoom.creation();
			}
			// Menu Option 2
			else if (choose == 2) {
				System.out.println("2. Remove Room");
				System.out.println("Enter room ID>: ");
				room_id = input.nextInt();

				RoomActions delRoom = new RoomActions(room_id);
				delRoom.connections(conn, stmt);
				delRoom.deletion();



		}
		        // Menu Option 3
		        else if(choose == 3) {
				System.out.println("3. Get Reservation History of a Room");
				System.out.println("Enter room ID>: ");
				room_id = input.nextInt();
					ReservationActions roomhist = new ReservationActions(room_id);
				roomhist.connections(conn, stmt);
				roomhist.rommhist();
			}
                        // Menu Option 4
			else if(choose == 4) {
				System.out.println("4. Get Reservation History of a User");
				System.out.println("Enter User ID>: ");
				user_id = input.nextInt();
				UserActions userhist = new UserActions(user_id);
				userhist.connections(conn, stmt);
				userhist.userhist();

			}
			else if(choose == 5) {
				System.out.println("5. Create Building ");
				input.nextLine();
				System.out.println("Building Name >: ");
				String building_name = input.nextLine();
				
				System.out.println("Building ID >: ");
				building_id = input.nextInt();
				
				
				BuildingActions newBuilding = new BuildingActions(building_id, building_name);
				newBuilding.connections(conn, stmt);
				newBuilding.creation();		
			}
			// Menu Option 0 
			else if(choose == 0) {
				adminMenu();
				adminSelect();
			}
                       // >5 or <0
			else {
				System.out.println("Please choose Menu option from 0 to 5");
				adminSelect();
			}
			
			adminSelect(); //Looping menu so that after we successfully done something it continues working and we can choose other option
		}
		
		///HANDLING EXCEPTIONS. 		
		catch(java.sql.SQLIntegrityConstraintViolationException ex) { //EXCEPTION if we try to create 2 identical rooms in one building. 
			System.out.println("There can not 2 identical rooms or buildings with same name or ID in one Building or Table");
			adminSelect();
		}
		finally{
		       //finally block used to close resources
		       try{
		          if(stmt!=null)
		             stmt.close();
		       }
		       catch(SQLException se2){
		       }// nothing we can do
		       try{
		          if(conn!=null)
		             conn.close();
		       }
		       catch(SQLException se){
		          se.printStackTrace();
		       }
		}

	}

	public static void main(String[] args) throws Exception {
		if(userType == 1) {
			userMenu();
			userSelect();
		}

		else if (userType == 0) {
			adminMenu();
			adminSelect();


		}
	}

	public static void main(String[] args) throws Exception {
		if(userType == 1) {
			userMenu();
			userSelect();
		}

		else if (userType == 0) {
			adminMenu();
			adminSelect();


		}
	}

}
}



