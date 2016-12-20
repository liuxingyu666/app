package com.mybatis01.test;



import org.junit.Before;
import org.junit.Test;

import com.mybatis01.dao.DeptDao;
import com.mybatis01.pojo.Dept;


public class DeptDaoTest {
	private DeptDao dao;
	
	@Before
	public void init(){
		dao= new DeptDao();
	}

	@Test
	public void test() {
		Dept dept = dao.findById(10);
		System.out.println(dept);
	}
	@Test
	public void findAll(){
		for(Dept dept:dao.findAll()){
			System.out.println(dept);
		}
	}
	@Test
	public void add(){
		Dept dept = new Dept();
		dept.setDeptno(50);
		dept.setDname("开发部");
		dept.setLoc("长沙");
		int count = dao.add(dept);
		if(count == 0){
			System.out.println("失败");
			
		}else{
			System.out.println("成功");
		}
	}
	
	@Test
	public void modify(){
		Dept dept = new Dept();
		dept.setDeptno(50);
		dept.setDname("开发部");
		dept.setLoc("上海");
		int count = dao.modify(dept);
		if(count == 0){
			System.out.println("失败");
			
		}else{
			System.out.println("成功");
		}
	}
	@Test
	public void remove(){
		int count = dao.remove(50);
		if(count == 0){
			System.out.println("失败");
			
		}else{
			System.out.println("成功");
		}
	}

}
