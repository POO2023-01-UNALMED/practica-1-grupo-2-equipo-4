import tkinter as tk
from tkinter import messagebox, Button, Label, ttk
import os
from src.guiMain.FieldFrame import FieldFrame
from src.guiMain import deserealizador
from src.guiMain import serializador
from src.gestorAplicacion.clasesEnum.Alergeno import Alergeno
from src.gestorAplicacion.clasesPrincipales.Alimento import Alimento
from src.guiMain import excepciones

"""
    Crea y muestra la ventana principal para el usuario en la aplicación Gymbro.
    Adicionalmente, en ella se puede acceder a las opciones o funcionalidades
    ademas se añaden botones para conocer mas sobre la aplicacion, y una sesion de ayuda
    que muestra informacion sobre los desarrolladores

    Parámetros:
        - root: La ventana raíz principal de la aplicación.

    """
def ventana_principal_usuario(root):
    # Listas de objetos

    gimnasios, ejercicios, maquinas, comidas, alimentos, movimientos, clientes = deserealizador.deserializar()

    # Funciones de las funcionalidades
    def mostrar_funcionalidad1():
        # Borra los widgets existentes en el frame de funcionalidades
        for widget in funcionalidades_frame.winfo_children():
            widget.destroy()

        # Crea las etiquetas de título y descripción
        titulo_proceso = tk.Label(funcionalidades_frame, text=2 * "\n" + "Recomendar Plan Ejercicio",
                                  font=("Verdana", 16, "bold"),
                                  fg="dark blue",
                                  padx=10,
                                  pady=10)

        descripcion_detalle = tk.Label(funcionalidades_frame,
                                       text="Recibe un Plan de Ejercicio que recomiendan nuestros mejores entrenadores.",
                                       font=("Verdana", 14),
                                       padx=10,
                                       pady=10)

        # Coloca las etiquetas de título y descripción en la parte superior del funcionalidades_frame
        titulo_proceso.pack(anchor='center')
        descripcion_detalle.pack(anchor='center')

        # Crea y añade el FieldFrame al funcionalidades_frame
        superFrame = FieldFrame(funcionalidades_frame, "Información",
                                ["Nombre usuario","Identificación","Nombre para el plan"], "Datos",
                                ["algo", "hola", "djio"])
        superFrame.pack(padx=10,
                        pady=10,
                        expand=True)

        # Crea los botones "Aceptar" y "Borrar"
        buttons_frame = tk.Frame(funcionalidades_frame)  # Frame adicional para los botones
        aceptarButton = tk.Button(buttons_frame,
                                  text="Aceptar",
                                  font=("Verdana", 14))

        borrarButton = tk.Button(buttons_frame,
                                 text="Borrar",
                                 font=("Verdana", 14))

        def clear_entries():
            for entry in superFrame._valoresEntry.values():
                entry.delete(0, 'end')

        def creaPlanEjercicio():
            nombre = (superFrame.getValue("Nombre usuario")).capitalize()
            ident = superFrame.getValue("Identificación")
            plan = (superFrame.getValue("Nombre para el plan")).capitalize()

            clear_entries()

            try:
                if not (1<=int(ident)<=50):
                    raise excepciones.ErrorIdentificacion()
            except  excepciones.ErrorIdentificacion as e:
                messagebox.showinfo("Error",str(e))

            else:
                for widget in funcionalidades_frame.winfo_children():
                    widget.destroy()

                for user in clientes:
                    if user.identificacion == int(ident):
                        cliente = user
                        break

                textDisplayed = f"{nombre}, basándonos en tu nivel de habilidad y tu objetivo, hemos creado el plan {plan} para ti\n" \
                                + "\n" \
                                f"{cliente.generarPlanEjercicio()}"

                planCliente = tk.Text(funcionalidades_frame,
                                      fg="black",
                                      bg="#F0F0F0",
                                      font=("Verdana", 12, "bold"),
                                      cursor="arrow")

                planCliente.insert(tk.END, textDisplayed, "justifying")
                planCliente.config(state="disabled")

                planCliente.pack(expand=True,
                                 fill="both",
                                 side="bottom")

                planCliente.tag_configure('justifying',
                                          justify='center')

        aceptarButton.config(command=creaPlanEjercicio)
        borrarButton.config(command=clear_entries)

        # Empaqueta los botones en el nuevo frame
        aceptarButton.pack(side='left',
                           padx=5)

        borrarButton.pack(side='left',
                          padx=5)

        # Empaqueta el frame de botones debajo del FieldFrame
        buttons_frame.pack(pady=10)

    #Funcion buscar alimento
    def mostrar_funcionalidad2():
        # Borra los widgets existentes en el frame de funcionalidades
        for widget in funcionalidades_frame.winfo_children():
            widget.destroy()

        # Crea las etiquetas de título y descripción

        titulo_proceso = tk.Label(funcionalidades_frame, text=2 * "\n" + "Añadir Alimento",
                                  font=("Verdana", 16, "bold"),
                                  fg="dark blue",
                                  padx=20,
                                  pady=5)

        descripcion_detalle = tk.Label(funcionalidades_frame,
                                       text="Añada un alimento con el cual podrá preparar una comida que se ajuste a su Plan de Alimentación y su objetivo.",
                                       font=("Verdana", 14),
                                       padx=20,
                                       pady=5)

        # Coloca las etiquetas de título y descripción en la parte superior del funcionalidades_frame
        titulo_proceso.pack()
        descripcion_detalle.pack()

        # Crea y añade el FieldFrame al funcionalidades_frame
        superFrame = FieldFrame(funcionalidades_frame, "Requerimientos",
                                ["Nombre", "Calorías", "Proteínas", "Carbohidratos", "Grasas", "Alergeno"], "Datos",
                                ["ManzanaNueva", "52", "0.3", "14", "0.2", "NINGUNO"])

        superFrame.pack(padx=20,
                        pady=5,
                        expand=True)

        def crear_alimento():
            nombre = superFrame.getValue("Nombre")
            calorias = superFrame.getValue("Calorías")
            proteinas = superFrame.getValue("Proteínas")
            carbohidratos = superFrame.getValue("Carbohidratos")
            grasas = superFrame.getValue("Grasas")
            alergeno = (superFrame.getValue("Alergeno")).upper()

            try:
                calorias = float(calorias)
                proteinas = float(proteinas)
                carbohidratos = float(carbohidratos)
                grasas = float(grasas)

                if not excepciones.iserror(float, nombre):
                    raise excepciones.ErrorNombreAlimento()

                if not excepciones.iserror(float, alergeno):
                    raise excepciones.ErrorNombreAlergeno()

            except excepciones.ErrorNombreAlimento as e:
                messagebox.showinfo("Error", str(e))

            except excepciones.ErrorNombreAlergeno as e:
                messagebox.showinfo("Error", str(e))

            except ValueError as e:
                messagebox.showinfo("Error", "Por favor ingrese un número.")

            else:
                alimento_nuevo = Alimento(nombre,
                                          calorias,
                                          proteinas,
                                          carbohidratos,
                                          grasas,
                                          alergeno)

                alimentos.append(alimento_nuevo)

                for widget in funcionalidades_frame.winfo_children():
                    widget.destroy()

                titulo_proceso = tk.Label(funcionalidades_frame, text=5 * "\n" + "¡Alimento añadido exitosamente!",
                                          font=("Verdana", 18, "bold"),
                                          fg="dark blue",
                                          padx=20,
                                          pady=5)

                descripcion_detalle = tk.Label(funcionalidades_frame,
                                               text=2 * "\n" + str(alimento_nuevo),
                                               font=("Verdana", 16),
                                               padx=20,
                                               pady=5)

                titulo_proceso.pack()
                descripcion_detalle.pack()

        # Crea los botones "Aceptar" y "Borrar"
        buttons_frame = tk.Frame(funcionalidades_frame)  # Frame adicional para los botones
        aceptarButton = tk.Button(buttons_frame,
                                  text="Aceptar",
                                  command=crear_alimento,
                                  font=("Verdana", 14))

        borrarButton = tk.Button(buttons_frame,
                                 text="Borrar",
                                 font=("Verdana", 14))

        # Empaqueta los botones en el nuevo frame
        aceptarButton.pack(side='left',
                           padx=5)

        borrarButton.pack(side='left',
                          padx=5)

        # Empaqueta el frame de botones debajo del FieldFrame
        buttons_frame.pack(pady=10)

    def mostrar_funcionalidad3():
        # Borra los widgets existentes en el frame de funcionalidades
        for widget in funcionalidades_frame.winfo_children():
            widget.destroy()

        # Crea las etiquetas de título y descripción
        titulo_proceso = tk.Label(funcionalidades_frame, text=2 * "\n" + "Buscar Alimentos por Calorías, Proteínas y Alergeno",
                                  font=("Verdana", 16, "bold"),
                                  fg="dark blue",
                                  padx=20,
                                  pady=5)

        descripcion_detalle = tk.Label(funcionalidades_frame,
                                       text="Escoge entre una lista de alimentos que cumplen tus requerimientos\n"
                                            "calóricos y proteínicos, descarta los alimentos a los que seas alérgico/a.",
                                       font=("Verdana", 14),
                                       padx=20,
                                       pady=5)

        # Coloca las etiquetas de título y descripción en la parte superior del funcionalidades_frame
        titulo_proceso.pack()
        descripcion_detalle.pack()

        # Crea y añade el FieldFrame al funcionalidades_frame
        superFrame = FieldFrame(funcionalidades_frame, "Requerimientos",
                                ["Máximo de calorías", "Mínimo de proteínas", "Alergeno"], "Datos",
                                ["algo", "hola", "djio"])

        superFrame.pack(padx=20,
                        pady=5,
                        expand=True)

        # Crea los botones "Aceptar" y "Borrar"
        buttons_frame = tk.Frame(funcionalidades_frame)  # Frame adicional para los botones
        aceptarButton = tk.Button(buttons_frame,
                                  text="Aceptar",
                                  font=("Verdana", 14))

        borrarButton = tk.Button(buttons_frame,
                                 text="Borrar",
                                 font=("Verdana", 14))

        def clear_entries():
            for entry in superFrame._valoresEntry.values():
                entry.delete(0, 'end')

        def buscarAlimento():
            maxCal = superFrame.getValue("Máximo de calorías")
            minProt = superFrame.getValue("Mínimo de proteínas")
            aler = superFrame.getValue("Alergeno")

            clear_entries()

            alimentosAceptados = []
            for alimento in alimentos:
                if alimento.encontrarAlimentos(maxCal, minProt, aler) == True:
                    alimentosAceptados.append(alimento._nombre)


            for widget in funcionalidades_frame.winfo_children():
                widget.destroy()

            text = ""
            for alimentoSelec in alimentosAceptados:
                text += (f"{alimentoSelec}\n")


            listaResultados = Label(funcionalidades_frame,
                                    text = text,
                                    font=("Verdana", 16),
                                    fg="black",
                                    padx=20,
                                    pady=5)

            listaResultados.pack(anchor = "c")

        aceptarButton.config(command=buscarAlimento)
        borrarButton.config(command=clear_entries)

        # Empaqueta los botones en el nuevo frame
        aceptarButton.pack(side='left',
                           padx=5)

        borrarButton.pack(side='left',
                          padx=5)

        # Empaqueta el frame de botones debajo del FieldFrame
        buttons_frame.pack(pady=10)

    def mostrar_funcionalidad4():
        # Borra los widgets existentes en el frame de funcionalidades
        for widget in funcionalidades_frame.winfo_children():
            widget.destroy()

        # Crea las etiquetas de título y descripción
        titulo_proceso = tk.Label(funcionalidades_frame, text= 2 * "\n" + "Buscar Gimnasios por Ciudad",
                                  font=("Verdana", 16, "bold"),
                                  fg="dark blue",
                                  padx=10,
                                  pady=10)

        descripcion_detalle = tk.Label(funcionalidades_frame,
                                       text="Consulte las sedes de los gimnasios presentes en su ciudad.",
                                       font=("Verdana", 14),
                                       padx=10,
                                       pady=10)

        # Coloca las etiquetas de título y descripción en la parte superior del funcionalidades_frame
        titulo_proceso.pack()
        descripcion_detalle.pack()

    def mostrar_funcionalidad5():
        # Borra los widgets existentes en el frame de funcionalidades
        for widget in funcionalidades_frame.winfo_children():
            widget.destroy()

        # Crea las etiquetas de título y descripción
        titulo_proceso = tk.Label(funcionalidades_frame,
                                  text="Nombre del proceso o consulta",
                                  font=("Verdana", 12, "bold"),
                                  fg="dark blue",
                                  padx=10,
                                  pady=10)

        descripcion_detalle = tk.Label(funcionalidades_frame,
                                       text="Descripcion del detalle del Proceso o la Consulta",
                                       font=("Verdana", 10),
                                       padx=10,
                                       pady=10)

        # Coloca las etiquetas de título y descripción en la parte superior del funcionalidades_frame
        titulo_proceso.pack()
        descripcion_detalle.pack()

        # Crea y añade el FieldFrame al funcionalidades_frame
        superFrame = FieldFrame(funcionalidades_frame, "Requerimientos",
                                ["Maximo de calorias", "Mínimo de proteinas", "Alergenos"], "Datos",
                                ["algo", "hola", "djio"])

        superFrame.pack(padx=10,
                        pady=10,
                        expand=True)

    # Funciones de las nuevas funcionalidades
    def mostrar_aplicacion():
        messagebox.showinfo("Aplicación", "Gymbro consiste en una aplicación que tiene " 
                            "como fin gestionar el funcionamiento de un gimnasio."
                            + "\n"
                            + "\n"
                            + "Con esta podrás realizar procesos y consultas que llevarán "
                            "tu disciplina y consistencia con tus planes a otro nivel,"
                            + "\n"
                            + "trabajando de la mano de los mejores entrenadores "
                            "y sus recomendaciones.")


    # Creación de la ventana principal de usuario
    ventana_usuario = tk.Toplevel(root)
    ventana_usuario.title("Gymbro - Usuario")
    ventana_usuario.state('zoomed')

    def mostrar_acerca_de():
        messagebox.showinfo("Acerca de", "Esta aplicación fue desarrollada "
                                        "(con sudor y lágrimas) por: "
                                        + "\n"
                                        + "\n"
                                        + "1. Juan José Ospina Erazo"
                                        + "\n"
                                        + "2. Jacobo Ochoa Ramírez"
                                        + "\n"
                                        + "3. Juan Manuel Rodríguez Sánchez"
                                        + "\n"
                                        + "4. Sebastián Valdivieso Zapata"
                                        + "\n"
                                        + "5. Esteban Vásquez Pérez")

    def mostrar_ayuda():
        # Borra los widgets existentes en el frame de funcionalidades
        for widget in funcionalidades_frame.winfo_children():
            widget.destroy()

        # Crear botón "Aplicación"
        aplicacion_btn = ttk.Button(funcionalidades_frame,
                                    text="Acerca de",
                                    style="Botones.TButton",
                                    width=25,
                                    command=mostrar_acerca_de)

        aplicacion_btn.grid(row=0,
                            columnspan=3,
                            sticky="nsew",
                            padx=5,
                            pady=5)

    def mostrar_salir():
        # Oculta la ventana de usuario
        ventana_usuario.withdraw()
        # Muestra la ventana root
        root.deiconify()
        root.state('zoomed')

    root.withdraw()
    # Frame principal
    main_frame_usuario = tk.Frame(ventana_usuario,
                                  bg='light blue')

    main_frame_usuario.pack(fill="both",
                            expand=True)

    # Barra de menú
    barra_menu = tk.Frame(main_frame_usuario,
                          bg="light grey",
                          height=100)

    barra_menu.pack(fill="x")

    # Estilo de los botones de funcionalidades
    estilo_botones = ttk.Style()
    estilo_botones.configure("Botones.TButton",
                             font=("Verdana", 20),
                             background="light blue",
                             relief="solid",
                             borderwidth=2)

    estilo_botones.map("Botones.TButton",
                       background=[("active", "light blue")],
                       foreground=[("active", "black")],
                       relief=[("active", "sunken")])

    # Estilo de los botones de barra de menú
    estilo_botones_menu = ttk.Style()
    estilo_botones_menu.configure("BotonesMenu.TButton",
                                   font=("Verdana", 16),
                                   background="light grey",
                                   relief="solid",
                                   borderwidth=2)

    estilo_botones_menu.map("BotonesMenu.TButton",
                             background=[("active", "light grey")],
                             foreground=[("active", "black")],
                             relief=[("active", "sunken")])

    # Estilo del botón "Salir"
    estilo_botones_salir = ttk.Style()
    estilo_botones_salir.configure("BotonesSalir.TButton",
                                   font=("Verdana", 20),
                                   background="red",
                                   relief="solid",
                                   borderwidth=2)

    estilo_botones_salir.map("BotonesSalir.TButton",
                             background=[("active", "dark red")],
                             foreground=[("active", "black")],
                             relief=[("active", "sunken")])

    # Función del botón "Archivo"
    def mostrar_archivo():
        # Borra los widgets existentes en el frame de funcionalidades
        for widget in funcionalidades_frame.winfo_children():
            widget.destroy()

        # Crear botón "Aplicación"
        aplicacion_btn = ttk.Button(funcionalidades_frame,
                                    text="Aplicación",
                                    style="Botones.TButton",
                                    width=25,
                                    command=mostrar_aplicacion)

        aplicacion_btn.grid(row=0,
                            column=0,
                            sticky="nsew",
                            padx=5,
                            pady=5)

        # Crear botón "Salir"
        salir_btn = ttk.Button(funcionalidades_frame,
                               text="Salir",
                               style="BotonesSalir.TButton",
                               width=25,
                               command=mostrar_salir)

        salir_btn.grid(row=0,
                       column=1,
                       sticky="nsew",
                       padx=5,
                       pady=5)

        # Configuración del grid
        funcionalidades_frame.grid_rowconfigure(0,
                                                weight=1)

        funcionalidades_frame.grid_columnconfigure(0,
                                                   weight=1)

        funcionalidades_frame.grid_columnconfigure(1,
                                                   weight=1)

    archivo_btn = ttk.Button(barra_menu,
                             text="Archivo",
                             width=15,
                             command=mostrar_archivo,
                             style="BotonesMenu.TButton")

    archivo_btn.pack(side="left",
                     padx=10,
                     pady=10)

    # Función del botón "Procesos y Consultas"
    def mostrar_funcionalidades():
        # Borra los widgets existentes en el frame de funcionalidades
        for widget in funcionalidades_frame.winfo_children():
            widget.destroy()

        # Crea los botones de las funcionalidades
        funcionalidad1_btn = ttk.Button(funcionalidades_frame,
                                        text="Recomendar Plan Ejercicio",
                                        style="Botones.TButton",
                                        width=25,
                                        command=mostrar_funcionalidad1)

        funcionalidad1_btn.grid(row=0,
                                column=0,
                                sticky="nsew",
                                padx=5,
                                pady=5)

        funcionalidad2_btn = ttk.Button(funcionalidades_frame,
                                        text="Añadir Alimento",
                                        style="Botones.TButton",
                                        width=25,
                                        command=mostrar_funcionalidad2)

        funcionalidad2_btn.grid(row=0,
                                column=1,
                                sticky="nsew",
                                padx=5,
                                pady=5)

        funcionalidad3_btn = ttk.Button(funcionalidades_frame,
                                        text="Buscar Alimento por Calorías, Proteínas y Alergeno",
                                        style="Botones.TButton",
                                        width=25,
                                        command=mostrar_funcionalidad3)

        funcionalidad3_btn.grid(row=1,
                                column=0,
                                sticky="nsew",
                                padx=5,
                                pady=5)

        funcionalidad4_btn = ttk.Button(funcionalidades_frame,
                                        text="Buscar Gimnasios por Ciudad",
                                        style="Botones.TButton",
                                        width=25,
                                        command=mostrar_funcionalidad4)

        funcionalidad4_btn.grid(row=1,
                                column=1,
                                sticky="nsew",
                                padx=5,
                                pady=5)

        funcionalidad5_btn = ttk.Button(funcionalidades_frame,
                                        text="Buscar Entrenadores por Formación",
                                        style="Botones.TButton",
                                        width=25,
                                        command=mostrar_funcionalidad5)

        funcionalidad5_btn.grid(row=2,
                                column=0,
                                columnspan=2,
                                sticky="nsew",
                                padx=5,
                                pady=5)

        # Configuración del grid
        funcionalidades_frame.grid_rowconfigure(0,
                                                weight=1)

        funcionalidades_frame.grid_rowconfigure(1,
                                                weight=1)

        funcionalidades_frame.grid_rowconfigure(2,
                                                weight=1)

        funcionalidades_frame.grid_columnconfigure(0,
                                                   weight=1)

        funcionalidades_frame.grid_columnconfigure(1,
                                                   weight=1)

    procesos_btn = ttk.Button(barra_menu,
                              text="Procesos y Consultas",
                              width=20,
                              command=mostrar_funcionalidades,
                              style="BotonesMenu.TButton")

    procesos_btn.pack(side="left",
                      padx=10,
                      pady=10)

    ayuda_btn = ttk.Button(barra_menu,
                           text="Ayuda",
                           width=10,
                           command=mostrar_ayuda,
                           style="BotonesMenu.TButton")

    ayuda_btn.pack(side="left",
                   padx=10,
                   pady=10)

    # Frame de las funcionalidades
    funcionalidades_frame = tk.Frame(main_frame_usuario,
                                     bg='white')

    funcionalidades_frame.pack(fill="both",
                               expand=True)

    # Mostrar las funcionalidades por defecto al abrir la ventana
    mostrar_funcionalidades()
    serializador.serializar(gimnasios, ejercicios, maquinas, comidas, alimentos, movimientos, clientes)

