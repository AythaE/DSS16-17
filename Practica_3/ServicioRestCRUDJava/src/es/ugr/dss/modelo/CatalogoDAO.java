package es.ugr.dss.modelo;

import java.util.HashMap;
import java.util.Map;

import es.ugr.dss.modelo.ItemCatalogo.Color;

public enum CatalogoDAO {

	INSTANCE;
	private Map<String, ItemCatalogo> proveedorContenido = new HashMap<String, ItemCatalogo>();

	private CatalogoDAO() {
		ItemCatalogo it1 = new ItemCatalogo("1", "Traje", "Traje de corte italiano para caballero", 190.5, "S, M, L",
				Color.Negro);
		proveedorContenido.put("1", it1);

		ItemCatalogo it2 = new ItemCatalogo("2", "Vestido", "Vestido de espalda descubierta para señora", 249.99,
				"S, M, L", Color.Rojo);
		proveedorContenido.put("2", it2);

		ItemCatalogo it3 = new ItemCatalogo("3", "Traje comunion", "Traje de comunión para niños estilo marinero",
				249.99, "10, 12, 14", Color.Blanco);
		proveedorContenido.put("3", it3);
	}

	public Map<String, ItemCatalogo> getModelo() {
		return proveedorContenido;
	}

}
