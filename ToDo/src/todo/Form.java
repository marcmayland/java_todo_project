/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author Maciej
 *
 */
public class Form {

    public Form() {

        final Stage primaryStage = new Stage();
        final Form form = this;


        /*
        *   Top line with buttons
         */
        Button closeButton = new Button("Cancel");
        closeButton.setBackground(Background.EMPTY);
        //closeButton.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 15));
        closeButton.setOnAction(e -> {

            primaryStage.close();
        });

        Button addButton = new Button("Save");
        addButton.setBackground(Background.EMPTY);
        //addButton.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 15));
        HBox hb = new HBox(addButton,  closeButton);

        /*TreeItem<Node> rootItem = new TreeItem<>(hb);
        rootItem.setExpanded(true);
        rootItem.expandedProperty().addListener(c -> {
            if(!rootItem.isExpanded()){
                rootItem.setExpanded(true);
            }
        });*/


        /*
        *   Main body V1
         */
        Label taskNameLabel = new Label(" Task's name:");
        Label taskRemarksLabel = new Label(" Remarks:");
        TextField taskNameIn = new TextField();
        TextArea taskRemarksIn = new TextArea();
        VBox vBox = new VBox(hb, taskNameLabel, taskNameIn, taskRemarksLabel, taskRemarksIn);


        /*
        *   Main body V2
        TextField taskNameIn = new TextField("insert task's name");
        TextArea taskRemarksIn = new TextArea("insert remarks");
        VBox vBox = new VBox(hb, taskNameIn, taskRemarksIn);
        */


        StackPane root = new StackPane(vBox);
        //root.getChildren().add(exitButton);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
}
