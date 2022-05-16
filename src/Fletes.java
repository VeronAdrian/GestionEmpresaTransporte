
public class Fletes extends Transporte{
	private boolean _acompañante;
	private Integer _costoAcompañante;
	private Integer _cantidadAcompañantes;

	Fletes(Integer identificación, Integer cargaMaxima, Integer capacidadMaxima, Integer costoKM,boolean acompañante, Integer costoAcompañante) {
		super(identificación, cargaMaxima, capacidadMaxima, false, costoKM);
		set_acompañante(acompañante);
		set_costoAcompañante(costoAcompañante);
	}

	public boolean is_acompañante() {
		return _acompañante;
	}

	public void set_acompañante(boolean _acompañante) {
		this._acompañante = _acompañante;
	}

	public Integer get_costoAcompañante() {
		return _costoAcompañante;
	}

	public void set_costoAcompañante(Integer _costoAcompañante) {
		this._costoAcompañante = _costoAcompañante;
	}

	public Integer get_cantidadAcompañantes() {
		return _cantidadAcompañantes;
	}

	public void set_cantidadAcompañantes(Integer _cantidadAcompañantes) {
		this._cantidadAcompañantes = _cantidadAcompañantes;
	}
	
}
