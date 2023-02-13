package com.example.aplicacionconconexionresapi;

import com.example.aplicacionconconexionresapi.dao.APIClient;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.*;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import java.util.List;

public class GasolinerasController {

    private Gasolinera GasolineraAux;
    private ObservableList <Gasolinera> datos;

    @javafx.fxml.FXML
    private TableColumn tcProductVendor;
    @javafx.fxml.FXML
    private Button btnBorrar;
    @javafx.fxml.FXML
    private TextField txtVendedor;
    @javafx.fxml.FXML
    private TextField txtStock;
    @javafx.fxml.FXML
    private TableColumn tcBuyPrice;
    @javafx.fxml.FXML
    private TableView<Gasolinera> tvGasolineras;
    @javafx.fxml.FXML
    private TableColumn tcQuantityInStock;
    @javafx.fxml.FXML
    private TextField txtID;
    @javafx.fxml.FXML
    private TextField txtNombre;
    @javafx.fxml.FXML
    private TextField txtEscala;
    @javafx.fxml.FXML
    private TableColumn tcProductDescription;
    @javafx.fxml.FXML
    private TextField txtPrecioCompra;
    @javafx.fxml.FXML
    private TableColumn tcProductScale;
    @javafx.fxml.FXML
    private Button btnAlta;
    @javafx.fxml.FXML
    private TableColumn tcMSRP;
    @javafx.fxml.FXML
    private TextField txtPrecioVenta;
    @javafx.fxml.FXML
    private TextField txtLinea;
    @javafx.fxml.FXML
    private TableColumn tcProductName;
    @javafx.fxml.FXML
    private TableColumn tcProductLine;
    @javafx.fxml.FXML
    private TextField txtDescripcion;
    @javafx.fxml.FXML
    private Button btnActualizar;
    @javafx.fxml.FXML
    private TableColumn tcProductCode;

    public void initialize()  {
        obtenerDatosRest();


    }

    private void obtenerDatosRest() {
        GasolineraInterface apiService = APIClient.getClient().create(GasolineraInterface.class);

        Call<ObservableList<Gasolinera>> call = apiService.cargarGasolineras();
        call.enqueue(new Callback<ObservableList<Gasolinera>>() {

            @Override
            public void onResponse(Call<ObservableList<Gasolinera>> call, Response<ObservableList<Gasolinera>> response) {
                if(response.isSuccessful()) {
                    List<Gasolinera> datosaux = response.body();
                    datos = FXCollections.observableList(datosaux);
                   // datosaux.forEach(prod -> datos.add(prod));
                    System.out.println(datosaux.get(0));
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR, "No se ha podido conectar con el servidor. Inténtelo más tarde. ", ButtonType.OK );
                    alert.showAndWait();
                }
            }

            @Override
            public void onFailure(Call<ObservableList<Gasolinera>> call, Throwable throwable) {
                throwable.printStackTrace();
            }
        });
    }
}
