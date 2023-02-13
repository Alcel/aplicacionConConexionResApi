package com.example.aplicacionconconexionresapi;


import java.util.ArrayList;

public class Gasolinera {
        private String Fecha;
        ArrayList< Object > ListaEESSPrecio = new ArrayList < Object > ();
        private String Nota;
        private String ResultadoConsulta;


        // Getter Methods

        public String getFecha() {
            return Fecha;
        }

        public String getNota() {
            return Nota;
        }

        public String getResultadoConsulta() {
            return ResultadoConsulta;
        }
    }

