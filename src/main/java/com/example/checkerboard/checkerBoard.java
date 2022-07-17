package com.example.checkerboard;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class checkerBoard extends Application {
    Canvas canvas;
    GraphicsContext g;

    private int selectedRow; //Row and column of selected square
    private int selectedCol;

    public static void main(String[] arg){
        launch();
    }

    public void start(Stage stage){
        selectedRow = -1; //To start, no square is selected

        canvas = new Canvas(400, 400);
        g = canvas.getGraphicsContext2D();
        g.setFill(Color.GRAY);
        g.fillRect(0,0, canvas.getWidth(), canvas.getHeight()); //fill the all image with a background color

        drawPicture(g);

        canvas.setOnMousePressed(e -> mousePressed(e));

        Pane root = new Pane(canvas);
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Check Board");
        stage.setResizable(false);
        stage.show();
    }
    int row;
    int col;
    double x, y;

    public void drawPicture(GraphicsContext g){
        for(row = 0; row < 8; row++){
            for(col = 0; col < 8; col++){
               x = 50*col;
               y = 50*row;
                if((row%2) == (col%2)){
                    g.setFill(Color.RED);
                }else{
                    g.setFill(Color.BLACK);
                }
                g.fillRect(x,y,50,50);
            }
        }
        draw();
    }//end of drawPicture

    public void mousePressed(MouseEvent evt){
      int col = (int)(evt.getX()/ 50); //Collum where user clicked.
      int row = (int)(evt.getY()/50); //Row where user clicked.

      if(selectedRow == row && selectedCol == col){
          //User clicked on the currently selected square.
          //Turn off the selection by setting selectedRow to -1.
          selectedRow = -1;
      }  else{
          //Change the selection to the square the user clicked on.
          selectedRow = row;
          selectedCol = col;
      }
        drawPicture(g);
    }

    public void draw(){
        int x,y; //Top-left corner of square

        if(selectedRow >= 0){
            //Since there is a selected square, draw a white
            //border around it. (if selectedRow < =, then
            //no square is selected and no border is drawn.)
            g.setStroke(Color.WHITE);
            g.setLineWidth(3);
            y = selectedRow * 50;
            x = selectedCol * 50;
            g.strokeRect(x+1.5, y+1.5, 47, 47);
        }
    }

}//end of class
