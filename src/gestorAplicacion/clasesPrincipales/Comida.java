package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import java.io.Serializable;
import java.util.ArrayList;

public class Comida implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombre;
    public ArrayList<Alimento> listaAlimentos = new ArrayList<>();
    public double calorias;
    public double proteinas;
    public double carbohidratos;
    public double grasas;
    public TipoComida tipo;
    private PreferenciaAlimenticia preferenciaAlimenticia;
    public ObjetivoCliente objetivoCliente;

    // Constructor, getters y setters
    public Comida(String nombre, ArrayList<Alimento> listaAlimentos, TipoComida tipo, PreferenciaAlimenticia preferenciaAlimenticia, ObjetivoCliente objetivoCliente) {
        this.nombre = nombre;
        this.listaAlimentos = listaAlimentos;
        this.tipo = tipo;
        this.preferenciaAlimenticia = preferenciaAlimenticia;
        this.objetivoCliente = objetivoCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<Alimento> getListaAlimentos() {
        return listaAlimentos;
    }

    public void setListaAlimentos(ArrayList<Alimento> listaAlimentos) {
        this.listaAlimentos = listaAlimentos;
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

    public TipoComida getTipo() {
        return tipo;
    }

    public void setTipo(TipoComida tipo) {
        this.tipo = tipo;
    }

    public PreferenciaAlimenticia getPreferenciaAlimenticia() {
        return preferenciaAlimenticia;
    }

    public void setPreferenciaAlimenticia(PreferenciaAlimenticia preferenciaAlimenticia) {
        this.preferenciaAlimenticia = preferenciaAlimenticia;
    }

    public ObjetivoCliente getObjetivoCliente() {
        return objetivoCliente;
    }

    public void setObjetivoCliente(ObjetivoCliente objetivoCliente) {
        this.objetivoCliente = objetivoCliente;
    }

    public double calcularCalorias() {
    	double caloriasTotales = 0;
    	
    	
    	
        return caloriasTotales;
    }

    public void calcularMacronutrientes() {
        // logica
    }

    public void filtrarComidasPorObjetivo() {
        // logica
    }

    public void filtrarComidasPorPreferenciaAlimenticia() {
        // logica
    }
}
