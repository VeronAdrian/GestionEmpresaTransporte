
public class Fletes extends Transporte{
	private double _costoAcompañante;
	private double _cantidadAcompañantes;

	Fletes(String id, double cargaMax, double capacidad, double costoKM, int cantAcompaniantes, double costoPorAcompaniante) {
		set_identificación(id);
		set_cargaMaxima(cargaMax);
		set_capacidadMaxima(capacidad);
		set_costoKM(costoKM);
		set_cantidadAcompañantes(cantAcompaniantes);
		set_costoAcompañante(costoPorAcompaniante);
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
		string.append(" Carga:"+get_cargaMaxima()+" No puede transportar paquetes frios Cuenta con "+get_cantidadAcompañantes()+" acompañantes");
		return string.toString();
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
