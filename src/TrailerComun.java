
public class TrailerComun extends Transporte{
	private Integer _distanciaMaximaKM;
	private double _seguroCarga;
	
	TrailerComun(String id, double cargaMax,boolean equipoRefrigeracion, double costoKm, double segCarga) {
		set_identificación(id);
		set_cargaMaxima(cargaMax);
		set_equipoRefrigeracion(equipoRefrigeracion);
		set_costoKM(costoKm);
		set_seguroCarga(segCarga);
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
		string.append(" Carga:"+get_cargaMaxima());
		if(get_equipoRefrigeracion()) {
			string.append(" Puede transportar paquetes frios");
		}
		else {
			string.append(" No puede transportar paquetes frios");
		}
		return string.toString();
	}
	
	public Integer get_distanciaMaximaKM() {
		return _distanciaMaximaKM;
	}

	public void set_distanciaMaximaKM(Integer _distanciaMaxima) {
		this._distanciaMaximaKM = _distanciaMaxima;
	}

	public double get_seguroCarga() {
		return _seguroCarga;
	}

	public void set_seguroCarga(double _seguroCarga) {
		this._seguroCarga = _seguroCarga;
	}

}
