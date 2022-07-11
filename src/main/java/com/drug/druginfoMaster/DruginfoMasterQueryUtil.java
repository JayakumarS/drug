package com.drug.druginfoMaster;

public class DruginfoMasterQueryUtil {

	public static final String INSERT_DRUGINFO_MASTER = "SELECT sp_add_drugs(?, ?, ?, ?, ?, ?::integer, ?, ?::integer, ?::boolean, ?, ?, ?::boolean, ?::numeric, ?::numeric, ?::numeric, ?)";
	public static final String GET_DRUGINFO_LIST = "SELECT drg.ndcupc_code as ndcupc, manufat.manufacturer_name as manufacturerBy,  drg.rx_or_otc as rxOtc, drg.uom as unitOfMeasure FROM public.drugs drg left outer join manufacturer manufat on manufat.manufacturer_code=drg.manufactured_by order by drg.ndcupc_code desc";
	public static final String GETCUSCODE = "SELECT ndcupc_code as ndcupc, description as description, pakage_size as packageSize, strength as strength, my_price as myPrice, awp_price as awp, wac_price as wap, control_class as control, rx_or_otc as rxOtc, uom as unitOfMeasure, unit_per_pkg as unitPerPackage, is_hazardous as hazardous, is_unit_dose as unitDose, dosage as dosage, manufactured_by as manufacturerBy FROM public.drugs where ndcupc_code = ? ";
	public static final String DELETE_DRUGINFO = "delete from drugs where ndcupc_code = ?";
	public static final String UPDATE_DRUGINFO_MASTER = "SELECT sp_update_drugs(?, ?, ?, ?, ?, ?::integer, ?, ?::integer, ?::boolean, ?, ?, ?::boolean, ?::numeric, ?::numeric, ?::numeric, ?)";
	public static final String GET_MANUFACTURER_LIST = "select manufacturer_code as id, manufacturer_name as text from manufacturer";

}
