package manufacturing;

import java.sql.*;
import java.util.ArrayList;

public class Conector {

	// Atributos de la clase
		private static Connection con;
		private static Conector INSTANCE = null;
		
		//Constructor
		private Conector() {
			
		}
		
		//Crear instancia
		private synchronized static void crearInstancia() {
			if (INSTANCE == null){
				INSTANCE = new Conector();
				crearConexion();
			}
		}
		
		//Obtener instancia
		public static Conector getInstancia () {
			if (INSTANCE == null){
				crearInstancia();
			}
			return INSTANCE;
		}
		
		
		//Crear conexion
		private static void crearConexion() {
			String host = "127.0.0.1";
			String user = "Justina";
			String password = "29septiembre2000*";
			String dataBase = "manufacturing";
			try {
				//Importando la libreria de conexion de mysql
				Class.forName("com.mysql.jdbc.Driver");
				
				String urlConexion = "jdbc:mysql://"+host+"/"
				+dataBase+"?user="+user+"&password="+password;
				con = DriverManager.getConnection(urlConexion);
				//System.out.println("Lo lograste");
				
			}catch (Exception e) {
				//System.out.println("Error al conectar a la base de datos");
				//System.out.println(e);
			}
		}
		
		
		public ArrayList<String> getEjercicio1() throws SQLException {
			ArrayList<String> listaClientes = new ArrayList<String>();
			PreparedStatement ps = (PreparedStatement) 
					con.prepareStatement("SELECT distinct name FROM manufacturing.clients\r\n" + 
							"inner join orders on clients.username = orders.clientusername \r\n" + 
							"&& orders.status = 'Done';");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listaClientes.add(rs.getString("name"));
			}
			rs.close();
			return listaClientes;
		}
		
		
		
		public ArrayList<String> getEjercicio2() throws SQLException {
			ArrayList<String> listaClientes = new ArrayList<String>();
			PreparedStatement ps = (PreparedStatement) 
					con.prepareStatement("SELECT distinct name, cost ,modeoftransport FROM manufacturing.clients\r\n" + 
							"inner join delivery on clients.username=delivery.clntusername\r\n" + 
							"inner join product on delivery.item=product.producttype\r\n" + 
							"where clients.name = 'New Client 1';");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listaClientes.add(rs.getString("name")+" - "+rs.getString("cost")+" - "+rs.getString("modeoftransport"));
			}
			rs.close();
			return listaClientes;
		}
		
		
		
		public ArrayList<String> getEjercicio3() throws SQLException {
			ArrayList<String> listaEmpleados = new ArrayList<String>();
			PreparedStatement ps = (PreparedStatement) 
					con.prepareStatement("SELECT name, email FROM manufacturing.employee \r\n" + 
							"left join attendance on employee.username = attendance.empusername \r\n" + 
							"where attendance.value is null;");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				listaEmpleados.add(rs.getString("name")+" - "+rs.getString("email"));
			}
			rs.close();
			return listaEmpleados;
		}
	
}
