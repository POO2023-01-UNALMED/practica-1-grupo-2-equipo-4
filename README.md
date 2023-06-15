
# practica-1-grupo-2-equipo-4
practica-1-grupo-2-equipo-4 created by GitHub Classroom

# Gymbro

Gymbro es una aplicación para gimnasios que ofrece planes de entrenamiento y alimentación personalizados para sus usuarios. El objetivo principal de la aplicación es ayudar a los usuarios a alcanzar sus metas de fitness y mantener un estilo de vida saludable.

El proyecto Gymbro consta de dos versiones: una versión desarrollada en Java y otra versión desarrollada en Python. Ambas versiones ofrecen funcionalidades similares y están diseñadas para proporcionar una experiencia fluida y fácil de usar a los usuarios.

## Clases

El proyecto Gymbro incluye las siguientes clases:

- **Cliente**: Representa al usuario principal de la aplicación. Cada cliente tiene un plan de alimentación y un plan de entrenamiento asociado. También puede tener un gimnasio preferido, aunque tiene la flexibilidad de cambiarlo si así lo desea.

- **Entrenador**: Son los profesionales encargados de entrenar a los clientes. Cada entrenador trabaja con clientes de diferentes niveles de habilidad, como principiante, intermedio y avanzado. También tienen disponibilidad semanal y horarios específicos para las sesiones de entrenamiento.

- **Movimiento**: Esta clase representa un movimiento en el contexto del entrenamiento. Puede ser un calentamiento, cardio o una repetición de un ejercicio. Cada movimiento puede tener dificultades asociadas.

- **Ejercicio**: Es una subclase de Movimiento. Cada ejercicio tiene atributos como repeticiones, sets y tiempo. Además, cada ejercicio se enfoca en un solo tipo de músculo.

- **Rutina**: Representa una secuencia de ejercicios que forman una rutina completa de entrenamiento. La rutina tiene una duración total determinada.

- **Máquina**: Esta clase representa las máquinas utilizadas para realizar los movimientos en el gimnasio. Puede incluir mancuernas, bandas elásticas, caminadoras, barras, entre otros equipos específicos.

- **Gimnasio**: Representa un gimnasio que consta de máquinas, entrenadores y clientes. La aplicación permite gestionar múltiples gimnasios que pueden tener sedes en diferentes ciudades y ofrecer horarios disponibles.

- **Alimento**: Representa un componente individual de una comida, como tomate, zanahoria, pollo, etc.

- **Comida**: Representa una combinación de varios alimentos que forman una comida completa.

- **Plan Alimentación**: Es un plan que consta de múltiples comidas y está diseñado para seguirse durante una semana. Proporciona pautas dietéticas personalizadas para los usuarios.

- **Plan Ejercicio**: Es un plan que consta de múltiples ejercicios y está diseñado para seguirse durante una semana. Proporciona un programa de entrenamiento personalizado para los usuarios.

Este es un resumen de las principales clases del proyecto Gymbro. Cada clase tiene sus propios atributos y métodos que se utilizan para implementar las funcionalidades de la aplicación.
