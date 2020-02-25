package com.app.utility;

public class TestData {

	public static Object[][] credentials() {
		String sheetName = "Employee";
		Object[][] excelData = null;
		ExcelUtils excelUtils = new ExcelUtils("sentrifugo.xlsx");

		int rows = excelUtils.getRowCount(sheetName);
		int columns = excelUtils.getColumnCount(sheetName);

		excelData = new Object[rows - 1][columns];
		for (int i = 1; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				excelData[i - 1][j] = excelUtils.getCellData(sheetName, j, i);
			}
		}
		for (Object[] objects : excelData) {
			for (Object objects2 : objects) {
				System.out.println((String) objects2);
			}
		}
		return null;
	}

	public static void main(String[] args) {
		TestData data = new TestData();
		data.credentials();
	}

}
