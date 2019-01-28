/*
 * Java
 */
package upp2FX;

/**
 *
 * @author Julia
 */
public class ColorF {
    private int id;
    private int demoId;
    private int färgId;  
    private String name;
    public ColorF(int id, int demoId, int färgId, String name){
        this.id=id;
        this.demoId=demoId;
        this.färgId=färgId;
        this.name=name;
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
     * @return the färgId
     */
    public int getFärgId() {
        return färgId;
    }

    /**
     * @return the name
     */
    public String getName() {
        return färgId + "." + name;
    }
    @Override
    public String toString(){
        return färgId + ". färg " + name;
    }
    public void print(){
        System.out.println("id: " + id + "\tdemoId: " + demoId + "\tcolor: " + name);
    }
}
