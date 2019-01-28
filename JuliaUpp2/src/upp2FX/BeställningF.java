/*
 * Java
 */
package upp2FX;

import java.sql.Date;

/**
 *
 * @author Julia
 */
class BeställningF {
    private int id;
    private int kundId;
    private int produktId;
    private int ortId;
    private Date datum;
    private boolean skickad;
    
    public BeställningF(int id, int kundId, int produktId, int ordId, Date datum, boolean skickad){
        this.id=id;
        this.kundId=kundId;
        this.produktId=produktId;
        this.ortId=ortId;
        this.datum=datum;
        this.skickad=skickad;
    }
    public BeställningF(){}

    public int getKundId() {
        return kundId;
    }

    public void setKundId(int kundId) {
        this.kundId = kundId;
    }

    public int getOrtId() {
        return ortId;
    }

    public void setOrtId(int ortId) {
        this.ortId = ortId;
    }

    
    public boolean isSkickad() {
        return skickad;
    }

    public void setSkickad(boolean skickad) {
        this.skickad = skickad;
    }
    
    public void print(){
        System.out.println("beställningId: "+getId()+ "\tkundId: " + kundId + 
                " \tproduktId: " + produktId + "\tortId: " + ortId + 
                " \tdatum: "+datum+" \tskickad: "+skickad + " \n");
    }
    public String getInfo(){
        return "Id: "+getId()+ " \tproduktId: " + produktId + " \tdatum: "+datum+" \tskickad: "+skickad + " \n";
    }
    @Override
    public String toString(){
        return "Id: "+getId()+", \tdatum: "+datum+" \tskickad: "+skickad + " \n";
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    
}
