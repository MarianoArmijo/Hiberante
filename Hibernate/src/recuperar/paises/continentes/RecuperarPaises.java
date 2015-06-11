package recuperar.paises.continentes;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import clases.hibernate.Regions;
import clases.hibernate.Countries;

public class RecuperarPaises {

	private static Configuration configuration;
	private static StandardServiceRegistryBuilder builder;
	private static SessionFactory factory;
	private static Session session;
	private static Transaction transaction;
	
	public RecuperarPaises() {
		
		configuration = new Configuration().configure();
		builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
		factory = configuration.buildSessionFactory(builder.build());
		session = factory.openSession();
		session.disconnect();
	}
	
	public void closeSession(){
		
		try {
			
		session.close();
		factory.close();
		}
		
		catch(Exception e){
			
			e.printStackTrace();
		}
	}
	
	public void extraerPaises(){

		try {
			transaction = session.beginTransaction();
			@SuppressWarnings("unchecked")
			List<Regions> list = session.createSQLQuery("SELECT * from REGIONS order by REGION_ID").addEntity(Regions.class).list();//entity es el objeto java asociada a la base de datos
			Iterator<Regions> it = list.iterator();
			
			while (it.hasNext()) {

				Regions regions = it.next();
				System.out.println(regions);
				
				@SuppressWarnings("unchecked")
				Set<Countries> setcountries = regions.getCountrieses();
				for(Countries countries : setcountries) {
					
					System.out.println(countries);
				}
			}
			
			transaction.commit();
		}
		
		catch (Exception e) {
			e.printStackTrace();
			transaction.rollback();
		}
		
		finally {
			
			session.disconnect();
		}
	}
	
}
