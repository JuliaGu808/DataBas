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
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Julia
 */
public class AddSizeF {
    private String title;
    private List<SizeF> sizes = new ArrayList<>();
    
    public List<SizeF> addSize (List<SizeF> size, int demoId, String title){
        this.title=title;
        for(SizeF c: size){
            if(c.getDemoId()==demoId){
                sizes.add(c);
            }
        }
        return sizes;
    }
    public HBox addBox(){
        HBox box = new HBox();
        box.setPadding(new Insets(10));
        box.setSpacing(8);
        Text tit = new Text(title+"");
        tit.setFont(Font.font("Aria", FontWeight.BOLD, 14));
        box.getChildren().add(tit);
        List<RadioButton> rbtn = new ArrayList<>();
        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i<sizes.size(); i++){
            RadioButton b = new RadioButton(sizes.get(i).toString());
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
}
