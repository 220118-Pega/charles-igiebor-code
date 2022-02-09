package com.revature.reimbursements.dl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.revature.reimbursements.models.Report;
import com.revature.reimbursements.models.approvals;

public class DBRepository implements IRepository{
	private DAO<Report,Integer> ReportDAO;
	private DAO<approvals, Integer> ApprovalDAO;
	
	public DBRepository(DAO<Report, Integer> ReportDAO, DAO<approvals, Integer> ApprovalDAO) {
		this.ReportDAO = ReportDAO;
		this.setApprovalDAO(ApprovalDAO);
	}
		private void setApprovalDAO(DAO<approvals, Integer> ApprovalDAO) {
		// TODO Auto-generated method stub
		
	}
		// TODO Auto-generated constructor stub
	
	@Override
	public void addReport(Report newReport) {
		// TODO Auto-generated method stub
		
		ReportDAO.add(newReport);
	}

	@Override
	public List<Report> getReports() {
		// TODO Auto-generated method stub
		return ReportDAO.findAll();
	}

	@Override
	public Report getReportById(int id) throws Exception {
		// TODO Auto-generated method stub
		Report reportWanted = ReportDAO.findById(id);
		List<approvals> allapprovals = ApprovalDAO.findAll();
		//reportWanted.setapprovalss(allapprovalss.stream().filter(soln -> soln.getReportId() == id).toList());
		// the singular line above is equivalent to
		List<approvals> Approvals4Report = new ArrayList<approvals>();
		for(approvals soln:allapprovals)
		{
			if(soln.getReportId() == id) Approvals4Report.add(soln);
		}
		reportWanted.setapprovals(Approvals4Report);
		try(Connection conn = ConnectionFactory.getInstance().getConnection())
	{
		String query = "select * from report inner join approvals on emp.id = approvals.emp_id where report.emp_id = ?";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			ResultSet rs = pstmt.executeQuery();
			int ctr = 0;
			Report reportWanted2 = new Report();
			ArrayList<approvals> ApprovalsOfReport = new ArrayList<approvals>();
			while(rs.next()) {
				//unpack my result set here
				if(ctr == 0) {
					reportWanted2.setempId(rs.getInt("emp_id"));
					
					reportWanted2.setitemReimbursemnt(rs.getInt("itemReimbursment"));
					++ctr;
				}
				ApprovalsOfReport.add(new approvals(
							rs.getString("approval"),
							rs.getInt("empid"),
							rs.getInt("itemreimbursement"),
							rs.getInt("report_id")
						));
				
			}
			reportWanted2.setapprovals(ApprovalsOfReport);
			return reportWanted2;
			}
		}
			

	@Override
	public void addapprovals(approvals newapprovals) throws Exception {
		// TODO Auto-generated method stub
		ApprovalDAO.add(newapprovals);
		
	}
	@Override
	public void updateapprovals(approvals updatedapprovals) {
		// TODO Auto-generated method stub
		ApprovalDAO.update(updatedapprovals);
		
	}
	@Override
	public approvals getapprovalsById(int id) {
		// TODO Auto-generated method stub
		return ApprovalDAO.findById(id);
		
	}

}

