package um.tds.persistencia;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.dominio.Filtro;
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
	private static final String FILTRO = "filtro";
	
	/*
	private static final String HISTORIAL = "historial";
	private static final String LISTAS_REPRODUCCION = "playlists";
	private static final String FILTROS = "filtros";
	
	// listas especiales separadas de las normales ?
	private static final String LISTAS_REPRODUCCION = "playlists";
	*/
	
	//TODO AÑADIR LAS DEMAS PROPIEDADES DE UN USUARIO

	
	private enum Properties{
		
		USUARIO,NOMBRE,APELLIDOS,EMAIL,USER,PASSWORD,FECHA_NACIMIENTO,PREMIUM,FILTRO;
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
		
		array.add(new Propiedad(FECHA_NACIMIENTO,u.getFechaNacimiento().toString()));
		array.add(new Propiedad(FILTRO,u.getFiltroActual().toString()));
		
		
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
		
		String filtro=servPersistencia.recuperarPropiedadEntidad(e, FILTRO);
		
		
		///////
		
		Filtro f=null;
		
		
		try {
			f=(Filtro) Class.forName(filtro).newInstance();
			
			
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e1) {
			
			e1.printStackTrace();
		}
		
		if(f==null) {
			
			
			System.out.println("filtro nulo cuidado");
		}
		
		
		
		
		boolean prem=false;
		
		if (premium.equals("T")) prem=true;
		else prem=false;
		
		
		
		//TODO poner la fecha en su valor correspondiente tras recuperarla
		
		LocalDate d = null;
		//System.out.println(fechaNacimiento);
		if(fechaNacimiento!=null) d = LocalDate.parse(fechaNacimiento);
		//if(d!=null)System.out.println(d.toString());
		
		Usuario u = new Usuario(nombre, apellidos, email, prem, user, password, d);

		u.setId(e.getId());
		
		
		
		
		u.setFiltroActual(f);
		
		//TODO  AÑADIR LISTAS Y FILTROS
		
		
		
		
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
			
		
			//existe=false;
		}
		
		
		//if(existe==false || e!=null) return false;// !no pilla la excepcion por algun motivo
		
		if(e!=null)return false;
		
		e=buildEntity(us);
		
		e=servPersistencia.registrarEntidad(e);
		
		us.setId(e.getId());
		
		
		
		return true;
	}
	

	@Override
	public boolean removeUsuario(Usuario us) {
		
		Entidad e= servPersistencia.recuperarEntidad(us.getId());
		
		if(e==null)	return true;
		
		/////////////////////////////////
		
		//TODO BORRAR LISTAS 
		
		return servPersistencia.borrarEntidad(e);
		
		
	}

	
	//TODO
	@Override
	public void modificarUsuario(Usuario us) {

	
		
		Entidad e = servPersistencia.recuperarEntidad(us.getId());
		
		servPersistencia.eliminarPropiedadEntidad(e, NOMBRE);
		servPersistencia.anadirPropiedadEntidad(e, NOMBRE,us.getNombre());
		
		servPersistencia.eliminarPropiedadEntidad(e, APELLIDOS);
		servPersistencia.anadirPropiedadEntidad(e, APELLIDOS,us.getApellidos());
		
		servPersistencia.eliminarPropiedadEntidad(e, EMAIL);
		servPersistencia.anadirPropiedadEntidad(e, EMAIL,us.getEmail());
		
		servPersistencia.eliminarPropiedadEntidad(e, FECHA_NACIMIENTO);
		servPersistencia.anadirPropiedadEntidad(e, FECHA_NACIMIENTO,us.getFechaNacimiento().toString());
		
		servPersistencia.eliminarPropiedadEntidad(e, USER);
		servPersistencia.anadirPropiedadEntidad(e, USER,us.getUsuario());
				
		servPersistencia.eliminarPropiedadEntidad(e, PASSWORD);
		servPersistencia.anadirPropiedadEntidad(e, PASSWORD,us.getPassword());
		
		
		String auxPremium;
		
		if(us.isPremium()) auxPremium="T";
		else auxPremium="F";
		
		servPersistencia.eliminarPropiedadEntidad(e, PREMIUM);
		servPersistencia.anadirPropiedadEntidad(e, PREMIUM,auxPremium);
		
		
		
		//TODO LISTAS CUANDO ESTEN READY
		
		servPersistencia.eliminarPropiedadEntidad(e, FILTRO);
		servPersistencia.anadirPropiedadEntidad(e, FILTRO,us.getFiltroActual().toString());
		
	}

	@Override
	public Usuario findUsuario(int id) {
	
		
		return buildUser(servPersistencia.recuperarEntidad(id));
	}

	@Override
	public List<Usuario> recuperarTodosUsuarios() {

		List<Usuario> users = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades(USUARIO);
		
		
		for (Entidad e : ent) {
			
			Entidad eaux=servPersistencia.recuperarEntidad(e.getId());
			users.add(buildUser(eaux));
			
			
			
		}
		
		
		return users;
		
	}

}
