import java.util.ArrayList;

public abstract class Transporte {
	private String _identificación;
	private double _cargaMaxima;
	private double _capacidadMaxima;
	private boolean _equipoRefrigeracion;
	private double _costoKM;
	private Viaje _viajeAsignado;
	private ArrayList<Paquete> Carga = new ArrayList<Paquete>();
	private boolean _viajando;
	
	Transporte(String id, double cargaMax,boolean equipoRefrigeracion, double costoKM, double segCarga) {
		set_identificación(id);
		set_cargaMaxima(cargaMax);
		set_equipoRefrigeracion(equipoRefrigeracion);
		set_costoKM(costoKM);
		blanquearViaje();
		set_Viajando(false);
	}
	
	public boolean agregarPaquete(Paquete nuevoPaquete) {
		if(nuevoPaquete.get_volumen()<=get_cargaMaxima()) {
			Carga.add(nuevoPaquete);
			set_cargaMaxima(get_cargaMaxima()-nuevoPaquete.get_volumen());
			return true;
		}
		return false;
	}
	
	public void vaciarPaquete() {
		this.Carga = new ArrayList<Paquete>();
	}
	
	public void blanquearViaje() {
		Viaje nuevoVacio = new Viaje("", 0);
		set_viajeAsignado(nuevoVacio);
	}
	
	public Integer cantidadCargada() {
		return Carga.size();
	}
	
	public String get_identificación() {
		return _identificación;
	}

	public void set_identificación(String id) {
		this._identificación = id;
	}

	public double get_cargaMaxima() {
		return _cargaMaxima;
	}

	public void set_cargaMaxima(double d) {
		this._cargaMaxima = d;
	}

	public boolean get_equipoRefrigeracion() {
		return _equipoRefrigeracion;
	}

	public void set_equipoRefrigeracion(boolean _equipoRefrigeracion) {
		this._equipoRefrigeracion = _equipoRefrigeracion;
	}

	public double get_costoKM() {
		return _costoKM;
	}

	public void set_costoKM(double segCarga) {
		this._costoKM = segCarga;
	}
	
	public Viaje get_viajeAsignado() {
		return _viajeAsignado;
	}
	
	public void set_viajeAsignado(Viaje _viajeAsignado) {
		this._viajeAsignado = _viajeAsignado;
	}

	public boolean is_Viajando() {
		return _viajando;
	}

	public void set_Viajando(boolean viajando) {
		this._viajando = viajando;
	}

	public double get_capacidadMaxima() {
		return _capacidadMaxima;
	}

	public void set_capacidadMaxima(double _capacidadMaxima) {
		this._capacidadMaxima = _capacidadMaxima;
	}

}
