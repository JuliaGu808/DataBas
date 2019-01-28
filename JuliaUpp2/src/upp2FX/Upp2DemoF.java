/*
 * Java
 */

package upp2FX;

import java.util.List;
import javax.swing.*;


public class Upp2DemoF {
    public Upp2DemoF(){
       KundRepo r = new KundRepo();
       KundControlF kf = new KundControlF(r.showAllKund());
       String s = JOptionPane.showInputDialog("Your förnamn ?");
       if(s == null || s.trim().equals("")){
           System.exit(0);
       }
       else if(kf.checkFörNamn(s)){
           String[] args = new String[2];
           args[0] = kf.getKundName(s);
           args[1] = kf.getKundId(s)+"";
           BeställFX.main(args);
       }
       else System.out.println("check your name please!");
    }

    
    public static void main(String[] args) {
        Upp2DemoF körVi = new Upp2DemoF();
//       List<KundF> kunder = r.showAllKund();
//       String s = JOptionPane.showInputDialog("Your förnamn ?");
//       if(kunder != null){    
//           String name="";
////           String validBeställ="";
//           for(KundF k : kunder){
//               if(k.getFörnamn().equalsIgnoreCase(s)){
//                   name=k.getFörnamn();
//                   r.showAllProdukt(name).forEach((c -> c.print()));
//               }
//           }
////           List<Beställning> beställ = r.showValidBeställ(name);
////           for(Beställning b: beställ){
////               validBeställ = validBeställ + b.print();
////           }
////           JOptionPane.showMessageDialog(null, validBeställ);
//        
//           AddProduktF ap = new AddProduktF(name);
//           
//       }
//       r.showAllKund().forEach(c -> c.print());
//       int id = r.kundId("Peter");
//        System.out.println(id);
//       int prodid = r.produktId(2);
//        System.out.println(prodid);
//       r.showAllProdukt("Peter").forEach(c -> c.print());
//       r.showValidBeställ("Cindy").forEach(c -> c.print());
//       r.callAddToCart(2, 7, 2);
//       r.callAddToCart(2, 8, 6);
    }

    /**
     * @return the r
     */

    

}
