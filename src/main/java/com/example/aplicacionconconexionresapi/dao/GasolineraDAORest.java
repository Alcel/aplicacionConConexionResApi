package com.example.aplicacionconconexionresapi.dao;


import com.example.aplicacionconconexionresapi.*;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class GasolineraDAORest implements Callback<ObservableList<Gasolinera>>  {
    static final String BASE_URL = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/";

    public void start() {
        Gson gson = new GsonBuilder()
                .setLenient()
                .registerTypeAdapter(StringProperty.class,new StringPropertyAdapter())
                .registerTypeAdapter(IntegerProperty.class,new IntegerPropertyAdapter())
                .registerTypeAdapter(DoubleProperty.class,new DoublePropertyAdapter())
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        GasolineraInterface GasolinerasAPI = retrofit.create(GasolineraInterface.class);

        Call<ObservableList<Gasolinera>> call = GasolinerasAPI.cargarGasolineras();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<ObservableList<Gasolinera>> call, Response<ObservableList<Gasolinera>> response) {
        if(response.isSuccessful()) {
            List<Gasolinera> changesList = response.body();
          //  changesList.forEach(change -> System.out.println(change.getProductName()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<ObservableList<Gasolinera>> call, Throwable throwable) {
        throwable.printStackTrace();
    }

}
