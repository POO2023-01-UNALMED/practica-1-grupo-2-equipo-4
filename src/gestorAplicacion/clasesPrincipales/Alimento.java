package gestorAplicacion.clasesPrincipales;
import java.io.Serializable;

import gestorAplicacion.clasesEnum.Alergeno;

public class Alimento implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
    public double calorias;
    public double proteinas;
    public double carbohidratos;
    public double grasas;
    private final Alergeno alergeno;

    // Constructor
    public Alimento(String nombre, double calorias, double proteinas, double carbohidratos, double grasas, Alergeno alergeno) {
        this.nombre = nombre;
        this.calorias = calorias;
        this.proteinas = proteinas;
        this.carbohidratos = carbohidratos;
        this.grasas = grasas;
        this.alergeno = alergeno;
    }

    // Getters y setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getCarbohidratos() {
        return carbohidratos;
    }

    public void setCarbohidratos(double carbohidratos) {
        this.carbohidratos = carbohidratos;
    }

    public double getGrasas() {
        return grasas;
    }

    public void setGrasas(double grasas) {
        this.grasas = grasas;
    }

	public Alergeno getAlergeno() {
		return alergeno;
	}
}
