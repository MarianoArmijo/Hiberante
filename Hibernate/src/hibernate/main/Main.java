package hibernate.main;

import java.math.BigDecimal;
import java.util.List;

import clases.hibernate.Employees;
import hibernate.services.EmployeesServices;

public class Main {

	public static void main(String[] args) {
		
		EmployeesServices emp_ser = new EmployeesServices();
		
		/**
		 *  Incrementar un 20% el salario de todos los empleados.
		 */
//		List<Employees> list = emp_ser.incrementarSalario();
//		
//		for(Employees employees : list){employees.setSalary(employees.getSalary().multiply(new BigDecimal(1.2)));}
		
		/**
		 *  Listar mayores salarios de los empleados de cada departamento.
		 */
//		List<Employees> list1 = emp_ser.listarMayoresSalarios();
//
//		for(Employees emp : list1){System.out.println(emp.toString());}

		/** Dado un Id de Empleado devolver el empleados que 
		* tiene ese Id.
		*/
//		List<Employees> list2 = emp_ser.recuperarListaEmployeesPorID(101);
//		
//		for(Employees emp : list2){System.out.println(emp.toString());}
		
		/** Dado un Id de Departamento devolver la lista de empleados que 
		* pertenece a ese departamento.
		*/
		
		int l = emp_ser.recuperarIdDepartamento("Administration");
		
		List<Employees> list3 = emp_ser.recuperarListaEmployeesPorDepartamento(l);
		for(Employees emp : list3){System.out.println(emp.toString());}
		
//		List<Employees> list3 = emp_ser.recuperarListaEmployeesPorDepartamento(100);
//		
//		for(Employees emp : list3){System.out.println(emp.toString());}
		
		/** Hago una llamada que cierra el session factory
		 */
		emp_ser.cerrarSessionFactory();
	}
}