package com.bugmaker.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.shiro.crypto.hash.Md5Hash;

import com.bugmaker.bean.Dept;
import com.bugmaker.bean.ProfessionClass;
import com.bugmaker.bean.Student;
import com.bugmaker.bean.User;

public class XslResolveUtil {

	// 读取输出流数据返回学生列表
	public static List<Student> getStudentsFromXSL(InputStream inputStream,
			List<ProfessionClass> classes, List<Dept> depts) {
		List<Student> students = new ArrayList<Student>();
		try {
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
			// 循环工作表Sheet
			for (int sheet = 0; sheet < hssfWorkbook.getNumberOfSheets(); sheet++) {
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheet);
				if (hssfSheet == null) {
					continue;
				}
				// 循环行
				for (int row = 1; row <= hssfSheet.getLastRowNum(); row++) {
					HSSFRow hssfRow = hssfSheet.getRow(row);
					if (hssfRow == null) {
						continue;
					}

					Student student = new Student();
					User user = new User();
					user.setId(getCellValue(hssfRow.getCell(1)));
					user.setUsername(getCellValue(hssfRow.getCell(2)));
					user.setSex(getCellValue(hssfRow.getCell(3)));
					user.setAge(Integer.valueOf(getCellValue(hssfRow.getCell(4))));
					user.setPhone(getCellValue(hssfRow.getCell(5)));
					user.setEmail(getCellValue(hssfRow.getCell(6)));
					String className = getCellValue(hssfRow.getCell(7));
					for (ProfessionClass clazz : classes) {
						if (clazz.getClassName().equals(className)) {
							student.setProfessionClass(clazz);
						}
					}
					String deptName = getCellValue(hssfRow.getCell(8));
					for (Dept dept : depts) {
						if (dept.getDeptName().equals(deptName)) {
							user.setDept(dept);
						}
					}
					String password = new Md5Hash(user.getId(),
							getCellValue(hssfRow.getCell(9))).toString();
					user.setPassword(password);
					student.setUser(user);
					students.add(student);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return students;
	}

	// 根据不同类型的列读取值
	public static String getCellValue(HSSFCell hssfCell) {
		if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_BOOLEAN) {
			// 返回布尔类型的值
			return String.valueOf(hssfCell.getBooleanCellValue());
		} else if (hssfCell.getCellType() == HSSFCell.CELL_TYPE_NUMERIC) {
			// 返回数值类型的值

			Double doubleValue = hssfCell.getNumericCellValue();
			String str = doubleValue.toString();
			if (str.contains(".0")) {
				str = str.replace(".0", "");
			}
			if (str.contains(".")) {
				str = str.replace(".", "");
			}
			if (str.contains("E10")) {
				str = str.replace("E10", "");
			}
			return str;
		} else {
			// 返回字符串类型的值
			return String.valueOf(hssfCell.getStringCellValue());
		}
	}

	// 读取输出流数据返回教师列表
	public static List<User> getTeachersFromXSL(InputStream inputStream,
			List<ProfessionClass> classes, List<Dept> depts) {
		List<User> teachers = new ArrayList<User>();
		try {
			HSSFWorkbook hssfWorkbook = new HSSFWorkbook(inputStream);
			// 循环工作表Sheet
			for (int sheet = 0; sheet < hssfWorkbook.getNumberOfSheets(); sheet++) {
				HSSFSheet hssfSheet = hssfWorkbook.getSheetAt(sheet);
				if (hssfSheet == null) {
					continue;
				}
				// 循环行
				for (int row = 1; row <= hssfSheet.getLastRowNum(); row++) {
					HSSFRow hssfRow = hssfSheet.getRow(row);
					if (hssfRow == null) {
						continue;
					}
					User teacher = new User();
					teacher.setId(getCellValue(hssfRow.getCell(1)));
					teacher.setUsername(getCellValue(hssfRow.getCell(2)));
					teacher.setSex(getCellValue(hssfRow.getCell(3)));
					teacher.setAge(Integer.valueOf(getCellValue(hssfRow.getCell(4))));
					teacher.setPhone(getCellValue(hssfRow.getCell(5)));
					teacher.setEmail(getCellValue(hssfRow.getCell(6)));
					String className = getCellValue(hssfRow.getCell(7));
					String deptName = getCellValue(hssfRow.getCell(8));
					for (Dept dept : depts) {
						if (dept.getDeptName().equals(deptName)) {
							teacher.setDept(dept);
						}
					}
					String password = new Md5Hash(teacher.getId(),
							getCellValue(hssfRow.getCell(9))).toString();
					teacher.setPassword(password);
					teachers.add(teacher);
				}
			}
		} catch (IOException e) {

			e.printStackTrace();
		}

		return teachers;
	}
}
