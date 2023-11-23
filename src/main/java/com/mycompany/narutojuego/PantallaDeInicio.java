package com.mycompany.narutojuego;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import java.io.IOException;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PantallaDeInicio {
     public void setStage(Stage stage) {
        this.stage = stage;
    }


    @FXML
    private ImageView nuevaPartida;

    private Stage stage;
    
    @FXML
    private AnchorPane pane;
    
    @FXML
    private ImageView Salir;

    
@FXML
void Salir(MouseEvent event) {
    Stage stage = (Stage) pane.getScene().getWindow();
    stage.close();
}

    @FXML
    void Jugar(MouseEvent event) {
    try {
        // Cargar la vista desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("secondary.fxml"));
        Parent root = loader.load();
        
         SeleccionDePersonaje controller = loader.getController();
        controller.setStage(stage);
        
        pane.getChildren().setAll(root);
    
    } catch (IOException e) {
        e.printStackTrace();
        // Manejar la excepción de carga de FXML
    }
    }
}




    
    

