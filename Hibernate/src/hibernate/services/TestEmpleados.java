package hibernate.services;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.math.BigDecimal;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import clases.hibernate.Employees;

public class TestEmpleados {
	
	SessionFactory factory = null;
	Session session = null;
	SuperDAO superdao = new SuperDAO();
	
	@Before
	public void startTest(){
		
		factory = SessionManager.getSessionFactory();
		session = SessionManager.obtenerSesionNueva();
		superdao.setSession(session);
	}
	
	@After
	public void finTest(){
		
		SessionManager.cerrarSession(session);
		SessionManager.cerrarSessionFactory();
	}
	
	@Test
	public void testEmployeesServices() {
		
		assertNotNull(new EmployeesServices());
	}
	
	@SuppressWarnings("deprecation")
	@Test
	public void testIncrementarSalario(){
		
		EmployeesServices es = new EmployeesServices();
		
		Employees e1 = (Employees) es.recuperarListaEmployeesPorID(105);
		es.incrementarSalario();
		
		Employees e2 = (Employees) es.recuperarListaEmployeesPorID(105);
		
		int ie1 = e1.getSalary().intValue();
		int ie2 = e2.getSalary().intValue();
		assertEquals(ie1*1.2,ie2);
	}		
	@Test
	public void testRecuperarListaMayorSalarioPorDepartamento() {
		
		fail("Not yet implemented");
	}
	
}
