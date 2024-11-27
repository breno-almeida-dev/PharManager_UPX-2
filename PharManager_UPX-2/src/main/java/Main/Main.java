package Main;

import javax.swing.SwingUtilities;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


	public class Main extends Application {
	    @Override
	    public void start(Stage primaryStage) {
	        // Criando os componentes da interface
	        Label label = new Label("Bem-vindo ao JavaFX!");
	        Button button = new Button("Clique aqui");
	        button.setOnAction(event -> label.setText("Botão clicado!"));

	        // Configurando o layout
	        VBox layout = new VBox(10);
	        layout.getChildren().addAll(label, button);

	        // Criando a cena e configurando no palco (Stage)
	        Scene scene = new Scene(layout, 300, 200);
	        primaryStage.setScene(scene);

	        // Configurando o título e exibindo o palco
	        primaryStage.setTitle("Aplicação JavaFX");
	        primaryStage.show();
	    }
	public static void main(String[] args) {
		launch(args);
	}

}
