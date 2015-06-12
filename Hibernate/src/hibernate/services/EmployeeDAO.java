package hibernate.services;

import java.util.List;

import org.hibernate.Session;

import clases.hibernate.Employees;

public class EmployeeDAO extends SuperDAO implements CRUD {
	
	public List<Employees> obtenerEmpleados() {
		
	Session session = null;
	session = SuperDAO.getSession();
	
	@SuppressWarnings("unchecked")
	List<Employees> list = session.createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list();//entity es el objeto java asociada a la base de datos
	return list;
	}
	
	public void read(Employees DTO){}

	public void create(Employees DTO){}
	
	public void update(Employees DTO){}
	
	public void delete(Employees DTO){}
}
