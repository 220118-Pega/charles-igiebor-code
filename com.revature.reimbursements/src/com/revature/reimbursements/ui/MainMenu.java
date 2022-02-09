package com.revature.reimbursements.ui;

import java.util.Scanner;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.reimbursements.bl.rreportsBL;

import com.revature.reimbursements.models.Report;
import com.revature.reimbursements.models.approvals;


public class MainMenu {
	// the scanner is very important to a UI
	// declare it as a dependency
	private Scanner myscanner;
	private rreportsBL ReportBL;
	
	private final Logger logger = LogManager.getLogger(this.getClass());

	// inject this dep via constructor
	public MainMenu(Scanner myscanner, rreportsBL ReportBL) {
		this.myscanner = myscanner;
		this.ReportBL = ReportBL;
	}

	public void start() {
		// method signature : access modifier*, non access modifier*, return type,
		// methodName, (arguments), throws exceptions*
		boolean keepGoing = true;
		do {
			System.out.println("Welcome to reimbursements, what do you wanna do?");
			System.out.println("[0] Create an report");
			System.out.println("[1] Get all reports");
			System.out.println("[2] View report with approval");
			System.out.println("[3] Add approval to report");
			System.out.println("[x] Exit");

			String userInput = myscanner.nextLine();
			switch (userInput) {
			case "0": 
				System.out.println("Creating an report");
				createReport();
				break;
			case "1":
				System.out.println("Getting reports..");
				getReports();
				break;
			case "2":
				getSpecificReport();
				break;
			case "3":
				addApproval();
				break;
			case "x":
				System.out.println("Goodbye");
				keepGoing = false;
				break;
			default:
				System.out.println("Sorry wrong input, please try again");
				break;
			}

		} while (keepGoing);

	}

	private void addApproval() {
		// TODO Auto-generated method stub
		System.out.println("Enter the  employee id of the Report you'd like to add a approval to: ");
		String stringId = myscanner.nextLine();
		System.out.println("Enter X to add your approval");
		String answer = myscanner.nextLine();
		approvals newApproval = new approvals(answer);
		//logger.debug(answer);
		try {
			logger.info("Adding solution");
			newApproval.setreportId(Integer.parseInt(stringId));
			ReportBL.addApprovals(newApproval);
		} catch (NumberFormatException ex) {
			System.out.println("Please only enter numerics");
			logger.error("Invalid user input");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("No such report found, try another id");
			logger.error("Issue not found");
		}
	}

	private void getSpecificReport() {
		// TODO Auto-generated method stub
		System.out.println("Enter the employee id of the report you'd like to view the approval for: ");
		String StringId = myscanner.nextLine();
		// Integer.parseInt() is a method used to parse strings to integers
		Report foundReport;
		try {
			foundReport = ReportBL.getReportById(Integer.parseInt(StringId));
			System.out.println(foundReport);
			for (approvals approvals : foundReport.getApprovals()) {
				System.out.println(approvals);
			}
			getapprovalsSubMenu();
		} catch (NumberFormatException e1) {
			// TODO Auto-generated catch block
			System.out.println("Please only enter numerics");
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			System.out.println("No such Report found, try another id");
			logger.error("Issue not found");
		}

	}
	private void getapprovalsSubMenu() {
		System.out.println("Would like to: ");
		System.out.println("[0] approve report");
		System.out.println("[x] Exit");
		String userInput = myscanner.nextLine();
		switch(userInput)
		{
		case "0":
			approveApprovals();
			break;
		case "x":
			System.out.println("going back to main menu");
			break;
		default:
			System.out.println("wrong input, going back to main menu");
		}
		
	}

	private void approveApprovals() {
		// TODO Auto-generated method stub
		System.out.println("Enter a id of reimbursement you want to approve: ");
		String userInput = myscanner.nextLine();
		ReportBL.approveApprovals(Integer.parseInt(userInput));
	}


	private void getReports() {
		// TODO Auto-generated method stub
		for (Report report : ReportBL.getReports()) {
			System.out.println(report);
		}
	}

	private void createReport() {
		// TODO Auto-generated method stub
		System.out.println("Enter a title for your Report: ");
		String title = myscanner.nextLine();
		System.out.println("Enter a Item Name for your Report: ");
		String itemName = myscanner.nextLine();
		System.out.println("Enter your reimburement cost: ?");
		int itemCost = myscanner.nextInt();
		System.out.println("What is your employee id: ?");
		int empId = myscanner.nextInt();		
		Report newReport = new Report(title, itemName, itemCost, empId);
		
		// saving to storage
		ReportBL.addReport(newReport);
		System.out.println(newReport);
	}
}


