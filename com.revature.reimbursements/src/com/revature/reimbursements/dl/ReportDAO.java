package com.revature.reimbursements.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.reimbursements.models.Report;

public class ReportDAO implements DAO<Report, Integer> {
	private final Logger logger = LogManager.getLogger(this.getClass());

	@Override
	public Report findById(Integer id) {
		// try with resources block, after the try block finishes executing, it
		// disposes of the resources for you
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			// ? is a placeholder for parameter we'll be sending our DB
			String query = "select * from report where emp_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			// executeQuery - used for executing select commands
			// result set - holds the results from the DB
			ResultSet rs = pstmt.executeQuery();
			// we need to unpack result set to return something to end user
			if (rs.next()) {
				return new Report(rs.getString("Title"), rs.getString("Item Name"), rs.getInt("Item Cost,"), rs.getInt("empId"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Error with connecting to the DB");
		}
		return null;
	}

	@Override
	public List<Report> findAll() {
		// TODO Auto-generated method stub
		ArrayList<Report> reports = new ArrayList<Report>();
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "select * from report";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next())
			{
				reports.add(
						new Report(
								rs.getString("Title"),
								rs.getString("ItemName"), 
								rs.getInt("itemCost"), 
								rs.getInt("empId"))
								);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.error("Something went wrong",e);
		}
		return reports;
	}

	@Override
	public void add(Report newObject) {
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "insert into report (Title, itemName, itemCost, empId) values (?,?,?,?);";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, newObject.getTitle());
			pstmt.setString(2, newObject.getitemName());
			pstmt.setInt(3, newObject.getitemCost());
			pstmt.setInt(4, newObject.empId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Report newObject) {
		// TODO Auto-generated method stub

	}

}
