import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComponent;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;
/**
 * Slide Controller class 
 * @author ReginaYe
 *
 */
public class SlideController extends JPanel implements ActionListener {
	JTextField text;
	JTextField time;
	JPanel displayPanel;
	Slide[] array;
	BinaryHeap heap;
	PriorityQueue sq;
	protected int tIME = 0;
	TimerDemo timer = new TimerDemo();
	ActionListener listener;
	JButton addBtn;
	JButton showBtn;

	/**
	 * constructor for slide controller 
	 */
	public SlideController() {
		initGUI();
		sq = new PriorityQueueBH(10);
	}

	/**
	 * initialize GUI
	 */
	public void initGUI() {
		this.setLayout(new BorderLayout());
		this.add((Component) this.userInputPanel(), "North");
		this.add((Component) this.buttonPanel(), "East");
		this.add((Component) this.displayPanel(), "Center");
	}

	/**
	 * user input panel set up
	 * @return
	 */
	public JPanel userInputPanel() {
		JPanel userInteractPanel = new JPanel();
		userInteractPanel.setBackground(Color.LIGHT_GRAY);
		userInteractPanel.setLayout(new GridLayout(4, 0));
		JLabel textLabel = new JLabel("Text: ");
		this.text = new JTextField();
		JLabel timeLabel = new JLabel("Time(no more than 19s): ");
		this.time = new JTextField();
		userInteractPanel.add(textLabel);
		userInteractPanel.add(this.text);
		userInteractPanel.add(timeLabel);
		userInteractPanel.add(this.time);
		return userInteractPanel;
	}

	/**
	 * the panel where the buttons are on 
	 * @return
	 */
	public JPanel buttonPanel() {
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.LIGHT_GRAY);
		buttonPanel.setLayout(new GridLayout(2, 0));
		addBtn = new JButton("add");
		showBtn = new JButton("show");
		addBtn.addActionListener((this));
		showBtn.addActionListener((this));
		buttonPanel.add(addBtn);
		buttonPanel.add(showBtn);
		return buttonPanel;
	}

	/**
	 * set up the panel for slide 
	 * @return
	 */
	public JPanel displayPanel() {
		this.displayPanel = new JPanel();
		this.displayPanel.setBackground(new Color(224, 224, 224));
		this.displayPanel.setLayout(new BoxLayout(this.displayPanel, 1));
		return this.displayPanel;
	}

	/**
	 * link the buttons to actions 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == addBtn) {
			if (time.getText() != null && text.getText() != null) {
				Slide s = new Slide(Integer.parseInt(time.getText()), text.getText());
				array[(int) Integer.parseInt(time.getText())] = s;
				sq.insert(s);
			}
		}
		if (e.getSource() == showBtn) {
			timer.startTimer();
		}
	}

}
