package uy.edu.ort.obligatorioDA.Presentadores;

import uy.edu.ort.obligatorioDA.Servicios.Fachada.Fachada;
import uy.edu.ort.obligatorioDA.Dominio.Usuario;

public class PresentadorLoginAdministrador extends PresentadorLogin {

	/**
	 *  
	 */
	protected abstract Usuario obtenerUsuario(String nombre, int contrasenia);

	protected abstract void siguienteCU();

	protected abstract String loginUrl();

}
