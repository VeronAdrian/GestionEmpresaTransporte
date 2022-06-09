import java.util.Scanner;

public class main {
	private static String _user;
	private static boolean _run;
	private static boolean _bussines;
	private static Empresa _empresa;

	public static void main(String[] args) {
		Scanner read = new Scanner(System.in);
		iniciarUsuario();
		System.out.println("Hola "+ _user+" \nEn esta aplicacion tendras la oportunidad de crear y gestionar una empresa de transporte,\n"
				+ "para interacturar con las diferentes funciones deberas presionar el numero correspondiente\n"
				+ "al comando que deseas ejecutar.\nPrimero deberas iniciar la empresa");
		set_run(true);
		_empresa = iniciarEmpresa();
		while(_run) {
			Menu();
			int input = read.nextInt();
			if(input == 0) {
				System.out.println("¿Seguro deseas salir? Escriba SALIR ");
				String inputSalida = read.next();
				if(inputSalida.toUpperCase().equals("SALIR")) {
					set_run(false);
				}
				else {
					System.out.println("Volviendo...");
				}
			}
			if(input == 1) {
				System.out.println(_empresa.toString());
			}
			if(input>=10) {
				System.out.println("-----  Entrada equivacada  -----");
			}
		}
	}

	private static boolean iniciarUsuario() {
		Scanner read = new Scanner(System.in);
		System.out.println("Bienvenido al creador y gestor de empresas, \nPor favor introdusca su nombre de usuario:");
		while(true) {
			String string = read.next();
			set_user(string);
			if(!_user.isEmpty() && _user.length()>2) {
				set_bussines(true);
				return true;
			}
			else {
				System.out.println("El usuario debe tener mas de 2 caracteres");
			}
		}
	}
	
	private static Empresa iniciarEmpresa() {
		Scanner read = new Scanner(System.in);
		String CUIT = "";
		boolean bCUIT = true;
		String nombre = "";
		boolean bnombre = true;
		Integer capacidadMaxima = 0;
		boolean bcapacidadMaxima = true;
		System.out.println("Introduzca el nombre de la compañia:");
		while(bnombre) {
			nombre = read.next();
			if(!nombre.isEmpty() && nombre.length()>2) {
				bnombre = false;
			}
			else {
				System.out.println("El nombre debe tener mas de 2 caracteres");
			}
		}
		System.out.println("Introduzca el CUIT de la compañia:");
		while(bCUIT) {
			CUIT = read.next();
			if(!CUIT.isEmpty() && CUIT.length() == 8) {
				bCUIT = false;
			}
			else {
				System.out.println("Se necesitan 8 caracteres");
			}
		}
		System.out.println("Introduzca la capacidad de la empresa(Capacidad de los depositos)");
		while(bcapacidadMaxima) {
			capacidadMaxima = read.nextInt();
			if(capacidadMaxima >= 100) {
				bcapacidadMaxima = false;
			}
			else {
				System.out.println("La capacidad es muy pequeña o no es valida");
			}
		}
		Empresa nueva = new Empresa(CUIT, nombre, capacidadMaxima);
		return nueva;
	}
	
	private static void Menu() {
		System.out.println("Seleccione una accion:\n"
				+ "[1]Mostrar el estado de la empresa.\n"
				+ "[0]Salir");
	}

	public static String get_user() {
		return _user;
	}

	public static void set_user(String _user) {
		main._user = _user;
	}

	public static boolean is_run() {
		return _run;
	}

	public static void set_run(boolean _run) {
		main._run = _run;
	}

	public static boolean is_bussines() {
		return _bussines;
	}

	public static void set_bussines(boolean _bussines) {
		main._bussines = _bussines;
	}
}
