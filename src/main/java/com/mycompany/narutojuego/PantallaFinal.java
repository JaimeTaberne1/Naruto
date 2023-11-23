/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.narutojuego;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class PantallaFinal {
     @FXML
    private AnchorPane pane4;
     @FXML
    private ImageView salir;

    @FXML
    private ImageView voltarmenu;
    private Stage stage;

    @FXML
    void irMenu(MouseEvent event) {
         try {
        // Cargar la vista desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("primary.fxml"));
        Parent root = loader.load();
        
         PantallaDeInicio controller = loader.getController();
        controller.setStage(stage);
        
        pane4.getChildren().setAll(root);
    
    } catch (IOException e) {
        e.printStackTrace();
        // Manejar la excepción de carga de FXML
    }
    }

    

    @FXML
    void salir(MouseEvent event) {
        Stage stage = (Stage) pane4.getScene().getWindow();
    stage.close();

    }


    @FXML
    private ImageView imagenfinal;

    @FXML
    private Label textofinal;

    String nombre;
    boolean turnoJugador1;

    public void setNombre(String nombre) {
        this.nombre = nombre;
        Image imagen=new Image("/resources/"+nombre+"Imagen.png");
        imagenfinal.setImage(imagen);
    }

    public void setTurnoJugador1(boolean turnoJugador1) {
          this.turnoJugador1 = turnoJugador1;
          if (!turnoJugador1){
              textofinal.setText("Jugador 1 gana!!");
          }else {
              textofinal.setText("Jugador 2 gana!!");
          }
    }

    void setStage(Stage stage) {
    }
    
}
