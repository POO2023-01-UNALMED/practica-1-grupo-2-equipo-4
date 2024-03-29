class ErrorAplicacion(Exception):
    # Error general
    def __init__(self, mensaje):
        super().__init__("Manejo de errores de la Aplicación: " + mensaje)


class ErrorAlimento(ErrorAplicacion):
    # Error ValueType de calorías, error de calorías totales.
    def __init__(self, mensaje):
        super().__init__("Error en la clase Alimento: " + mensaje)


class ErrorValueTypeCalorias(ErrorAlimento):
    # No ingresó un entero de calorías
    def __init__(self):
        super().__init__("Error en el valor de calorías. Por favor ingrese un entero")


class ErrorNombreAlimento(ErrorAlimento):
    # No ingresó un nombre de alimento de string
    def __init__(self):
        super().__init__("Error en el valor de nombre. Por favor ingrese una palabra.")
class ErrorNombreAlergeno(ErrorAlimento):
    # No ingresó un nombre de alergeno de string
    def __init__(self):
        super().__init__("Error en el valor de alergeno. Por favor ingrese una palabra.")

class ErrorCliente(ErrorAplicacion):
    # Error nombre, error identificación.
    def __init__(self, mensaje):
        super().__init__("Error en la clase Cliente: " + mensaje)


class ErrorNombreCliente(ErrorCliente):
    # No ingresó un string como nombre
    def __init__(self):
        super().__init__("No ingresó texto para el nombre del cliente")


class ErrorIdentificacion(ErrorCliente):
    # No ingresó un int de 1 a 50
    def __init__(self):
        super().__init__("No ingresó un número entero del 1 al 50 para la identificación")


class ErrorAtributoNoExistente(ErrorAlimento):
    def __init__(self):
        super().__init__("No existe este tipo de dato. Por Favor ingrese nuevamente el valor")

class ErrorCamposIncompletos(ErrorAlimento):
    def __init__(self):
        super().__init__("Faltan campos por llenar")

def iserror(func, *args, **kw):
    try:
        func(*args, **kw)
        return False
    except Exception:
        return True