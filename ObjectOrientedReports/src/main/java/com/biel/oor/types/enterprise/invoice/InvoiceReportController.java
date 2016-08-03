package com.biel.oor.types.enterprise.invoice;

import java.util.ArrayList;

import com.biel.oor.ReportController;
import com.biel.oor.types.enterprise.CompanyInfo;
import com.biel.oor.types.enterprise.EnterpriseReportController;

public abstract class InvoiceReportController extends EnterpriseReportController {
	//Data
	private CompanyInfo recieverCompanyInfo = new CompanyInfo();
	private ArrayList<ProductRequest> productRequestList = new ArrayList<ProductRequest>();
	
	//Logic - Calculate totals and prepare information for display
	
}
