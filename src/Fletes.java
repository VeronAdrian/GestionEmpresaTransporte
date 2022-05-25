
public class Fletes extends Transporte{
	private double _costoAcompañante;
	private double _cantidadAcompañantes;

	Fletes(String id, double cargaMax, double capacidad, double costoKM, int cantAcompaniantes, double costoPorAcompaniante) {
		super(id, cargaMax, false, costoKM, 0);
		set_costoAcompañante(costoPorAcompaniante);
		set_cantidadAcompañantes(cantAcompaniantes);
	}

	public double get_costoAcompañante() {
		return _costoAcompañante;
	}

	public void set_costoAcompañante(double _costoAcompañante) {
		this._costoAcompañante = _costoAcompañante;
	}

	public double get_cantidadAcompañantes() {
		return _cantidadAcompañantes;
	}

	public void set_cantidadAcompañantes(double _cantidadAcompañantes) {
		this._cantidadAcompañantes = _cantidadAcompañantes;
	}
	
}
