package como.ejemplos.hibernate;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.cfg.Configuration;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.hibernate.Employees;

public class IncrementarSalarios {
	
	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	private static Session session;
	private static Transaction transaction;
	
	public IncrementarSalarios() {
		
		configuration = new Configuration().configure();
		builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
		session = factory.openSession();
		session.disconnect();
	}
	
	public void closeSession(){
		
		try {
			
		session.close();
		factory.close();
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public void incrementarSalario(){

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 80").addEntity(Employees.class).list();//entity es el objeto java asociada a la base de datos
			Iterator<Employees> it = list.iterator();
			Employees employees;
			BigDecimal n_salary = new BigDecimal(0);
			BigDecimal incrementar = new BigDecimal(1.2);
			
			while(it.hasNext()){
				
				employees = it.next();
				n_salary = employees.getSalary().multiply(incrementar);
				employees.setSalary(n_salary);
				session.saveOrUpdate(employees);
			}
			
			transaction.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
	}
	
	public void mostrarDepVentas() {
    	
		try {
			
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = 80").addEntity(Employees.class).list();// entity es el objeto java asociado a la base de datos
			Iterator<Employees> it = list.iterator();
			Employees em;
			while (it.hasNext()) {
				
				em = it.next();
				System.out.println(em);
			}
			transaction.commit();
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}
		
		finally {
			
			session.disconnect();
		}
	}
	
}
