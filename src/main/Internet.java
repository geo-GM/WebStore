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
public class Internet {
    
    private final StringProperty netFlow = new SimpleStringProperty(this, "netFlow", "");
    private final StringProperty netSpeed = new SimpleStringProperty(this, "netSpeed", "");
    
    public Internet(){
    
    }
    
    public Internet (String netFlow, String netSpeed){
        this.netFlow.set(netFlow);
        this.netSpeed.set(netSpeed);
    }
    
    public Internet (String netFlow){
    this.netFlow.set(netFlow);
    }
    
    public String getNetFlow(){
    return netFlow.get();
    }
    
    public void setNetFlow (String netFlow){
        this.netFlow.set(netFlow);
    }
    
    public StringProperty netFlowProperty(){
        return netFlow;
    }
    
    public String getNetSpeed(){
        return netSpeed.get();
    }
    
    public void setNetSpeed(String netSpeed){
        this.netSpeed.set(netSpeed);
    }
    
    public StringProperty netSpeedProperty(){
        return netSpeed;
    }
    
    private final ObjectProperty<ArrayList<String>> errorList = new SimpleObjectProperty<> (this, "errorList", new ArrayList<>());
    
    public ObjectProperty<ArrayList<String>> errorsProperty(){
        return errorList;
    }
    
    public boolean isValid(){
        boolean isValid = true;
        
        if(netFlow.get() != null&& netFlow.get().equals("")){
            errorList.getValue().add("You must choose value!");
            isValid = false;
        }
        if(netSpeed.get() != null&& netSpeed.get().equals("")){
            errorList.getValue().add("You must choose speed!");
            isValid = false;
        }
        
        return isValid;
    }
    
}
