import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class SwingAppGUI extends JFrame {
	private JFrame mainFrame;
	private JLabel headerLabel;
	private JLabel statusLabel;
	private JPanel controlPanel;

	public SwingAppGUI() {
		prepareGUI();
	}

	public static void main(String[] args) {
		SwingAppGUI sD = new SwingAppGUI();
		sD.showEvent();
	}

	private void prepareGUI() {
		mainFrame = new JFrame("NB Gardens");
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new GridLayout(3, 1));
		headerLabel = new JLabel("", JLabel.CENTER);
		statusLabel = new JLabel("", JLabel.CENTER);
		statusLabel.setSize(350, 100);
		mainFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent windowEvent) {
				System.exit(0);
			}
		});
		controlPanel = new JPanel();
		controlPanel.setLayout(new FlowLayout());
		mainFrame.add(headerLabel);
		mainFrame.add(controlPanel);
		mainFrame.add(statusLabel);
		mainFrame.setVisible(true);
	}

	private void showEvent() {
		headerLabel.setText("Please select an option.");
		JButton ordersButton = new JButton("Customer Orders");
		JButton productButton = new JButton("Product Location");
		JButton OrderLineButton = new JButton("Order Line");
		JButton cancelButton = new JButton("Cancel");
		ordersButton.setActionCommand("Customer Orders");
		productButton.setActionCommand("Product Location");
		OrderLineButton.setActionCommand("Order Line");
		cancelButton.setActionCommand("Cancel");
		ordersButton.addActionListener(new BCL());
		productButton.addActionListener(new BCL());
		OrderLineButton.addActionListener(new BCL());
		cancelButton.addActionListener(new BCL());
		controlPanel.add(ordersButton);
		controlPanel.add(productButton);
		controlPanel.add(OrderLineButton);
		controlPanel.add(cancelButton);
		mainFrame.setVisible(true);
	}

	private class BCL implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent ae) {
			String command = ae.getActionCommand();
			switch (command) {
			case "Customer Orders":
				statusLabel.setText("Customer Orders button selected!");
				break;
			case "Product Location":
				statusLabel.setText("Product Location button selected!");
				break;
			case "Order Line":
				statusLabel.setText("Order Line button selected!");
				break;
			case "Cancel":
				statusLabel.setText("Cancel not possible");
				break;
			}
		}
	}
}
