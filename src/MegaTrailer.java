
public class MegaTrailer extends Transporte{
	private boolean _seguroCarga;
	private static Integer _distanciaMaximaKM;
	private Integer _costoFijo;
	private Integer _costoComida;
	
	MegaTrailer(Integer identificación, Integer cargaMaxima, Integer capacidadMaxima, boolean equipoRefrigeracion, Integer costoKM, Integer costoFijo, Integer costoComida) {
		super(identificación, cargaMaxima, capacidadMaxima, equipoRefrigeracion, costoKM);
		set_seguroCarga(true);
		set_distanciaMaximaKM(500);
		set_costoFijo(costoFijo);
		set_costoComida(costoComida);
	}
	
	public boolean is_seguroCarga() {
		return _seguroCarga;
	}

	public void set_seguroCarga(boolean _seguroCarga) {
		this._seguroCarga = _seguroCarga;
	}

	public static Integer get_distanciaMaximaKM() {
		return _distanciaMaximaKM;
	}

	public static void set_distanciaMaximaKM(Integer _distanciaMaxima) {
		MegaTrailer._distanciaMaximaKM = _distanciaMaxima;
	}

	public Integer get_costoFijo() {
		return _costoFijo;
	}

	public void set_costoFijo(Integer _costoFijo) {
		this._costoFijo = _costoFijo;
	}

	public Integer get_costoComida() {
		return _costoComida;
	}

	public void set_costoComida(Integer _costoComida) {
		this._costoComida = _costoComida;
	}

}
