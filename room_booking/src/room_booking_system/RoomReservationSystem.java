package assignment1RoomReservation;

import java.sql.*;
package room_booking_system;

import java.sql.*;
import java.util.Scanner;

public class RoomBookingSystem {
	
 // 1 is User 0 is Admin 
	static int userType;
	public RoomBookingSystem (int userType) {
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
}