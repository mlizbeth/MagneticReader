package io.valhala.msr;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;

public class Main {
	
	private final static Integer THRESHOLD = 100;
	private static String id = "";
	private static Long time;
	private static String newId = "";
	public static void main(String[] args) {
		
		JFrame f = new JFrame();
		f.setVisible(true);
		f.requestFocus();
		f.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if(time == null) {
					time = System.currentTimeMillis();
				}
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					System.out.println("ID: " + id);
					newId = id.substring(id.indexOf(";") + 1, id.indexOf("?") - 1);
					System.out.println(newId);
					time = null;
					id = null;
					newId = null;
				}
				else { 
					long delta = System.currentTimeMillis() - time;
					if(delta < THRESHOLD) {
						id += e.getKeyChar();
					}
				} 
			}
		});
	}
}
