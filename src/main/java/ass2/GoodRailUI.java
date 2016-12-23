package ass2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import ass2.models.*;

public class GoodRailUI extends JFrame implements ActionListener{

	private TrainDisplay traindisplay = new TrainDisplay();
	private LoggerDisplay loggerDisplay = new LoggerDisplay();
	private CommandInputDisplay commandInputDisplay = new CommandInputDisplay();
	private Commands commandHandler = new Commands();
	private JPanel command_panel = new JPanel();
	private TextField command_text_box = new TextField("", 40);
	private JButton command_button = new JButton("Execute");
	private JPanel main_panel = new JPanel();

	public GoodRailUI(){
		initGUI();
		Trainstation.getInstance(traindisplay, commandInputDisplay, loggerDisplay);
		Trainstation.getInstance().registerObserver(loggerDisplay);
		Trainstation.getInstance().registerObserver(commandInputDisplay);
		Trainstation.getInstance().registerObserver(traindisplay);
	}

	public static void main(String[] args)
	{
		GoodRailUI inst = new GoodRailUI();
		inst.setLocationRelativeTo(null);
		inst.setVisible(true);
	}

	public void initGUI(){

		main_panel.setLayout(new BorderLayout());
		main_panel.setSize(new Dimension(800, 600));

		traindisplay.setPreferredSize(new Dimension(800, 300));
		loggerDisplay.setPreferredSize(new Dimension(350, 200));
		commandInputDisplay.setPreferredSize(new Dimension(350, 200));
		command_panel.setPreferredSize(new Dimension(400, 100));

		command_panel.add(command_text_box);
		command_panel.add(command_button);

		command_button.addActionListener(this);

		main_panel.add(traindisplay, BorderLayout.NORTH);
		main_panel.add(loggerDisplay, BorderLayout.EAST);
		main_panel.add(commandInputDisplay, BorderLayout.WEST);
		main_panel.add(command_panel, BorderLayout.SOUTH);

		this.getContentPane().add(main_panel);

		this.setSize(800, 600);
		this.setVisible(true);
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

	}

	public void actionPerformed(ActionEvent e){
		if (!command_text_box.getText().isEmpty())
		{
			String command = command_text_box.getText();
			commandHandler.parse(command);
		}
	}
}
