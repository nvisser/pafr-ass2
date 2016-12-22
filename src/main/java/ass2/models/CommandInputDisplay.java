package ass2.models;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class CommandInputDisplay extends JPanel implements Observer {
    private JTextArea txt1 = new JTextArea();
    public CommandInputDisplay(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setVisible(true);
        txt1.setEditable(false);
        this.add(txt1, BorderLayout.NORTH);

    }

    @Override
    public void update() {

    }

}
