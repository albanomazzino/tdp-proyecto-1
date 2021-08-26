package launcher;

import javax.swing.JFrame;

import entities.Student;
import gui.SimplePresentationScreen;

public class Launcher {
	public static void main(String [] args) {
        //Schedule a job for the event-dispatching thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
            	Student albano = new Student (130010, "Mazzino", "Albano", "albimazzino@gmail.com", "https://github.com/albanomazzino", "/images/pepe.jpg");
            	JFrame gui = new SimplePresentationScreen(albano);
                gui.setVisible(true);
            }
        });
    }
}