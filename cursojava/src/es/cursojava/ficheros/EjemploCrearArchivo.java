package es.cursojava.ficheros;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class EjemploCrearArchivo {
	public static void main(String[] args) {
		LocalDateTime datetime = LocalDateTime.now();
		System.out.println(datetime);
		System.out.println(datetime.getYear());
		System.out.println(datetime.getMonthValue());
		System.out.println(datetime.getMonth());

		String fechaStr = "" + datetime.getYear() + datetime.getMonthValue() + datetime.getDayOfMonth();

		LocalDate date = LocalDate.now(); // Saca solo año, mes y dia
		String fechaStr2 = "" + date;

		Instant instant = Instant.now();
		System.out.println(instant);
		// Ruta relativa a la carpeta del proyecto

		Date fecha = new Date();
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy"); // m en minuscula es mes y M es mes
		String fechaStr3 = df.format(fecha);

		System.out.println(fechaStr3);

		String nombreArchivo = "./recursos/eva_" + fechaStr3 + ".txt";
		System.out.println(nombreArchivo);

		ArchivoServicio service = new ArchivoServicio();
		// service.mostrarContenidoDirectorio("C:\\Users\\Tardes\\");
		service.crearArchivo(nombreArchivo);
	}
}
