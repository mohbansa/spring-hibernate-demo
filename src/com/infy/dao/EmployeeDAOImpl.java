package com.infy.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.context.ApplicationContextException;

import com.infy.entity.EmployeeEntity;
import com.infy.exception.AccelerateAppDBException;
import com.infy.exception.InvalidEmployeeIdException;
import com.infy.model.AddEmployeeDTO;
import com.infy.model.EmployeeDTO;

public class EmployeeDAOImpl implements EmployeeDAO{
		
	/* Constructor */
	public EmployeeDAOImpl() {
		
	}

	@Override
	public int insertEmployee(AddEmployeeDTO addEmpObj) throws AccelerateAppDBException {
		System.out.println("In EmployeeDAOImpl : insertEmployee");

		Session session = null;
		int empId = -1;
		try {
			EmployeeEntity empEntity = new EmployeeEntity();
			empEntity.setName(addEmpObj.getName());
			empEntity.setEmail(addEmpObj.getEmail());
			empEntity.setDept(addEmpObj.getDept());
			empEntity.setCurrentLocation(addEmpObj.getCurrentLocation());
			empEntity.setBaseLocation(addEmpObj.getBaseLocation());
			empEntity.setSalary(addEmpObj.getSalary());
			
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			empId = (int) session.save(empEntity);
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
			throw new AccelerateAppDBException(e.getMessage());
		}finally {
			if(session != null ) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
		return empId;
	}

	@Override
	public EmployeeEntity getEmployee(int empId) throws AccelerateAppDBException {
		Session session = null;
		EmployeeEntity empEntity = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			empEntity = (EmployeeEntity) session.get(EmployeeEntity.class, empId);
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
			throw new AccelerateAppDBException(e.getMessage());
		}finally {
			if(session != null ) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
		return empEntity;
	}

	@Override
	public List<EmployeeEntity> getAllEmployees() throws AccelerateAppDBException {
		Session session = null;
		List<EmployeeEntity> empEntityList = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			String hql = "from EmployeeEntity";
			Query query = session.createQuery(hql);
			
			empEntityList = query.list();
			
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
			throw new AccelerateAppDBException(e.getMessage());
		}finally {
			if(session != null ) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
		return empEntityList;
	}
	
	@Override
	public List<EmployeeEntity> getAllEmployeesByPage(int pageId, int total)
			throws AccelerateAppDBException {
		Session session = null;
		List<EmployeeEntity> empEntityList = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			
			String hql = "from EmployeeEntity";
			Query query = session.createQuery(hql);
			int startRecord = (pageId-1)*total;
			query.setFirstResult(startRecord);
			query.setMaxResults(total);
			
			empEntityList = query.list();
			
			session.getTransaction().commit();
		}catch(HibernateException e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
			throw new AccelerateAppDBException(e.getMessage());
		}finally {
			if(session != null ) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
		return empEntityList;
	}
	
	@Override
	public String deleteEmployee(int empId) throws AccelerateAppDBException, InvalidEmployeeIdException {
		String rtnStr = "Failure";
		Session session = null;
		EmployeeEntity empEntity = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			empEntity = (EmployeeEntity) session.get(EmployeeEntity.class, empId);
			if(empEntity == null) {
				throw new InvalidEmployeeIdException(empId);
			}
			session.delete(empEntity);
			session.getTransaction().commit();
			rtnStr = "Deleted successful";
		}catch(HibernateException e) {
			e.printStackTrace();
			session.beginTransaction().rollback();
			throw new AccelerateAppDBException(e.getMessage());
		}finally {
			if(session != null ) {
				if(session.isOpen()) {
					session.close();
				}
			}
		}
		return rtnStr;
	}
	
}
