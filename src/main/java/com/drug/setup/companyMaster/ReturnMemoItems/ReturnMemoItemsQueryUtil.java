package com.drug.setup.companyMaster.ReturnMemoItems;

public class ReturnMemoItemsQueryUtil {

	public static final String INSERT_RETURNMEMOITEMS_MASTER = "SELECT sp_add_returnMemo_Items(?,?,?,?,?,?,?,?,?)";
	public static final String GET_RETURNMEMOITEMS_LIST = "SELECT return_memo_no as returnMemoNo, ndcupc_code as ndcupcCode, quantity as quantity, price as price, exp_date as expDate FROM public.return_memo_items order by ndcupc_code desc";
	public static final String GETCUSCODE = "select * From fn_generate_reference_no('customer', 'customer_code', 'CU', '4')";
	public static final String DELETE_RETURNMEMOITEMS = "delete from return_memo_items where return_memo_items_code = ?";
	public static final String SELECT_DEBITMEMO = "SELECT return_memo_items_code as returnMemoItemsCode, return_memo_no as returnMemoNo, ndcupc_code as ndcupcCode, pakage_or_unit as pakageOrUnit, quantity as quantity, price as price, exp_date as expDate, reason as reason, lot_no as lotNo FROM public.return_memo_items where return_memo_items_code = ?";
	public static final String UPDATE_DEBITMEMO = "SELECT sp_update_returnmemo_items(?,?,?,?,?,?,?,?,?,?)";
	public static final String COMPANY_MASTER_DROPDOWNLIST = "select company_code as id, company_name as text from company order by company_name asc";
	public static final String DEBIT_MEMO_DROPDOWNLIST = "select return_memo_no as id, return_memo_name as text from return_memo order by return_memo_name asc";
	public static final String RETURN_MEMO_NAMEBYID ="select return_memo_name from public.return_memo where return_memo_no=?";
}
