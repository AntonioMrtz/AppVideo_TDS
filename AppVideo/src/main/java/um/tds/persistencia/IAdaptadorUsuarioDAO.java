package um.tds.persistencia;

import java.util.List;

import um.tds.dominio.Usuario;

public interface IAdaptadorUsuarioDAO {
	
	public boolean addUsuario(Usuario us);
	public boolean removeUsuario(Usuario us);
	public void modificarUsuario(Usuario us);
	public Usuario findUsuario(int codigo);
	public List<Usuario> recuperarTodosUsuarios();
	

}
