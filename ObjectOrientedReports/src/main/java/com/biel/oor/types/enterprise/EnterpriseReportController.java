package com.biel.oor.types.enterprise;

import java.util.Date;

import com.biel.oor.ReportController;
import com.biel.oor.contracts.Datable;

public abstract class EnterpriseReportController extends ReportController implements Datable {
	private CompanyInfo companyInfo = new CompanyInfo();
	private Date date = new Date();
	@Override
	public Date getDate() {
		// TODO Auto-generated method stub
		return date;
	}
	
}
