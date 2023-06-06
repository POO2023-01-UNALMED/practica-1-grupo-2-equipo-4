import tkinter as tk
from tkinter import messagebox

def main():
    # Creación de la ventana principal
    root = tk.Tk()
    root.title("Gymbro")

    screen_width = root.winfo_screenwidth()  # Ancho de la pantalla
    screen_height = root.winfo_screenheight()  # Altura de la pantalla

    width = int(screen_width * 0.9)  # 90% del ancho de la pantalla
    height = int(screen_height * 0.9)  # 90% de la altura de la pantalla

    # Centrar la ventana
    x = (screen_width // 2) - (width // 2)
    y = (screen_height // 2) - (height // 2)

    root.geometry(f'{width}x{height}+{x}+{y}') # Establecer la geometría de la ventana
    
    root.configure(bg='light blue')

    # Creación de los widgets de inicio de sesión
    main_frame = tk.Frame(root, bg='light blue')
    main_frame.place(relx=0.5, rely=0.5, anchor='center')

    label = tk.Label(main_frame, text="¡Hola! Bienvenido a Gymbro\n-----INICIO DE SESIÓN-----", font=('Helvetica', 18, 'bold'), bg='light blue')
    label.pack(pady=10)

    id_entry = tk.Entry(main_frame, font=('Helvetica', 16), width=50)
    id_entry.pack(pady=10)
    id_entry.insert(0, "Ingrese su identificación: ")

    def verificar_identificacion():
        ident = id_entry.get()
        # Aqui se necesita implementar la logica !!! (PENDIENTE)
        for widget in main_frame.winfo_children():
            widget.destroy()  # Esto elimina todos los widgets de inicio de sesión
        show_menu()  # Esto muestra el menú

    verificar_button = tk.Button(main_frame, text="Verificar", command=verificar_identificacion, font=('Helvetica', 16), bg='light grey')
    verificar_button.pack(pady=10)

    def seleccionar_opcion():
        opcion = menu.curselection()[0] + 1
        # Añade aquí la lógica para manejar la opción seleccionada
        messagebox.showinfo("Info", f"Seleccionó la opción {opcion}")

    def show_menu():
        # Creación de los widgets del menú principal
        opciones = [
            "1. Reservar Gimnasio",
            "2. Recomendación de Plan de Alimentación Semanal",
            "3. Recomendación de Plan de Ejercicio Semanal",
            "4. Recomendación de Entrenadores",
            "5. Salir",
        ]

        menu = tk.Listbox(main_frame, font=('Helvetica', 16), width=50, height=5)
        for opcion in opciones:
            menu.insert(tk.END, opcion)
        menu.pack(pady=10)

        seleccionar_button = tk.Button(main_frame, text="Seleccionar", command=seleccionar_opcion, font=('Helvetica', 16), bg='light grey')
        seleccionar_button.pack(pady=10)

    # Iniciar la aplicación
    root.mainloop()

if __name__ == "__main__":
    main()



