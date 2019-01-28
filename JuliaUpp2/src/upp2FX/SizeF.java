/*
 * Java
 */
package upp2FX;

/**
 *
 * @author Julia
 */
public class SizeF {
    private int id;
    private int demoId;
    private int storlekId;  
    private double size;
    public SizeF(int id, int demoId, int storlekId, double size){
        this.id=id;
        this.demoId=demoId;
        this.storlekId=storlekId;
        this.size=size;
    }    

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @return the demoId
     */
    public int getDemoId() {
        return demoId;
    }

    /**
     * @return the storlekId
     */
    public int getStorlekId() {
        return storlekId;
    }

    /**
     * @return the size
     */
    public double getSize() {
        return size;
    }
    @Override
    public String toString(){
        return storlekId + ". storlek " + size;
    }
    public void print(){
        System.out.println("id: " + id + "\tdemoId: " + demoId + "\tsize: " + size);
    }
}
