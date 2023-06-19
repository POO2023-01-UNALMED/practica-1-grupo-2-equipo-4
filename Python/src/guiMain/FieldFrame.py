import tkinter
from tkinter import Frame, Entry, Label

class FieldFrame(Frame):
    def __init__(self, master, tituloCriterios, criterios, tituloValores, valores, habilitado = [], **kwargs):
        super().__init__(master,kwargs)

        self._tituloCriterios = tkinter.Label(self, text=tituloCriterios, font=("Verdana 12 bold"), fg = "dark blue")
        self._tituloValores = tkinter.Label(self, text=tituloValores,  font=("Verdana 12 bold"), fg = "dark blue")
        self._tituloCriterios.grid(row = 0, column=0,padx=10,pady=10,sticky="w")
        self._tituloValores.grid(row = 0, column=1,padx=10,pady=10,sticky="w")

        self._valoresEntry = {}

        if habilitado == None:
            habilitado=[]

        for criterio in criterios:
            llave = tkinter.Label(self,text=criterio,  font=("Verdana 10")).grid(row = (criterios.index(criterio) + 1), column=0,padx=10,pady=10,sticky="w")

        for valor in valores:

            val = tkinter.Entry(self,text=valor,font=("Verdana 10"),state= (lambda : "disabled" if valor in habilitado else "normal")()).grid(row = (valores.index(valor) + 1), column=1,padx=10,pady=10,sticky="w")
            self._valoresEntry[criterios[valores.index(valor)]] = val



   

    def getValue(self,criterio):
        for i in self._valoresEntry:
            if criterio == i:
                self._valoresEntry[i]


