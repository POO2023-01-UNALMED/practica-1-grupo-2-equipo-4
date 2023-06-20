class ErrorAplicacion(Exception):
    # Error general
    def __init__(self, mensaje):
        super().__init__("Manejo de errores de la Aplicación: " + mensaje)


class ErrorAlimento(ErrorAplicacion):
    # Error ValueType de calorías, error de calorías totales.
    def __init__(self, mensaje):
        super().__init__("Error en la clase Alimento: " + mensaje)


class ErrorNombreAlimento(ErrorAlimento):
    # No ingresó un nombre de alimento de string
    def __init__(self):
        super().__init__("Error en el valor de nombre. Por favor ingrese una palabra.")

class ErrorNombreAlergeno(ErrorAlimento):
    # No ingresó un nombre de alergeno de string
    def __init__(self):
        super().__init__("Error en el valor de alergeno. Por favor ingrese una palabra.")

class ErrorCaloriasTotales(ErrorAlimento):
    # La suma de calorías en la proteína + grasas + carbohidratos no es igual al total de calorías
    def __init__(self):
        super().__init__("Error en el total de calorías del alimentos.")


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


def metodoGestionErroresInventados(nombre, identificacion, caloriasTotales, proteina, grasas, carbohidratos):
    # Este método se llama dentro de las consultas y creación de objetos.
    # Se pasan en este orden:
    # nombre del cliente, identificación del cliente
    # calorias_totales, proteina, grasas, carbohidratos

    try:
        if not isinstance(nombre, str):
            raise ErrorNombreCliente()

        if not (1 <= identificacion <= 50):
            raise ErrorIdentificacion()

        if not isinstance(caloriasTotales, int):
            raise ErrorValueTypeCalorias()

        if (proteina*4 + grasas*9 + carbohidratos*4) != caloriasTotales:
            raise ErrorCaloriasTotales()

    # Manejo de excepciones llamando a los constructores de las clases
    except ErrorValueTypeCalorias as e:
        return str(e)
    except ErrorCaloriasTotales as e:
        return str(e)
    except ErrorNombreCliente as e:
        return str(e)
    except ErrorIdentificacion as e:
        return str(e)
    except Exception as e:
        return "Error desconocido:", str(e)

    else:
        return "No se encontraron errores."
    finally:
        return "Finalizando metodoGestionErrores."

def iserror(func, *args, **kw):
    try:
        func(*args, **kw)
        return False
    except Exception:
        return True


# def metodoGestionErroresSugeridos():
#     try:
#         if (condicion_Atributo_no_Existente):
#             raise ErrorAtributoNoExistente()
#
#         if (condicion_campos_incompletos):
#             raise ErrorCamposIncompletos()
#
#     except ErrorAtributoNoExistente as e:
#         return str(e)
#     except ErrorCamposIncompletos as e:
#         return str(e)
#     except Exception as e:
#         return "Error desconocido:", str(e)
#
#     else:
#         return "No se encontraron errores."
#     finally:
#         return "Finalizando metodoGestionErrores."
