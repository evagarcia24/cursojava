package es.juego.dominio.criatura;

import java.util.List;

import org.hibernate.cache.spi.support.AbstractReadWriteAccess.Item;

import es.juego.dominio.raza.Raza;

public interface Criatura {

	String getNombre();

	int getExperiencia();

	Raza getRaza();

	int getPuntosVida();

	int getPuntosVidaMax();

	List<Item> getArmas();

	List<Item> getEscudos();

	List<Item> getPociones();

	List<Item> getInventarioPasivoArmas();

	List<Item> getInventarioPasivoEscudos();

	List<Item> getInventarioPasivoPociones();
}
