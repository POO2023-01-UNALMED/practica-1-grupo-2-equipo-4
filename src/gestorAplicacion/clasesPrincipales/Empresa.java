package gestorAplicacion.clasesPrincipales;

import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import baseDatos.Deserializador;
import gestorAplicacion.clasesHerencia.Movimiento;
import gestorAplicacion.clasesHerencia.Plan;

import java.util.Iterator;

//Autores: Jacobo Ochoa.

//Finalidad de la clase: 
//La clase Comida sirve para almacenar listas de alimentos que componen
//una de las tres comidas diarias.

//Estructuras de datos:
//Utilizamos un ArrayList para guardar la lista de alimentos

//Componentes:

//Unos atributos de nombre, TipoComida, PreferenciaAlimenticia y ObjetivoCliente
//que describen el tipo de la comida

//Unos atributos de Macronutrientes que se calculan con un método que mostraremos más adelante
//Una lista estática de todas las comidas que se van creando

public class Empresa implements Serializable {
  
    private static final long serialVersionUID = 1L;

    private List<Gimnasio> gimnasios = new ArrayList<Gimnasio>();
    private List<Entrenador> entrenadores = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();
    private List<Maquina> maquinas = new ArrayList<>();
    private List<Movimiento> movimientos = new ArrayList<>();
    private List<Comida> comidas = new ArrayList<>();
    private List<Ejercicio> ejercicios = new ArrayList<>();
    private List<Rutina> rutinas = new ArrayList<>();
    private List<PlanAlimentacion> planesAlimentacion = new ArrayList<>();
    private List<PlanEjercicio> planesEjercicio = new ArrayList<>();
    private List<Alimento> alimentos = new ArrayList<>();

    public Empresa (){
        Deserializador.desearilizar(this);
    }

    public void agregarObjetosGimnasio(Gimnasio[] gimnasios){
        for (Gimnasio gimnasio : gimnasios ){
            this.gimnasios.add(gimnasio);
        }
    }

    public void agregarObjetosEntrenador(Entrenador[] entrenadores){
        for (Entrenador entrenador : entrenadores ){
            this.entrenadores.add(entrenador);
        }
    }

    public void agregarObjetosCliente(Cliente[] clientes){
        for (Cliente cliente:  clientes){
            this.clientes.add(cliente);
        }
    }

    public void agregarObjetosMaquina(Maquina[] maquinas){
        for (Maquina maquina:  maquinas){
            this.maquinas.add(maquina);
        }
    }
    
    public void agregarObjetosMovimiento(Movimiento[] movimientos){
        for (Movimiento movimiento :  movimientos){
            this.movimientos.add(movimiento);
        }
    }

    public void agregarObjetosComida(Comida[] comidas){
        for ( Comida comida:  comidas){
            this.comidas.add(comida);
        }
    }
     
    public void agregarObjetosEjercicio(Ejercicio[] ejercicios){
        for (Ejercicio ejercicio:  ejercicios){
            this.ejercicios.add(ejercicio);
        }
    }
     
    public void agregarObjetosRutina(Rutina[] rutinas){
        for (Rutina rutina : rutinas ){
            this.rutinas.add(rutina);
        }
    }
     
    public void agregarObjetosPlanAlimentacion(PlanAlimentacion[] planesAlimentacion){
        for (PlanAlimentacion planAlimentacion: planesAlimentacion ){
            this.planesAlimentacion.add(planAlimentacion);
        }
    }
      
    public void agregarObjetosPlanEjercicio(PlanEjercicio[] planesEjercicio){
        for (PlanEjercicio planEjercicio :  planesEjercicio){
            this.planesEjercicio.add(planEjercicio);
        }
    }

    public void agregarObjetosAlimentos(Alimento[] alimentos){
        for (Alimento alimento :  alimentos){
            this.alimentos.add(alimento);
        }
    }

    //metodos get y set
    public void setEjercicios (List<Ejercicio> ejercicios) {
        this.ejercicios = ejercicios;
    }
    
    public void setGimnasios (List<Gimnasio> gimnasios) {
        this.gimnasios = gimnasios;
    }
    
    public void setRutinas (List<Rutina> rutinas) {
        this.rutinas = rutinas;
    }
    
    public void setPlanesEjercicio (List<PlanEjercicio> planesEjercicio) {
        this.planesEjercicio = planesEjercicio;
    }
    
    public void setComidas (List<Comida> comidas) {
        this.comidas = comidas;
    }
    
    public void setMovimientos (List<Movimiento> movimientos) {
        this.movimientos = movimientos;
    }
    
    public void setPlanesAlimentacion (List<PlanAlimentacion> planesAlimentacion) {
        this.planesAlimentacion = planesAlimentacion;
    }
    
    public void setClientes (List<Cliente> clientes) {
        this.clientes = clientes;
    }
    
    public void setMaquinas (List<Maquina> maquinas) {
        this.maquinas = maquinas;
    }
    
    public void setEntrenadores (List<Entrenador> entrenadores) {
        this.entrenadores = entrenadores;
    }
    
    public void setAlimentos (List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public List<Ejercicio> getEjercicios() {
        return ejercicios;
    }
    
    public List<Gimnasio> getGimnasios() {
        return gimnasios;
    }
    
    public List<Rutina> getRutinas() {
        return rutinas;
    }
    
    public List<PlanEjercicio> getPlanesEjercicio() {
        return planesEjercicio;
    }
    
    public List<Comida> getComidas() {
        return comidas;
    }
    
    public List<Movimiento> getMovimientos() {
        return movimientos;
    }
    
    public List<PlanAlimentacion> getPlanesAlimentacion() {
        return planesAlimentacion;
    }
    
    public List<Cliente> getClientes() {
        return clientes;
    }
    
    public List<Maquina> getMaquinas() {
        return maquinas;
    }
    
    public List<Entrenador> getEntrenadores() {
        return entrenadores;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }
    
    public PlanEjercicio convertirAPlanEjercicio (Plan planEjercicio){
        return new PlanEjercicio(((PlanEjercicio) planEjercicio).getPlanSemanalEjercio());
    }
}
