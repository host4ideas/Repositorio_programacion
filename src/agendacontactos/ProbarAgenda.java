package agendacontactos;

public class ProbarAgenda {

	public static void main(String[] args) {
		
		Contacto c1,c2,c3,c4,c5,c6, c7;
		
		c1= new Contacto("Carlos" , "Herrero", "678678678");
		c2= new Contacto("Maria" , "Perez", "914445566");
		c3= new Contacto("Pilar" , "Gomez", "979445566");
		c4= new Contacto("Rafael" , "Mora", "956333444");
		c5= new Contacto("Beatriz" , "Franco", "645888999");
		c6= new Contacto("Antonio" , "Castellanos", "988777666");
		c7 = new Contacto("Sandra" , "Mora", "988989990");
		
		//creamos el objeto agenda
		AgendaTelefonica miAgenda = new AgendaTelefonica();
		
		//agregamos los contactos, en cualquier orden
		
		miAgenda.agregarContacto(c5);
		miAgenda.agregarContacto(c2);
		miAgenda.agregarContacto(c4);
		miAgenda.agregarContacto(c1);
		miAgenda.agregarContacto(c7);
		miAgenda.agregarContacto(c6);
		miAgenda.agregarContacto(c3);
		
		//imprimo la agenda
		miAgenda.listarAgenda();
		
		// buscamos el telï¿½fono de Antonio Castellanos
		System.out.println("\n Teléfono de Antonio Castellanos: "+ miAgenda.localizarContacto("Antonio", "Castellanos"));
		
		// buscamos el telï¿½fono de Beatriz Pï¿½rez
				
		System.out.println("\n Teléfono de Beatriz Pérez: "+ miAgenda.localizarContacto("Beatriz", "Pérez"));
		
		// buscamos dos nï¿½meros de telï¿½fono
		String tel1="956333444";
		String tel2="912223344";
		
		System.out.println("\nEl teléfono "+tel1+ " pertenece a "+ miAgenda.localizarContacto(tel1));
		System.out.println("\nEl teléfono "+tel2+ " pertenece a "+ miAgenda.localizarContacto(tel2));
		// TODO Auto-generated method stub
		
		//borro un telï¿½fono
		System.out.println( miAgenda.eliminarContacto("Rafael", "Mora") ? "Contacto eliminado": "Contacto no encontrado");
		
		//veo otra vez la agenda
		
		miAgenda.listarAgenda();

	}

}
