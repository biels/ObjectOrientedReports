package com.biel.oor.types.enterprise.invoice;

import com.biel.xre.generation.Report;

public class InvoiceReportView extends Report {
	protected InvoiceReportController controller;
	
	public InvoiceReportView(InvoiceReportController controller) {
		super();
		this.controller = controller;
	}

	@Override
	public String getXHTML() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
