package gestorAplicacion.clasesPrincipales;
import gestorAplicacion.clasesEnum.*;
import gestorAplicacion.clasesHerencia.Movimiento;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

//Autor: Jacobo Ochoa 
//Finalidad de la clase: Simular una rutina de ejercicios para un entrenamiento

public class Rutina implements Serializable{
    private static final long serialVersionUID = 1L;
	
  //Componentes: atributos de nombre, TipoEjercicio y una constante con el máximo numero de ejercicios en una rutina
    //Estructura de datos: ArrayList con todos los ejercicios que hacen parte de una rutina
    
    //Cabeceras en los métodos
    //A tener en cuenta
    
    private String nombre;
	private ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
	private TipoEjercicio tipoEjercicio;
	private static final int NUMEJERCIOS = 7; //Uso de constante

    public Rutina(String nombre) {
    	this.setNombre(nombre);
    }

    //Sobrecarga de constructores
    
    public Rutina(ArrayList<Ejercicio> ejercicios, TipoEjercicio tipoEjercicio){
    	this.ejercicios = ejercicios;
    	this.tipoEjercicio = tipoEjercicio;
    }
    
    public Rutina(String nombre, ArrayList<Ejercicio> ejercicios, TipoEjercicio tipoEjercicio){
        this.nombre = nombre;
    	this.ejercicios = ejercicios;
        this.tipoEjercicio = tipoEjercicio;
    }

    //Genera un objeto de rutina con los parametros de Tipo de ejercio, objetivo y el Nivel del cliente
    //Este debe tener 1 calentamiento, hasta 5 ejercios del tipo de ejercicio y un estiramiento
    
    public static Rutina generarRutina(TipoEjercicio tipoEjercicio, ObjetivoCliente objetivo, NivelCliente dificultad){
        ArrayList<Ejercicio> ejercicios = new ArrayList<Ejercicio>();
        
        //Filtra los movimientos por dificultad y por tipo de movimiento y los agrega a un arrayList

        ArrayList<Movimiento> movimientosDisponibles = Movimiento.filtrarMovimientosPorDificultad(Movimiento.filtrarMovimientosPorTipo(tipoEjercicio), dificultad);
        Random random = new Random();

        //Filtra los movimientos por tipo para que entregue los de tipo Calentmiento y estiramiento

        ArrayList<Movimiento> movCalentamiento = Movimiento.filtrarMovimientosPorTipo(TipoEjercicio.CALENTAMIENTO);
        ArrayList<Movimiento> movEstiramiento = Movimiento.filtrarMovimientosPorTipo(TipoEjercicio.ESTIRAMIENTO);
        
        //Convierte los movimientos en ejercicios/agrega el calentamiento

        ejercicios.add(Ejercicio.generarEjercicio(movCalentamiento.get(random.nextInt(movCalentamiento.size())), objetivo ));

        Collections.shuffle(movimientosDisponibles);

        //Añade los movimientos convertidos a ejercicios que son de tipoEjercicio a la lista de ejercicios

        for (int i = 0; i < movimientosDisponibles.size(); i++){
            if (i==(NUMEJERCIOS - 2)){
                break;
            }else {
                ejercicios.add(Ejercicio.generarEjercicio(movimientosDisponibles.get(i), objetivo));
            }
        }
        //Convierte los movimientos en ejercicios/agrega el estiramiento

        ejercicios.add(Ejercicio.generarEjercicio(movEstiramiento.get(random.nextInt(movEstiramiento.size())), objetivo ));
        
        return new Rutina(ejercicios, tipoEjercicio);
    }

    //toString que retorna la rutina con el nombre del ejercicio, y cuántas series y repeticiones se deben realizar
   
    @Override
    public String toString(){
        String toString = getTipoEjercicio() + "\n";
        for (Ejercicio ejercicio : getEjercicios()){
            toString = toString 
	            		+ ejercicio.getNombre() 
	            		+ " = " 
	            		+ ejercicio.getMaquina().getNombre() 
	            		+ " ---> " 
	            		+ ejercicio.getRepeticiones() 
	            		+ "x" 
	            		+ ejercicio.getSeries() 
	            		+ "\n";
        }
        return toString;
    }

	//Metodos Set y Get
    
    public void setEjercicios (ArrayList<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
    
    public void setTipoEjercicio (TipoEjercicio tipoEjercicio) {
        this.tipoEjercicio = tipoEjercicio;
    }
    
    public void setNombre(String nombre) {
		this.nombre = nombre;
    }

    public ArrayList<Ejercicio> getEjercicios() {
    	return ejercicios;
    }
    
    public TipoEjercicio getTipoEjercicio() {
    	return tipoEjercicio;
    }
    
    public String getNombre() {
        return nombre;
    }
      
    public int retNumEje() {
    	return NUMEJERCIOS;
    }
}
    
