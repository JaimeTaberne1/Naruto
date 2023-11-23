package com.mycompany.narutojuego;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SeleccionDePersonaje {

    private Stage stage;

    // Constructor sin argumentos
    public SeleccionDePersonaje() {
        // Inicialización si es necesario
    }

    // Método para establecer el Stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    // Otros métodos y lógica del controlador
    @FXML
    private AnchorPane pane2;

    @FXML
    private ImageView deidara;

    @FXML
    private ImageView deidara2;

    @FXML
    private ImageView jugador1;

    @FXML
    private ImageView jugador2;

    @FXML
    private ImageView kakashi;

    @FXML
    private ImageView kakashi2;

    @FXML
    private ImageView naruto;

    @FXML
    private ImageView naruto2;

    @FXML
    private ImageView sasuke;

    @FXML
    private ImageView sasuke2;
     @FXML
    private ImageView start;

    @FXML
    private ImageView exit;

    
    @FXML
    private ImageView mapa;
boolean mapa1seleccionado=true;
String nomJugador1;
String nomJugador2;
    @FXML
    void cambiarMapa(MouseEvent event) {
    Image mapa1=new Image("/resources/mapa1.jpg");
    Image mapa2=new Image("/resources/mapa2.jpg");
    if (mapa1seleccionado){
        mapa.setImage(mapa2);
        mapa1seleccionado=false;
    }else{
        mapa.setImage(mapa1);
         mapa1seleccionado=true;
        
    }
    }

     @FXML
    void ponerj1(MouseEvent event) {
        ImageView boton = (ImageView)event.getSource();
        String idDelBoton = boton.getId();
        
        Image imagen=new Image("/resources/"+idDelBoton+"Imagen.png");
        jugador1.setImage(imagen);
        nomJugador1=idDelBoton;

    }
        @FXML
    void ponerj2(MouseEvent event) {
        ImageView boton = (ImageView)event.getSource();
        String idDelBoton = boton.getId();
        idDelBoton=idDelBoton.substring(0, idDelBoton.length()-1);
        Image imagen=new Image("/resources/"+idDelBoton+"Imagen.png");
        jugador2.setImage(imagen);
        nomJugador2=idDelBoton;

    }
     @FXML
    void Salir(MouseEvent event) {
        try {
        // Cargar la vista desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
        
         PantallaDeInicio controller = loader.getController();
        controller.setStage(stage);
        
        pane2.getChildren().setAll(root);
    
    } catch (IOException e) {
        e.printStackTrace();
        // Manejar la excepción de carga de FXML
    }
    }
    @FXML
    void empezarJuego(MouseEvent event) {
        if(jugador1.getImage() != null && jugador2.getImage() != null){
         try {
        // Cargar la vista desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("tertiary.fxml"));
        Parent root = loader.load();
       
         Juego controller = loader.getController();
         controller.setNomJugador1(nomJugador1);
         controller.setNomJugador2(nomJugador2);
         controller.setMapa1seleccionado(mapa1seleccionado);
        controller.setStage(stage);
        
        pane2.getChildren().setAll(root);
    
    } catch (IOException e) {
        e.printStackTrace();
        // Manejar la excepción de carga de FXML
    }
    } else {
        // Mostrar una alerta indicando que ambos jugadores deben seleccionar una imagen
        Alert alert = new Alert(AlertType.WARNING);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText("Ambos jugadores deben seleccionar un personaje.");
        alert.showAndWait();
    }
    }

    }



