package main;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;

/**
 *
 * @Gorana Matuh
 */
public class SaleController {
    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private TextField address;
    @FXML
    private ChoiceBox netFlow;
    @FXML
    private ChoiceBox netSpeed;
    
    
    @FXML
    private ToggleGroup contractDurration;
    @FXML
    private RadioButton one;
    @FXML
    private RadioButton two;

    @FXML
    private Button saveBtn;
    @FXML
    private Button clearBtn;
    @FXML
    private Button closeBtn;
    @FXML
    private Button deleteBtn;

    @FXML
    private URL location;
    @FXML
    private ResourceBundle resources;

    ObservableList<Sale> sales = FXCollections.<Sale>observableArrayList();
    Sale sale;
    
    ObservableList<Person> persons = FXCollections.<Person>observableArrayList();
    Person person;
    
    ObservableList<Internet> internets = FXCollections.<Internet>observableArrayList();
    Internet internet;

    @FXML//
    TableView<Sale> tabela = new TableView<>();//
    
    int contractID;
    
    public SaleController()
    {
    }
    
    @FXML
    private void initialize()
    {
	sale = new Sale();
        person = new Person();
        internet = new Internet();
        

	firstName.textProperty().bindBidirectional(person.firstNameProperty());
	lastName.textProperty().bindBidirectional(person.lastNameProperty());
	address.textProperty().bindBidirectional(person.addressProperty());

	netFlow.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
	{
            @Override
	    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue)
	    {
		if(newValue != null)
		{
                    netFlow.setValue(netFlow);

		}
	    }
	});
        
        netSpeed.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>()
	{
            @Override
	    public void changed(ObservableValue<? extends Number> observableValue, Number oldValue, Number newValue)
	    {
		if(newValue != null)
		{
                    sale.setNetSpeed(netSpeed.toString());

		}
	    }
	});
                }
    @FXML
    private void saveSale()
    {
	if(person.isValid())
        {
            sales = tabela.getItems();
            int id = 1;
            for (int i = 0; i<= sales.size(); i++){
                contractID = id++;
            }
            
            ToggleButton selected = (RadioButton) contractDurration.getSelectedToggle();
            switch(selected.getId())
	    {
		case "one":
		    sales.add(new Sale(one.getText(), contractID, firstName.getText(), lastName.getText(), address.getText(),(String) netFlow.getValue(), (String) netSpeed.getValue()));
		    break;
		case "two":
		    sales.add(new Sale(two.getText(), contractID, firstName.getText(), lastName.getText(), address.getText(),(String) netFlow.getValue(), (String) netSpeed.getValue()));
		    break;
	    }
            tabela.setItems(sales);
        }
	else
        {
            StringBuilder errMsg = new StringBuilder();
            StringBuilder errMsgs = new StringBuilder();
            
            ArrayList<String> errList = person.errorsProperty().get();
            ArrayList<String> errList2 = internet.errorsProperty().get();
            for(String errList1 : errList)
                errMsgs.append(errList1);
                for(String errList3:errList2)
                errMsg.append(errList3);
                
            
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Access denied!");
            alert.setHeaderText(null);
            alert.setContentText(errMsg.toString()+ errMsgs.toString());
            alert.showAndWait();
            errList.clear();
        }
    }

    @FXML
    private void closeForm()
    {
	Platform.exit();
    }

    @FXML
    private void clearSale()
    {
	person.firstNameProperty().set("");
	person.lastNameProperty().set("");
	person.addressProperty().set("");
        netSpeed.getSelectionModel().selectFirst();
        netFlow.getSelectionModel().selectFirst();
    }

    @FXML
    private void deleteSale()
    {
	sales = tabela.getItems();
	int index = tabela.selectionModelProperty().getValue().getSelectedIndex();
	sales.remove(index);
	tabela.setItems(sales);
    }
}
