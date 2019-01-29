/*
 * Java
 */
package upp2FX;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TouchEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 *
 * @author Julia
 */
public class BeställFX extends Application {
    private static String name;
    private static int id;
    private List<ColorF> colors = new ArrayList<>();
    private List<SizeF> sizes = new ArrayList<>();
    private List<OrtF> orter = new ArrayList<>();
    private List<BeställningF> beställningar = new ArrayList<>();
    private List<BeställningF> validBeställ = new ArrayList<>();
    VBox beställerBox = new VBox();
    VBox produkterBox = new VBox();
    HBox colorBox = new HBox();
    HBox sizeBox = new HBox();
    HBox ortBox = new HBox();
    Text produktInfo = new Text();
    Text extraInfo = new Text();
    Button btn = new Button("Add to Cart");
    GridPane grid = new GridPane();
    BorderPane border = new BorderPane();

    @Override
    public void start(Stage primaryStage) {
        grid.setHgap(20);
        grid.setVgap(10);
        grid.setPadding(new Insets(0,10,0,10));
        RepositoryF r = new RepositoryF();
        colors = r.showAllColor();
        sizes = r.showAllSize();
        orter = r.showAllOrt();
        ProduktRepo pr = new ProduktRepo();
        List<ProduktF> produkter = pr.showAllProdukt();
        produkterBox = addVBoxP(produkter, "choose one produkt");
        Text titC = new Text("choose color");
        titC.setFont(Font.font("Aria", FontWeight.BOLD, 14));
        colorBox.getChildren().add(titC);
        Text titS = new Text("choose size");
        titS.setFont(Font.font("Aria", FontWeight.BOLD, 14));
        sizeBox.getChildren().add(titS);
        BeställRepo br = new BeställRepo();
        beställningar = br.showAllBeställ();
        BeställControlF bc = new BeställControlF();
        validBeställ = bc.showValidBeställ(beställningar,id);
        beställerBox = addVBoxB(validBeställ, "choose one beställning");
        ortBox = addBoxO("choose one place");
        ortBox.setVisible(false);
        grid.add(produkterBox, 0, 0);
        grid.add(beställerBox, 3, 0);
        grid.add(ortBox, 0, 1, 2, 1);
        grid.add(colorBox, 0, 2, 2, 1);
        grid.add(sizeBox, 0, 3, 2, 1);
        grid.add(produktInfo, 3, 1, 1, 2);
        grid.add(extraInfo, 3, 3, 1,1);
        grid.add(btn, 1, 4, 2, 1);
        StackPane root = new StackPane();
        border.setCenter(grid);
        root.getChildren().add(border);
        Scene scene = new Scene(root, 1000, 500);
        primaryStage.setTitle(name + " beställningar!");
        primaryStage.setScene(scene);
        primaryStage.show();
        btn.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {   
                extraInfo.setVisible(true);
                int demoId = 0;
                int beställId = 0;
                Text ps =(Text) produkterBox.getChildren().get(0);
                Text bs =(Text) beställerBox.getChildren().get(0);
                Text ortname =(Text) ortBox.getChildren().get(0);
                Text colorname = (Text) colorBox.getChildren().get(0);
                Text sizename = (Text) sizeBox.getChildren().get(0);
                int ortint=2, colorint=1, sizeint=5;
                try{
                    demoId = Integer.parseInt(ps.getText().trim());
                }
                catch(Exception e){
                    demoId = 0;
                    extraInfo.setText("choose one produkt");
                }
                try{
                    beställId = Integer.parseInt(bs.getText().trim());
                    if(demoId != 0 ){
                        if(colorname.getText().startsWith("choose")) colorint=1;
                            else{
                                int colorii = colorname.getText().indexOf(".");
                                String colorstr = colorname.getText().substring(0, colorii);
                                colorint = Integer.parseInt(colorstr);
                            }
                            if(sizename.getText().startsWith("choose")) sizeint=5;
                            else{
                                int sizeii = sizename.getText().indexOf(".");
                                String sizestr = sizename.getText().substring(0, sizeii);
                                sizeint = Integer.parseInt(sizestr);
                            }
                        if(colorint==1 && sizeint==5) 
                            r.callAddToCart(id, beställId, demoId);
                        else
                            r.callAddToCart2(id, beställId, demoId, ortint, colorint, sizeint);
                        try {
                            Thread.sleep(2000);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(AddProduktF.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        System.exit(0);
                    }
                    else{
                        extraInfo.setText("choose one produkt");
                    }
                }
                catch(Exception e){
                    if(demoId != 0){
                        if(bs.getText().startsWith("new")){
                            beställId = 0;
                            if(ortname.getText().startsWith("choose")) ortint=2;
                            else{
                                int ortii = ortname.getText().indexOf(".");
                                String ortstr = ortname.getText().substring(0, ortii);
                                ortint = Integer.parseInt(ortstr);
                            }
                            if(colorname.getText().startsWith("choose")) colorint=1;
                            else{
                                int colorii = colorname.getText().indexOf(".");
                                String colorstr = colorname.getText().substring(0, colorii);
                                colorint = Integer.parseInt(colorstr);
                            }
                            if(sizename.getText().startsWith("choose")) sizeint=5;
                            else{
                                int sizeii = sizename.getText().indexOf(".");
                                String sizestr = sizename.getText().substring(0, sizeii);
                                sizeint = Integer.parseInt(sizestr);
                            }
                            if(ortint==2 && colorint==1 && sizeint==5) {
                                r.callAddToCart(id, beställId, demoId);
                            }
                            else{
                                r.callAddToCart2(id, beställId, demoId, ortint, colorint, sizeint);
                            }
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException ex) {
                                Logger.getLogger(AddProduktF.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            System.exit(0);
                        }
                        else{
                            extraInfo.setText("choose one beställning");
                        }
                    }
                    else{
                        if(bs.getText().trim().startsWith("new")) extraInfo.setText("choose one produkt");
                        else extraInfo.setText("choose one produkt och one beställning");
                    }
                }
            }
        });
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        name = args[0];
        id = Integer.parseInt(args[1].trim());
        launch();
    }
    public VBox addVBoxP(List<ProduktF> produkt, String str){
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        box.setSpacing(8);
        Text title = new Text(str);
        title.setFont(Font.font("Aria", FontWeight.BOLD, 14));
        box.getChildren().add(title);
        List<RadioButton> rbtn = new ArrayList<>();
        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i<produkt.size(); i++){
            if(produkt.get(i).getTotal() > 0){              
                RadioButton b = new RadioButton(produkt.get(i).toString());
                b.setOnAction(new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent event) {
                        extraInfo.setVisible(false);
                        RadioButton rb = (RadioButton) event.getSource();
                        int temp = rb.getText().indexOf(",", 0);
                        String s = rb.getText().substring(4, temp).trim();  
                        int num = Integer.parseInt(s);
                        AddColorF ac = new AddColorF();
                        List<ColorF> färg = ac.addCol(colors, num, "choose one color");
                        grid.getChildren().remove(colorBox);
                        colorBox = ac.addBox();
                        grid.add(colorBox, 0, 2, 2, 1);
                        AddSizeF as = new AddSizeF();
                        List<SizeF> storlek = as.addSize(sizes, num, "choose one size");
                        grid.getChildren().remove(sizeBox);
                        sizeBox = as.addBox();
                        grid.add(sizeBox, 0, 3, 2, 1);
                        title.setText(num+"");
                    }
                });
                b.setToggleGroup(group);
                rbtn.add(b);
            }
        }
        box.getChildren().addAll(rbtn);
        return box;
    } 
    public HBox addBoxO(String title){
        HBox box = new HBox();
        box.setPadding(new Insets(10));
        box.setSpacing(8);
        Text tit = new Text(title);
        tit.setFont(Font.font("Aria", FontWeight.BOLD, 14));
        box.getChildren().add(tit);
        List<RadioButton> rbtn = new ArrayList<>();
        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i<orter.size(); i++){
            RadioButton b = new RadioButton(orter.get(i).toString());
            b.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                RadioButton rb = (RadioButton) event.getSource();
                String s = rb.getText().trim();   
                tit.setText(s);
                }
            });
            b.setToggleGroup(group);
            rbtn.add(b);
        }
        box.getChildren().addAll(rbtn);
        return box;
    }
    public VBox addVBoxB(List<BeställningF> beställ, String str){
    VBox box = new VBox();
    box.setPadding(new Insets(10));
    box.setSpacing(8);
    Text title = new Text(str);
    title.setFont(Font.font("Aria", FontWeight.BOLD, 14));
    box.getChildren().add(title);
    List<RadioButton> rbtn = new ArrayList<>();
    ToggleGroup group = new ToggleGroup();
    for(int i = 0; i<beställ.size(); i++){
        if(beställ.get(i).isSkickad()==false){
            RadioButton b = new RadioButton(beställ.get(i).toString());
            b.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                extraInfo.setVisible(false);
                RadioButton rb = (RadioButton) event.getSource();
                int temp = rb.getText().indexOf(",", 0);
                String s = rb.getText().substring(4, temp).trim();  
                int num = Integer.parseInt(s);
                AddProduktF af = new AddProduktF(beställningar, num);
                List<BeställningF> produkts = af.addPro();
                String strPro = "";
                for(BeställningF b: produkts){
                    strPro = strPro + b.getInfo();
                }
                produktInfo.setText(strPro);
                produktInfo.setVisible(true);
                title.setText(num+"");
                ortBox.setVisible(false);
                }
            });
            b.setToggleGroup(group);
            rbtn.add(b);
        }
    }
        RadioButton testB = new RadioButton("new beställning");
        testB.setOnAction(new EventHandler<ActionEvent>(){
        @Override
        public void handle(ActionEvent event) {
            extraInfo.setVisible(false);
            RadioButton rbt = (RadioButton) event.getSource();
            String st = rbt.getText().trim();    
            title.setText(st);
            ortBox.setVisible(true);
            produktInfo.setVisible(false);
        }
    });
        testB.setToggleGroup(group);
        rbtn.add(testB);
    box.getChildren().addAll(rbtn);
    return box;        
    }
}
