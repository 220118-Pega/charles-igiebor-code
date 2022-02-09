package com.revature.reimbursements.utils;

import com.revature.reimbursements.models.Report;
import com.revature.reimbursements.models.approvals;

import io.javalin.plugin.openapi.dsl.OpenApiBuilder;
import io.javalin.plugin.openapi.dsl.OpenApiDocumentation;


public class DocumentationFactory {
	public static OpenApiDocumentation getDoc(String endPoint)
	{
		switch (endPoint)
		{
		case "getReports":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Report");
			}).jsonArray("200", Report.class);
		case "getReportById":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Report");
			}).json("200", Report.class);
		case "addReport":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("Reports");
			}).body(Report.class).result("201");
		case "addapprovals":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("approvals");
			}).body(approvals.class).result("201");
		case "updateapprovals":
			return OpenApiBuilder.document().operation(op -> 
			{
				op.addTagsItem("approvals");
			}).queryParam("approve", String.class).result("204");
		case "getSolution":
			return OpenApiBuilder.document().operation(op -> {
				op.addTagsItem("approvals");
			}).json("200", approvals.class);
		default:
			return null;
		}
	}
	
}
