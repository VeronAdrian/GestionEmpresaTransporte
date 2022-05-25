
public class Paquete {
	private Integer _peso;
	private double _volumen;
	private String _destino;
	private boolean _frio;
	
	Paquete(String destino, Integer peso, double volumen, boolean frio){
		set_destino(destino);
		set_pesoKG(peso);
		set_volumen(volumen);
		set_frio(frio);
	}
	
	public Integer get_pesoKG() {
		return _peso;
	}
	public void set_pesoKG(Integer _pesoKG) {
		this._peso = _pesoKG;
	}
	public double get_volumen() {
		return _volumen;
	}
	public void set_volumen(double _volumen) {
		this._volumen = _volumen;
	}
	public String get_destino() {
		return _destino;
	}
	public void set_destino(String _destino) {
		this._destino = _destino;
	}
	public boolean is_frio() {
		return _frio;
	}
	public void set_frio(boolean _frio) {
		this._frio = _frio;
	}

}
