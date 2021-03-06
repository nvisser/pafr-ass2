package ass2.models;

import java.awt.*;
import java.util.ArrayList;

import javax.swing.*;

public class TrainDisplay extends JPanel implements Observer{


    private int currentTrain=0;
    private int OFFSET=120;
    private int currentWagon = 0;


    public  TrainDisplay (){
        this.setLayout(new BorderLayout());
        this.setOpaque(true);
        this.setVisible(true);

        JTextArea txt2 = new JTextArea();
        txt2.setBackground(Color.WHITE);
        txt2.setForeground(Color.BLACK);
        txt2.setEditable(false);
        init();
    }



    private void init(){
        this.setLayout(new FlowLayout());
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setVisible(true);

    }

    @Override
    public void update() {
        currentTrain = 0;
        Trainstation s = Trainstation.getInstance();
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
        Graphics g = this.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        int TRAINLENGTH = 100;
        g.fillRect(30+currentWagon* TRAINLENGTH,80+currentTrain*OFFSET,80,40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(35+currentWagon* TRAINLENGTH, 120+currentTrain*OFFSET, 20, 20, 20, 20);
        g.fillRoundRect(80+currentWagon* TRAINLENGTH, 120+currentTrain*OFFSET, 20, 20, 20, 20);
        g.drawString(id,40+currentWagon* TRAINLENGTH,105+currentTrain*OFFSET);

    }

    private void drawtrain(String t) {
        Graphics g = this.getGraphics();
        g.setColor(Color.LIGHT_GRAY);
        g.fillRect(30,80+currentTrain*OFFSET,80,40);
        g.fillRect(80,60+currentTrain*OFFSET,30,30);
        g.drawRoundRect(85, 40+currentTrain*OFFSET, 20, 20, 20, 20);
        g.drawRoundRect(85, currentTrain*OFFSET, 40, 40, 40, 40);
        g.setColor(Color.BLACK);
        g.fillRoundRect(35, 120+currentTrain*OFFSET, 20, 20, 20, 20);
        g.fillRoundRect(80, 120+currentTrain*OFFSET, 20, 20, 20, 20);
        g.drawString(t, 40, 105 + currentTrain*OFFSET);


    }


}