"""
Este código define la ventana principal de la aplicación Gymbro.
Proporciona una interfaz gráfica de usuario donde los usuarios pueden acceder a funciones relacionadas con entrenamiento y alimentación.

La ventana principal contiene varios frames para organizar los elementos visuales de la interfaz.
Incluye un frame de título, frames izquierdo y derecho, y frames anidados dentro de ellos."""
def ventana_principal():
    # Obtención de paths para las imágenes
    current_directory = os.path.dirname(os.path.abspath(__file__))
    dir_imagenes = os.path.join(current_directory, "pics")

    # Función para el path de una imagen (SOLO FUNCIONA CON IMAGENES PNG)
    def im(nombre_imagen: str):
        return os.path.join(dir_imagenes, nombre_imagen)

    # Métodos necesarios en el menú desplegable
    def salir_ventana_principal():
        root.destroy()

    def mostrar_descripcion():
        messagebox.showinfo("Descripción del sistema", "Este sistema es un asistente de "
                                                       "entrenamiento y alimentación "
                                                       "para personas que quieren "
                                                       "llevar su entrenamiento al máximo nivel.")

    # Creación de la ventana principal
    root = tk.Tk()
    root.title("Gymbro")

    root.state('zoomed')

    # Frame principal
    main_frame = tk.Frame(root,
                          bg='light blue')

    main_frame.pack(fill="both",
                    expand=True)

    # Frame título anidado en el main_frame
    top_frame = tk.Frame(main_frame, bg="dark blue", borderwidth=3)
    top_frame.place(relx=.05, rely=.005, relwidth=.9, relheight=.1, anchor="nw")

    # Frames anidados (arriba izquierda, arriba derecha) (abajo izaquierda, abajo derecha)
    left_frame = tk.Frame(main_frame, bg="#6495ED", borderwidth=.5, relief="solid")
    left_frame.place(relx=.045, rely=.55, relwidth=.45, relheight=.82, anchor="w")

    right_frame = tk.Frame(main_frame, bg="#6495ED", borderwidth=.5, relief="solid")
    right_frame.place(relx=.965, rely=.55, relwidth=.45, relheight=.82, anchor="e")

    # Frames anidados a left_frame y right_frame
    upper_left_frame = tk.Frame(left_frame, bg="#F0F0F0", borderwidth=.5, relief="raised")
    upper_left_frame.place(relx=0.5, rely=0.003, relwidth=0.995, relheight=0.38, anchor="n")

    bottom_left_frame = tk.Frame(left_frame, bg="#F0F0F0", borderwidth=.5, relief="raised")
    bottom_left_frame.place(relx=0.5, rely=0.997, relwidth=0.995, relheight=0.6, anchor="s")

    upper_right_frame = tk.Frame(right_frame, bg="#F0F0F0", borderwidth=.5, relief="raised")
    upper_right_frame.place(relx=0.5, rely=0.003, relwidth=0.995, relheight=0.38, anchor="n")

    bottom_right_frame = tk.Frame(right_frame, bg="#F0F0F0", borderwidth=.5, relief="raised")
    bottom_right_frame.place(relx=0.5, rely=0.997, relwidth=0.995, relheight=0.6, anchor="s")

    # Definir método para mostrar imágenes que se cambian cuando pasa el cursor por encima
    def cambiar_imagen(event):
        nonlocal i
        i = (i + 1) % len(imagenes_inicio)  # Voy cambiando el índice del programa global
        imagen = tk.PhotoImage(file=imagenes_inicio[i])  # Tomo la imagen
        espacio_imagenes_bottom_left.config(image=imagen)  # La configuro
        espacio_imagenes_bottom_left.image = imagen  # Actualizo la referencia

    # Definir un Label para las imágenes
    espacio_imagenes_bottom_left = Label(bottom_left_frame)
    i = 0  # Variable del índice de la imagen. Debe ser global para que sea posible correr el programa
    imagenes_inicio = [im("buff.png"), im("diet.png"), im("buff2.png"), im("diet2.png"), im("buff3.png")]
    imagen_inicial = tk.PhotoImage(file=imagenes_inicio[i])
    espacio_imagenes_bottom_left.config(image=imagen_inicial)
    espacio_imagenes_bottom_left.bind("<Enter>", cambiar_imagen)  # Llamo al método cambiar imagen con el evento

    espacio_imagenes_bottom_left.pack(side="top")  # Posiciono las imagenes arriba del botón

    # Se define el espacio para el botón de ir a inicio de sesión
    button_frame = tk.Frame(bottom_left_frame)
    button_frame.pack(side="bottom",
                      pady=10)

    boton_inferior = tk.Button(button_frame, text="Ingresar",
                               width=20,
                               height=3,
                           font=("Verdana", 14, "bold italic"),
                               bd=2,
                               relief="solid",
                               cursor="hand2",
                           command=lambda: ventana_principal_usuario(root))
    boton_inferior.pack()


    # Quiero que al dar clic en este botón me lleve al inicio de sesión

    # Ahora llenamos toda la información
    # Título
    label_principal = "GYMBRO"
    titulo = Label(top_frame,
                   text=label_principal,
                   font=("Verdana", 24, "bold underline"))

    titulo.place(rely=0.5,
                 relwidth=0.998,
                 relheight=0.96,
                 anchor="w")

    bienvenida_str = 2 * "\n" + "¡BIENVENIDO A GYMBRO!" \
                    + 3 * "\n" + "Nuestra meta es que puedas cumplir todos tus " \
                    + "\n" \
                    "objetivos deportivos y lleves una vida saludable, \n " \
                    "teniendo recomendaciones de profesionales." \
                    + 4 * "\n" \
                    + '"Porque todos necesitamos un GYMBRO".'

    bienvenida = tk.Text(upper_left_frame,
                         fg="black",
                         bg="#F0F0F0",
                         font=("Verdana", 12, "bold"),
                         cursor="arrow")

    bienvenida.insert(tk.END,
                      bienvenida_str,
                      "justifying")

    bienvenida.tag_configure("justifying",
                             justify="center")

    bienvenida.config(state="disabled")

    bienvenida.pack(expand=True,
                    fill="both",
                    side="bottom")

    # Definimos la funcionalidad para que cada vez que se de clic a la hoja de vida, esta se cambie
    # Y muestre cuatro imágenes del desarrollador correspondiente.

    def cambiar_imagenes_devs():
        """Hace un proceso parecido al de cambiar_imagen"""
        nonlocal j
        j = (j + 1) % len(imgs)  # Hace el módulo entre las cuatro imágenes mientras va sumando a la variable global
        photo_imgs = []  # Llena la lista con las cuatro photo_imgs de cada desarrollador
        for k, i_paths in enumerate(imgs[j]):
            photo_img = tk.PhotoImage(file=i_paths).subsample(2, 2)  # Hace un escalamiento de las imágenes
            labels[k].config(image=photo_img)  # Hace la configuración del label
            photo_imgs.append(photo_img)  # añade todas las imágenes a esta lista para actualizar la referencia

        lab1.image = photo_imgs[0]
        lab2.image = photo_imgs[1]
        lab3.image = photo_imgs[2]
        lab4.image = photo_imgs[3]

    j = 0
    imgs = [  # Aquí van las imágenes de nosotros. Un set de imágenes del integrante por cada fila
        [im("JuanOspina1.png"),
         im("JuanOspina2.png"),
         im("JuanOspina3.png"),
         im("JuanOspina4.png")],

        [im("Ochoa1.png"),
         im("Ochoa3.png"),
         im("Ochoa2.png"),
         im("Ochoa4.png")],

        [im("jr1.png"),
         im("jr2.png"),
         im("jr3.png"),
         im("jr4.png")],

        [im("valdivieso1.png"),
         im("valdivieso2.png"),
         im("valdivieso3.png"),
         im("valdivieso4.png")],

        [im("esteban1.png"),
         im("esteban2.png"),
         im("esteban3.png"),
         im("esteban4.png")],
    ]

    imgs_labels = []  # Primero convierto a Label con cada path

    for row in imgs:
        row_images = []
        for img_path in row:
            image = Label(bottom_right_frame)
            image.image = tk.PhotoImage(file=img_path).subsample(2, 2)  # Reescalo
            image.config(image=image.image)  # Hago la configuración inicial
            row_images.append(image)
        imgs_labels.append(row_images)  # Lleno la lista para luego usarlo en el grid

    # Lleno el grid con un padx y pady
    lab1 = imgs_labels[0][0]
    lab2 = imgs_labels[0][1]
    lab3 = imgs_labels[0][2]
    lab4 = imgs_labels[0][3]

    lab1.grid(row=0,
              column=0,
              padx=3,
              pady=5)

    lab2.grid(row=0,
              column=1,
              padx=3,
              pady=5)

    lab3.grid(row=1,
              column=0,
              padx=3,
              pady=5)

    lab4.grid(row=1,
              column=1,
              padx=3,
              pady=5)

    labels = [lab1,
              lab2,
              lab3,
              lab4]  # Esto es para usarlo dentro de cambiar_imagenes_devs

    # Hago que las imágenes tengan distribución uniforme en el frame
    bottom_right_frame.grid_rowconfigure(0,
                                         weight=1)

    bottom_right_frame.grid_rowconfigure(1,
                                         weight=1)

    bottom_right_frame.grid_columnconfigure(0,
                                            weight=1)

    bottom_right_frame.grid_columnconfigure(1,
                                            weight=1)

    def actualizar_hojas_vida():
        """Esta función cambia el texto del botón y las imágenes en el frame de abajo"""

        if button["text"] == ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                + 3 * "\n"
                + "Nombre: "
                  "Juan José Ospina Erazo"
                + "\n"
                + "Fecha de nacimiento: "
                  "9 de mayo del 2000"
                + "\n"
                + "Gustos: "
                  "senderismo, trekking y jugar tenis"):

            button["text"] = ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                             + 3 * "\n"
                             + "Nombre: "
                               "Jacobo Ochoa Ramírez"
                             + "\n"
                             + "Fecha de nacimiento: "
                               "28 de enero del 2004"
                             + "\n"
                             + "Gustos: "
                               "balonmano, calistenia, taekwondo")

            cambiar_imagenes_devs()

        elif button["text"] == ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                + 3 * "\n"
                + "Nombre: "
                  "Jacobo Ochoa Ramírez"
                + "\n"
                + "Fecha de nacimiento: "
                  "28 de enero del 2004"
                + "\n"
                + "Gustos: "
                  "balonmano, calistenia, taekwondo"):

            button["text"] = ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                             + 3 * "\n"
                             + "Nombre: " 
                               "Juan Manuel Rodríguez Sánchez"
                             + "\n"
                             + "Fecha de nacimiento: " 
                               "9 de julio del 2004"
                             + "\n"
                             + "Gustos: " 
                               "tecnología, finanzas y escuchar música")

            cambiar_imagenes_devs()

        elif button["text"] == ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                + 3 * "\n"
                + "Nombre: "
                  "Juan Manuel Rodríguez Sánchez"
                + "\n"
                + "Fecha de nacimiento: "
                  "9 de julio del 2004"
                + "\n"
                + "Gustos: "
                  "tecnología, finanzas y escuchar música"):

            button["text"] = ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                             + 3 * "\n"
                             + "Nombre: " 
                               "Sebastián Valdivieso Zapata"
                             + "\n"
                             + "Fecha de nacimiento: " 
                               "27 de enero del 2004"
                             + "\n"
                             + "Gustos: " 
                             "tocar guitarra y bajo")

            cambiar_imagenes_devs()

        elif button["text"] == ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                + 3 * "\n"
                + "Nombre: " 
                  "Sebastián Valdivieso Zapata"
                + "\n"
                + "Fecha de nacimiento: " 
                  "27 de enero del 2004"
                + "\n"
                + "Gustos: " 
                  "tocar guitarra y bajo"):

            button["text"] = ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                             + 3 * "\n"
                             + "Nombre: " 
                               "Esteban Vásquez Pérez"
                             + "\n"
                             + "Fecha de nacimiento: " 
                               "3 de enero del 2003"
                             + "\n"
                             + "Gustos: " 
                               "pasear, ir al gimnasio y leer poesía")

            cambiar_imagenes_devs()

        elif button["text"] == ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                + 3 * "\n"
                + "Nombre: "
                  "Esteban Vásquez Pérez"
                + "\n"
                + "Fecha de nacimiento: "
                  "3 de enero del 2003"
                + "\n"
                + "Gustos: "
                  "pasear, ir al gimnasio y leer poesía"):

            button["text"] = ("BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                             + 3 * "\n"
                             + "Nombre: "
                               "Juan José Ospina Erazo"
                             + "\n"
                             + "Fecha de nacimiento: "
                               "9 de mayo del 2000"
                             + "\n"
                             + "Gustos: "
                               "senderismo, trekking y jugar tenis")

            cambiar_imagenes_devs()

    # Quiero definir un grid para el bottom_right_frame
    # Botón de hojas de vida inicial
    button = Button(upper_right_frame, text="BREVE HOJA DE VIDA DE LOS DESARROLLADORES"
                                            + 3 * "\n"
                                            + "Nombre: "
                                              "Juan José Ospina Erazo"
                                            + "\n"
                                            + "Fecha de nacimiento: "
                                              "9 de mayo del 2000"
                                            + "\n"
                                            + "Gustos: "
                                              "senderismo, trekking y jugar tenis", bg="#F0F0F0", command=actualizar_hojas_vida,
                    font=("Verdana", 12, "bold"), cursor="hand2")

    button.pack(expand=True,
                fill="both")

    # Menú inicio
    main_menu = tk.Menu(top_frame)
    menu_bar = tk.Menu(main_menu,
                       tearoff=0)

    menu_bar.add_command(label="Salir",
                         command=salir_ventana_principal)

    menu_bar.add_command(label="Descripción",
                         command=mostrar_descripcion)

    # creo las partes del menú
    main_menu.add_cascade(label="Inicio",
                          menu=menu_bar)

    root.config(menu=main_menu)

    root.mainloop()

    pass

def main():

    ventana_principal()

if __name__ == "__main__":

    main()