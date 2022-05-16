import java.util.HashMap;
import java.util.HashSet;

public class empresa {
	private Integer _CUIT;
	private String _nombre;
	HashSet<Deposito> Depositos = new HashSet<Deposito>();
	HashMap<Integer, Transporte> Vehiculos = new HashMap<>();
	HashMap<Integer, Viaje> VehiculosViajando = new HashMap<>();
	
	empresa(Integer CUIT, String nombre, Integer capacidadMáxima) {
		set_CUIT(CUIT);
		set_nombre(nombre);
		Deposito depositoFrio = new Deposito(true, capacidadMáxima);
		Deposito depositoNormal = new Deposito(false, capacidadMáxima);
		Depositos.add(depositoFrio);
		Depositos.add(depositoNormal);
	}
	
	public boolean agregarPaqueteDeposito(String destino, Integer peso, Integer volumen, boolean frio) {
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
	
	public boolean agregarTransporte(Integer identificación, Integer cargaMaxima, Integer capacidadMaxima, boolean equipoRefrigeracion, Integer costoKM) {
		if(!Vehiculos.containsKey(identificación)) {
			Transporte nuevo = new Transporte(identificación, cargaMaxima, capacidadMaxima, equipoRefrigeracion, costoKM);
			Vehiculos.put(identificación, nuevo);
			return true; 
		}
		return false;
	}
	
	public boolean agregarViaje(Integer id, String destino, Integer km) throws Exception {
		if(Vehiculos.containsKey(id)) {
			if(Vehiculos.get(id).cantidadCargada()>0) {
				throw new Exception("El transporte: "+Vehiculos.get(id)+" tiene paquetes cargados.");
			}
			Viaje nuevoViaje = new Viaje(destino, km);
			Vehiculos.get(id).set_viajeAsignado(nuevoViaje);
			return true;
		}
		return false;
	}
	
	public Integer cargarTransporte(Integer id) throws Exception {
		Integer volumenCargado = 0;
		if(Vehiculos.get(id).get_viajeAsignado().get_destino() != "") {
			throw new Exception("El transporte: "+Vehiculos.get(id)+" no tiene un destino asignado.");
		}
		if(VehiculosViajando.containsKey(id)) {
			throw new Exception("El transporte: "+Vehiculos.get(id)+" ya se encuentra viajando.");
		}
		if(Vehiculos.containsKey(id)) {
			for(Deposito deposito : Depositos) {
					if(Vehiculos.get(id).get_equipoRefrigeracion() && deposito.get_refrigeracion()) {
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
	
	public boolean iniciarViaje(Integer id) throws Exception {
		if(VehiculosViajando.containsKey(id)) {
			throw new Exception("El transporte: "+Vehiculos.get(id)+" ya se encuentra viajando.");
		}
		if(Vehiculos.get(id).get_viajeAsignado().get_destino() != "") {
			throw new Exception("El transporte: "+Vehiculos.get(id)+" no tiene un destino asignado.");
		}
		if(Vehiculos.get(id).cantidadCargada()>0) {
			throw new Exception("El transporte: "+Vehiculos.get(id)+" no tiene un paquete cargado.");
		}
		if(Vehiculos.containsKey(id)) {
			VehiculosViajando.put(id, Vehiculos.get(id).get_viajeAsignado());
			return true;
		}
		return false;
	}
	
	public boolean finalizarViaje(Integer id) throws Exception {
		if(!VehiculosViajando.containsKey(id)) {
			throw new Exception("El transporte: "+Vehiculos.get(id)+" no esta en viaje.");
		}
		Vehiculos.get(id).vaciarPaquete();
		Vehiculos.get(id).blanquearViaje();
		VehiculosViajando.remove(id);
		return true;
	}
	
	public double costoViaje(Integer id) throws Exception {
		double costo = 0;
		if(!VehiculosViajando.containsKey(id)) {
			throw new Exception("El transporte: "+Vehiculos.get(id)+" no esta en viaje.");
		}
		if(VehiculosViajando.containsKey(id)) {
			if(VehiculosViajando.get(id).getClass().equals(TrailerComun.class)) {
				TrailerComun vehiculoActual = (TrailerComun) Vehiculos.get(id);
				costo = vehiculoActual.get_costoKM() * VehiculosViajando.get(id).get_distanciaKM();
				return costo;
			}
			if(VehiculosViajando.get(id).getClass().equals(MegaTrailer.class)) {
				MegaTrailer vehiculoActual = (MegaTrailer) Vehiculos.get(id);
				costo = (((vehiculoActual.get_costoFijo() + vehiculoActual.get_costoKM()) * VehiculosViajando.get(id).get_distanciaKM()) + vehiculoActual.get_costoComida());
				return costo;
			}
			if(VehiculosViajando.get(id).getClass().equals(Fletes.class)) {
				Fletes vehiculoActual = (Fletes) Vehiculos.get(id);
				costo = (vehiculoActual.get_costoKM() * VehiculosViajando.get(id).get_distanciaKM()) + (vehiculoActual.get_costoAcompañante() * vehiculoActual.get_cantidadAcompañantes());
				return costo;
			}
		}
		return costo;
	}

	public Integer get_CUIT() {
		return _CUIT;
	}

	public void set_CUIT(Integer _CUIT) {
		this._CUIT = _CUIT;
	}

	public String get_nombre() {
		return _nombre;
	}

	public void set_nombre(String _nombre) {
		this._nombre = _nombre;
	}
}
