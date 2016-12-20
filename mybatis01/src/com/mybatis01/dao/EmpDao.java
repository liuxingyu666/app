package com.mybatis01.dao;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.mybatis01.pojo.Emp;

public class EmpDao {
	private static SqlSessionFactory factory;

	static {
		String resource = "mybatis-config.xml";
		try {
			InputStream in = Resources.getResourceAsStream(resource);
			factory = new SqlSessionFactoryBuilder().build(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Emp findById(Integer empno) {
		SqlSession session = factory.openSession();
		Emp emp = null;
		try {
			emp = session.selectOne("findByIdEmp", empno);
		} finally {
			session.close();
		}

		return emp;
	}

	public List<Emp> findAll() {
		SqlSession session = factory.openSession();
		List<Emp> emps = null;
		try {
			emps = session.selectList("findAllEmp");
		} finally {
			session.close();
		}
		return emps;
	}

	public int add(Emp emp) {
		SqlSession session = factory.openSession();
		int count = 0;
		try {
			count = session.insert("addEmp", emp);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return count;
	}

	public int modify(Emp Emp) {
		SqlSession session = factory.openSession();
		int count = 0;
		try {
			count = session.update("modifyEmp", Emp);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return count;
	}

	public int remove(Integer empno) {
		SqlSession session = factory.openSession();
		int count = 0;
		try {
			count = session.delete("removeEmp", empno);
			session.commit();
		} catch (Exception e) {
			session.rollback();
		} finally {
			session.close();
		}
		return count;
	}

}
