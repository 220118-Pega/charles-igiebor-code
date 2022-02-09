package com.revature.reimbursements;

import java.util.Scanner;


import com.revature.reimbursements.bl.ReportBL;
import com.revature.reimbursements.dl.DBRepository;
import com.revature.reimbursements.dl.ReportDAO;

import com.revature.reimbursements.dl.ApprovalDAO;
import com.revature.reimbursements.ui.MainMenu;

public class Driver {

	public static void main(String[] args) {
		// We'll start our app here somewhere
		MainMenu menu = new MainMenu(new Scanner(System.in), new ReportBL(new DBRepository(new ReportDAO(), new ApprovalDAO())));
		menu.start();
	} 
	
}