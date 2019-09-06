package main;

import java.util.ArrayList;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @Gorana Matuh
 */
public class Person {
    private final StringProperty firstName = new SimpleStringProperty(this, "firstName", "");
    private final StringProperty lastName = new SimpleStringProperty(this, "lastName", "");
    private final StringProperty address = new SimpleStringProperty(this, "address", "");
    
    public Person(){
    
    }
    
    public Person (String firstName, String lastName, String address){
        this.firstName.set(firstName);
        this.lastName.set(lastName);
        this.address.set(address);
    }
    
    public Person (String firstName){
    this.firstName.set(firstName);
    }
    
    public String getFirstName(){
    return firstName.get();
    }
    
    public void setFirstName (String firstName){
        this.firstName.set(firstName);
    }
    
    public StringProperty firstNameProperty(){
        return firstName;
    }
    
    public String getLastName(){
        return lastName.get();
    }
    
    public void setLastName(String lastName){
        this.lastName.set(lastName);
    }
    
    public StringProperty lastNameProperty(){
        return lastName;
    }
    
    public String getAddress()
    {
	return address.get();
    }

    public void setAddress(String address)
    {
	this.address.set(address);
    }

    public StringProperty addressProperty()
    {
	return address;
    }
    
    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<> (this, "errorList", new ArrayList<>());
    
    public ObjectProperty<ArrayList<String>> errorsProperty(){
        return errorList;
    }
    
    public boolean isValid(){
        boolean isValid = true;
        
        if(firstName.get() != null&& firstName.get().equals("")){
            errorList.getValue().add("Please enter first name!");
            isValid = false;
        }
        if(lastName.get().equals("")){
            errorList.getValue().add("Please enter last name!");
            isValid = false;
        }
        
        if(address.get().equals(""))
	{
	    errorList.getValue().add("Please enter address!");
	    isValid = false;
	}
        
        return isValid;
    }
}
