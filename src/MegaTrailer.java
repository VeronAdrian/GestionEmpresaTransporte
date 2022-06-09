
public class MegaTrailer extends Transporte{
	private double _seguroCarga;
	private Integer _distanciaMaximaKM;
	private double _costoFijo;
	private double _costoComida;
	
	MegaTrailer(String id, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKM, double segCarga, double costoFijo, double costoComida) {
		set_identificación(id);
		set_cargaMaxima(cargaMax);
		set_capacidadMaxima(capacidad);
		set_equipoRefrigeracion(tieneRefrigeracion);
		set_costoKM(costoKM);
		set_seguroCarga(segCarga);
		set_costoFijo(costoFijo);
		set_costoComida(costoComida);
		set_distanciaMaximaKM(500);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Vehiculo id: "+get_identificación());
		if(is_Viajando()) {
			string.append(" Actualmente esta viajando");
		}
		else {
			string.append(" Actualmente no esta viajando");
		}
		string.append(" Carga:"+get_cargaMaxima()+" Tiene un seguro de carga por: "+get_seguroCarga());
		if(get_equipoRefrigeracion()) {
			string.append(" Puede transportar paquetes frios");
		}
		else {
			string.append(" No puede transportar paquetes frios");
		}
		return string.toString();
	}
	
	public double get_seguroCarga() {
		return _seguroCarga;
	}

	public void set_seguroCarga(double _seguroCarga) {
		this._seguroCarga = _seguroCarga;
	}

	public Integer get_distanciaMaximaKM() {
		return _distanciaMaximaKM;
	}

	public void set_distanciaMaximaKM(Integer _distanciaMaxima) {
		this._distanciaMaximaKM = _distanciaMaxima;
	}

	public double get_costoFijo() {
		return _costoFijo;
	}

	public void set_costoFijo(double costoFijo) {
		this._costoFijo = costoFijo;
	}

	public double get_costoComida() {
		return _costoComida;
	}

	public void set_costoComida(double costoComida) {
		this._costoComida = costoComida;
	}

}
