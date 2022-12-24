package RoomBookingSystem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReservationActions {

    int room_id;

    int user_id;


    Connection conn;
    Statement stmt;

    public ReservationActions() { //Empty Constructer
        // TODO Auto-generated constructor stub
    }

    public ReservationActions(int room_id) {
        this.room_id = room_id;
        // TODO Auto-generated constructor stub
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


