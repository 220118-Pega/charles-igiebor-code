package com.revature.reimbursements.models;


import java.util.List;

/**
 * This is a class used to model coding issues
 *  @author CharlesIgiebor
 *
 */
public class Report {

	private static String title;
	private String itemName;
	private int itemCost;
	private int empId;
	private List<approvals> approval;
	
	public Report() {
		this("No title", "no item name", 0, 0, null);
	}
	public Report(String title, String itemName) {
		// the this keyword pertains to the particular instance's title and description properties
		// the title attribute of the object I'm constructing will have the value of the title parameter i am passing
		Report.title = title;
		this.itemName = itemName;
	}
		
	public Report(String Title, String itemName, int itemCost, int empId)
	{
		// Calling an existing constructor of the same class
		this(title, itemName);
		this.empId = empId;
		this.itemCost = itemCost;
	}
	public Report(String title, String itemName, int itemCost, int empId, List<approvals> approval)
	{
		
		this(title, itemName, itemCost, empId);
		this.approval = approval;
	}
	// having multiple constructors is a form of polymorphism, called method overloading
	// when you call a constructor from another constructor, that's called constructor chaining
//Methods
	// describe the behavior of your object
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		//you can introduce validation logic here
		Report.title = title;
	}
	public String getitemName() {
		return itemName;
	}
	public void setitemName(String itemName) {
		this.itemName = itemName;
	}
	public int getempId(int empId) {
		return empId;
	}
	public void setempId(int empId) {
		this.empId = empId;
	}
	public List<approvals> getapprovals() {
		return approval;
	}
	
	public void setapprovals(List<approvals> Approval) {
		this.approval = Approval;
	}
	//Format of object when converted to string
	@Override
	public String toString() {
		return "Report [title=" + title + ", itemName=" + itemName + ", empId=" + empId + ", itemCost=" + itemCost + "]";
	}
	public int getitemCost() {
		// TODO Auto-generated method stub
		return itemCost;
	}
	public void setitemCost(int itemCost) {
		this.itemCost = itemCost;
	}
	public int empId() {
		// TODO Auto-generated method stub
		 return this.empId;
	}

	public void setitemReimbursemnt(int int1) {
		// TODO Auto-generated method stub
		
	}

	public void setReportId(int reportId) {
		// TODO Auto-generated method stub
		return;
	}

	public com.revature.reimbursements.models.approvals[] getApprovals() {
		// TODO Auto-generated method stub
		return this.getApprovals();
	}

	

}

