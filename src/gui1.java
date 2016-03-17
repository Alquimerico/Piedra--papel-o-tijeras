import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class gui1 {
	public JLabel lblCentro;
	public JLabel lblScore;
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					gui1 window = new gui1();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public gui1() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("Piedra, papel o tijeras v1.0");
		
		JButton btnPiedra = new JButton("Piedra");
		btnPiedra.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				game(1);
			}
		});
		btnPiedra.setBounds(47, 55, 89, 23);
		frame.getContentPane().add(btnPiedra);
		
		JButton btnPapel = new JButton("Papel");
		btnPapel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game(2);
			}
		});
		btnPapel.setBounds(172, 55, 89, 23);
		frame.getContentPane().add(btnPapel);
		
		JButton btnTijeras = new JButton("Tijeras");
		btnTijeras.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				game(3);
			}
		});
		btnTijeras.setBounds(305, 55, 89, 23);
		frame.getContentPane().add(btnTijeras);
		
		lblCentro = new JLabel("                   Bienvenido :3");
		lblCentro.setBounds(120, 105, 201, 65);
		frame.getContentPane().add(lblCentro);
		
		JButton btnNewButton = new JButton("Acerca de...");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(null, "La piedra rompe a la tijera, el papel envuelve a la piedra, y la tijera corta el papel. \n Escrito por Ao Kin Ecab Gutiérrez González L. \n v1.0");
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnNewButton.setBounds(305, 227, 102, 23);
		frame.getContentPane().add(btnNewButton);
		
		lblScore = new JLabel("<html>Puntuación: 0 <br> Intentos: 10 </html>");
		lblScore.setBounds(28, 198, 89, 39);
		frame.getContentPane().add(lblScore);
	}
	@SuppressWarnings("static-access")
	public void game(int n)
	{
		Main metodos = new Main();
		int m = metodos.random1_3();
		int result = metodos.match(n, m);
		lblCentro.setText("<html>La el humano ha jugado "  + metodos.intToppt(n)+ "<br>La maquina ha jugado " + metodos.intToppt(m) + ".<br>" + metodos.matchOutcome(result) + "<html>");
		intentos--;
		switch (result){case 1: {score++; break;} case 2: {score--; break;} case 3: {score = score; break;}}
		if(intentos == 0) {score = 0; intentos = 10;}
		lblScore.setText("<html>Puntuación: " + String.valueOf(score) +  "<br> Intentos: " + String.valueOf(intentos) + "</html>");
		
	}
	public int score = 0;
	public int HiScore = 0;
	public int intentos = 10;
}
