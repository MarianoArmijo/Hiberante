package hibernate.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.LinkedList;

import clases.hibernate.Employees;

public class EmployeeDAO extends SuperDAO implements CRUD {
	
	private SuperDAO superdao = null;

	public EmployeeDAO(SuperDAO superdao) {
		this.superdao = superdao;
	}
	
	public List<Employees> obtenerTodosLosEmpleados() {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerEmpleados()).addEntity(Employees.class).list();
		return list;
	}
	
	public List<Employees> obtenerListaSalariosMayores(){
		
		List l_dep = null;
		List<Employees> l_emp = null;
		LinkedList<Employees> emp_ordenado = new LinkedList<Employees>();
		
		DepartmentsDAO departamento = new DepartmentsDAO(superdao);
		l_dep = departamento.obtenerIDDepartments();
		
		for (Object departament : l_dep) {
			
			BigDecimal department = (BigDecimal)departament;
			l_emp = obtenerEmpleadosPorDepartamento(department.intValue());
			emp_ordenado.add(l_emp.get(0));
		}
		return emp_ordenado;
	}

	public List<Employees> obtenerEmpleadosPorID(int EMPLOYEE_ID) {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerEmpleadosID(EMPLOYEE_ID)).addEntity(Employees.class).list();
		return list;
	}
	
	public List<Employees> obtenerEmpleadosPorDepartamento(int DEPARTMENT_ID) {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerEmpleadosPorDepartamento(DEPARTMENT_ID)).addEntity(Employees.class).list();
		return list;
	}
	
	public List<Employees> obtenerEmpleadosDepartamento(int DEPARTMENT_ID) {
		
		@SuppressWarnings("unchecked")
		List<Employees> list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerEmpleadosDepartamentos(DEPARTMENT_ID)).addEntity(Employees.class).list();
		return list;
	}
	
	
	public Employees read(Employees DTO){
		return DTO;}

	public Employees create(Employees DTO){
		return DTO;}
	
	public Employees update(Employees DTO){
		return DTO;}
	
	public Employees delete(Employees DTO){
		return DTO;}

}
