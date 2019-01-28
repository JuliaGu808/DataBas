/*
 * Java
 */
package upp2FX;

import java.util.ArrayList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Julia
 */
public class ProduktControlF {
    List<ColorF> colors;
    List<SizeF> sizes;
    GridPane grid = new GridPane();
    HBox colorBox = new HBox();
    HBox sizeBox = new HBox();
    HBox ortBox = new HBox();
    public VBox addVBox(List<ProduktF> produkt, String str){
        RepositoryF r = new RepositoryF();
        colors = r.showAllColor();
        sizes = r.showAllSize();
        VBox box = new VBox();
        box.setPadding(new Insets(10));
        box.setSpacing(8);
        Text title = new Text(str);
        title.setFont(Font.font("Aria", FontWeight.BOLD, 14));
        box.getChildren().add(title);
        List<RadioButton> rbtn = new ArrayList<>();
        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i<produkt.size(); i++){
            RadioButton b = new RadioButton(produkt.get(i).toString());
            b.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                RadioButton rb = (RadioButton) event.getSource();
                int temp = rb.getText().indexOf(",", 0);
                String s = rb.getText().substring(4, temp).trim();  
                int num = Integer.parseInt(s);
                AddColorF ac = new AddColorF();
                colors = ac.addCol(colors, num, "choose one color");
//                List<ColorF> colors = ac.addCol(r, num, "choose one color");
//                grid.getChildren().remove(colorBox);
//                
//                colorBox = ac.addBox();
                
                

//                List<Color> colors = r.showDemoColor(num);
//                colorBox = addVBoxP(colors, "choose one color");
//                grid.add(colorBox, 0, 1);
//                primaryStage.show();
                title.setText(num+"");
            }
        });
            b.setToggleGroup(group);
            rbtn.add(b);
        }
//            RadioButton testB = new RadioButton("new one");
//            testB.setOnAction(new EventHandler<ActionEvent>(){
//            @Override
//            public void handle(ActionEvent event) {
//                RadioButton rbt = (RadioButton) event.getSource();
//                String st = rbt.getText().trim();    
//                title.setText(st);
//            }
//        });
//            testB.setToggleGroup(group);
//            rbtn.add(testB);
        
        box.getChildren().addAll(rbtn);

        return box;
    
        
    }


}
