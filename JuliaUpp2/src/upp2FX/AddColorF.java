/*
 * Java
 */
package upp2FX;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

/**
 *
 * @author Julia
 */
public class AddColorF {
    private String title;
    private int colorId;
    private List<ColorF> colors = new ArrayList<>();
    public List<ColorF> addCol (List<ColorF> färg, int demoId, String title){
        this.title=title;
        colors = färg.stream().filter(c -> c.getDemoId()==demoId).collect(Collectors.toList());
        return colors;
    }
    public HBox addBox(){
        AddMap ap = new AddMap();
        Map mp = ap.changeMapC(colors);
        HBox box = new HBox();
        box.setPadding(new Insets(10));
        box.setSpacing(8);
        Text tit = new Text(title);
        tit.setFont(Font.font("Aria", FontWeight.BOLD, 14));
        box.getChildren().add(tit);
        List<RadioButton> rbtn = new ArrayList<>();
        ToggleGroup group = new ToggleGroup();
        for(int i = 0; i<colors.size(); i++){
            RadioButton b = new RadioButton(mp.get(colors.get(i).getFärgId()).toString());
            b.setOnAction(new EventHandler<ActionEvent>(){
            @Override
            public void handle(ActionEvent event) {
                RadioButton rb = (RadioButton) event.getSource();
                String s = rb.getText().trim();   
                tit.setText(s);
                colorId = ap.getId(mp, s);
            }
        });
            b.setToggleGroup(group);
            rbtn.add(b);
        }
        box.getChildren().addAll(rbtn);
        return box;        
    }
    public int getColorId(){
        return colorId;
    }
}
