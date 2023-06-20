import pickle
import os


def deserializar():
    return deserializarGimnasios(), deserializarEjercicios(), deserializarMaquinas(), deserializarComidas(), deserializarAlimentos(), deserializarMovimientos(), deserializarClientes()


def deserializarGimnasios():
    directorio = os.path.join(os.path.dirname(os.path.dirname(__file__)), "baseDatos", "tempo", "gimnasios.pkl")

    with open(directorio, "rb") as file:
        gimnasios = pickle.load(file)

    return gimnasios


def deserializarMaquinas():
    directorio = os.path.join(os.path.dirname(os.path.dirname(__file__)), "baseDatos", "tempo", "maquinas.pkl")

    with open(directorio, "rb") as file:
        objetosDeClase = pickle.load(file)

    return objetosDeClase


def deserializarMovimientos():
    directorio = os.path.join(os.path.dirname(os.path.dirname(__file__)), "baseDatos", "tempo", "movimientos.pkl")

    with open(directorio, "rb") as file:
        objetosDeClase = pickle.load(file)

    return objetosDeClase

def deserializarEjercicios():
    directorio = os.path.join(os.path.dirname(os.path.dirname(__file__)), "baseDatos", "tempo", "ejercicios.pkl")

    with open(directorio, "rb") as file:
        objetosDeClase = pickle.load(file)

    return objetosDeClase

def deserializarAlimentos():
    directorio = os.path.join(os.path.dirname(os.path.dirname(__file__)), "baseDatos", "tempo", "alimentos.pkl")

    with open(directorio, "rb") as file:
        objetosDeClase = pickle.load(file)

    return objetosDeClase

def deserializarComidas():
    directorio = os.path.join(os.path.dirname(os.path.dirname(__file__)), "baseDatos", "tempo", "comidas.pkl")

    with open(directorio, "rb") as file:
        objetosDeClase = pickle.load(file)

    return objetosDeClase

def deserializarClientes():
    directorio = os.path.join(os.path.dirname(os.path.dirname(__file__)), "baseDatos", "tempo", "clientes.pkl")

    with open(directorio, "rb") as file:
        objetosDeClase = pickle.load(file)

    return objetosDeClase
