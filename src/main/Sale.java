
package main;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @Gorana Matuh
 */
public class Sale {
    private final StringProperty contractDurration = new SimpleStringProperty(this, "contractDurration", "");
    private final IntegerProperty contractID = new SimpleIntegerProperty(1);
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty address = new SimpleStringProperty(this, "address", "");
    private final StringProperty netFlow = new SimpleStringProperty(this, "netFlow", "");
    private final StringProperty netSpeed = new SimpleStringProperty(this, "netSpeed", "");
    
   
    //private final ObjectProperty<Person> person = new SimpleObjectProperty(this, "person", "");
    //private final ObjectProperty<Internet> internet = new SimpleObjectProperty(this, "internet", "");
   
    Person person = new Person();
    Internet internet = new Internet();
    public Sale(){
    
    }
    public Sale (String contractDurration, int contractID, String firstName,String lastName, String address, String netFlow, String netSpeed){
        this.contractDurration.set(contractDurration);
        this.contractID.set(contractID);
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.address.set(address);
        this.netFlow.set(netFlow);
        this.netSpeed.set(netSpeed);
    }

    
    public String getContractDurration(){
        return contractDurration.get();
    }
    
    public void setContractDurration(String contractDurration){
        this.contractDurration.set(contractDurration);
    }
    
    public StringProperty contractDurrationProperty(){
        return contractDurration;
    }
    
    public Integer getContractID(){
        return contractID.get();
    }
    
    public void setContractID(Integer contractID){
        this.contractID.set(contractID);
    }
    
    public IntegerProperty contractIDProperty(){
        return contractID;
    }
    
    public String getFirstName(){
        return firstName.get();        
    }
    
    public void setFirstName(String firstName){
        this.firstName.set(firstName);
    }
    public String getLastName(){
        return lastName.get();        
    }
    
    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }
    public String getAddress(){
        return address.get();        
    }
    
    public void setAddress(String address){
        this.address.set(address);
    }
    
    public Person personProperty(){
        return person;
    }
    
    public String getNetSpeed(){
        return netSpeed.get();
    }
    
    public void setNetSpeed(String netSpeed){
        this.netSpeed.set(netSpeed);
    }
    public String getNetFlow(){
        return netFlow.get();        
    }
    
    public void setNetFlow(String netFlow){
        this.netFlow.set(netFlow);
    }
}
