import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class Empresa {
	private String _CUIT;
	private String _nombre;
	List<Deposito> Depositos = new ArrayList<Deposito>();
	HashMap<String, Transporte> Vehiculos = new HashMap<>();
	HashMap<String, Viaje> DestinosDistancia = new HashMap<>();
	
	public Empresa(String CUIT, String nombre, int capacidadMáxima) {
		set_CUIT(CUIT);
		set_nombre(nombre);
		Deposito depositoFrio = new Deposito(true, capacidadMáxima);
		Deposito depositoNormal = new Deposito(false, capacidadMáxima);
		Depositos.add(depositoFrio);
		Depositos.add(depositoNormal);
	}

	public void agregarDestino(String id, int km) throws Exception  {
		if(DestinosDistancia.containsKey(id)) {
			throw new RuntimeException("El destino "+id+ " ya existe");
		}
		else {
			Viaje nuevoViaje = new Viaje(id, km);
			DestinosDistancia.put(id, nuevoViaje);
		}
	}

	public boolean incorporarPaquete(String destino, int peso, double volumen, boolean frio) {
		if(frio) {
			Paquete nuevoPaquete = new Paquete(destino, peso, volumen, frio);
			for(Deposito deposito : Depositos) {
				if(deposito.get_refrigeracion() && deposito.agregarPaquete(nuevoPaquete)) {
					return true;
				}
			}
			return false;
		}
		if(!frio) {
			Paquete nuevoPaquete = new Paquete(destino, peso, volumen, frio);
			for(Deposito deposito : Depositos) {
				if(!deposito.get_refrigeracion() && deposito.agregarPaquete(nuevoPaquete)) {
					return true;
				}
			}
			return false;
		}
		return false;
	}

	public void iniciarViaje(String id) {
		if(Vehiculos.get(id).is_Viajando()) {
			throw new RuntimeException("El transporte: "+Vehiculos.get(id)+" ya se encuentra viajando.");
		}
		if(Vehiculos.get(id).get_viajeAsignado().get_destino() == "") {
			throw new RuntimeException("El transporte: "+Vehiculos.get(id)+" no tiene un destino asignado.");
		}
		if(Vehiculos.get(id).cantidadCargada()==0) {
			throw new RuntimeException("El transporte: "+Vehiculos.get(id)+" no tiene un paquete cargado.");
		}
		if(Vehiculos.containsKey(id)) {
			Vehiculos.get(id).set_Viajando(true);
		}
	}
	
	public void finalizarViaje(String id) throws Exception {
		if(!Vehiculos.get(id).is_Viajando()) {
			throw new RuntimeException("El transporte: "+(id)+" no esta en viaje.");
		}
		else {
			Vehiculos.get(id).vaciarPaquete();
			Vehiculos.get(id).blanquearViaje();
			Vehiculos.get(id).set_Viajando(false);
		}
	}

	public void asignarDestino(String id, String destino) {
		if(!DestinosDistancia.containsKey(destino)) {
			throw new RuntimeException("No se encontro el destino: "+destino);
		}
		else {
			Vehiculos.get(id).set_viajeAsignado(DestinosDistancia.get(destino));
		}
	}

	public double cargarTransporte(String id) {
		double volumenCargado = 0;
		if(Vehiculos.get(id).get_viajeAsignado().get_destino() == "") {
			throw new RuntimeException("El transporte: "+Vehiculos.get(id)+" no tiene un destino asignado.");
		}
		if(Vehiculos.get(id).is_Viajando()) {
			throw new RuntimeException("El transporte: "+Vehiculos.get(id)+" ya se encuentra viajando.");
		}
		if(Vehiculos.containsKey(id)) {
			for(Deposito deposito : Depositos) {
					if(Vehiculos.get(id).get_equipoRefrigeracion() && deposito.get_refrigeracion()) {
						for(Paquete paquete : deposito.inventario()) {
							if(Vehiculos.get(id).agregarPaquete(paquete)) {
								volumenCargado += paquete.get_volumen();
								deposito.retirarPaquete(paquete);
							}
							else {
								return volumenCargado;
							}
						}
					}
					if(!Vehiculos.get(id).get_equipoRefrigeracion() && !deposito.get_refrigeracion()) {
						for(Paquete paquete : deposito.inventario()) {
							if(Vehiculos.get(id).agregarPaquete(paquete)) {
								deposito.retirarPaquete(paquete);
								volumenCargado += paquete.get_volumen();
							}
							else {
								return volumenCargado;
							}
						}
					}
			}
		}
		return volumenCargado;
	}

	public double obtenerCostoViaje(String id) throws Exception {
		double costo = 0;
		if(!Vehiculos.get(id).is_Viajando()) {
			throw new Exception("El transporte: "+Vehiculos.get(id)+" no esta en viaje.");
		}
		if(Vehiculos.containsKey(id)) {
			if(Vehiculos.get(id).getClass().equals(TrailerComun.class)) {
				TrailerComun vehiculoActual = (TrailerComun) Vehiculos.get(id);
				costo = vehiculoActual.get_costoKM() * vehiculoActual.get_viajeAsignado().get_distanciaKM() + vehiculoActual.get_seguroCarga();
				return costo;
			}
			if(Vehiculos.get(id).getClass().equals(MegaTrailer.class)) {
				MegaTrailer vehiculoActual = (MegaTrailer) Vehiculos.get(id);
				costo = (vehiculoActual.get_viajeAsignado().get_distanciaKM() * vehiculoActual.get_costoKM()+ + vehiculoActual.get_seguroCarga() + vehiculoActual.get_costoFijo() + vehiculoActual.get_costoComida());
				return costo;
			}
			if(Vehiculos.get(id).getClass().equals(Fletes.class)) {
				Fletes vehiculoActual = (Fletes) Vehiculos.get(id);
				costo = (vehiculoActual.get_costoKM() * Vehiculos.get(id).get_viajeAsignado().get_distanciaKM()) + (vehiculoActual.get_costoAcompañante() * vehiculoActual.get_cantidadAcompañantes());
				return costo;
			}
		}
		return costo;
	}

	public void agregarTrailer(String id, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKm, double segCarga) {
		if(!Vehiculos.containsKey(id)) {
			Transporte nuevo = new TrailerComun(id, cargaMax, tieneRefrigeracion, costoKm, segCarga);
			Vehiculos.put(id, nuevo);
		}
	}

	public void agregarMegaTrailer(String id, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKM, double segCarga, double costoFijo, double costoComida) {
		if(!Vehiculos.containsKey(id)) {
			Transporte nuevo = new MegaTrailer(id, cargaMax, capacidad, tieneRefrigeracion, costoKM, segCarga, costoFijo, costoComida);
			Vehiculos.put(id, nuevo);
		}
	}

	public void agregarFlete(String id, double cargaMax, double capacidad, double costoKM, int cantAcompaniantes, double costoPorAcompaniante) {
		if(!Vehiculos.containsKey(id)) {
			Transporte nuevo = new Fletes(id, cargaMax, capacidad, costoKM, cantAcompaniantes, costoPorAcompaniante);
			Vehiculos.put(id, nuevo);
		}
	}

	public Object obtenerTransporteIgual(String id) {
		for (Entry<String, Transporte> entrada : Vehiculos.entrySet()) {
		    if(!id.equals(entrada.getKey()) && Vehiculos.get(id).getClass().equals(entrada.getValue().getClass()) 
		    		&& Vehiculos.get(id).get_viajeAsignado().get_destino().equals(entrada.getValue().get_viajeAsignado().get_destino())
		    		&& Vehiculos.get(id).cantidadCargada().equals(entrada.getValue().cantidadCargada())) {
		    	return entrada.getKey();
		    }
		}
		return null;
	}

	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("CUIT de la empresa: "+get_CUIT()+" Nombre de la empresa: "+get_nombre()+" Cantidad de depositos: "+Depositos.size());
		return string.toString();
	}
	
	public String get_CUIT() {
		return _CUIT;
	}

	public void set_CUIT(String _CUIT) {
		this._CUIT = _CUIT;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}

}
