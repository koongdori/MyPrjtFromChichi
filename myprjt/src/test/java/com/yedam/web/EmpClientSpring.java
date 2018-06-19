package com.yedam.web;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yedam.web.emp.EmpVO;
import com.yedam.web.emp.impl.EmpDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(
		locations={"classpath:/config/applicationContext.xml",
				"classpath:/config/transactionContext.xml"})
public class EmpClientSpring {
	
	@Autowired EmpDAO empDAO;
	
	//다건삭제
	@Test
	public void deptDeleteTest() {
		List<String> list = 
				  new ArrayList<String>();
		list.add("400");
		list.add("410");
		list.add("510");
		empDAO.deleteDeptList(list);
	}
	
	@Test
	@Ignore
	public void getEmpTest() {
		//단건조회
		//EmpVO empVO = empDAO.getEmp("100");
		//System.out.println(empVO);
		
		//다건 조회
		EmpVO empVO = new EmpVO();
		empVO.setDepartmentId("20");
		empVO.setFirstName("m");
		List<Map<String, Object>> list = empDAO.getEmpList(empVO);
		System.out.println("조회건수:" + list.size());
		System.out.println(list);
	}
	
/*	@Test
	public void insertEmpTest() {
		
		empDAO.insertEmp();
	}*/
}
