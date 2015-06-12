package hibernate.services;

import org.hibernate.Session;

public class SuperDAO {
	
	private static Session sesion;

	public static Session getSession() {
		
		return sesion;
	}

	public static void setSession(Session session) {
		
		sesion = session;
	}
	
}
