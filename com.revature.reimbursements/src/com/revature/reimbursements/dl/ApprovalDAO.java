package com.revature.reimbursements.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursements.models.approvals;


public class ApprovalDAO implements DAO<approvals, Integer> {

	@Override
	public approvals findById(Integer emp_id) {
		// TODO Auto-generated method stub
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from approvals where emp_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, emp_id);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				return new approvals(rs.getInt("emp_id"), rs.getString("approval"), rs.getInt("itemreimbursement"), rs.getInt("report_id"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<approvals> findAll() {
		// TODO Auto-generated method stub
		ArrayList<approvals> approval = new ArrayList<approvals>();
		try (Connection conn = ConnectionFactory.getInstance().getConnection()) {
			String query = "select * from approvals";
			PreparedStatement pstmt = conn.prepareStatement(query);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				approval.add(new approvals(rs.getString("approval"), rs.getInt("itemreimbursement"), rs.getInt("report_id")
));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return approval;
	}

	@Override
	public void add(approvals newObject) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection()){
			String query = "insert into approvals (emp_id, approval, itemreimbursement, report_id) values (?,?,?,?);";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newObject.getempId());
			pstmt.setString(2, newObject.getApproval());
			pstmt.setInt(3, newObject.getitemreimbursement());
			pstmt.setInt(4, newObject.getReportId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void update(approvals newObject) {
		// TODO Auto-generated method stub
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
		{
			String query = "update approvals set approval = ?, itemreimbursement = ?, report_id = ? where emp_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, newObject.getempId());
			pstmt.setString(2, newObject.getApproval());
			pstmt.setInt(3, newObject.getitemreimbursement());
			pstmt.setInt(4, newObject.getReportId());
			pstmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
