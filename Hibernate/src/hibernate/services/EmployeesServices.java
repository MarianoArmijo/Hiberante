package hibernate.services;

import java.math.BigDecimal;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.hibernate.Employees;

public class EmployeesServices {
	
	private EmployeeDAO emp = null;
	
	public EmployeesServices(){
		
		emp = new EmployeeDAO();
	}
	
	public boolean incrementarSalario() {
		
		boolean inc = false;
		
		Session session = null;
		Transaction transacion = null;
		List<Employees> list = null;
		
		try {
			
			session = SessionManager.obtenerSesionNueva();
			SuperDAO.setSession(session);
			
			transacion = session.beginTransaction();
			
			list = emp.obtenerEmpleados();
			
			for(Employees employees : list){employees.setSalary(employees.getSalary().multiply(new BigDecimal(1.2)));}
			
			transacion.commit();
			inc = true;
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			transacion.rollback();
		}
		
		finally {
			
			SessionManager.cerrarSession(session);
			SessionManager.cerrarSessionFactory();
		}
		return inc;
	}
}
