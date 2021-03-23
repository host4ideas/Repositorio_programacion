package agendacontactos;

import java.util.ArrayList;

public class AgendaTelefonica {

	// propiedad lista con los contactos que se guardan en la agenda
	private ArrayList<Contacto> agenda;

	// constructor ï¿½nico de la clase
	public AgendaTelefonica() {
		this.agenda = new ArrayList<Contacto>();
	}

	/**
	 * Mï¿½todo para agregar un nuevo contacto al final de la lista -agenda Si ya
	 * existe otro contacto con el mismo nombre y apellidos, no lo agrega
	 * 
	 * @param c: objeto de la clase Contacto con el contacto a agregar
	 * @return: true si se agerega correctamente, false en otro caso
	 */
	public boolean agregarContacto(Contacto c) {
		try {
			// comprobamos si existe
			if (buscarContacto(c.getApellidos(), c.getNombre()) > -1) {
				// Si el contacto existe, lanzamos una excepcion
				throw new IllegalArgumentException("Esta persona ya existe en la agenda");
			}

			// en caso contrario, lo agregamos
			agenda.add(c);
			return true;

		} catch (IllegalArgumentException e) {
			return false;
		}

	}

	/**
	 * Mï¿½todo para agregar un nuevo contacto en una determinada posiciï¿½n de la
	 * agenda Si ya existe otro contacto con el mismo nombre y apellidos, no lo
	 * agrega
	 * 
	 * @param pos: posiciï¿½n en la que insertar en contacto
	 * @param c:   objeto de la clase Contacto con el contacto a agregar
	 * @return: true si se agerega correctamente, y false en alguno de estos casos:
	 *          1- El contacto ya estï¿½ duplicado 2- La posiciï¿½n indicada no
	 *          existe en la agenda
	 */
	public boolean agregarContacto(int pos, Contacto c) {
		try {
			// comprobamos si existe
			if (buscarContacto(c.getApellidos(), c.getNombre()) > -1) {
				// Si el contacto existe, lanzamos una excepcion
				throw new IllegalArgumentException("Esta persona ya existe en la agenda");
			}
			// en caso contrario, tratatamos de insertarlo en esa posiciï¿½n
			agenda.add(pos, c);
			return true;
		} catch (IndexOutOfBoundsException e) {
			System.out.println("La posiciï¿½n que has indicado no existe en la agenda");
			return false;
		} catch (IllegalArgumentException e) {
			System.out.println("Esta persona ya existe en la agenda");
			return false;
		}

	}

	/**
	 * Mï¿½todo para obtener un listado de los contactos de la agenda,
	 */
	public void listarAgenda() {

		System.out.println("\n\t NOMBRE \t\t APELLIDOS \t\t TELEFONO");
		System.out.println("------------------------------------------------------");

		int menor = 0;
		Contacto auxiliar;
		int n = this.agenda.size();
		Contacto[] arrayAgenda = new Contacto[n];
		this.agenda.toArray(arrayAgenda);

		for (int i = 0; i <= n - 2; i++) {
			auxiliar = arrayAgenda[i];
			menor = i;

			for (int j = i + 1; j < n; j++) {
				if (esMayor(arrayAgenda[i], arrayAgenda[j])) {
					auxiliar = arrayAgenda[j];
					menor = j;
				}
			}
			auxiliar = arrayAgenda[i];
			arrayAgenda[i] = arrayAgenda[menor];
			arrayAgenda[menor] = auxiliar;
		}

		for (Contacto contacto : arrayAgenda) {
			System.out.println("\nNombre: " + contacto.getNombre() + "\nApellidos: " + contacto.getApellidos()
					+ "\nTelefono: " + contacto.getTelefono());
		}

	}// fin del mï¿½todo

