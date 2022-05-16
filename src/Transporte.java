import java.util.ArrayList;

public class Transporte {
	private Integer _identificación;
	private static Integer _cargaMaxima;
	private static Integer _capacidadMaxima;
	private boolean _equipoRefrigeracion;
	private Integer _costoKM;
	private Viaje _viajeAsignado;
	private ArrayList<Paquete> Carga = new ArrayList<Paquete>();
	
	Transporte(Integer identificación, Integer cargaMaxima, Integer capacidadMaxima, boolean equipoRefrigeracion, Integer costoKM) {
		set_identificación(identificación);
		set_cargaMaxima(cargaMaxima);
		set_capacidadMaxima(capacidadMaxima);
		set_equipoRefrigeracion(equipoRefrigeracion);
		set_costoKM(costoKM);
		blanquearViaje();
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
	
	public Integer get_identificación() {
		return _identificación;
	}

	public void set_identificación(Integer _identificación) {
		this._identificación = _identificación;
	}

	public static Integer get_cargaMaxima() {
		return _cargaMaxima;
	}

	public static void set_cargaMaxima(Integer _cargaMaxima) {
		Transporte._cargaMaxima = _cargaMaxima;
	}

	public static Integer get_capacidadMaxima() {
		return _capacidadMaxima;
	}

	public static void set_capacidadMaxima(Integer _capacidadMaxima) {
		Transporte._capacidadMaxima = _capacidadMaxima;
	}

	public boolean get_equipoRefrigeracion() {
		return _equipoRefrigeracion;
	}

	public void set_equipoRefrigeracion(boolean _equipoRefrigeracion) {
		this._equipoRefrigeracion = _equipoRefrigeracion;
	}

	public Integer get_costoKM() {
		return _costoKM;
	}

	public void set_costoKM(Integer _costoKM) {
		this._costoKM = _costoKM;
	}
	
	public Viaje get_viajeAsignado() {
		return _viajeAsignado;
	}
	
	public void set_viajeAsignado(Viaje _viajeAsignado) {
		this._viajeAsignado = _viajeAsignado;
	}

}
