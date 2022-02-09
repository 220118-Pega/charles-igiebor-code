package com.revature.reimbursements;

import com.revature.reimbursements.bl.ReportBL;
import com.revature.reimbursements.controllers.IController;
import com.revature.reimbursements.controllers.ReportController;
import com.revature.reimbursements.controllers.approvalController;
import com.revature.reimbursements.dl.DBRepository;
import com.revature.reimbursements.dl.ReportDAO;
import com.revature.reimbursements.dl.ApprovalDAO;
import com.revature.reimbursements.utils.Router;

import io.javalin.Javalin;
import io.javalin.plugin.openapi.OpenApiOptions;
import io.javalin.plugin.openapi.OpenApiPlugin;
import io.javalin.plugin.openapi.ui.SwaggerOptions;
import io.swagger.v3.oas.models.info.Info;

public class RESTDriver {

		public static void main(String[] args) {
			// TODO Auto-generated method stub
			// Create Controllers 
			IController reportController = new ReportController(
					new ReportBL(new DBRepository(new ReportDAO(), new ApprovalDAO())));
			IController approvalController = new approvalController(new ReportBL(new DBRepository(new ReportDAO(), new ApprovalDAO())));
			Javalin app = Javalin.create(config -> {
				config.registerPlugin(new OpenApiPlugin(getOpenApiOptions()));
			}).start(8000);
			Router router = new Router(app, reportController, approvalController);
			router.setUpEndPoints();
		}

		private static OpenApiOptions getOpenApiOptions() {
			// Configuring swagger
			// We'll use swagger for documentation and testing our API
			Info applicationInfo = new Info().version("1.0").description("Reimbursements REST");
			return new OpenApiOptions(applicationInfo).path("/swagger-docs")
					.swagger(new SwaggerOptions("/swagger").title("Reimbursememts API Docs"));
		}

	}	
		
