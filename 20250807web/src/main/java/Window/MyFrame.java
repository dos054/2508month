package Window;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

class MyAction implements ActionListener {

	JTextField tf;
	
	public MyAction() {
		this.tf = tf;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(tf.getText());
		
	}
	
}

public class MyFrame extends JFrame {
	JButton btn = new JButton("클릭");
	JButton btn2 = new JButton("윈도우");
	JTextField tf = new JTextField();  // 여기
	MyFrame2 myFrame2 = new MyFrame2();
	MyFrame() {
		Container con = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		con.setLayout(null);
		
		con.add(btn);
		btn.setBounds(10, 20, 70, 40);
		
		con.add(tf);  // 여기
		tf.setBounds(100, 20, 70, 40);  // 여기
		
		con.add(btn2);
		btn2.setBounds(200, 20, 70, 40);
		
		this.setLocation(1000, 400);
		this.setSize(300, 200);
		this.setVisible(true);
		btn.addActionListener(new Window.MyAction());
//		btn.addActionListener(new Window.MyAction(this.tf.getText()));
		
		btn2.addActionListener((e) -> myFrame2.setVisible(true));
	}
	class MyAction implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println(tf.getText());
			
			
		}
		
	}

	class MyFrame2 extends JFrame implements WindowListener{
		public MyFrame2() {
			Container con = this.getContentPane();
//			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			con.setLayout(null);
			
			this.setLocation(1300, 400);
			this.setSize(300, 200);
			this.setVisible(false);
		}

		@Override
		public void windowOpened(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowClosing(WindowEvent e) {
			this.setVisible(false);
			
		}

		@Override
		public void windowClosed(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowIconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowActivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
			// TODO Auto-generated method stub
			
		}

		}
	
	public static void main(String[] args) {
		new MyFrame();

	}

}
