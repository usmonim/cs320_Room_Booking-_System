package assignment1RoomReservation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class ReservationActions {

    int room_id;

    int user_id;


    Connection conn;
    Statement stmt;
