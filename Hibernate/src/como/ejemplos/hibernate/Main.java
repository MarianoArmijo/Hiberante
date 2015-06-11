package como.ejemplos.hibernate;

public class Main {
	
	/**
	 * Hacer una aplicación utilizando la persistencia de hibernate que incremente en un 20% 
	 * el salario de los empleados del departamento de ventas (Sales)
	 * 
	 * @autor Mariano
	 */
	
	public static void main(String[] args) {

		IncrementarSalarios insl = new IncrementarSalarios();
		
		try {
			
		insl.mostrarDepVentas();
		insl.incrementarSalario();
		insl.mostrarDepVentas();
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}

		finally {
			
			insl.closeSession();
		}
	}
}
