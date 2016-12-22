package ass2.models;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.Dimension;
import java.util.Collections;
import javax.swing.JScrollPane;

public class LoggerDisplay extends JPanel implements Observer {
    private JTextArea txt1 = new JTextArea();
    private JScrollPane jsp = new JScrollPane();

    public LoggerDisplay() {
        this.setLayout(new BorderLayout());
        this.setBackground(Color.BLACK);
        this.setOpaque(true);
        this.setVisible(true);

        txt1.setBackground(Color.BLACK);
        txt1.setForeground(Color.WHITE);
        jsp.setBackground(Color.BLACK);
        jsp.setForeground(Color.WHITE);
        jsp.setPreferredSize(new Dimension(350, 185));
        txt1.setEditable(false);
        jsp.getViewport().add(txt1);
        this.add(jsp, BorderLayout.NORTH);


    }

    @Override
    public void update() {
        Logger logger = new Logger();
        txt1.setText("");
        ArrayList<String> allLogs = logger.getLogcommands();
        for (String log : allLogs) {
            txt1.setText(txt1.getText() + log.toString() + "\n");
        }

        }
    }

