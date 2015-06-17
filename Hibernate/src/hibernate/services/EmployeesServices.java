package hibernate.services;

import java.math.BigDecimal;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import clases.hibernate.Departments;
import clases.hibernate.Employees;

public class EmployeesServices {
	
	private final static Logger log = Logger.getLogger("mylog");
	
	private SuperDAO superdao = null; 
	
	public EmployeesServices(){
		
		superdao = new SuperDAO();
	}
	
	// M�todo que incrementa el salario de los empleados un 20%
	public boolean incrementarSalario() {
		
		boolean inc = false;
		
		Session session = null;
		Transaction transaction = null;
		List<Employees> list = null;
		EmployeeDAO emp = null;
		emp = new EmployeeDAO(superdao);

		try {
			
			session = SessionManager.obtenerSesionNueva();
			superdao.setSession(session);
			
			transaction = session.beginTransaction();
			
			list = emp.obtenerTodosLosEmpleados();
			
			for(Employees employees : list){employees.setSalary(employees.getSalary().multiply(new BigDecimal(1.2)));}
			
			transaction.commit();
			inc = true;
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}
		
		finally {
			
			SessionManager.cerrarSession(session);
		}
		
		return inc;
	}
	
	// M�todo que lista los salarios m�s altos de cada departamento.
	public boolean listarMayoresSalarios() {
		
		boolean sal = false;
		
		Session session = null;
		List<Employees> list = null;
		EmployeeDAO empdao = null;
		empdao = new EmployeeDAO(superdao);

		try {
			
			session = SessionManager.obtenerSesionNueva();
			superdao.setSession(session);
			
			list = empdao.obtenerListaSalariosMayores();
			
			for(Employees emp : list){System.out.println(emp.toString());}
			
			sal = true;
		}
		
		catch (Exception ex) {
			
			ex.printStackTrace();
		}
		
		finally {
			
			SessionManager.cerrarSession(session);
		}
		
		log.info("M�todo listarMayoresSalarios terminado.");
		
		return sal;
	}
	
	// M�todo que dado un id de empleado devuelve un Empleado.
		public List<Employees> recuperarListaEmployeesPorID(int EMPLOYEE_ID) {	
			
			List<Employees> id = null;
			
			Session session = null;
			List<Employees> list = null;
			EmployeeDAO emps_byid = null;
			emps_byid = new EmployeeDAO(superdao);
			
			try{	
				session = SessionManager.obtenerSesionNueva();
				superdao.setSession(session);
				
				list = emps_byid.obtenerEmpleadosPorID(EMPLOYEE_ID);
				
				for(Employees empds : list){System.out.println(empds.toString());}
				
			}
			
			catch(Exception e){
				
				e.printStackTrace();
			}
			
			finally {
				
				SessionManager.cerrarSession(session);
			}
			
			log.info("M�todo recuperarListaEmployeesPorID terminado.");
			
			return id;
		}
	
	// M�todo que dado un departamento devuelve una lista de Empleados de ese departamento.
	public boolean recuperarListaEmployeesPorDepartamento(int DEPARTMENT_ID) {	
		
		boolean id = false;
		
		Session session = null;
		List<Employees> list = null;
		EmployeeDAO emps_byid = null;
		emps_byid = new EmployeeDAO(superdao);
		
		try{	
			
			session = SessionManager.obtenerSesionNueva();
			superdao.setSession(session);
			
			list = emps_byid.obtenerEmpleadosDepartamento(DEPARTMENT_ID);
			
			for(Employees empds : list){System.out.println(empds.toString());}
			
			id = true;
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
	
		finally {
			
			SessionManager.cerrarSession(session);
		}
		
		log.info("M�todo recuperarListaEmployeesPorDepartamento terminado.");
		
		return id;
	}
	
	public void cerrarSessionFactory() {
		
	SessionManager.cerrarSessionFactory();
	log.info("M�todo cerrarSessionFactory terminado.");
	}
}
