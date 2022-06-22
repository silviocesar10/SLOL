/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package edu.ifes.ci.si.les.slol.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import edu.ifes.ci.si.les.slol.model.Cliente;
import edu.ifes.ci.si.les.slol.services.ClienteService;


/**
 * FXML Controller class
 *
 * @author silvio
 */
public class FXMLAnchorPaneCadastrosClienteDialogController implements Initializable {

    @FXML
    private Button buttonConfirmar;
    @FXML
    private Button buttonCancelar;
    @FXML
    private Label labelClienteId;
    @FXML
    private Label labelClienteNome;
    @FXML
    private Label labelClienteTelefone;
    @FXML
    private Label labelClienteDataNascimento;
    @FXML
    private Label labelClienteCidade;
    @FXML
    private Label labelClienteRua;
    @FXML
    private Label labelClienteBairro;
    @FXML
    private Label labelClienteCPf;
    
    @FXML
    private TextField textFieldClienteSigla;
    @FXML
    private TextField textFieldClienteNome;
    
    private Stage dialogStage;
    private boolean buttonConfirmarClicked = false;
    private Cliente cliente;
    private ClienteService service = new ClienteService();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        buttonCancelar.setCancelButton(true);
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    
    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        if(cliente.getIdPessoa() != null){
        	this.labelClienteId.setText(cliente.getIdPessoa().toString());
        }else{
        	this.labelClienteId.setText("");
                //this.textFieldClienteSigla.setText(cliente.getSigla());
                this.textFieldClienteNome.setText(cliente.getNome());
        }
    }
    

    public boolean isButtonConfirmarClicked() {
        return buttonConfirmarClicked;
    }

    @FXML
    public void handleButtonConfirmar() {
        if (validarEntradaDeDados()) {
        	if(labelClienteId.getText() != "")
        		cliente.setIdPessoa(Integer.parseInt(labelClienteId.getText()));
        	else
        		cliente.setIdPessoa(0);
            //cliente.setSigla(textFieldClienteSigla.getText());
            cliente.setNome(textFieldClienteNome.getText());
            buttonConfirmarClicked = true;
            dialogStage.close();
        }
    }

    @FXML
    public void handleButtonCancelar() {
        dialogStage.close();
    }

    //Validar entrada de dados para o cadastro
    private boolean validarEntradaDeDados() {
        String errorMessage = "";

        if (textFieldClienteSigla.getText() == null || textFieldClienteSigla.getText().length() == 0) {
            errorMessage += "Sigla inválida!\n";
        }
        if (textFieldClienteNome.getText() == null || textFieldClienteNome.getText().length() == 0) {
            errorMessage += "Nome inválido!\n";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Mostrando a mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Campos inválidos, por favor, corrija...");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
    
}
