package um.tds.persistencia;

import java.util.ArrayList;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.dominio.Usuario;

public class AdaptadorUsuario implements IAdaptadorUsuarioDAO{

	
	private static ServicioPersistencia servPersistencia = null;
	private static AdaptadorUsuario unicaInstancia = null;
	
	
	
	// Campos usuario en servidor
	
	private static final String USUARIO = "Usuario";
	private static final String NOMBRE = "nombre";
	private static final String APELLIDOS = "apellidos";
	private static final String EMAIL = "email";
	private static final String USER = "USER";
	private static final String PASSWORD = "password";
	private static final String FECHA_NACIMIENTO = "fechaNacimiento";
	private static final String PREMIUM = "premium";
	
	/*
	private static final String HISTORIAL = "historial";
	private static final String LISTAS_CANCIONES = "playlists";
	*/
	
	//TODO AÑADIR LAS DEMAS PROPIEDADES DE UN USUARIO

	
	private enum Properties{
		
		USUARIO,NOMBRE,APELLIDOS,EMAIL,USER,PASSWORD,FECHA_NACIMIENTO,PREMIUM
	}
	
	
	private AdaptadorUsuario() {
		
		servPersistencia= FactoriaServicioPersistencia.getInstance().getServicioPersistencia();
	}
	
	public static AdaptadorUsuario getUnicaInstancia() {
		if (unicaInstancia == null)
			return new AdaptadorUsuario();
		else
			return unicaInstancia;
		
	}
	
	
	
	///// AUXILIARES
	
	
	
	private Entidad buildEntity(Usuario u) {
		
		
		Entidad e= new Entidad();
		
		e.setNombre(USUARIO);
		
		
		ArrayList<Propiedad> array= new ArrayList<>();
		
		
		array.add(new Propiedad(NOMBRE,u.getNombre()));
		array.add(new Propiedad(APELLIDOS,u.getApellidos()));
		array.add(new Propiedad(EMAIL,u.getEmail()));
		array.add(new Propiedad(USER,u.getUsuario()));
		array.add(new Propiedad(PASSWORD,u.getPassword()));
		
		String premium ;
		if (u.isPremium()) {
			premium="T";
		}
		else {
			premium="F";
		}
		
		array.add(new Propiedad(PREMIUM,premium));
		
		
		
		
		
		
		e.setPropiedades(array);
		
		return e;
		
	}
	
	
	public Usuario buildUser(Entidad e) {
		
		if(e==null) return null;
		
		
		String nombre=servPersistencia.recuperarPropiedadEntidad(e, NOMBRE);
		String apellidos=servPersistencia.recuperarPropiedadEntidad(e, APELLIDOS);
		String email=servPersistencia.recuperarPropiedadEntidad(e, EMAIL);
		String user=servPersistencia.recuperarPropiedadEntidad(e, USER);
		String password=servPersistencia.recuperarPropiedadEntidad(e, PASSWORD);
		String fechaNacimiento=servPersistencia.recuperarPropiedadEntidad(e, FECHA_NACIMIENTO);
		String premium=servPersistencia.recuperarPropiedadEntidad(e, PREMIUM);
		
		boolean prem;
		
		if (premium.equals("T")) prem=true;
		else prem=false;
		
		//TODO poner la fecha en null tras recuperarla
		
		Usuario u = new Usuario(nombre, apellidos, email, prem, user, premium, null);
		u.setId(e.getId());
		
		return u;
		
	}
	
	
	
	//// METODOS
	
	
	
	
	@Override
	public boolean addUsuario(Usuario us) {
		
		Entidad e=null;
		

		boolean existe = true; 
		
		try {
			
			e  = servPersistencia.recuperarEntidad(us.getId());
		
		} catch (NullPointerException ex) {
		
			existe=false;
		}
		
		
		//if(existe && e!=null) return false;// !no pilla la excepcion por algun motivo
		
		if(e!=null)return false;
		
		e=buildEntity(us);
		
		e=servPersistencia.registrarEntidad(e);
		
		us.setId(e.getId());
		
		
		
		return true;
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

		List<Usuario> users = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades(USUARIO);
		
		for (Entidad e : ent) {
			
			users.add(buildUser(e));
			
		}
		
		return users;
		
	}

}