	/**
	 * 
	 * @param c1 Contacto que se compara a c2
	 * @param c2 Conatcto que se compara a c1
	 * @return Devuelve esMayor = true si el Contacto c1 es mayor que c2
	 */
	boolean esMayor(Contacto c1, Contacto c2) {
		boolean esMayor = false;

		if (c1.getNombre().compareToIgnoreCase(c2.getNombre()) == -1) {
			esMayor = true;
		} else if (c1.getApellidos().compareToIgnoreCase(c2.getApellidos()) == -1
				&& c1.getNombre().compareToIgnoreCase(c2.getNombre()) == 0) {
			esMayor = true;
		}
		return esMayor;
	}

	/**
	 * Mï¿½todo para buscar un contacto en la agenda por nombre y apellidos
	 * 
	 * @param nom: CAdena con el nombre de bï¿½squeda
	 * @param ape: CAdena con los apellidos de bï¿½squeda
	 * @return: Posiciï¿½n de la lista (desde 0) donde se encuentra el contacto /-1
	 *          si no se encuentra La bï¿½squeda no diferencia entre mayï¿½sculas y
	 *          minï¿½sculas El mÃ©todo es private para que se pueda llamar
	 *          solamente desde la propia clase
	 */
	private int buscarContacto(String nom, String ape) {
		boolean encontrado = false;
		Contacto aux;
		int i = 0;
		// si la agenda no está vacía
		if (agenda.size() > 0) {
			while (!encontrado && i < agenda.size()) {

				aux = agenda.get(i);
				if (aux.getApellidos().compareToIgnoreCase(ape) == 0 && aux.getNombre().compareToIgnoreCase(nom) == 0)
					encontrado = true;
				else
					i++;
			} // fin del bucle while
		} // fin del if
			// devolvemos la posición donde se encontró el contacto
		return encontrado ? i : -1;
	}

	/**
	 * Mï¿½todo para buscar un contacto en la agenda por nombre y apellidos y
	 * devolver su telï¿½fono
	 * 
	 * @param nom: CAdena con el nombre de bï¿½squeda
	 * @param ape: CAdena con los apellidos de bï¿½squeda
	 * @return: Cadena con el telï¿½fono del contacto buscado, o "No Encontrado" si
	 *          no se encuentra La bï¿½squeda no diferencia entre mayï¿½sculas y
	 *          minï¿½sculas
	 */
	public String localizarContacto(String nom, String ape) {
		int indice = buscarContacto(nom, ape);
		if (indice > 0) {
			return agenda.get(indice).getTelefono();

		} else {
			return "No Encontrado";
		}
	}

	/**
	 * Mï¿½todo para buscar un contacto en la agenda por nï¿½mero de telï¿½fono
	 * 
	 * @param tel : CAdena con el nï¿½mero de telï¿½fono buscado
	 * @return: Cadena con la combinaciï¿½n de nombres y apellidos, o "No
	 *          encontrado" si no se encuentra
	 * 
	 */

	public String localizarContacto(String tel) {
		boolean encontrado = false;
		Contacto aux = null;
		int i = 0;
		while (!encontrado && i < agenda.size()) {

			aux = agenda.get(i);
			if (aux.getTelefono().compareTo(tel) == 0)
				encontrado = true;
			else
				i++;
		} // fin del bucle while
		return encontrado ? aux.getNombre() + " " + aux.getApellidos() : "No encontrado";
	}

	/**
	 * Mï¿½todo para buscar un contacto en la agenda por nombre y apellidos y
	 * eliminarlo
	 * 
	 * @param nom: CAdena con el nombre de bï¿½squeda
	 * @param ape: CAdena con los apellidos de bï¿½squeda
	 * @return: true si encuentra el contacto y lo elimina; False en otro caso La
	 *          bï¿½squeda no diferencia entre mayï¿½sculas y minï¿½sculas
	 */
	public boolean eliminarContacto(String nom, String ape) {
		int indice = buscarContacto(nom, ape);
		if (indice > 0) {
			agenda.remove(indice);
			return true;
		}
		// en caso de no encontrarlo, devolvemos Falso
		return false;

	}

}
