
public class TrailerComun extends Transporte{
	private boolean _seguroCarga;
	private static Integer _distanciaMaximaKM;
	
	TrailerComun(Integer identificación, Integer cargaMaxima,boolean equipoRefrigeracion, Integer capacidadMaxima, Integer costoKM) {
		super(identificación, cargaMaxima, capacidadMaxima, equipoRefrigeracion, costoKM);
		set_seguroCarga(true);
		set_distanciaMaximaKM(500);
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
		TrailerComun._distanciaMaximaKM = _distanciaMaxima;
	}

}
