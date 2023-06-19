import pickle
import os

def serializar(gimnasios, ejercicios, maquinas, comidas, alimentos, movimientos, clientes):
    current_directory = os.getcwd()
    two_levels_up = os.path.abspath(os.path.join(current_directory, "../../"))

    dirgimnasios = os.path.join(two_levels_up, "src/baseDatos/tempo/gimnasios.pkl")
    dirmaquinas = os.path.join(two_levels_up, "src/baseDatos/tempo/maquinas.pkl")
    dirmovimientos = os.path.join(two_levels_up, "src/baseDatos/tempo/movimientos.pkl")
    direjercicios = os.path.join(two_levels_up, "src/baseDatos/tempo/ejercicios.pkl")
    diralims = os.path.join(two_levels_up, "src/baseDatos/tempo/alimentos.pkl")
    dircomidas = os.path.join(two_levels_up, "src/baseDatos/tempo/comidas.pkl")
    dirclientes = os.path.join(two_levels_up, "src/baseDatos/tempo/clientes.pkl")

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