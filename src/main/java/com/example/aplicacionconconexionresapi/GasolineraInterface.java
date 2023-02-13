package com.example.aplicacionconconexionresapi;

import javafx.collections.ObservableList;
import retrofit2.Call;
import retrofit2.http.*;

public interface GasolineraInterface {
    @GET("ResultadoConsulta")
    Call<ObservableList<Gasolinera>> cargarGasolineras();
}
