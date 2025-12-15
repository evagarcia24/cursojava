package hibernate.ejercicioOneToMany.dto;

public class AlumnoAulaDto {

    private String nombreAlumno;
    private String codigoAula;
    private String ubicacion;

    public AlumnoAulaDto(String nombreAlumno, String codigoAula, String ubicacion) {
        this.nombreAlumno = nombreAlumno;
        this.codigoAula = codigoAula;
        this.ubicacion = ubicacion;
    }

    public String getNombreAlumno() {
        return nombreAlumno;
    }

    public String getCodigoAula() {
        return codigoAula;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    @Override
    public String toString() {
        return "AlumnoAulaDTO [alumno=" + nombreAlumno + ", aula=" + codigoAula +
               ", ubicacion=" + ubicacion + "]";
    }
}
