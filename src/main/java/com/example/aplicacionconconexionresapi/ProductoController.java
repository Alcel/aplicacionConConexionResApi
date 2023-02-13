package com.example.aplicacionconconexionresapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class ProductoController implements Callback<List<Gasolinera>> {

    static final String BASE_URL = "https://sedeaplicaciones.minetur.gob.es/ServiciosRESTCarburantes/PreciosCarburantes/EstacionesTerrestres/";

    public void start() {

        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        System.out.println("E");
        GasolineraInterface productosAPI = retrofit.create(GasolineraInterface.class);

        Call<List<Gasolinera>> call = productosAPI.listProductos();
        call.enqueue(this);

    }

    @Override
    public void onResponse(Call<List<Gasolinera>> call, Response<List<Gasolinera>> response) {
        if(response.isSuccessful()) {
            List<Gasolinera> changesList = response.body();
            changesList.forEach(change -> System.out.println(change.getFecha()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Gasolinera>> call, Throwable throwable) {
        throwable.printStackTrace();
    }
}
