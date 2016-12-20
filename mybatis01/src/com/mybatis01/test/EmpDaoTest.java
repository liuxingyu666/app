package com.mybatis01.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import com.mybatis01.dao.EmpDao;
import com.mybatis01.pojo.Dept;
import com.mybatis01.pojo.Emp;

public class EmpDaoTest {
	private EmpDao dao;
	
	@Before
	public void init(){
		dao = new EmpDao();
	}

	
	
	@Test
	public void test() {
		Emp emp = dao.findById(7788);
		System.out.println(emp);
	}
	@Test
	public void findAll(){
		for(Emp emp:dao.findAll()){
			System.out.println(emp);
		}
	}
	@Test
	public void add(){
		Emp emp = new Emp();
		emp.setEmpno(9967);
		emp.setEname("xiaoliu");
		emp.setHiredate(new Date());
		emp.setSal(4000.0);
		int count = dao.add(emp);
		if(count == 0){
			System.out.println("失败");
			
		}else{
			System.out.println("成功");
		}
	}
	
	@Test
	public void modify(){
		Emp emp = new Emp();
		emp.setEmpno(9967);
		emp.setEname("遛遛遛");
		emp.setHiredate(new Date());
		emp.setSal(5000.0);
		int count = dao.modify(emp);
		if(count == 0){
			System.out.println("失败");
			
		}else{
			System.out.println("成功");
		}
	}
	@Test
	public void remove(){
		int count = dao.remove(9967);
		if(count == 0){
			System.out.println("失败");
			
		}else{
			System.out.println("成功");
		}
	}
}
