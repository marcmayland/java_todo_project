/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package todo;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Scanner;
import javafx.scene.layout.Background;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 *
 * @author liljom
 */
public class ToDo extends Application{

    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage){

        Button closeButton = new Button("Close");
        closeButton.setBackground(Background.EMPTY);
        closeButton.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 15));
        closeButton.setOnAction(e -> {
            primaryStage.close();
        });

        Button addButton = new Button("Add");
        addButton.setBackground(Background.EMPTY);
        addButton.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 15));
        addButton.setOnAction(e -> {
            new Form();
        });

        Button deleteButton = new Button("Delete");
        deleteButton.setBackground(Background.EMPTY);
        deleteButton.setFont(Font.font(STYLESHEET_MODENA, FontWeight.BOLD, 15));

        HBox hb = new HBox(addButton, deleteButton, closeButton);

        TreeItem<Node> rootItem = new TreeItem<>(hb);
        rootItem.setExpanded(true);
        rootItem.expandedProperty().addListener(c -> {
            if(!rootItem.isExpanded()){
                rootItem.setExpanded(true);
            }
        });

        ArrayList<String> strings = new ArrayList<String>();

        TreeView<Node> tree = new TreeView<Node> (rootItem);
        tree.setMinWidth(350);
        tree.setShowRoot(false);

        for (int i = 0; i < 10; i++) {

            strings.add("task " + i + "|" + "remarks " + i);     //generating sample text, remove after having data

            Scanner sc = new Scanner(strings.get(i));
            sc.useDelimiter("[|]");

            TreeItem ti = new TreeItem(sc.next());
            rootItem.getChildren().add(i, ti);

            if(sc.hasNext() && i%2 == 0){
                TreeItem ti1 = new TreeItem(sc.next());
                ti.getChildren().add(ti1);
            }
        }

        VBox vb = new VBox(hb, tree);

        Pane pane = new Pane(vb);
        primaryStage.setScene(new Scene(pane));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

}
