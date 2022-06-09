
public class Fletes extends Transporte{
	private double _costoAcompa�ante;
	private double _cantidadAcompa�antes;

	Fletes(String id, double cargaMax, double capacidad, double costoKM, int cantAcompaniantes, double costoPorAcompaniante) {
		set_identificaci�n(id);
		set_cargaMaxima(cargaMax);
		set_capacidadMaxima(capacidad);
		set_costoKM(costoKM);
		set_cantidadAcompa�antes(cantAcompaniantes);
		set_costoAcompa�ante(costoPorAcompaniante);
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		string.append("Vehiculo id: "+get_identificaci�n());
		if(is_Viajando()) {
			string.append(" Actualmente esta viajando");
		}
		else {
			string.append(" Actualmente no esta viajando");
		}
		string.append(" Carga:"+get_cargaMaxima()+" No puede transportar paquetes frios Cuenta con "+get_cantidadAcompa�antes()+" acompa�antes");
		return string.toString();
	}
	
	public double get_costoAcompa�ante() {
		return _costoAcompa�ante;
	}

	public void set_costoAcompa�ante(double _costoAcompa�ante) {
		this._costoAcompa�ante = _costoAcompa�ante;
	}

	public double get_cantidadAcompa�antes() {
		return _cantidadAcompa�antes;
	}

	public void set_cantidadAcompa�antes(double _cantidadAcompa�antes) {
		this._cantidadAcompa�antes = _cantidadAcompa�antes;
	}
	
}
