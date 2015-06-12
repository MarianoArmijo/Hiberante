package hibernate.services;

import clases.hibernate.Employees;

public interface CRUD {

	public void read(Employees DTO);

	public void create(Employees DTO);
	
	public void update(Employees DTO);
	
	public void delete(Employees DTO);
	
}
