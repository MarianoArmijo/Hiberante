package hibernate.services;

public class Main {

	public static void main(String[] args) {
		
		EmployeesServices emp_ser = new EmployeesServices();
		
		// Incrementar un 20% el salario de todos los empleados.
		emp_ser.incrementarSalario();
		
		// Listar mayores salarios de los empleados de cada departamento.
		emp_ser.listarMayoresSalarios();
		
		// Dado un Id de Empleado devolver el empleados que 
		// tiene ese Id.
		emp_ser.recuperarListaEmployeesPorID(150);
		
		// Dado un Id de Departamento devolver la lista de empleados que 
		// pertenece a ese departamento.
		emp_ser.recuperarListaEmployeesPorDepartamento(100);
		
		// Hago una llamada que cierra el session factory
		emp_ser.cerrarSessionFactory();
	}
}