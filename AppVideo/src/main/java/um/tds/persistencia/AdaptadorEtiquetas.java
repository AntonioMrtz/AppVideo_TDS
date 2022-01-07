package um.tds.persistencia;

import java.util.ArrayList;
import java.util.List;

import beans.Entidad;
import beans.Propiedad;
import tds.driver.FactoriaServicioPersistencia;
import tds.driver.ServicioPersistencia;
import um.tds.dominio.Etiqueta;

public class AdaptadorEtiquetas implements IAdaptadorEtiquetasDAO {

	private static ServicioPersistencia servPersistencia = null;
	private static AdaptadorEtiquetas unicaInstancia = null;

	private static final String ETIQUETA = "Etiqueta";

	private static final String NOMBRE = "Nombre";

	private enum Properties {

		NOMBRE;
	}

	public AdaptadorEtiquetas() {

		servPersistencia = FactoriaServicioPersistencia.getInstance().getServicioPersistencia();

	}

	public static AdaptadorEtiquetas getUnicaInstancia() {

		if (unicaInstancia == null)
			return new AdaptadorEtiquetas();
		else
			return unicaInstancia;

	}

	public Entidad buildEntity(Etiqueta et) {

		Entidad e = new Entidad();
		e.setNombre(ETIQUETA);

		ArrayList<Propiedad> a = new ArrayList<>();
		a.add(new Propiedad(NOMBRE, et.getNombre()));
		e.setPropiedades(a);

		return e;
	}

	public Etiqueta buildEtiqueta(Entidad e) {

		if (e == null)
			return null;

		String nombre = servPersistencia.recuperarPropiedadEntidad(e, NOMBRE);

		Etiqueta et = new Etiqueta(nombre);
		et.setId(e.getId());

		return et;

	}

	@Override
	public boolean registrarEtiqueta(Etiqueta et) {

		Entidad e = null;

		try {

			e = servPersistencia.recuperarEntidad(et.getId());

		} catch (NullPointerException ex) {

			// existe=false;
		}

		if (e != null)
			return false;

		e = buildEntity(et);

		e = servPersistencia.registrarEntidad(e);

		et.setId(e.getId());

		return true;

	}

	@Override
	public boolean borrarEtiqueta(Etiqueta et) {

		Entidad e = servPersistencia.recuperarEntidad(et.getId());

		if (e == null)
			return true;

		return servPersistencia.borrarEntidad(e);

	}

	/*
	 * En principio no es necesario modificar una etiqueta ya que solo tiene el
	 * campo string
	 * 
	 * @Override public void modificarEtiqueta(Etiqueta e) {
	 * 
	 * 
	 * }
	 */

	@Override
	public Etiqueta findEtiqueta(int codigo) {

		return buildEtiqueta(servPersistencia.recuperarEntidad(codigo));
	}

	@Override
	public List<Etiqueta> recuperarTodasEtiquetas() {

		List<Etiqueta> etiquetas = new ArrayList<>();
		List<Entidad> ent = servPersistencia.recuperarEntidades(ETIQUETA);

		for (Entidad e : ent) {

			Entidad eaux = servPersistencia.recuperarEntidad(e.getId());
			etiquetas.add(buildEtiqueta(eaux));

		}

		return etiquetas;
	}

}
