import pickle
import os

def deserializar():
    return deserializarGimnasios(), deserializarEjercicios(), deserializarMaquinas(), deserializarComidas(), deserializarAlimentos(), deserializarMovimientos(), deserializarClientes()


def deserializarGimnasios():
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dirgimnasios = os.path.join(two_levels_up, "src/baseDatos/tempo/gimnasios.pkl")

    with open(dirgimnasios, "rb") as file:
        gimnasios = pickle.load(file)

    gimnasios


def deserializarMaquinas():
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dir = os.path.join(two_levels_up, "src/baseDatos/tempo/maquinas.pkl")

    with open(dir, "rb") as file:
        objetosDeClase = pickle.load(file)

    objetosDeClase


def deserializarMovimientos():
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dir = os.path.join(two_levels_up, "src/baseDatos/tempo/movimientos.pkl")

    with open(dir, "rb") as file:
        objetosDeClase = pickle.load(file)

    objetosDeClase

def deserializarEjercicios():
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dir = os.path.join(two_levels_up, "src/baseDatos/tempo/ejercicios.pkl")

    with open(dir, "rb") as file:
        objetosDeClase = pickle.load(file)

    objetosDeClase

def deserializarAlimentos():
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dir = os.path.join(two_levels_up, "src/baseDatos/tempo/alimentos.pkl")

    with open(dir, "rb") as file:
        objetosDeClase = pickle.load(file)

    objetosDeClase

def deserializarComidas():
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dir = os.path.join(two_levels_up, "src/baseDatos/tempo/comidas.pkl")

    with open(dir, "rb") as file:
        objetosDeClase = pickle.load(file)

    objetosDeClase

def deserializarClientes():
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dir = os.path.join(two_levels_up, "src/baseDatos/tempo/clientes.pkl")

    with open(dir, "rb") as file:
        objetosDeClase = pickle.load(file)

    objetosDeClase

