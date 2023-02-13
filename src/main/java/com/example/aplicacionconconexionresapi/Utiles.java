package com.example.aplicacionconconexionresapi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Utiles {

    public static <ObjectType> ObjectType copiaDeep(ObjectType origen, Class<ObjectType> ClassInfo)
    {
        Gson gson = new GsonBuilder().create();
        String text = gson.toJson(origen);
        return gson.fromJson(text, ClassInfo);
    }

}
