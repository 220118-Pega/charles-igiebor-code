package com.revature.reimbursements.bl;

import java.util.List;

import com.revature.reimbursements.dl.IRepository;
import com.revature.reimbursements.models.Report;
import com.revature.reimbursements.models.approvals;

public class ReportBL implements rreportsBL {
	private IRepository repo;

	public ReportBL(IRepository repo) {
		this.repo = repo;
	}
	
	@Override
	public void addReport(Report report) {
		// call my dl 
		repo.addReport(report);
	}
	
	@Override
	public List<Report> getReports() {
		return repo.getReports();
	}
	
	public Report getReportById(int id) throws Exception {
		// TODO Auto-generated method stub
		return repo.getReportById(id);
	}
	
	@Override
	public void addApprovals(approvals Approvals) throws Exception {
		// TODO Auto-generated method stub
		repo.addapprovals(Approvals);
	}
	
	public void approveApproval(int id) {
		// TODO Auto-generated method stub
		approvals approvals2Approval = repo.getapprovalsById(id);
		int currentApprovals = approvals2Approval.getapprove();
		try {
			// diff ++x vs x++: both increment x but ++x returns incremented value, x++ returns old value, then increments value of x
			approvals2Approval.setapprove(++currentApprovals);
			repo.updateapprovals(approvals2Approval);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
		
	public void updateApprovals(Integer approvalsId, Integer newapprove) {
		// TODO Auto-generated method stub
		approvals approvals2Update = repo.getapprovalsById(approvalsId);
		try {
			approvals2Update.setapprove(newapprove);
			repo.updateapprovals(approvals2Update);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	@Override
	public approvals getapprovalsById(int id) {
		// TODO Auto-generated method stub
		return repo.getapprovalsById(id);
	}

	@Override
	public void approveApprovals(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateapprovals(Integer approvalId, String newapprove) {
		// TODO Auto-generated method stub
		
	}

	
		

		
	}
