package com.biel.oor.types.enterprise.invoice;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Locale;

import com.biel.oor.ReportController;
import com.biel.oor.types.enterprise.CompanyInfo;
import com.biel.oor.types.enterprise.EnterpriseReportController;

public abstract class InvoiceReportController extends EnterpriseReportController {
	//Data
	private CompanyInfo recieverCompanyInfo = new CompanyInfo();
	private ArrayList<ProductRequest> productRequestList = new ArrayList<ProductRequest>();
	private ArrayList<String> notes = new ArrayList<String>();
	//Logic - Calculate totals and prepare information for display
	protected double getTotal(){
		int s = 0;
		for(ProductRequest r : productRequestList)s+= r.getTotalPrice();
		return s;
	}
	protected static String formatCurrencyField(double value, boolean displayCurrency){
		String currencyFilter = (displayCurrency ? "{0} €" : "{0}");
		DecimalFormat formatter = new DecimalFormat("###,###,###.00");
		return MessageFormat.format(currencyFilter, formatter.format(value));
	}
	protected static String formatCurrencyField(double value){
		return formatCurrencyField(value, true);
	}
	
	//Display - Provide information ready to display, without caring about the layout
	public String getTotalFormatted(){
		return formatCurrencyField(getTotal());
	}
	
	public CompanyInfo getRecieverCompanyInfo() {
		return recieverCompanyInfo;
	}
	public void setRecieverCompanyInfo(CompanyInfo recieverCompanyInfo) {
		this.recieverCompanyInfo = recieverCompanyInfo;
	}
	public ArrayList<ProductRequest> getProductRequestList() {
		return productRequestList;
	}
	public void setProductRequestList(ArrayList<ProductRequest> productRequestList) {
		this.productRequestList = productRequestList;
	}
	
}
