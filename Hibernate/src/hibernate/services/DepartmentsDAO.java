package hibernate.services;

import java.util.List;

import clases.hibernate.Employees;

public class DepartmentsDAO extends SuperDAO implements CRUD {

	private SuperDAO superdao = null;

	public DepartmentsDAO(SuperDAO superdao) {
		this.superdao = superdao;
	}
	
	public List obtenerIDDepartments(){
		
		List list = superdao.getSession().createSQLQuery(ConsultasSQL.consultaObtenerIDDepartmentos()).list();
		return list;
	}

	@Override
	public Employees read(Employees ObjectDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees create(Employees ObjectDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees update(Employees ObjectDTO) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Employees delete(Employees ObjectDTO) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
