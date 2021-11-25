package um.tds.dominio;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import um.tds.persistencia.DAOException;
import um.tds.persistencia.FactoriaDAO;
import um.tds.persistencia.IAdaptadorUsuarioDAO;



public class CatalogoUsuarios {

	private Map<String,Usuario> usuarios; 
	private static CatalogoUsuarios unicaInstancia = new CatalogoUsuarios();
	
	private FactoriaDAO dao;
	private IAdaptadorUsuarioDAO adaptadorUsuario;
	
	
	
	private void CatalogoClientes() {
		try {
  			dao = FactoriaDAO.getInstancia(FactoriaDAO.DAO_TDS);
  			adaptadorUsuario = dao.getUsuarioDAO();
  			usuarios = new HashMap<String,Usuario>();
  			this.cargarCatalogo();
  		} catch (DAOException eDAO) {
  			eDAO.printStackTrace();
  		}
	}
	
	
	public static CatalogoUsuarios getUnicaInstancia(){
		return unicaInstancia;
	}
	
	
	public List<Usuario> getClientes(){
		ArrayList<Usuario> lista = new ArrayList<Usuario>();
		for (Usuario u:usuarios.values()) 
			lista.add(u);
		return lista;
	}
	
	
	public Usuario getUsuario(String us) {
		for (Usuario u:usuarios.values()) {
			if (u.getUsuario()==us) return u;
		}
		return null;
	}
	public Usuario getCliente(String dni) {
		return usuarios.get(dni); 
	}
	
	public void addUsuario(Usuario u) {
		usuarios.put(u.getUsuario(),u);
	}
	public void removeUsuario(Usuario u) {
		usuarios.remove(u.getUsuario());
	}
	
	/*Recupera todos los clientes para trabajar con ellos en memoria*/
	private void cargarCatalogo() throws DAOException {
		 List<Usuario> clientesBD = adaptadorUsuario.recuperarTodosUsuarios();
		 for (Usuario u: clientesBD) 
			 usuarios.put(u.getUsuario(),u);
	}
	
	
	
	
}
