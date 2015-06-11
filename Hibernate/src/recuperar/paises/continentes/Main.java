package recuperar.paises.continentes;

public class Main {
	
	public static void main(String[] args) {
		
		RecuperarPaises rec_ps = new RecuperarPaises();
		
		try {
			
			rec_ps.extraerPaises();
		}
		
		catch (Exception e) {
			
			e.printStackTrace();
		}
	
		finally {
			
			rec_ps.closeSession();
		}
	}
}
