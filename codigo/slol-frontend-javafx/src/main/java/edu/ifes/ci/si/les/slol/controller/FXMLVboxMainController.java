/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.ifes.ci.si.les.slol.controller;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;


/**
 * FXML Controller class
 *
 * @author silvio
 */
public class FXMLVboxMainController implements Initializable {

   @FXML
    private AnchorPane anchorPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    public void handleMenuItemCadastrosLivro() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/slol/view/FXMLAnchorPaneCadastrosUFs.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    public void handleMenuItemCadastrosCategoriaLivro() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/slol/view/FXMLAnchorPaneCadastrosUFs.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    public void handleMenuItemCadastrosCliente() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/slol/view/FXMLAnchorPaneCadastrosUFs.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    
    public void handleMenuItemProcessosEmprestimos() throws IOException {
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/slol/view/FXMLAnchorPaneProcessosEmprestimos.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    public void handleMenuItemRelatoriosEmprestimosPorClientePeriodo() throws IOException {
    	AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/slol/view/FXMLAnchorPaneRelatoriosEmprestimosPorClientePeriodo.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    public void handleMenuItemRelatoriosEmprestimosPorClienteTotalQuantidade() throws IOException {
    	AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getResource("/edu/ifes/ci/si/les/slol/view/FXMLAnchorPaneRelatoriosEmprestimosPorClienteTotalQuantidade.fxml"));
        anchorPane.getChildren().setAll(a);
    }

    
}
