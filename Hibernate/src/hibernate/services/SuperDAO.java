package hibernate.services;

import org.hibernate.Session;

public class SuperDAO {
	
	private Session sesion = null;

	public Session getSession() {
		
		return sesion;
	}

	public void setSession(Session session) {
		
		sesion = session;
	}

}
