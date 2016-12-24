package ass2.models;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTextArea;


public class CommandInputDisplay extends JPanel implements Observer {
    private JTextArea txt1 = new JTextArea();
    public CommandInputDisplay(){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.WHITE);
        this.setForeground(Color.BLACK);
        this.setOpaque(true);
        this.setVisible(true);
        txt1.setEditable(false);
        this.add(txt1, BorderLayout.NORTH);

    }

    public void update() {
        Trainstation t = Trainstation.getInstance();
        ArrayList<Train> trains = t.getTrainList();
        ArrayList<Wagon> wagons = t.getWagonList();
        txt1.setText("Wagons:\n");
        for (Wagon wagon : wagons){

            txt1.setText(txt1.getText()+"("+wagon.getId()+" : "+wagon.getSeats()+")  ");
        }

        txt1.setText(txt1.getText()+"\nTrains:\n");
        for (Train train : trains){

            ArrayList<Wagon> train_wagons = train.getWagonList();
            txt1.setText(txt1.getText()+"("+train.getId()+")");
            for(Wagon wagon : train_wagons){
                txt1.setText(txt1.getText()+"-("+wagon.getId()+") ");
            }
            txt1.setText(txt1.getText()+"\n");
        }

    }
}


