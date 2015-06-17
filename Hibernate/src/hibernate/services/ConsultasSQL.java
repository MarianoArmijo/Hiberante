package hibernate.services;

public class ConsultasSQL {
	
	public static String consultaObtenerEmpleados() {
		
		String consulta = "SELECT * FROM EMPLOYEES";
		return consulta;
	}
	
	public static String consultaObtenerEmpleadosPorDepartamento(int DEPARTMENT_ID) {
	
		String consulta = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = "+DEPARTMENT_ID+" ORDER BY SALARY DESC";
		return consulta;
	}
	
	public static String consultaObtenerIDDepartmentos() {
		
		String consulta = "SELECT DISTINCT DEPARTMENT_ID FROM EMPLOYEES WHERE DEPARTMENT_ID IS NOT NULL";
		return consulta;
	}
	
	public static String consultaObtenerEmpleadosDepartamentos(int DEPARTMENT_ID) {
		
		String consulta = "SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID = "+DEPARTMENT_ID;
		return consulta;
	}
	
	public static String consultaObtenerEmpleadosID(int EMPLOYEE_ID) {
		
		String consulta = "SELECT * FROM EMPLOYEES WHERE EMPLOYEE_ID = "+EMPLOYEE_ID;
		return consulta;
	}
	
}

//	public static String consultaObtenerListaSalariosMayores() {
//	
//	String consulta = "SELECT * FROM EMPLOYEES WHERE (DEPARTMENT_ID, salary) IN(SELECT DEPARTMENT_ID, max(SALARY) FROM EMPLOYEES GROUP BY DEPARTMENT_ID) ORDER BY DEPARTMENT_ID";
//	return consulta;
//}
