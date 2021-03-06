package kr.ac.halla.ice.h02404.swing_examples.lecture5;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class P2Dialog extends JFrame {

	JFrame frame = this;
	JTextArea rcode = null;
	JButton sbutton = null;

	public P2Dialog() {
		setTitle("Example");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setLayout(new FlowLayout());

		JLabel text = new JLabel("Talk is cheap. Show me your code.");
		contentPane.add(text);
		JButton submit = new JButton("Submit");
		contentPane.add(submit);

		rcode = new JTextArea(20, 20);
		contentPane.add(new JScrollPane(rcode));

		submit.addActionListener(new ActionListener() {

			@SuppressWarnings("unused")
			@Override
			public void actionPerformed(ActionEvent e) {
				MyDialog dialog = new MyDialog(frame, rcode);
			}
		});

		setSize(300, 150);
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		P2Dialog frame = new P2Dialog();
	}
}

@SuppressWarnings("serial")
class MyDialog extends JDialog {

	public MyDialog(JFrame frame, JTextArea rcode) {
		super(frame);

		setTitle("Insert your code");
		setLayout(new FlowLayout());

		JTextArea scode = new JTextArea(20, 20);
		add(new JScrollPane(scode));
		JButton sbutton = new JButton("Submit");
		add(sbutton);

		sbutton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				rcode.setText(scode.getText());
				setVisible(false);
				dispose();
			}
		});

		setSize(500, 500);
		setVisible(true);
	}
}
