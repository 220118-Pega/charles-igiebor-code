package com.revature.reimbursements.utils;

import com.revature.reimbursements.controllers.IController;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.dsl.OpenApiBuilder;

public class Router {
	// Your router is the front controller in the front controller design pattern 
		private Javalin app;
		private IController ReportController;
		private IController approvalController;
		public Router(Javalin app, IController ReportController, IController approvalsController, IController approvalController)
		{
			this.app = app;
			this.ReportController = ReportController;
			this.approvalController = approvalController;
		}
		
		public
		
		Router(Javalin app2, IController reportController2, IController approvalController2) {
		}
		
			// TODO Auto-generated constructor stub
		

		public void setUpEndPoints() {
			app.get("/Reports", OpenApiBuilder.documented(DocumentationFactory.getDoc("getReports"), ReportController.getAll()));
			app.get("/Reports/{Report_id}/approvals", OpenApiBuilder.documented(DocumentationFactory.getDoc("getReportById"), ReportController.getById()));
			app.post("/Reports",  OpenApiBuilder.documented(DocumentationFactory.getDoc("addReport"), ReportController.add()));
			app.post("/approvals", OpenApiBuilder.documented(DocumentationFactory.getDoc("addapproval"), approvalController.add()));
			app.put("/approvals/{approval_id}", OpenApiBuilder.documented(DocumentationFactory.getDoc("updateapprovals"), approvalController.update()));
			app.get("/approvals/{approval_id}", OpenApiBuilder.documented(DocumentationFactory.getDoc("getSolution"), approvalController.getById()));
		}
	}

