package com.revature.reimbursements.bl;

import java.util.List;

import com.revature.reimbursements.models.Report;
import com.revature.reimbursements.models.approvals;

public interface rreportsBL {

	void addReport(Report report);

	List<Report> getReports();
	Report getReportById(int id) throws Exception;
	void addApprovals(approvals approval) throws Exception;
	void approveApprovals(int id);
	
	void updateapprovals(Integer approvalId, String newapprove);
	approvals getapprovalsById(int id);
}

