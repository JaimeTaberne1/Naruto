/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.narutojuego;

import java.io.IOException;
import java.util.Random;
import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Mañana_pos2
 */
public class Juego {
    
    boolean turnoMuneco1=true;
    @FXML
    private ProgressBar barrasuper;

    @FXML
    private ProgressBar barrasuper2;
    @FXML
    private ProgressBar vida;

    @FXML
    private ProgressBar vida2;
     @FXML
    private ImageView muneco1;
     @FXML
    private ImageView ataque;

    @FXML
    private ImageView superaw;

    @FXML
    private ImageView superaw2;

    @FXML
    private ImageView ataque2;

    @FXML
    private ImageView muneco2;
    
    @FXML
    private AnchorPane pane3;

    @FXML
    private ImageView imagenfondo;


    private Stage stage;
        // Método para establecer el Stage
    public void setStage(Stage stage) {
        this.stage = stage;
    }
    
    String nomJugador1;
    String nomJugador2;
    boolean mapa1seleccionado;



    public void setNomJugador1(String nomJugador1) {
        this.nomJugador1 = nomJugador1;
        Image mun1= new Image ("/resources/"+nomJugador1+"movnormal.gif");
        muneco1.setImage(mun1);
    }


    public void setNomJugador2(String nomJugador2) {
        this.nomJugador2 = nomJugador2;
         Image mun2= new Image ("/resources/"+nomJugador2+"movnormal2.gif");
        muneco2.setImage(mun2);
    }

    public void setMapa1seleccionado(boolean mapa1seleccionado) {
        this.mapa1seleccionado = mapa1seleccionado;
         Image mapa1=new Image("/resources/mapa1.jpg");
         Image mapa2=new Image("/resources/mapa2.jpg");
        if (mapa1seleccionado){
        imagenfondo.setImage(mapa1);
        
    }else{
        imagenfondo.setImage(mapa2);
       
        
    }
        empezar();
        
    }
    void empezar (){
        ataque.setVisible(true);
        vida.setProgress(1);
        vida2.setProgress(1);
        
        
        
    }
       @FXML
    void atacar(MouseEvent event) {
        ataque.setVisible(false);
        superaw.setVisible(false);
        turnoMuneco1=false;
        Image munecoataque= new Image ("/resources/"+nomJugador1+"ataquenormal.gif");
        muneco1.setImage(munecoataque);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));

        // Set an event handler to be triggered when the pause is finished
        pause.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Image mun1= new Image ("/resources/"+nomJugador1+"movnormal.gif");
                muneco1.setImage(mun1);
                if(aciertoConProbabilidad(0.6)){
                    vida2.setProgress(vida2.getProgress()-0.2);
                    cargarSuper();
                if(comprobarDerrota()){
                    finalizarJuego();
                }
                }
                ataque2.setVisible(true);
               if(super2Cargada()){
               superaw2.setVisible(true);
                }
            }

            
        });

        // Start the pause
        pause.play();
    }

    

    @FXML
    void atacar2(MouseEvent event) {
        ataque2.setVisible(false);
        superaw2.setVisible(false);
        turnoMuneco1=true;
        Image munecoataque2= new Image ("/resources/"+nomJugador2+"ataquenormal2.gif");
        muneco2.setImage(munecoataque2);
        PauseTransition pause = new PauseTransition(Duration.seconds(1));

        // Set an event handler to be triggered when the pause is finished
        pause.setOnFinished(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                Image mun1= new Image ("/resources/"+nomJugador2+"movnormal2.gif");
                muneco2.setImage(mun1);
                if(aciertoConProbabilidad(0.6)){
                vida.setProgress(vida.getProgress()-0.2);
                cargarSuper();
     
             if(comprobarDerrota()){
                    finalizarJuego();
             }
              }
                
               ataque.setVisible(true);
               if(superCargada()){
               superaw.setVisible(true);
                }
            }
        });

        // Start the pause
        pause.play();
    }

    

 @FXML
void superar(MouseEvent event) {
    ataque.setVisible(false);
    superaw.setVisible(false);
    turnoMuneco1 = false;
    Image munecoataque = new Image("/resources/" + nomJugador1 + "ataquenormal.gif");
    muneco1.setImage(munecoataque);
    PauseTransition pause = new PauseTransition(Duration.seconds(1));

    // Set an event handler to be triggered when the pause is finished
    pause.setOnFinished(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Image mun1 = new Image("/resources/" + nomJugador1 + "movnormal.gif");
            muneco1.setImage(mun1);
            if (aciertoConProbabilidad(0.6)) {
                vida2.setProgress(vida2.getProgress() - 0.3);
                if (comprobarDerrota()) {
                    finalizarJuego();
                }
            }
            ataque2.setVisible(true);
            barrasuper.setProgress(0);
            if (super2Cargada()) {
                superaw2.setVisible(true);
            }
        }
    });

    // Start the pause
    pause.play();
}

@FXML
void superar2(MouseEvent event) {
    ataque2.setVisible(false);
    superaw2.setVisible(false);
    turnoMuneco1 = true;
    Image munecoataque = new Image("/resources/" + nomJugador2 + "ataquenormal2.gif");
    muneco2.setImage(munecoataque);
    PauseTransition pause = new PauseTransition(Duration.seconds(1));

    // Set an event handler to be triggered when the pause is finished
    pause.setOnFinished(new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent e) {
            Image mun1 = new Image("/resources/" + nomJugador2 + "movnormal2.gif");
            muneco2.setImage(mun1);
            if (aciertoConProbabilidad(0.6)) {
                vida.setProgress(vida.getProgress() - 0.3);
                if (comprobarDerrota()) {
                    finalizarJuego();
                }
            }
            ataque.setVisible(true);
            barrasuper2.setProgress(0);
            if (superCargada()) {
                superaw.setVisible(true);
            }
        }
    });
    // Start the pause
    pause.play();
}

    
    boolean aciertoConProbabilidad(double probabilidad) {
        Random random = new Random();
        double valorAleatorio = random.nextDouble(); // Genera un valor entre 0.0 (inclusive) y 1.0 (exclusive)
        return valorAleatorio < probabilidad;
    }
    
    boolean comprobarDerrota(){
        if (vida.getProgress()<=0.1){
            return true;
        }else if(vida2.getProgress()<=0.1){
            return true;
        }else{
            return false;
        }
    }
    
        void finalizarJuego() {
         try {
        // Cargar la vista desde el archivo FXML
        FXMLLoader loader = new FXMLLoader(getClass().getResource("quaternary.fxml"));
        Parent root = loader.load();
       
         PantallaFinal controller = loader.getController();
         if (turnoMuneco1){
         controller.setNombre(nomJugador1);
         }else{
            controller.setNombre(nomJugador2);  
         }
         controller.setTurnoJugador1(turnoMuneco1);
         
         
        controller.setStage(stage);
        
        pane3.getChildren().setAll(root);
    
    } catch (IOException e) {
        e.printStackTrace();
      
    }
        
            }
        
        void cargarSuper(){
            if (turnoMuneco1==true){
                barrasuper2.setProgress(barrasuper2.getProgress()+0.33);
 
               
            }else{
                barrasuper.setProgress(barrasuper.getProgress()+0.33);

            }
        }
        
        boolean superCargada(){
               if(barrasuper.getProgress()>0.9){
                    return true;
                    
        }else{
                   return false;
               }
        }
          boolean super2Cargada(){
               if(barrasuper2.getProgress()>0.9){
                    return true;
                    
        }else{
                   return false;
               }
        }

    
          
        }
    

    



