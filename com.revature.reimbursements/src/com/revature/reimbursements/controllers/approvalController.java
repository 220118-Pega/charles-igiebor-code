package com.revature.reimbursements.controllers;

import com.revature.reimbursements.bl.rreportsBL;
import com.revature.reimbursements.models.approvals;

import io.javalin.http.Handler;

public class approvalController implements IController{
	private rreportsBL ReportBL;
	
	public approvalController(rreportsBL ReportBL)
	{
		this.ReportBL = ReportBL;
	}
	@Override
	public Handler getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Handler getById() {
		// TODO Auto-generated method stub
		return ctx -> {
			ctx.jsonStream(ReportBL.getapprovalsById(Integer.parseInt(ctx.pathParam("report_id"))));
		};
	}

	@Override
	public Handler add() {
		// TODO Auto-generated method stub
		return ctx -> {
			ReportBL.addApprovals(ctx.bodyStreamAsClass(approvals.class));
		};
	}

	@Override
	public Handler update() {
		// TODO Auto-generated method stub
		return ctx -> {
		String newapprove = (ctx.queryParam("approve"));
		Integer approvalId = Integer.parseInt(ctx.pathParam("approval_id"));
		ReportBL.updateapprovals(approvalId, newapprove);
		ctx.status(204);
		};
	}
	

}
