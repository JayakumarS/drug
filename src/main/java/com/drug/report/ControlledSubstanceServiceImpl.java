package com.drug.report;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.text.Document;
import javax.xml.crypto.Data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.drug.core.util.DropDownList;
import com.drug.druginfoMaster.DruginfoMasterBean;
import com.drug.druginfoMaster.DruginfoMasterResultBean;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.sun.el.parser.ParseException;


@Service
public class ControlledSubstanceServiceImpl implements ControlledSubstanceService{
	
	@Autowired
	ControlledSubsatanceDao controlledSubsatanceDao;

	


	

	
	@Override
	public SearchResultBean getSearchList(SearchBean bean) throws Exception {
		return controlledSubsatanceDao.getSearchList(bean);
	}
	
	
	@Override
	public ReturnableResultBean getReturnSearchList(ReturableSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getReturnSearchList(bean);
	}
	
	
	@Override
	public NonReturableSearchResultBean getNonReturnSearchList(NonReturnableSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getNonReturnSearchList(bean);
	}
	
	
	@Override
	public ReportSearchResultBean getReportII(ReportSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getReportII(bean);
	}
	
	
	@Override
	public ReportSearchResultBean getReportIII_V(ReportSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getReportIII_V(bean);
	}
	
	
	@Override
	public ReportSearchResultBean getInventory(ReportSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getInventory(bean);
	}
	
	
	@Override
	public ReportSearchResultBean getPackingSlip(ReportSearchBean bean) throws Exception {
		return controlledSubsatanceDao.getPackingSlip(bean);
	}
	
	
	@Override
	public List<ManufacturerBean> getManufacturerAddress(String manufacturercode) {
		return controlledSubsatanceDao.getManufacturerAddress(manufacturercode);
	}
	
	@Override
	public List<CompanyBean> getCompanyAddress(String companyId) {
		return controlledSubsatanceDao.getCompanyAddress(companyId);
	}
	
	
}
