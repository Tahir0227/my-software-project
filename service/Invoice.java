package com.service;

public class Invoice {
	private int invoiceid;
	private Service_Request serviceReq;
	private Service_Manage serviceMng;
	private double partsTotalAmt;
	private double tecnicianCost;
	private double totalAmt;
	
	public Invoice() {
		
	}

	public Invoice(int invoiceid, Service_Request serviceReq, Service_Manage serviceMng, double partsTotalAmt,
			double tecnicianCost, double totalAmt) {
		this.invoiceid = invoiceid;
		this.serviceReq = serviceReq;
		this.serviceMng = serviceMng;
		this.partsTotalAmt = partsTotalAmt;
		this.tecnicianCost = tecnicianCost;
		this.totalAmt = totalAmt;
	}

	public int getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(int invoiceid) {
		this.invoiceid = invoiceid;
	}

	public Service_Request getServiceReq() {
		return serviceReq;
	}

	public void setServiceReq(Service_Request serviceReq) {
		this.serviceReq = serviceReq;
	}

	public Service_Manage getServiceMng() {
		return serviceMng;
	}

	public void setServiceMng(Service_Manage serviceMng) {
		this.serviceMng = serviceMng;
	}

	public double getPartsTotalAmt() {
		return partsTotalAmt;
	}

	public void setPartsTotalAmt(double partsTotalAmt) {
		this.partsTotalAmt = partsTotalAmt;
	}

	public double getTecnicianCost() {
		return tecnicianCost;
	}

	public void setTecnicianCost(double tecnicianCost) {
		this.tecnicianCost = tecnicianCost;
	}

	public double getTotalAmt() {
		return totalAmt;
	}

	public void setTotalAmt(double totalAmt) {
		this.totalAmt = totalAmt;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceid=" + invoiceid + ", serviceReq=" + serviceReq + ", serviceMng=" + serviceMng
				+ ", partsTotalAmt=" + partsTotalAmt + ", tecnicianCost=" + tecnicianCost + ", totalAmt=" + totalAmt
				+ "]";
	}
	
	
}
