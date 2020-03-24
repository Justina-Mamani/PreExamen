package manufacturing;

import java.sql.*;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Conector instancia = Conector.getInstancia();
		
		try {
			ArrayList <String> listNombres = instancia.getEjercicio1();
			System.out.println("1. CLIENTES CON STATUS DONE");
			for(String nombres :listNombres) {
				System.out.println(nombres);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
		
		
		
		
		try {
			ArrayList <String> lista = instancia.getEjercicio2();
			System.out.println("\n\n2. DATOS DE: New Client 1");
			System.out.println("NOMBRE - COSTO - MODO DE TRANSPORTE");
			for(String clientes :lista) {
				System.out.println(clientes);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}

		
		
		
		try {
			ArrayList <String> lista = instancia.getEjercicio3();
			System.out.println("\n\n3. EMPLEADOS SIN ASISTENCIA");
			System.out.println("NOMBRE - EMAIL");
			for(String empleados :lista) {
				System.out.println(empleados);
			}
		}catch (SQLException e){
			e.printStackTrace();
		}
	}

}
