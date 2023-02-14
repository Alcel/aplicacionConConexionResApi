package com.example.aplicacionconconexionresapi;

import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface GasolineraInterface {

    @GET("eevee")

    Call<Pokemon> listProductos();
}
