/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Data;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Abdullah
 */
public class TemperatureData {

    /**
     * @return the localDateTime
     */
    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    /**
     * @param localDateTime the localDateTime to set
     */
    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    /**
     * @return the isCelsius
     */
    public boolean isIsCelsius() {
        return isCelsius;
    }

    /**
     * @param isCelsius the isCelsius to set
     */
    public void setIsCelsius(boolean isCelsius) {
        this.isCelsius = isCelsius;
    }
    

    

    /**
     * @return the temperature
     */
    
    
    
    public void addPropertyChangeListener(PropertyChangeListener outsidePcl){
        this.pcl = outsidePcl;
    }
    
    public float getTemperature() {
        return temperature;
    }
    
    

    /**
     * @param temperature the temperature to set
     */
    public void setTemperature(float temperature) {
        localDateTime = now();
        float oldTemp = this.temperature;
        this.temperature = temperature;
        pcl.propertyChange(new PropertyChangeEvent(this, "Temperature", oldTemp, this.temperature));
        pcl.propertyChange(new PropertyChangeEvent(this, "feedback", "", toString()));
    }
    
    
    @Override
    public String toString(){
        String unit = "C";
        String feedback = "You are ok";
        DateTimeFormatter time = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String tm = localDateTime.format(time);
        if(isCelsius == false){
            unit = "F";
            this.temperature = (temperature-32)*5/9;
        }
        if(this.temperature > 37.9){
            feedback = "You should see a doctor";
        }
        return "Temperature " + this.temperature + unit + " @" + tm + " : " + feedback;
    }
    
    
    private float temperature;
    private boolean isCelsius = true;
    PropertyChangeListener pcl;
    private LocalDateTime localDateTime;
    
}

