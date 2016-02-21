package client.utilities;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import client.resources.Res;

public class Functions {
	// shows an error message and will exit program when ok is clicked
	public static void showErrorScreen(String errorString) {
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setSize(500, 125);
		frame.getContentPane().setLayout(new FlowLayout());
		Box vertBox = Box.createVerticalBox();
		vertBox.add(Box.createVerticalGlue());
		vertBox.add(new JPanel().add(new JLabel(errorString)));
		vertBox.add(Box.createVerticalStrut(20));
		JButton button = new JButton(Res.string.ok);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				System.exit(1);
			}

		});
		vertBox.add(button);
		vertBox.add(Box.createVerticalGlue());
		frame.getContentPane().add(vertBox);
		frame.setLocation(Res.screen.monitorWidth / 2 - frame.getSize().width / 2,
				Res.screen.monitorHeight / 2 - frame.getSize().height / 2);
		frame.setVisible(true);
	}
}
