package hibernate.services;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import hibernate.DAO.SuperDAO;
import hibernate.services.EmployeesServices;



import hibernate.session.manager.SessionManager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import clases.hibernate.Employees;

public class TestEmployeesServices {
	
	SessionFactory factory = null;
	Session session = null;
	SuperDAO superdao = new SuperDAO();
	
	@Before
	public void startTest(){
		
		session = SessionManager.obtenerSesionNueva();
		superdao.setSession(session);
	}
	
	@After
	public void finTest(){
		
		SessionManager.cerrarSession(session);
	}
	
	@Test
	public void testIncrementarSalario(){
		
		EmployeesServices es = new EmployeesServices();
		
		Employees e1 = (Employees) es.recuperarListaEmployeesPorID(101);
		es.incrementarSalario();
		
		Employees e2 = (Employees) es.recuperarListaEmployeesPorID(101);
		
		int ie1 = e1.getSalary().intValue();
		int ie2 = e2.getSalary().intValue();
		
		assertTrue(ie1*1.2 == ie2);
	}
	
	@Test
	public void testEmpleadoporId(){
		
		EmployeesServices es = new EmployeesServices();
		
		Employees e1 = (Employees) es.recuperarListaEmployeesPorID(101);
		
		assertNotNull(e1);
	}
	
}
