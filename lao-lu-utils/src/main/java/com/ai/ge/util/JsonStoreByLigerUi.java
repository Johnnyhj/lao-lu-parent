package com.ai.ge.util;

import java.util.List;

public class JsonStoreByLigerUi{
	private List<?> Rows;
	private int Total;
	
	
	public JsonStoreByLigerUi(int total, List<?> rows) {
		super();
		Rows = rows;
		Total = total;
	}
	public List<?> getRows() {
		return Rows;
	}
	public void setRows(List<?> rows) {
		Rows = rows;
	}
	public int getTotal() {
		return Total;
	}
	public void setTotal(int total) {
		Total = total;
	}
	
	

}
