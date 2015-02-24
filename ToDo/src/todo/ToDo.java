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
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;
import java.util.Scanner;

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

        Button closeButton = new Button("X");
        Button addButton = new Button("+");
        //Label label = new Label("ToDo");
        HBox hb = new HBox(addButton,  closeButton);
        //label.setAlignment(Pos.TOP_CENTER);
        closeButton.setAlignment(Pos.TOP_RIGHT);

        closeButton.setOnAction(e -> {

            primaryStage.close();
        });

        TreeItem<Node> rootItem = new TreeItem<>(hb);
        rootItem.setExpanded(true);
        rootItem.expandedProperty().addListener(c -> {
            if(!rootItem.isExpanded()){
                rootItem.setExpanded(true);
            }
        });
        ArrayList<String> strings = new ArrayList<String>();

        for (int i = 0; i < 10; i++) {

            strings.add("task " + i + "|" + "remarks " + i);     //generating sample text, remove after having data

            Scanner sc = new Scanner(strings.get(i));
            sc.useDelimiter("[|]");

            TreeItem ti = new TreeItem(sc.next());
            rootItem.getChildren().add(i, ti);

            if(sc.hasNext()){
                TreeItem ti1 = new TreeItem(sc.next());
                ti.getChildren().add(ti1);
            }
        }

        TreeView<Node> tree = new TreeView<Node> (rootItem);
        tree.setMinWidth(350);

        Pane pane = new Pane(tree);
        primaryStage.setScene(new Scene(pane));
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }
    
}
