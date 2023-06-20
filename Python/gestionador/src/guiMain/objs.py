import os
import pickle
from src.gestorAplicacion.clasesEnum.NivelCliente import NivelCliente
from src.gestorAplicacion.clasesEnum.TipoEjercicio import TipoEjercicio
from src.gestorAplicacion.clasesEnum.ObjetivoCliente import ObjetivoCliente
from src.gestorAplicacion.clasesEnum.Alergeno import Alergeno
from src.gestorAplicacion.clasesEnum.TipoComida import TipoComida
from src.gestorAplicacion.clasesEnum.PreferenciaAlimenticia import PreferenciaAlimenticia


def obtenerListaAlimentos(a1, a2, a3):
    lista_alimentos = [a1, a2, a3]
    return lista_alimentos


def intento():
    from src.gestorAplicacion.clasesPrincipales.Alimento import Alimento
    from src.gestorAplicacion.clasesEnum.Alergeno import Alergeno
    # Obtengo los directorios adecuados
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dirgimnasios = os.path.join(two_levels_up, "src/baseDatos/tempo/gimnasios.pkl")
    dirmaquinas = os.path.join(two_levels_up, "src/baseDatos/tempo/maquinas.pkl")
    dirmovimientos = os.path.join(two_levels_up, "src/baseDatos/tempo/movimientos.pkl")
    direjercicios = os.path.join(two_levels_up, "src/baseDatos/tempo/ejercicios.pkl")
    diralims = os.path.join(two_levels_up, "src/baseDatos/tempo/alimentos.pkl")
    dircomidas = os.path.join(two_levels_up, "src/baseDatos/tempo/comidas.pkl")
    dirclientes = os.path.join(two_levels_up, "src/baseDatos/tempo/clientes.pkl")

    from src.gestorAplicacion.clasesHerencia.Movimiento import Movimiento
    from src.gestorAplicacion.clasesPrincipales import Ejercicio
    from src.gestorAplicacion.clasesPrincipales.Alimento import Alimento
    from src.gestorAplicacion.clasesPrincipales.Cliente import Cliente
    from src.gestorAplicacion.clasesPrincipales.Comida import Comida
    from src.gestorAplicacion.clasesPrincipales.Gimnasio import Gimnasio
    from src.gestorAplicacion.clasesPrincipales.Maquina import Maquina

    g1 = Gimnasio("Gymbro", "Medellin", "Prado", True)
    g2 = Gimnasio("Gymbro", "Medellin", "Robledo", True)
    g3 = Gimnasio("Gymbro", "Medellin", "Laureles", True)
    g4 = Gimnasio("Bodytech", "Medellin", "San Juan", True)
    
    g5 = Gimnasio("Smartfit", "Medellin", "Colombia", False)
    
    g6 = Gimnasio("Smartfit", "Bogota", "La Candelaria", True)
    g7 = Gimnasio("Smartfit", "Bogota", "20 de Julio", True)
    g8 = Gimnasio("Smartfit", "Bogota", "La Merced", True)
    g9 = Gimnasio("Bodytech", "Bogota", "Santafe", True)
    

    g10 = Gimnasio("Gymbro", "Bogota", "Luna Park", True)
    
    g11 = Gimnasio("Bodytech", "Bogota", "Calle90", True)
    g12 = Gimnasio("Bodytech", "Bogota", "Chicó", True)
    g13 = Gimnasio("Bodytech", "Medellin", "Laureles", True)
    g14 = Gimnasio("Bodytech", "Medellin", "San Lucas", True)
    g15 = Gimnasio("Smartfit", "Medellin", "Los Colores", False)
    g16 = Gimnasio("Smartfit", "Medellin", "Unicentro", False)
    g17 = Gimnasio("Gymbro", "Bogota", "Santafe", True)

    #MAQUINA

    m1 = Maquina("Barra", g1)
    m2 = Maquina("Polea", g1)
    m3 = Maquina("Caminadora", g1)
    g2.agregarMaquina(m1)
    g2.agregarMaquina(m2)
    g2.agregarMaquina(m3)
    m4 = Maquina("Remo", g3)
    m5 = Maquina("Polea", g3)
    m6 = Maquina("Caminadora", g3)
    g4.agregarMaquina(m4)
    g4.agregarMaquina(m5)
    g4.agregarMaquina(m6)
    m7 = Maquina("Rodillo", g5)
    m8 = Maquina("Remo", g5)
    m9 = Maquina("Aductores", g5)
    g6.agregarMaquina(m7)
    g6.agregarMaquina(m8)
    g6.agregarMaquina(m9)
    m10 = Maquina("Caminadora", g7)
    m11 = Maquina ("Banco de abdominales", g7)
    m12 = Maquina ("Eliptica", g7)
    g8.agregarMaquina(m10)
    g8.agregarMaquina(m11)
    g8.agregarMaquina(m12)
    m13 = Maquina ("Rodillo", g9)
    m14 = Maquina ("Eliptica", g9)
    m15 = Maquina ("Caminadora", g9)
    g10.agregarMaquina(m13)
    g10.agregarMaquina(m14)
    g10.agregarMaquina(m15)
    m16 = Maquina ("Bicicleta", g4)
    m17 = Maquina ("Banco de abdominales", g4)
    m18 = Maquina ("Banca press", g4)


    #MOVIMIENTO

    mo1 = Movimiento ("Press plano de pecho", TipoEjercicio.EMPUJAR, m1, NivelCliente.INTERMEDIO)
    mo2 = Movimiento ("Elevaciones frontales", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO)
    mo3 = Movimiento ("Escalada", TipoEjercicio.PIERNA, m3, NivelCliente.PRINCIPIANTE)
    mo4 = Movimiento("Remo a ambas manos", TipoEjercicio.EMPUJAR, m4, NivelCliente.INTERMEDIO)
    mo5 = Movimiento("Remo en polea baja", TipoEjercicio.HALAR, m5, NivelCliente.AVANZADO)
    mo6 = Movimiento("Escalada", TipoEjercicio.PIERNA, m6, NivelCliente.PRINCIPIANTE)
    mo7 = Movimiento("Abdominales con rodillo", TipoEjercicio.EMPUJAR, m7, NivelCliente.AVANZADO)
    mo8 = Movimiento("Remo al pecho", TipoEjercicio.HALAR, m8, NivelCliente.INTERMEDIO)
    mo9 = Movimiento("Aductor de cadera", TipoEjercicio.PIERNA, m9, NivelCliente.INTERMEDIO)
    mo10 = Movimiento("Caminata lenta", TipoEjercicio.CALENTAMIENTO, m15, NivelCliente.PRINCIPIANTE)
    mo11 = Movimiento("Bicicleta lenta", TipoEjercicio.CARDIO, m16, NivelCliente.PRINCIPIANTE)
    mo12 = Movimiento ("Correr", TipoEjercicio.CARDIO, m10, NivelCliente.INTERMEDIO)
    mo13 = Movimiento ("Press de pierna", TipoEjercicio.PIERNA, m18, NivelCliente.AVANZADO)
    mo14 = Movimiento ("Abdominales", TipoEjercicio.CARDIO, m11, NivelCliente.INTERMEDIO)
    mo15 = Movimiento ("Aduccion de cadera invertida", TipoEjercicio.PIERNA, m9, NivelCliente.PRINCIPIANTE)
    mo16 = Movimiento ("Prueba de resistencia", TipoEjercicio.CARDIO, m6, NivelCliente.AVANZADO)
    mo17 = Movimiento ("Prueba de resistencia en bicicleta fija", TipoEjercicio.CARDIO, m16, NivelCliente.INTERMEDIO)
    mo18 = Movimiento ("Prueba de resistencia en escaladora eliptica", TipoEjercicio.CARDIO, m14, NivelCliente.AVANZADO)
    mo19 = Movimiento ("Press inclinado de pecho", TipoEjercicio.EMPUJAR, m1, NivelCliente.INTERMEDIO)
    mo20 = Movimiento ("Press inclinado de hombre", TipoEjercicio.EMPUJAR, m1, NivelCliente.INTERMEDIO)
    mo21 = Movimiento ("Oblicuos en polea alta", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO)
    mo22 = Movimiento ("Encogimiento abdominales en polea alta", TipoEjercicio.HALAR, m2, NivelCliente.AVANZADO)
    mo23 = Movimiento ("Elevaciones de pierna en polea alta", TipoEjercicio.PIERNA, m2, NivelCliente.INTERMEDIO)
    mo24 = Movimiento ("Flexion lateral de tronco en polea baja", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO)
    mo25 = Movimiento ("Elevaciones frontales con polea baja", TipoEjercicio.HALAR, m2, NivelCliente.PRINCIPIANTE)
    mo26 = Movimiento ("Face pull", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO)
    mo27 = Movimiento ("Pullover con polea alta", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO)
    mo28 = Movimiento ("Cruce de poleas de pie", TipoEjercicio.HALAR, m2, NivelCliente.INTERMEDIO)
    mo29 = Movimiento ("Peso muerto con barra", TipoEjercicio.HALAR, m1, NivelCliente.AVANZADO)
    mo30 = Movimiento ("Remo inclinado con barra", TipoEjercicio.EMPUJAR, m1, NivelCliente.AVANZADO)
    mo31 = Movimiento ("Press militar", TipoEjercicio.EMPUJAR, m1, NivelCliente.AVANZADO)
    mo32 = Movimiento ("Sentadilla con press", TipoEjercicio.PIERNA, m1, NivelCliente.AVANZADO)
    mo33 = Movimiento ("Zancada con press", TipoEjercicio.PIERNA, m1, NivelCliente.AVANZADO)
    mo34 = Movimiento ("Elevacion de pelvis", TipoEjercicio.PIERNA, m11, NivelCliente.PRINCIPIANTE)
    mo35 = Movimiento ("Sentadilla bulgara", TipoEjercicio.PIERNA, m18, NivelCliente.AVANZADO)
    mo36 = Movimiento ("Sentadilla bulgara con barra", TipoEjercicio.PIERNA, m1, NivelCliente.AVANZADO)
    mo37 = Movimiento ("Triceps con barra", TipoEjercicio.EMPUJAR, m1, NivelCliente.AVANZADO)
    mo38 = Movimiento ("Peso muerto rumano", TipoEjercicio.PIERNA, m1, NivelCliente.AVANZADO)
    mo39 = Movimiento ("Eliptica intensidad maxima", TipoEjercicio.CARDIO, m12, NivelCliente.PRINCIPIANTE)
    mo40 = Movimiento ("Remo con agarra interno", TipoEjercicio.HALAR, m4, NivelCliente.INTERMEDIO)
    mo41 = Movimiento ("Extension sentada de espalda", TipoEjercicio.HALAR, m4, NivelCliente.INTERMEDIO)
    mo42 = Movimiento ("Traccion de rodillas", TipoEjercicio.PIERNA, m4, NivelCliente.INTERMEDIO)
    mo43 = Movimiento ("De rodillas cruzado", TipoEjercicio.PIERNA, m4, NivelCliente.AVANZADO)
    mo44 = Movimiento ("De rodillas cruzado y con elevacion", TipoEjercicio.PIERNA, m4, NivelCliente.INTERMEDIO)
    mo45 = Movimiento ("Sentadilla de pie", TipoEjercicio.PIERNA, m4, NivelCliente.INTERMEDIO)
    mo46 = Movimiento ("Press de banca con mancuernas", TipoEjercicio.EMPUJAR, m11, NivelCliente.INTERMEDIO)
    mo47 = Movimiento ("Curl de Biceps", TipoEjercicio.HALAR, m11, NivelCliente.INTERMEDIO)
    mo48 = Movimiento ("Press frances", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO)
    mo49 = Movimiento ("Flexiones", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO)
    mo50 = Movimiento ("Fondos", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO)
    mo51 = Movimiento ("Sentadillas con banco", TipoEjercicio.PIERNA, m11, NivelCliente.INTERMEDIO)
    mo52 = Movimiento ("Hip Thrust", TipoEjercicio.PIERNA, m11, NivelCliente.AVANZADO)
    mo53 = Movimiento ("Remo con mancuerna", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO)
    mo54 = Movimiento ("Elevaciones con banco inclinado", TipoEjercicio.ESTIRAMIENTO, m11, NivelCliente.AVANZADO)
    mo55 = Movimiento ("Abductores", TipoEjercicio.PIERNA, m11, NivelCliente.INTERMEDIO)
    mo56 = Movimiento ("Aperturas de pectoral", TipoEjercicio.EMPUJAR, m11, NivelCliente.AVANZADO)
    mo57 = Movimiento ("Lumbares", TipoEjercicio.ESTIRAMIENTO, m11, NivelCliente.INTERMEDIO)
    mo58 = Movimiento ("Tibial anterior", TipoEjercicio.ESTIRAMIENTO, m7, NivelCliente.INTERMEDIO)
    mo59 = Movimiento ("Vasto interno", TipoEjercicio.ESTIRAMIENTO, m7, NivelCliente.INTERMEDIO)
    mo60 = Movimiento ("Vasto lateral", TipoEjercicio.ESTIRAMIENTO, m7, NivelCliente.INTERMEDIO)

    #EJERCICIOS
    eje1 = Ejercicio.generarEjercicio(mo1, ObjetivoCliente.ACONDICIONAR)
    eje2 = Ejercicio.generarEjercicio(mo2, ObjetivoCliente.MANTENER)
    eje3 = Ejercicio.generarEjercicio(mo3, ObjetivoCliente.BAJARPESO)
    eje4 = Ejercicio.generarEjercicio(mo4, ObjetivoCliente.AUMENTAR)
    eje5 = Ejercicio.generarEjercicio(mo5, ObjetivoCliente.DEFINIR)
    eje6 = Ejercicio.generarEjercicio(mo6, ObjetivoCliente.MANTENER)
    eje7 = Ejercicio.generarEjercicio(mo7, ObjetivoCliente.BAJARPESO)
    eje8 = Ejercicio.generarEjercicio(mo8, ObjetivoCliente.ACONDICIONAR)
    eje9 = Ejercicio.generarEjercicio(mo9, ObjetivoCliente.AUMENTAR)
    eje10 = Ejercicio.generarEjercicio(mo10, ObjetivoCliente.DEFINIR)
    eje11 = Ejercicio.generarEjercicio(mo11, ObjetivoCliente.MANTENER)
    eje12 = Ejercicio.generarEjercicio(mo12, ObjetivoCliente.BAJARPESO)
    eje13 = Ejercicio.generarEjercicio(mo13, ObjetivoCliente.ACONDICIONAR)
    eje14 = Ejercicio.generarEjercicio(mo14, ObjetivoCliente.AUMENTAR)
    eje15 = Ejercicio.generarEjercicio(mo15, ObjetivoCliente.DEFINIR)
    eje16 = Ejercicio.generarEjercicio(mo16, ObjetivoCliente.MANTENER)
    eje17 = Ejercicio.generarEjercicio(mo17, ObjetivoCliente.BAJARPESO)
    eje18 = Ejercicio.generarEjercicio(mo18, ObjetivoCliente.ACONDICIONAR)
    eje19 = Ejercicio.generarEjercicio(mo19, ObjetivoCliente.AUMENTAR)
    eje20 = Ejercicio.generarEjercicio(mo20, ObjetivoCliente.DEFINIR)
    eje21 = Ejercicio.generarEjercicio(mo21, ObjetivoCliente.MANTENER)
    eje22 = Ejercicio.generarEjercicio(mo22, ObjetivoCliente.BAJARPESO)
    eje23 = Ejercicio.generarEjercicio(mo23, ObjetivoCliente.ACONDICIONAR)
    eje24 = Ejercicio.generarEjercicio(mo24, ObjetivoCliente.AUMENTAR)
    eje25 = Ejercicio.generarEjercicio(mo25, ObjetivoCliente.DEFINIR)
    eje26 = Ejercicio.generarEjercicio(mo26, ObjetivoCliente.MANTENER)
    eje27 = Ejercicio.generarEjercicio(mo27, ObjetivoCliente.BAJARPESO)
    eje28 = Ejercicio.generarEjercicio(mo28, ObjetivoCliente.ACONDICIONAR)
    eje29 = Ejercicio.generarEjercicio(mo29, ObjetivoCliente.AUMENTAR)
    eje30 = Ejercicio.generarEjercicio(mo30, ObjetivoCliente.DEFINIR)
    eje31 = Ejercicio.generarEjercicio(mo31, ObjetivoCliente.MANTENER)
    eje32 = Ejercicio.generarEjercicio(mo32, ObjetivoCliente.BAJARPESO)
    eje33 = Ejercicio.generarEjercicio(mo33, ObjetivoCliente.ACONDICIONAR)
    eje34 = Ejercicio.generarEjercicio(mo34, ObjetivoCliente.AUMENTAR)
    eje35 = Ejercicio.generarEjercicio(mo35, ObjetivoCliente.DEFINIR)
    eje36 = Ejercicio.generarEjercicio(mo36, ObjetivoCliente.MANTENER)
    eje37 = Ejercicio.generarEjercicio(mo37, ObjetivoCliente.BAJARPESO)
    eje38 = Ejercicio.generarEjercicio(mo38, ObjetivoCliente.ACONDICIONAR)
    eje39 = Ejercicio.generarEjercicio(mo39, ObjetivoCliente.AUMENTAR)
    eje40 = Ejercicio.generarEjercicio(mo40, ObjetivoCliente.DEFINIR)
    eje41 = Ejercicio.generarEjercicio(mo41, ObjetivoCliente.MANTENER)
    eje42 = Ejercicio.generarEjercicio(mo42, ObjetivoCliente.BAJARPESO)
    eje43 = Ejercicio.generarEjercicio(mo43, ObjetivoCliente.ACONDICIONAR)
    eje44 = Ejercicio.generarEjercicio(mo44, ObjetivoCliente.AUMENTAR)
    eje45 = Ejercicio.generarEjercicio(mo45, ObjetivoCliente.DEFINIR)
    eje46 = Ejercicio.generarEjercicio(mo46, ObjetivoCliente.MANTENER)
    eje47 = Ejercicio.generarEjercicio(mo47, ObjetivoCliente.BAJARPESO)
    eje48 = Ejercicio.generarEjercicio(mo48, ObjetivoCliente.ACONDICIONAR)
    eje49 = Ejercicio.generarEjercicio(mo49, ObjetivoCliente.AUMENTAR)
    eje50 = Ejercicio.generarEjercicio(mo50, ObjetivoCliente.DEFINIR)
    eje51 = Ejercicio.generarEjercicio(mo51, ObjetivoCliente.MANTENER)
    eje52 = Ejercicio.generarEjercicio(mo52, ObjetivoCliente.BAJARPESO)
    eje53 = Ejercicio.generarEjercicio(mo53, ObjetivoCliente.ACONDICIONAR)
    eje54 = Ejercicio.generarEjercicio(mo54, ObjetivoCliente.AUMENTAR)
    eje55 = Ejercicio.generarEjercicio(mo55, ObjetivoCliente.DEFINIR)
    eje56 = Ejercicio.generarEjercicio(mo56, ObjetivoCliente.MANTENER)
    eje57 = Ejercicio.generarEjercicio(mo57, ObjetivoCliente.BAJARPESO)
    eje58 = Ejercicio.generarEjercicio(mo58, ObjetivoCliente.ACONDICIONAR)
    eje59 = Ejercicio.generarEjercicio(mo59, ObjetivoCliente.AUMENTAR)
    eje60 = Ejercicio.generarEjercicio(mo60, ObjetivoCliente.DEFINIR)

    #ALIMENTO
    a1 = Alimento("Manzana", 52, 0.3, 14, 0.2, Alergeno.NINGUNO)
    a2 = Alimento("Banana", 96, 1.2, 23, 0.2, Alergeno.NINGUNO)
    a3 = Alimento("Zanahoria", 41, 0.9, 10, 0.2, Alergeno.NINGUNO)
    a4 = Alimento("Tomate", 18, 0.9, 3.9, 0.2, Alergeno.NINGUNO)
    a5 = Alimento("Papa", 77, 2, 17, 0.1, Alergeno.NINGUNO)
    a6 = Alimento("Lechuga", 5, 0.5, 1, 0.1, Alergeno.NINGUNO)
    a7 = Alimento("Esparragos", 20, 2.2, 3.7, 0.2, Alergeno.NINGUNO)
    a8 = Alimento("Brocoli", 55, 3.7, 11, 0.6, Alergeno.NINGUNO)
    a9 = Alimento("Cebolla", 40, 1.1, 9.3, 0.1, Alergeno.NINGUNO)
    a10 = Alimento("Arroz", 130, 2.7, 28, 0.3, Alergeno.NINGUNO)
    a11 = Alimento("Lentejas", 116, 9, 20, 0.4, Alergeno.NINGUNO)
    a12 = Alimento("Garbanzos", 164, 8.9, 27, 2.6, Alergeno.NINGUNO)
    a13 = Alimento("Leche", 60, 3.3, 4.8, 3.2, Alergeno.LACTOSA)
    a14 = Alimento("Huevo", 155, 12.6, 0.6, 11, Alergeno.HUEVO)
    a15 = Alimento("Pollo", 165, 31, 0, 3.6, Alergeno.NINGUNO)
    a16 = Alimento("Carne de res", 250, 26, 0, 17, Alergeno.NINGUNO)
    a17 = Alimento("Pescado", 206, 22, 0, 13, Alergeno.NINGUNO)
    a18 = Alimento("Atun", 184, 25, 0, 8, Alergeno.NINGUNO)
    a19 = Alimento("Camarones", 85, 18, 0.2, 1.2, Alergeno.MARISCO)
    a20 = Alimento("Queso", 402, 25, 1.3, 33, Alergeno.LACTOSA)
    a21 = Alimento("Pan", 265, 9, 49, 3.1, Alergeno.GLUTEN)
    a22 = Alimento("Mantequilla", 717, 0.9, 0.1, 81, Alergeno.LACTOSA)
    a23 = Alimento("Nueces", 654, 15, 13, 65, Alergeno.FRUTOSECO)
    a24 = Alimento("Fresas", 32, 0.7, 7.7, 0.3, Alergeno.NINGUNO)
    a25 = Alimento("Sandia", 30, 0.6, 7.6, 0.2, Alergeno.NINGUNO)
    a26 = Alimento("Naranja", 43, 0.9, 9, 0.1, Alergeno.NINGUNO)
    a27 = Alimento("Uva", 69, 0.7, 18, 0.2, Alergeno.NINGUNO)
    a28 = Alimento("Kiwi", 41, 1.1, 9, 0.5, Alergeno.NINGUNO)
    a29 = Alimento("Platano", 96, 1.2, 23, 0.2, Alergeno.NINGUNO)
    a30 = Alimento("Cereza", 50, 1, 12, 0.3, Alergeno.NINGUNO)
    a31 = Alimento("Pera", 57, 0.4, 15, 0.2, Alergeno.NINGUNO)
    a32 = Alimento("Melon", 34, 0.8, 8.6, 0.2, Alergeno.NINGUNO)
    a33 = Alimento("Piña", 50, 0.5, 13, 0.1, Alergeno.NINGUNO)
    a34 = Alimento("Mango", 60, 0.8, 14, 0.4, Alergeno.NINGUNO)
    a35 = Alimento("Papaya", 43, 0.5, 11, 0.4, Alergeno.NINGUNO)
    a36 = Alimento("Calabaza", 26, 1, 6.5, 0.1, Alergeno.NINGUNO)
    a37 = Alimento("Remolacha", 43, 1.6, 10, 0.1, Alergeno.NINGUNO)
    a38 = Alimento("Espinaca", 23, 2.9, 3.6, 0.4, Alergeno.NINGUNO)
    a39 = Alimento("Coliflor", 25, 1.9, 5, 0.3, Alergeno.NINGUNO)
    a40 = Alimento("Aceite de oliva", 884, 0, 0, 100, Alergeno.NINGUNO)
    a41 = Alimento("Azucar", 387, 0, 100, 0, Alergeno.NINGUNO)
    a42 = Alimento("Sal", 0, 0, 0, 0, Alergeno.NINGUNO)
    a43 = Alimento("Vinagre", 18, 0, 0.2, 0, Alergeno.NINGUNO)
    a44 = Alimento("Canela", 247, 4, 81, 3.2, Alergeno.NINGUNO)
    a45 = Alimento("Chocolate", 546, 7.8, 57, 31, Alergeno.NINGUNO)
    a46 = Alimento("Miel", 304, 0.3, 82, 0, Alergeno.NINGUNO)
    a47 = Alimento("Avena", 389, 16.9, 66, 6.9, Alergeno.NINGUNO)
    a48 = Alimento("Yogur", 61, 3.5, 4.7, 3.3, Alergeno.LACTOSA)
    a49 = Alimento("Aceitunas", 145, 1.2, 3.8, 15, Alergeno.NINGUNO)
    a50 = Alimento("Mermelada", 250, 0.4, 63, 0.2, Alergeno.NINGUNO)
    a51 = Alimento("Avellanas", 628, 15, 17, 61, Alergeno.FRUTOSECO)

    #COMIDA

    co1 = Comida("Desayuno saludable 1", obtenerListaAlimentos(a1, a2, a3), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER)
    co2 = Comida("Desayuno saludable 2", obtenerListaAlimentos(a4, a5, a6), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR)
    co3 = Comida("Desayuno saludable 3", obtenerListaAlimentos(a10, a13, a14), TipoComida.DESAYUNO, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO)
    co4 = Comida("Desayuno saludable 4", obtenerListaAlimentos(a7, a8, a9), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR)
    co5 = Comida("Desayuno saludable 5", obtenerListaAlimentos(a13, a14, a15), TipoComida.DESAYUNO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.ACONDICIONAR)
    co6 = Comida("Desayuno saludable 6", obtenerListaAlimentos(a37, a38, a39), TipoComida.DESAYUNO, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.MANTENER)
    co7 = Comida("Almuerzo equilibrado 1", obtenerListaAlimentos(a16, a17, a18), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER)
    co8 = Comida("Almuerzo equilibrado 2", obtenerListaAlimentos(a19, a20, a21), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR)
    co9 = Comida("Almuerzo equilibrado 3", obtenerListaAlimentos(a49, a50, a51), TipoComida.ALMUERZO, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO)
    co10 = Comida("Almuerzo equilibrado 4", obtenerListaAlimentos(a22, a23, a24), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR)
    co11 = Comida("Almuerzo equilibrado 5", obtenerListaAlimentos(a25, a26, a27), TipoComida.ALMUERZO, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.ACONDICIONAR)
    co12 = Comida("Almuerzo equilibrado 6", obtenerListaAlimentos(a34, a35, a36), TipoComida.ALMUERZO, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.MANTENER)
    co13 = Comida("Cena ligera 1", obtenerListaAlimentos(a28, a29, a30), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.MANTENER)
    co14 = Comida("Cena ligera 2", obtenerListaAlimentos(a31, a32, a33), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.AUMENTAR)
    co15 = Comida("Cena ligera 3", obtenerListaAlimentos(a10, a11, a12), TipoComida.CENA, PreferenciaAlimenticia.VEGETARIANO, ObjetivoCliente.BAJARPESO)
    co16 = Comida("Cena ligera 4", obtenerListaAlimentos(a41, a42, a44), TipoComida.CENA, PreferenciaAlimenticia.SINRESTRICCIONES, ObjetivoCliente.DEFINIR)
    co17 = Comida("Cena ligera 5", obtenerListaAlimentos(a25, a26, a27), TipoComida.CENA, PreferenciaAlimenticia.VEGANO, ObjetivoCliente.ACONDICIONAR)

    c1 = Cliente("Duvan", g4, 1, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c2 = Cliente("Santiago", g4, 2, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c3 = Cliente("Maria", g4, 3, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR)
    c4 = Cliente("Manuel", g4, 4, 1.82, 75.2, "M", 24, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c5 = Cliente("Miguel", g5, 5, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.DEFINIR)
    c6 = Cliente("Andres", g5, 6, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.DEFINIR)
    c7 = Cliente("Maria", g5, 7, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR)
    c8 = Cliente("Manuel", g5, 8, 1.82, 75.2, "M", 24, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c9 = Cliente("Daniel", g5, 9, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.DEFINIR)
    c10 = Cliente("Santiago", g6, 10, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c11 = Cliente("Santiago", g6, 11, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c12 = Cliente("Maria", g6, 12, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.AUMENTAR)
    c13 = Cliente("Manuel", g6, 13, 1.82, 75.2, "M", 24, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c14 = Cliente("Daniel", g6, 14, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c15 = Cliente("Santiago", g7, 15, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c16 = Cliente("Santiago", g7, 16, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c17 = Cliente("Maria", g7, 17, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.AUMENTAR)
    c18 = Cliente("Manuel", g7, 18, 1.82, 75.2, "M", 24, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c19 = Cliente("Juan", g7, 19, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c20 = Cliente("Carlos", g8, 20, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c21 = Cliente("Angerson", g8, 21, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c22 = Cliente("Sofia", g8, 22, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR)
    c23 = Cliente("Alexis", g8, 23, 1.82, 75.2, "M", 24, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c24 = Cliente("Jose", g8, 24, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c25 = Cliente("Miguel Angel", g9, 25, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c26 = Cliente("Esneider", g9, 26, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c27 = Cliente("Maria", g9, 27, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR)
    c28 = Cliente("Manuel", g9, 28, 1.82, 75.2, "M", 24, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c29 = Cliente("Daniel", g9, 29, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c30 = Cliente("Stiven", g10, 30, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c31 = Cliente("Oscar", g10, 31, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c32 = Cliente("Claudia", g10, 32, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR)
    c33 = Cliente("Walter", g10, 33, 1.82, 75.2, "M", 40, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c34 = Cliente("Miguel", g10, 34, 1.72, 71.2, "M", 19,  PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c35 = Cliente("Juan", g1, 35, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c36 = Cliente("Carlos", g1, 36, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c37 = Cliente("Angerson", g1, 37, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c38 = Cliente("Sofia", g1, 38, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR)
    c39 = Cliente("Alexis", g1, 39, 1.82, 75.2, "M", 24, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c40 = Cliente("Jose", g1, 40, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c41 = Cliente("Miguel Angel", g2, 41, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c42 = Cliente("Esneider", g2, 42, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c43 = Cliente("Maria", g2, 43, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR)
    c44 = Cliente("Manuel", g2, 44, 1.82, 75.2, "M", 24, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c45 = Cliente("Daniel", g2, 45, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.BAJARPESO)
    c46 = Cliente("Stiven", g3, 46, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c47 = Cliente("Oscar", g3, 47, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.AUMENTAR)
    c48 = Cliente("Claudia", g3, 48, 1.62, 57.3, "F", 22, PreferenciaAlimenticia.VEGANO, NivelCliente.PRINCIPIANTE, ObjetivoCliente.DEFINIR)
    c49 = Cliente("Walter", g3, 49, 1.82, 75.2, "M", 40, PreferenciaAlimenticia.VEGETARIANO, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)
    c50 = Cliente("Miguel", g3, 50, 1.72, 71.2, "M", 19, PreferenciaAlimenticia.SINRESTRICCIONES, NivelCliente.INTERMEDIO, ObjetivoCliente.ACONDICIONAR)

    gimnasios = [g1, g2, g3, g4, g5, g6, g7, g8, g9, g10]
    maquinas = [m1, m2, m3, m4, m5, m6, m7, m8, m9, m10, m11, m12, m13, m14, m15, m16, m17, m18]
    movimientos = [mo1, mo2, mo3, mo4, mo5, mo6, mo7, mo8, mo9, mo10, mo11, mo12, mo13, mo14, mo15, mo16, mo17, mo18, mo19, mo20, mo21, mo22, mo23, mo24, mo25, mo26, mo27, mo28, mo29, mo30, mo31, mo32, mo33, mo34, mo35, mo36, mo37, mo38, mo39, mo40, mo41, mo42, mo43, mo44, mo45, mo46, mo47, mo48, mo49, mo50, mo51, mo52, mo53, mo54, mo55, mo56, mo57, mo58, mo59, mo60]
    ejercicios = [eje1, eje2, eje3, eje4, eje5, eje6, eje7, eje8, eje9, eje10, eje11, eje12, eje13, eje14, eje15, eje16, eje17, eje18, eje19, eje20, eje21, eje22, eje23, eje24, eje25, eje26, eje27, eje28, eje29, eje30, eje31, eje32, eje33, eje34, eje35, eje36, eje37, eje38, eje39, eje40, eje41, eje42, eje43, eje44, eje45, eje46, eje47, eje48, eje49, eje50, eje51, eje52, eje53, eje54, eje55, eje56, eje57, eje58, eje59, eje60]
    alimentos = [a1, a2, a3, a4, a5, a6, a7, a8, a9, a10, a11, a12, a13, a14, a15, a16, a17, a18, a19, a20, a21, a22, a23, a24, a25, a26, a27, a28, a29, a30, a31, a32, a33, a34, a35, a36, a37, a38, a39, a40, a41, a42, a43, a44, a45, a46, a47, a48, a49, a50, a51]
    comidas = [co1, co2, co3, co4, co5, co6, co7, co8, co9, co10, co11, co12, co13, co14, co15, co16, co17]
    clientes = [c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15, c16, c17, c18, c19, c20, c21, c22, c23, c24, c25, c26, c27, c28, c29, c30, c31, c32, c33, c34, c35, c36, c37, c38, c39, c40, c41, c42, c43, c44, c45, c46, c47, c48, c49, c50]

    with open(dirgimnasios, "wb") as file:
        pickle.dump(gimnasios, file)

    with open(dirmaquinas, "wb") as file:
        pickle.dump(maquinas, file)

    with open(dirmovimientos, "wb") as file:
        pickle.dump(movimientos, file)

    with open(direjercicios, "wb") as file:
        pickle.dump(ejercicios, file)

    with open(diralims, "wb") as file:
        pickle.dump(alimentos, file)

    with open(dircomidas, "wb") as file:
        pickle.dump(comidas, file)

    with open(dirclientes, "wb") as file:
        pickle.dump(clientes, file)

intento()
