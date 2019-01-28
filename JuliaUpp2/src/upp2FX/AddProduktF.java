/*
 * Java
 */
package upp2FX;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

/**
 *
 * @author Julia
 */
public class AddProduktF {
    private List<BeställningF> beställningar = new ArrayList<>();
    private int num;
    public AddProduktF(List<BeställningF> beställningar, int num){
        this.beställningar=beställningar;
        this.num=num;
    }

    public List<BeställningF> addPro() {
        List<BeställningF> temp = new ArrayList<>();
        for(int i = 0; i<beställningar.size(); i++){
            if(beställningar.get(i).getId()==num && 
                    beställningar.get(i).isSkickad()==false){
                temp.add(beställningar.get(i));
            }
        }
        return temp;
    }
}
