package ass2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;

import javax.swing.*;

import ass2.models.*;

public class GoodRailUI extends JFrame {

	private TrainDisplay traindisplay = new TrainDisplay();
	private CommandInputDisplay commandInputDisplay = new CommandInputDisplay();
	private Commands commandHandler = new Commands();
	private JPanel command_panel = new JPanel();
	private TextField command_text_box = new TextField("", 40);
	private JButton command_button = new JButton("Execute");
	private JPanel main_panel = new JPanel();


	public static void main(String[] args)
	{
		GoodRailUI inst = new GoodRailUI();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	public GoodRailUI(){
		initGUI();
		Trainstation t = Trainstation.getInstance();
		t.registerObserver(t.getLoggerDisplay());
	}

	public void initGUI(){

		main_panel.setLayout(new BorderLayout());
		main_panel.setSize(new Dimension(800, 600));

		traindisplay.setPreferredSize(new Dimension(800, 300));
		Trainstation.getInstance().getLoggerDisplay().setPreferredSize(new Dimension(350, 200));
		commandInputDisplay.setPreferredSize(new Dimension(350, 200));
		command_panel.setPreferredSize(new Dimension(400, 100));

		command_panel.add(command_text_box);
		command_panel.add(command_button);

		command_button.addActionListener(e -> {
            if (!command_text_box.getText().isEmpty()) {
                String command = command_text_box.getText();
                commandHandler.parse(command);
                commandInputDisplay.update();
            }
        });

		main_panel.add(traindisplay, BorderLayout.NORTH);
		main_panel.add(Trainstation.getInstance().getLoggerDisplay(), BorderLayout.EAST);
		main_panel.add(commandInputDisplay, BorderLayout.WEST);
		main_panel.add(command_panel, BorderLayout.SOUTH);

		this.getContentPane().add(main_panel);

		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}


	}

