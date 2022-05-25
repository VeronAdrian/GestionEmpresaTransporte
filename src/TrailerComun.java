
public class TrailerComun extends Transporte{
	private static Integer _distanciaMaximaKM;
	private double _seguroCarga;
	
	TrailerComun(String id, double cargaMax,boolean equipoRefrigeracion, double costoKm, double segCarga) {
		super(id, cargaMax, equipoRefrigeracion, costoKm, segCarga);
		set_seguroCarga(segCarga);
		set_distanciaMaximaKM(500);
	}

	public static Integer get_distanciaMaximaKM() {
		return _distanciaMaximaKM;
	}

	public static void set_distanciaMaximaKM(Integer _distanciaMaxima) {
		TrailerComun._distanciaMaximaKM = _distanciaMaxima;
	}

	public double get_seguroCarga() {
		return _seguroCarga;
	}

	public void set_seguroCarga(double _seguroCarga) {
		this._seguroCarga = _seguroCarga;
	}

}
