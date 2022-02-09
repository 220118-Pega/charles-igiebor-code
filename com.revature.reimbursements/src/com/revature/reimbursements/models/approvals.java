package com.revature.reimbursements.models;

	public class approvals {
		private int empId;
		private String approval;
		private int itemreimbursement;
		private int report_id;
		
		public approvals(int itemreimbursement, String approval)
		{
			this.approval = approval;
			this.itemreimbursement = itemreimbursement;
		}
		public approvals(String approval)
		{
			this.approval = approval;
			this.itemreimbursement = 0;
		}
		public approvals(String approval, int itemreimbursement, int id)
		{
			this(itemreimbursement, approval);
			this.report_id = id;
		}
		public approvals(String approval, int id, int itemreimbursement, int empId) {
				super();
				this.approval = approval;
				this.report_id = id;
				this.itemreimbursement = itemreimbursement;
				this.empId = empId;
			}
		
		public approvals(int empID, String approval, int itemReimbursement, int report_id) {
			// TODO Auto-generated constructor stub
			
		}
		public String getApproval() {
			return this.approval;
		}
		public void setApproval(String approval) {
			this.approval = approval;
		}
		public int getId() {
			return report_id;
		}
		public void setId(int id) {
			this.report_id = id;
		}
		public int getitemreimbursement() {
			return itemreimbursement;
		}
		public void setitemRiembursement(int itemreimbursement) throws Exception {
			if(itemreimbursement < 0) {
				throw new Exception("itemreimbursement should only be positive!");
			}
			this.itemreimbursement = itemreimbursement;
		}
		
		public int getempId() {
			return empId;
		}
		public void setempId(int empId) {
			this.empId = empId;
		}
		@Override
		public String toString() {
			return "approval [approval=" + approval + ", id=" + report_id + ", itemreimbursement=" + itemreimbursement + "]";
		}
		public void setreportId(int parseInt) {
			// TODO Auto-generated method stub
			
		}
		public int getitemReimbursemnt(int itemreimbursement) {
			// TODO Auto-generated method stub
			return this.itemreimbursement = itemreimbursement;
		}
		public void setApprove(String approval) {
			// TODO Auto-generated method stub
			return;
		}
		public int getReportId() {
			// TODO Auto-generated method stub
			return report_id;
		}
		public int getapprove() {
			// TODO Auto-generated method stub
			return 0;
		}
		public void setapprove(int i) {
			// TODO Auto-generated method stub
			
		}
		
	
		
		
		
	}
