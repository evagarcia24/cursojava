package es.bbdd.conexion;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConsultaProductos {
	private static final String CONSULTA_PRODUCTOS = "SELECT "
			+ "ID,NOMBRE,PRECIO,STOCK,FECHA_ALTA,ESTADO,CODIGO_SKU,CREADO_POR,IVA FROM TB_PRODUCTOS_PROFE";

	public static void main(String[] args) {

		consultaProductos();

	}

	public static void consultaProductos() {

		Connection conexion = UtilidadesBD.crearConexion();
		Statement st = null;
		ResultSet rs = null;
		try {
			st = conexion.createStatement();
			rs = st.executeQuery(CONSULTA_PRODUCTOS);
			while (rs.next()) {
				int id = rs.getInt("ID");
				String nombre = rs.getString("NOMBRE");
				int edad = rs.getInt("EDAD");
				double salario = rs.getDouble("SALARIO");

				System.out.println("Registro.[ id: " + id + ", nombre: " + nombre + ", edad: " + edad + ", salario: " + salario + "]");

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			UtilidadesBD.cierraConexion(conexion);
			try {
				st.close();
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		System.out.println("TERMINA");
	}

}
