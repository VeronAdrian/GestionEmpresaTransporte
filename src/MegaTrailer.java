
public class MegaTrailer extends Transporte{
	private double _seguroCarga;
	private static Integer _distanciaMaximaKM;
	private double _costoFijo;
	private double _costoComida;
	
	MegaTrailer(String id, double cargaMax, double capacidad, boolean tieneRefrigeracion, double costoKM, double segCarga, double costoFijo, double costoComida) {
		super(id, cargaMax, tieneRefrigeracion, costoKM, segCarga);
		set_capacidadMaxima(capacidad);
		set_seguroCarga(segCarga);
		set_distanciaMaximaKM(500);
		set_costoFijo(costoFijo);
		set_costoComida(costoComida);
	}
	
	public double get_seguroCarga() {
		return _seguroCarga;
	}

	public void set_seguroCarga(double _seguroCarga) {
		this._seguroCarga = _seguroCarga;
	}

	public static Integer get_distanciaMaximaKM() {
		return _distanciaMaximaKM;
	}

	public static void set_distanciaMaximaKM(Integer _distanciaMaxima) {
		MegaTrailer._distanciaMaximaKM = _distanciaMaxima;
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
