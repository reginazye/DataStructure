import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ColorConvertOp;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
/**
 * Roster Controller 
 * 
 * @author ReginaYe
 *
 */
public class RosterController extends JPanel implements ActionListener{

	protected JTextField nameEntry = new JTextField();
	protected JButton addBTN = new JButton("ADD");
	protected JButton dropBTN = new JButton("Drop");
	protected JTextArea WaitListArea = new JTextArea();
	protected JTextArea RosterArea = new JTextArea();
	protected JLabel roster= new JLabel("Roster");
	protected JLabel waitlist = new JLabel("WaitList");
	public DoublyLinkedList<String> enrolledStudents = new DoublyLinkedList<String>();
	public DoublyLinkedList<String> waitingStudents = new DoublyLinkedList<String>();
	static final int MAX_ENROLL = 7;
	static final int MAX_WAIT = 7;
	JPanel topBar = new JPanel();
	
	//constructor for the controller class 
	public RosterController() {
		super();
		setLayout(new GridLayout(3, 2));
		addBTN.addActionListener(this);
		dropBTN.addActionListener(this);
		setLook();
	}
	
	//setup the look of the app 
	public void setLook(){
		//set the titles of the boxes 
		roster.setForeground(Color.darkGray);
		roster.setFont(new Font("Monospaced", Font.BOLD, 80));
		roster.setSize(200, 120);
		waitlist.setForeground(Color.darkGray);
		waitlist.setFont(new Font("Monospaced", Font.BOLD, 80));
		add(roster);
		add(waitlist);
		
		nameEntry.setSize(500, 200);
		add(nameEntry);
		topBar.add(addBTN);
		topBar.add(dropBTN);
		add(topBar);

		//add the text fields for input 
		RosterArea.setBackground(new Color(66,244,194));
		RosterArea.setEditable(false);
		add(RosterArea);
		WaitListArea.setBackground(new Color(255,178,193));
		WaitListArea.setEditable(false);
		add(WaitListArea);
		topBar.setBackground(Color.LIGHT_GRAY);
	}
	
	/**
	 * add name for registration
	 */
	public void addName(){
		String name =  nameEntry.getText();
		if (enrolledStudents.getSize()<MAX_ENROLL) {
			enrolledStudents.insertFirst(name + "\n");
			RosterArea.setText(enrolledStudents.toString());
			RosterArea.setFont(new Font("Monospaced", Font.BOLD, 30));
			RosterArea.setForeground(Color.darkGray);
		}else if (enrolledStudents.getSize()>=MAX_ENROLL && waitingStudents.getSize()<MAX_WAIT){
			waitingStudents.insertFirst(name + "\n");
			WaitListArea.setText(waitingStudents.toString());
			WaitListArea.setText(enrolledStudents.toString());
			WaitListArea.setFont(new Font("Monospaced", Font.BOLD, 30));
			WaitListArea.setForeground(Color.darkGray);
		}else{
			WaitListArea.setText(waitingStudents.toString() + "\n" +"The List is full.");
		}
		
	}
	
	/**
	 * delete name method 
	 */
	public void dropName(){
		enrolledStudents.deleteLast();
		RosterArea.setText(enrolledStudents.toString());
		RosterArea.setFont(new Font("Monospaced", Font.BOLD, 30));
		RosterArea.setForeground(Color.darkGray);
	}

	
	/**
	 * what happens when user clicks the buttons 
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==addBTN){
			addName();
		}
		if (e.getSource()==dropBTN){
			dropName();
		}
		
	}
	
}
