package com.connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.sql.MysqlConnection;
import com.uberbooking.UberBooking;




public class DBoperation {
	Connection connection;
	Statement statement;
	PreparedStatement pstate;
	ResultSet resultset;
	
	public DBoperation() {
		connection = MysqlConnection.getInstance();
	}
	public int insertDataWithStatement(UberBooking ub) {
		int result = 0;
		String query = "insert into uber values(?,?,?)";	
		try {
			pstate = connection.prepareStatement(query);
			pstate.setString( 1, ub.getStartingpoint());
			pstate.setString(2, ub.getEndingpoint() );
			pstate.setLong(3, ub.getJourneyprice());
			
			result = pstate.executeUpdate();
		}
			catch(Exception e) {
				e.printStackTrace();
			}
		return result;
		
	}
	
}