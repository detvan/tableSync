package com.app;

public class DbRowProperty {

	private Boolean isRowSelected = false;
	private String columnName = null;
	private String columnType = null;

	public DbRowProperty(Boolean isRowSelected, String columnName, String columnType) {
		this.isRowSelected = isRowSelected;
		this.columnName = columnName;
		this.columnType = columnType;
	}

	public void setIsRowSelected(Boolean isRowSelected) {
		this.isRowSelected = isRowSelected;
	}
	
	public Boolean getIsRowSelected() {
		return isRowSelected;
	}
		
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	
	public String getColumnName() {
		return columnName;
	}	
	
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	
	public String getColumnType() {
		return columnType;
	}
}