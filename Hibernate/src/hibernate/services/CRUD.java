package hibernate.services;

import clases.hibernate.Employees;

public interface CRUD {

	public Employees read(Employees ObjectDTO);

	public Employees create(Employees ObjectDTO);
	
	public Employees update(Employees ObjectDTO);
	
	public Employees delete(Employees ObjectDTO);
	
}
