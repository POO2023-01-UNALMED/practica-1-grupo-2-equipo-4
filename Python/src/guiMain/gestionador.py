import tkinter as tk
from tkinter import messagebox, Button, Label
import os


def main():
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
        messagebox.showinfo("Descripción del sistema", "Esta aplicación es un asistente de "
                                                       "entrenamiento y alimentación "
                                                       "para personas que quieren "
                                                       "llevar su entrenamiento al máximo nivel.")

    # Creación de la ventana principal
    root = tk.Tk()
    root.title("Gymbro")

    # Elementos para la geometría de la pantalla
    screen_width = root.winfo_screenwidth()  # Ancho de la pantalla
    screen_height = root.winfo_screenheight()  # Altura de la pantalla

    width = int(screen_width * 0.9)  # 90% del ancho de la pantalla
    height = int(screen_height * 0.9)  # 90% de la altura de la pantalla

    # Centrar la ventana
    x = (screen_width // 2) - (width // 2)
    y = (screen_height // 2) - (height // 2)

    root.geometry(f'{width}x{height}+{x}+{y}')  # Establecer la geometría de la ventana

    # Frame principal
    main_frame = tk.Frame(root, bg='light blue')
    main_frame.pack(fill="both", expand=True)

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
    button_frame.pack(side="bottom", pady=10)

    boton_inferior = tk.Button(button_frame, text="Ir al inicio de sesión", width=20, height=3,
                               font=("Verdana", 14, "bold italic"), bd=2, relief="solid", cursor="hand2")
    boton_inferior.pack()

    # Quiero que al dar clic en este botón me lleve al inicio de sesión

    # Ahora llenamos toda la información
    # Título
    label_principal = "GYMBRO"
    titulo = Label(top_frame, text=label_principal, font=("Verdana", 24, "bold underline"))
    titulo.place(rely=0.5, relwidth=0.998, relheight=0.96, anchor="w")

    bienvenida_str = "TE DAMOS LA BIENVENIDA" \
                     "\n\n En Gymbro, nuestra meta es que cumplas con tus objetivos \n " \
                     "deportivos y tengas una vida saludable." \
                     + 6 * "\n" + "Desarrollado por Juan Ospina, Jacobo Ochoa, Juan Manuel, \nSebastián y Esteban."

    bienvenida = tk.Text(upper_left_frame, fg="black", bg="#F0F0F0", font=("Verdana", 12, "bold"), cursor="arrow")
    bienvenida.insert(tk.END, bienvenida_str, "justifying")
    bienvenida.tag_configure("justifying", justify="center")
    bienvenida.config(state="disabled")
    bienvenida.pack(expand=True, fill="both", side="bottom")

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
        [im("d1.png"), im("d1.png"), im("d1.png"), im("d1.png")],
        [im("d2.png"), im("d2.png"), im("d2.png"), im("d2.png")],
        [im("d1.png"), im("d1.png"), im("d1.png"), im("d1.png")],
        [im("d2.png"), im("d2.png"), im("d2.png"), im("d2.png")],
        [im("d1.png"), im("d1.png"), im("d1.png"), im("d1.png")],
        [im("buff.png"), im("buff.png"), im("buff.png"), im("buff.png")],
        [im("buff2.png"), im("buff2.png"), im("buff2.png"), im("buff2.png")],
        [im("esteban1.png"), im("esteban2.png"), im("esteban3.png"), im("esteban4.png")]
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

    lab1.grid(row=0, column=0, padx=3, pady=5)
    lab2.grid(row=0, column=1, padx=3, pady=5)
    lab3.grid(row=1, column=0, padx=3, pady=5)
    lab4.grid(row=1, column=1, padx=3, pady=5)

    labels = [lab1, lab2, lab3, lab4]  # Esto es para usarlo dentro de cambiar_imagenes_devs

    # Hago que las imágenes tengan distribución uniforme en el frame
    bottom_right_frame.grid_rowconfigure(0, weight=1)
    bottom_right_frame.grid_rowconfigure(1, weight=1)
    bottom_right_frame.grid_columnconfigure(0, weight=1)
    bottom_right_frame.grid_columnconfigure(1, weight=1)

    def actualizar_hojas_vida():
        """Esta función cambia el texto del botón y las imágenes en el frame de abajo"""
        if button["text"] == "Hoja de vida de Juan Ospina":
            button["text"] = "Hoja de vida de Jacobo Ochoa"
            cambiar_imagenes_devs()
        elif button["text"] == "Hoja de vida de Jacobo Ochoa":
            button["text"] = "Hoja de vida de Juan Manuel"
            cambiar_imagenes_devs()
        elif button["text"] == "Hoja de vida de Juan Manuel":
            button["text"] = "Hoja de vida de Sebastián"
            cambiar_imagenes_devs()
        elif button["text"] == "Hoja de vida de Sebastián":
            button["text"] = "Hoja de vida de Esteban"
            cambiar_imagenes_devs()
        elif button["text"] == "Hoja de vida de Esteban":
            button["text"] = "Hoja de vida de Juan Ospina"
            cambiar_imagenes_devs()

    # Quiero definir un grid para el bottom_right_frame
    # Botón de hojas de vida inicial
    button = Button(upper_right_frame, text="Hoja de vida de Juan Ospina", bg="#F0F0F0", command=actualizar_hojas_vida,
                    font=("Verdana", 12, "bold"), cursor="hand2")
    button.pack(expand=True, fill="both")

    # Menú inicio
    main_menu = tk.Menu(top_frame)
    menu_bar = tk.Menu(main_menu, tearoff=0)
    menu_bar.add_command(label="Salir", command=salir_ventana_principal)
    menu_bar.add_command(label="Acerca de", command=mostrar_descripcion)

    # creo las partes del menú
    main_menu.add_cascade(label="Inicio", menu=menu_bar)
    root.config(menu=main_menu)

    root.mainloop()

    # Esto va en la siguiente ventana después de presionar P4

    # label = Label(main_frame, text="¡Hola! Bienvenido a Gymbro\n-----INICIO DE SESIÓN-----",
    #                  font=('Helvetica', 18, 'bold'), bg='light blue')
    # label.pack(pady=10)
    #
    # id_entry = tk.Entry(main_frame, font=('Helvetica', 16), width=50)
    # id_entry.pack(pady=10)
    # id_entry.insert(0, "Ingrese su identificación: ")

    #
    # def verificar_identificacion():
    #     ident = id_entry.get()
    #     # Aqui se necesita implementar la logica !!! (PENDIENTE)
    #     for widget in main_frame.winfo_children():
    #         widget.destroy()  # Esto elimina todos los widgets de inicio de sesión
    #     show_menu()  # Esto muestra el menú
    #
    # verificar_button = tk.Button(main_frame,
    # text="Verificar", command=verificar_identificacion, font=('Helvetica', 16), bg='light grey')
    # verificar_button.pack(pady=10)
    #
    # def seleccionar_opcion():
    #     opcion = menu.curselection()[0] + 1
    #     # Añade aquí la lógica para manejar la opción seleccionada
    #     messagebox.showinfo("Info", f"Seleccionó la opción {opcion}")
    #
    # def show_menu():
    #     # Creación de los widgets del menú principal
    #     opciones = [
    #         "1. Reservar Gimnasio",
    #         "2. Recomendación de Plan de Alimentación Semanal",
    #         "3. Recomendación de Plan de Ejercicio Semanal",
    #         "4. Recomendación de Entrenadores",
    #         "5. Salir",
    #     ]
    #
    #     menu = tk.Listbox(main_frame, font=('Helvetica', 16), width=50, height=5)
    #     for opcion in opciones:
    #         menu.insert(tk.END, opcion)
    #     menu.pack(pady=10)
    #
    #     seleccionar_button = tk.Button(main_frame, text="Seleccionar",
    #     command=seleccionar_opcion, font=('Helvetica', 16), bg='light grey')
    #     seleccionar_button.pack(pady=10)

    # Iniciar la aplicación


if __name__ == "__main__":
    main()
