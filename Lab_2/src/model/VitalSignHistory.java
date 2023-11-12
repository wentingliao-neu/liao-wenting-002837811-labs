<<<<<<< HEAD
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author lwt
 */
public class VitalSignHistory {
    private ArrayList<VitalSigns>history;
    
    public VitalSignHistory(){
        this.history=new ArrayList<VitalSigns>();
    }

    public ArrayList<VitalSigns> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<VitalSigns> history) {
        this.history = history;
    }
    public VitalSigns addNewVital(){
        VitalSigns newVitals=new VitalSigns();
        history.add(newVitals);
        return newVitals;
    }

    public void deleteVitals(VitalSigns vs) {
        history.remove(vs); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
=======
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.util.ArrayList;
/**
 *
 * @author lwt
 */
public class VitalSignHistory {
    private ArrayList<VitalSigns>history;
    
    public VitalSignHistory(){
        this.history=new ArrayList<VitalSigns>();
    }

    public ArrayList<VitalSigns> getHistory() {
        return history;
    }

    public void setHistory(ArrayList<VitalSigns> history) {
        this.history = history;
    }
    public VitalSigns addNewVital(){
        VitalSigns newVitals=new VitalSigns();
        history.add(newVitals);
        return newVitals;
    }

    public void deleteVitals(VitalSigns vs) {
        history.remove(vs); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
>>>>>>> 36ef859345c6d4b61d0c6dcf1ba29875d0ffb3f4
