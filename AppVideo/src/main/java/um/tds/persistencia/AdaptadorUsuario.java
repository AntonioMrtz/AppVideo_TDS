package um.tds.persistencia;

import java.util.List;

import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.dominio.Usuario;

public class AdaptadorUsuario implements IAdaptadorUsuarioDAO{

	
	private static ServicioPersistencia servPersistencia = null;
	private static AdaptadorUsuario unicaInstancia = null;
	
	
	
	private AdaptadorUsuario() {
		
		servPersistencia= FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	public static AdaptadorUsuario getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorUsuario();
		else
			return unicaInstancia;
		
	}
	
	@Override
	public boolean addUsuario(Usuario us) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeUsuario(Usuario us) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void modificarUsuario(Usuario us) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Usuario findUsuario(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Usuario> recuperarTodosUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}

}
