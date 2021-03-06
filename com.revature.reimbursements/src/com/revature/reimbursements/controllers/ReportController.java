package com.revature.reimbursements.controllers;



import com.revature.reimbursements.bl.rreportsBL;
import com.revature.reimbursements.models.Report;

import io.javalin.http.Handler;

public class ReportController implements IController {

		private rreportsBL reportBL;
		
		public ReportController(rreportsBL reportBL)
		{
			this.reportBL = reportBL;
		}
		@Override
		public Handler getAll() {
			// Do note that the Handler is a fcnal interface
			// A means to pass functions as parameters 
			// We'll be returning a lambda function
			// as an implementation for this fcnal interface
			// the lambda we'll be returning is how we want
			// our httprequest to be handled
			return ctx -> {
				// marshalling my list of issues to a json format
				// jsonStream() sets the response body to json
				ctx.jsonStream(reportBL.getReports());
			};
		}

		@Override
		public Handler getById() {
			// TODO Auto-generated method stub
			return ctx -> {
				//get id of solution we want from the path param, 
				// we extract it from the ctx 
				String id = ctx.queryParam("report_id");
				int actualId = Integer.parseInt(id);
				try {
					ctx.jsonStream(reportBL.getReportById(actualId));
				} catch (NullPointerException ex)
				{
					ctx.status(204);
				}
				
			};
		}

		@Override
		public Handler add() {
			// TODO Auto-generated method stub
			return ctx -> {
				// unmarshall my request body into an issue class
				// bodyAsClass method unmarshalls the request body into the structure of the class you input into it
				// transforms the request body as the specified class
				Report newReport = ctx.bodyStreamAsClass(Report.class);
				try {
					reportBL.addReport(newReport);
					ctx.status(201);
				} catch (Exception e)
				{
					ctx.status(400);
				}
				
				
			};
		}

		@Override
		public Handler update() {
			// TODO Auto-generated method stub
			return null;
		}

	}
