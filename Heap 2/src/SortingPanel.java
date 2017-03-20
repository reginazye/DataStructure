import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SortingPanel extends JPanel {
	private static String[] sortingAlgs = { "Heap", "Selection", "Insertion", "Bubble" };

	private Integer[] intArray;
	private BarArrayDisplay barDisplay;
	private JComboBox algList;

	public SortingPanel() {
		super();
		initGUI();
	}

	private void randomizeArray() {
		System.out.println("SortingPanel width: " + getWidth());
		intArray = randomIntegerArray(getHeight() / 50, barDisplay.getHeight(), barDisplay.getWidth() / 20);
		barDisplay.setArray(intArray);
		repaint();

	}

	public void initGUI() {
		setLayout(new BorderLayout());
		barDisplay = new BarArrayDisplay(intArray);
		add(initSortingAlgsCB(), BorderLayout.NORTH);
		add(initButtonsPanel(), BorderLayout.SOUTH);
		add(barDisplay, BorderLayout.CENTER);
	}

	private JComboBox initSortingAlgsCB() {
		// Create the combo box
		algList = new JComboBox(sortingAlgs);
		// petList.setSelectedIndex(4); //
		// petList.addActionListener(
		// // this is a way of mimicking Function passing in AS3
		// new ActionListener()
		// {
		// /**
		// * Invoked when associated action is performed.
		// **/
		// public void actionPerformed( ActionEvent e )
		// {
		// selectSort();
		// }
		// }
		// );

		return algList;
	}

	private JPanel initButtonsPanel() {
		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new GridLayout(1, 2));

		// create and add init button
		buttonsPanel.add(initRandButton());

		// create and add sort button
		buttonsPanel.add(initSortButton());

		return buttonsPanel;

	}

	private JButton initRandButton() {
		// new array button at the bottom
		JButton randButton = new JButton("New random array");

		// add an action listener for button's action (click)
		randButton.addActionListener(
				// this is a way of mimicking Function passing in AS3
				new ActionListener() {
					/**
					 * Invoked when associated action is performed.
					 **/
					public void actionPerformed(ActionEvent e) {
						randomizeArray();
					}
				});

		return randButton;
	}

	private JButton initSortButton() {
		// sort button at the bottom
		JButton sortButton = new JButton("Sort!");

		// add an action listener for button's action (click)
		sortButton.addActionListener(
				// this is a way of mimicking Function passing in AS3
				new ActionListener() {
					/**
					 * Invoked when associated action is performed.
					 **/
					public void actionPerformed(ActionEvent e) {
						sort();
					}
				});

		return sortButton;
	}

	private void sort() {
		if (intArray != null) {
			int selectedSortingAlg = algList.getSelectedIndex();
			System.out.println("selectedSortingAlg: " + selectedSortingAlg);

			switch (selectedSortingAlg) {
			// selection
			case 0:
				ArraySorter.heapSort(intArray);
				break;
			// insertion
			case 1:
				ArraySorter.insertionSort(intArray);
				break;
			// bubble
			case 2:
				ArraySorter.bubbleSort(intArray);
				break;

			case 3:
				ArraySorter.selectionSort(intArray);
			default:
				// do nothing
			}

			// validate();
			barDisplay.repaint();
			repaint();
		}
	}

	/**
	 * Creates an array of length number of random Integers in the range [lo,hi)
	 **/
	public static Integer[] randomIntegerArray(int lo, int hi, int length) {
		Integer[] a = new Integer[length];

		for (int i = 0; i < length; i++) {
			a[i] = new Integer((int) Math.floor(Math.random() * (hi - lo) + lo));
		}

		return a;
	}
}