
public class Viaje {
	private String _destino;
	private Integer _distanciaKM;
	
	Viaje(String destino, Integer distancia) {
		set_destino(destino);
		set_distanciaKM(distancia);
	}
	
	public String get_destino() {
		return _destino;
	}
	public void set_destino(String _destino) {
		this._destino = _destino;
	}
	public Integer get_distanciaKM() {
		return _distanciaKM;
	}
	public void set_distanciaKM(Integer _distanciaKM) {
		this._distanciaKM = _distanciaKM;
	}
}
