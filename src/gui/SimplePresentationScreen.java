package gui;


import java.awt.Dimension;
import java.time.format.DateTimeFormatter;  
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import entities.Student;
import javax.swing.JTabbedPane;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;

@SuppressWarnings("serial")
public class SimplePresentationScreen extends JFrame {

	private JPanel contentPane;
	private JPanel tabInformation;
	private JTabbedPane tabbedPane;
	private Student studentData;
	private JLabel apellidoLbl;
	private JLabel nombreLbl;
	private JLabel emailLbl;
	private JLabel githubLbl;
	private JTextField githubText;
	private JTextField emailText;
	private JTextField nombreText;
	private JTextField apellidoText;
	private JTextField luText;
	private JLabel fechaLabel;
	private JLabel imagenLbl;

	public SimplePresentationScreen(Student studentData) {
		this.studentData = studentData;
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setTitle("TdP-DCIC-UNS 2021 :: Pantalla de presentación");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(new Dimension(615, 280));
		setResizable(false);
		setContentPane(contentPane);
		
		init();
	}
	
	private void init() {
		contentPane.setLayout(null);
		// Tabbed Pane to student personal data
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(5, 5, 430, 211);
		tabInformation = new JPanel();
		tabInformation.setPreferredSize(new Dimension(425, 275));
		tabbedPane.addTab("Información del alumno", null, tabInformation, "Muestra la información declarada por el alumno");
		tabInformation.setLayout(null);
		
		JLabel luLbl = new JLabel("LU");
		luLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		luLbl.setBounds(10, 11, 46, 14);
		tabInformation.add(luLbl);
		
		apellidoLbl = new JLabel("Apellido");
		apellidoLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		apellidoLbl.setBounds(10, 40, 46, 14);
		tabInformation.add(apellidoLbl);
		
		nombreLbl = new JLabel("Nombre");
		nombreLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		nombreLbl.setBounds(10, 70, 46, 14);
		tabInformation.add(nombreLbl);
		
		emailLbl = new JLabel("E-mail");
		emailLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		emailLbl.setBounds(10, 100, 46, 14);
		tabInformation.add(emailLbl);
		
		githubLbl = new JLabel("Github URL");
		githubLbl.setFont(new Font("Tahoma", Font.BOLD, 11));
		githubLbl.setBounds(10, 130, 62, 14);
		tabInformation.add(githubLbl);
		
		githubText = new JTextField();
		githubText.setColumns(10);
		githubText.setBounds(82, 128, 333, 20);
		tabInformation.add(githubText);
		
		emailText = new JTextField();
		emailText.setColumns(10);
		emailText.setBounds(82, 98, 333, 20);
		tabInformation.add(emailText);
		
		nombreText = new JTextField();
		nombreText.setColumns(10);
		nombreText.setBounds(82, 68, 333, 20);
		tabInformation.add(nombreText);
		
		apellidoText = new JTextField();
		apellidoText.setColumns(10);
		apellidoText.setBounds(82, 38, 333, 20);
		tabInformation.add(apellidoText);
		
		luText = new JTextField();
		luText.setColumns(10);
		luText.setBounds(82, 8, 333, 20);
		tabInformation.add(luText);
		contentPane.add(tabbedPane);
		
		// Date Label Settings
		fechaLabel = new JLabel("");
		fechaLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		fechaLabel.setBounds(7, 220, 428, 14);
		DateTimeFormatter day = DateTimeFormatter.ofPattern("dd/MM/yyyy");  
		DateTimeFormatter hrs = DateTimeFormatter.ofPattern("HH:mm:ss");  
		LocalDateTime now = LocalDateTime.now();  
		fechaLabel.setText("Esta ventana fue generada el " + day.format(now) + " a las " + hrs.format(now));
		contentPane.add(fechaLabel);
		
		// Student Data Setters && Info
		luText.setText(studentData.getId()+"");
		apellidoText.setText(studentData.getLastName());
		nombreText.setText(studentData.getFirstName());
		emailText.setText(studentData.getMail());
		githubText.setText(studentData.getGithubURL());
		imagenLbl = new JLabel();
		imagenLbl.setBounds(455, 27, 122, 152);
		contentPane.add(imagenLbl);
		
		// Student Image Setter (Label)
		ImageIcon studentImage = new ImageIcon(new ImageIcon(this.getClass().getResource(studentData.getPathPhoto())).getImage().getScaledInstance(imagenLbl.getWidth(), imagenLbl.getHeight(), Image.SCALE_SMOOTH));
		imagenLbl.setIcon(studentImage);
		
		// JFrame Icon Setter
		ImageIcon img = new ImageIcon(this.getClass().getResource("/images/tdp.png"));
		this.setIconImage(img.getImage());
	}
}


