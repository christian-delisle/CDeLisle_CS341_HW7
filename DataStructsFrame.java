import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DataStructsFrame extends JFrame {
	int[] number0;
	int[] number1;
	ListPanel unorderedList;
	public DataStructsFrame(String title, int[] numbers, int[] numbers1) {
		super(title);

		final JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));

		ArrayList<ListItem> list = arrayToList(numbers, numbers1);

		unorderedList = new ListPanel("Unordered List");
		unorderedList.setDiameter(75);
		unorderedList.addItems(list);

		final ListPanel orderedList = new ListPanel("Ordered List");
		orderedList.setDiameter(100);
		
		JTextField textChange = new JTextField("Add Values");
		JButton sortA = new JButton("Sort List A");
		JButton sortB = new JButton("Sort List B");
		JButton listAdd = new JButton("Add to the List");
		sortA.setSize(35, 20);
		sortB.setSize(35, 20);
		listAdd.setSize(35, 20);
		textChange.setSize(35, 20);
		sortA.setAlignmentX(CENTER_ALIGNMENT);
		sortB.setAlignmentX(CENTER_ALIGNMENT);
		textChange.setAlignmentX(CENTER_ALIGNMENT);
		listAdd.setAlignmentX(CENTER_ALIGNMENT);
		/*
		JButton sortButton = new JButton("Sort List");
		sortButton.setSize(30, 10);
		sortButton.setAlignmentX(CENTER_ALIGNMENT);
		*/

		sortA.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Collections.sort(list);
				orderedList.addItems(list);
				panel.add(orderedList);
				sortA.setEnabled(false);
				pack();
			}
		});
		
		sortB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Collections.sort(list);
				orderedList.addItems(list);
				panel.add(orderedList);
				sortB.setEnabled(false);
				pack();
			}
		});
		
		listAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				String textGet = textChange.getText();
				number0 = new int[1];
				number1 = new int[1];
				String[] str = textGet.split(" ");
				for (int i = 0; i < str.length; i++) {
					if (i == 0) {
						number0[0] = Integer.parseInt(str[i]);
						System.out.println(number0[i]);
					}
					else {
						number1[0] = Integer.parseInt(str[i]);
					}
				}
				
				textChange.setText("");
				ArrayList <ListItem> listItem0 = new ArrayList<ListItem>();
				ListItem listItem1 = new ListItem(number0[0], number1[0]);
				listItem0.add(listItem1);
				unorderedList.addItems(listItem0);
				orderedList.addItems(listItem0);
				panel.add(unorderedList);
				pack();
			}
		});

		panel.add(unorderedList);
		panel.add(sortA);
		panel.add(sortB);
		panel.add(textChange);
		panel.add(listAdd);
		add(panel);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}

	private ArrayList<ListItem> arrayToList(int[] numbers, int[] numbers1) {
		ArrayList<ListItem> list = new ArrayList<ListItem>();

		for (int i = 0; i < numbers.length; i++) {
			ListItem listI = new ListItem(numbers[i], numbers1[i]);
			list.add(listI);
		}

		return list;
	}
}
