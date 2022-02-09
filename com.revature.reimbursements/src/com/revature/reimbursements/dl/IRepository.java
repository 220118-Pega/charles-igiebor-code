package com.revature.reimbursements.dl;

import java.util.List;

import com.revature.reimbursements.models.Report;
import com.revature.reimbursements.models.approvals;



public interface IRepository{
	void addReport(Report newReport);
	List<Report> getReports();
	Report getReportById(int id) throws Exception;
	void addapprovals(approvals newApprovals) throws Exception;
	void updateapprovals(approvals updatedapprovals);
	approvals getapprovalsById(int id);
}
