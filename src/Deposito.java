import java.util.ArrayList;

public class Deposito {
	private boolean _refrigeracion;
	private Integer _capacidadMaxima;
	private ArrayList<Paquete> Depositos = new ArrayList<Paquete>();

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
	
	public ArrayList<Paquete> inventario() {
		return Depositos;
	}
	
	public boolean retirarPaquete(Paquete paqueteRetirado) {
		if(Depositos.contains(paqueteRetirado)) {
			return Depositos.remove(paqueteRetirado);
		}
		return false;
	}
	
	public boolean get_refrigeracion() {
		return _refrigeracion;
	}

	public void set_refrigeracion(boolean _refrigeracion) {
		this._refrigeracion = _refrigeracion;
	}

	public Integer get_capacidadMaxima() {
		return _capacidadMaxima;
	}

	public void set_capacidadMaxima(Integer _capacidadMaxima) {
		this._capacidadMaxima = _capacidadMaxima;
	}
}
