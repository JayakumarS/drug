package com.drug.report.returnMemo;

public class RetrunMemoQueryUtil {
	
	public static final String getMemoList = "select return_memo_no as no, return_memo_name as name, return_memo_date as date, company as text, created_by as create from return_memo";
	public static final String getMemoDetails = "select return_memo_no as returnMemo,ndcupc_code as ndcupcCode,pakage_or_unit as pakageUnit,quantity as quanTity, price as priceRs, exp_date as expDate, reason as reasoNo, lot_no as lotNo from return_memo_items";
	public static final String getMemoListDetails = "select return_memo_no as returnMemo,ndcupc_code as ndcupcCode,pakage_or_unit as pakageUnit,quantity as quantity, price as price, exp_date as expDate, reason as reason, lot_no as lotNo from return_memo_items";

}
