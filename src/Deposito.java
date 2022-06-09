import java.util.ArrayList;
import java.util.List;

public class Deposito {
	private boolean _refrigeracion;
	private double _capacidadMaxima;
	private List<Paquete> Depositos = new ArrayList<Paquete>();

	Deposito(boolean refrigeracion, Integer capacidadMaxima){
		set_capacidadMaxima(capacidadMaxima);
		set_refrigeracion(refrigeracion);
	}
	
	public boolean agregarPaquete(Paquete paqueteNuevo) {
		if(paqueteNuevo.get_volumen() <= get_capacidadMaxima()) {
			Depositos.add(paqueteNuevo);
			set_capacidadMaxima(get_capacidadMaxima()-paqueteNuevo.get_volumen());
			return true;
		}
		return false;
	}
	
	public List<Paquete> inventario() {
		return Depositos;
	}
	
	public void retirarPaquete(Paquete paqueteRetirado) {
		List<Paquete> nuevoDepositos = new ArrayList<Paquete>();
		for(Paquete paquete : Depositos) {
			if(!paquete.equals(paqueteRetirado)) {
				nuevoDepositos.add(paquete);
			}
		}
		Depositos = nuevoDepositos;
	}
	
	@Override
	public String toString() {
		StringBuilder string = new StringBuilder();
		if(!get_refrigeracion()) {
			string.append("El deposito no tiene refrigeracion,");
		}
		else {
			string.append("El deposito tiene refrigeracion,");
		}
		string.append(" cuenta con una capacidad de: "+get_capacidadMaxima()+" y con "+Depositos.size()+" paquetes almacenados");
		return string.toString();
	}
	
	public boolean get_refrigeracion() {
		return _refrigeracion;
	}

	public void set_refrigeracion(boolean _refrigeracion) {
		this._refrigeracion = _refrigeracion;
	}

	public double get_capacidadMaxima() {
		return _capacidadMaxima;
	}

	public void set_capacidadMaxima(double d) {
		this._capacidadMaxima = d;
	}
}
