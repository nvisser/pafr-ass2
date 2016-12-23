package ass2.models;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;


@SuppressWarnings("serial")
public class TrainDisplay extends JPanel implements Observer{



    private JTextArea txt2 = new JTextArea();
    private JScrollPane jsp = new JScrollPane();
    private int currentTrain=0;
    private int OFFSET=120;
    private int currentWagon = 0;
    private int TRAINLENGTH = 100;





    public  TrainDisplay (){
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setVisible(true);

        txt2.setBackground(Color.BLACK);
        txt2.setForeground(Color.WHITE);
        jsp.setBackground(Color.BLACK);
        jsp.setForeground(Color.WHITE);
        jsp.setPreferredSize(new Dimension(350, 185));
        txt2.setEditable(false);
        jsp.getViewport().add(txt2);
        this.add(jsp, BorderLayout.NORTH);

    }

    @Override
    public void update() {
        currentTrain = 0;
        Trainstation s =Trainstation.getInstance();
        ArrayList<Train> trains = s.getTrainList();

        for (Train t : trains){
            drawtrain(t.getId());
            currentWagon = 1;
            for (Wagon w: t.getWagonList()){
                drawWagon(w.getId());
                currentWagon++;
            }
            currentTrain++;
        }


        }

    private void drawWagon(String id) {

        txt2.append("WAGON" + " " + id);

    }

    public void drawtrain(String t) {

        txt2.append("TRAIN " + t + "\n");




    }


}