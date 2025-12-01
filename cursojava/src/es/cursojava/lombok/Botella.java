package es.cursojava.lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.ToString.Exclude;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Data
public class Botella {

	private double capacidad;
	private String material;
	private String forma;
	// @Exclude → esto serviria para que no se mostrara el contenido
	private String contenido;
	
}
