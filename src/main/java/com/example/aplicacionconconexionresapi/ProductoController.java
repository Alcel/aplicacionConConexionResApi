package com.example.aplicacionconconexionresapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.util.List;

public class ProductoController implements Callback<List<Pokemon>> {

    static final String BASE_URL = "https://pokeapi.co/api/v2/pokemon/";

    public void start() {

        /*Gson gson = new GsonBuilder()
                .setLenient()
                .create();*/

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(/*gson*/))
                .build();
        System.out.println("E");
        GasolineraInterface productosAPI = retrofit.create(GasolineraInterface.class);

        Call<Pokemon> call = productosAPI.listProductos();
        Callback<Pokemon> pokemon;
        call.enqueue( new Callback<Pokemon>(){


            @Override
            public void onResponse(Call<Pokemon> call, Response<Pokemon> response) {
                System.out.println(response);
            }

            @Override
            public void onFailure(Call<Pokemon> call, Throwable throwable) {

            }
        });

    }

    @Override
    public void onResponse(Call<List<Pokemon>> call, Response<List<Pokemon>> response) {
        if(response.isSuccessful()) {
            List<Pokemon> changesList = response.body();
            //changesList.forEach(change -> System.out.println(change.getFecha()));
        } else {
            System.out.println(response.errorBody());
        }
    }

    @Override
    public void onFailure(Call<List<Pokemon>> call, Throwable throwable) {
        throwable.printStackTrace();
    }
}
