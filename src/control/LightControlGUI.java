/***********
 * Program to turn on and off home appliance from remote system
 * 
 * Developed by 
 * C.Obedotto
 * Associate Professor,
 * Saveetha Engineering College,
 * 
 *  E-mail: obedotto@saveetha.ac.in
 */
package control;

import java.awt.*;
import java.awt.event.*;
import java.util.Timer;
import java.util.TimerTask;

public class LightControlGUI extends Frame implements ActionListener
{
	Button lighton1,lightoff1,lighton2,lightoff2;
	Panel lightstatus1,lightstatus2;
	Timer refresh;
	public LightControlGUI()
	{
		setLayout(new GridLayout(3, 2));
		lightstatus1=new Panel();
		lightstatus2=new Panel();
		lighton1=new Button("Light 1 On");
		lightoff1=new Button("Light 1 Off");
		lighton2=new Button("Light 2 On");
		lightoff2=new Button("Light 2 Off");
		add(lightstatus1);
		add(lightstatus2);
		add(lightoff1);
		add(lightoff2);
		add(lighton1);
		add(lighton2);
		
		lighton1.addActionListener(this);
		lightoff1.addActionListener(this);
		lighton2.addActionListener(this);
		lightoff2.addActionListener(this);
		
		refresh=new Timer();
		refresh.schedule(new TimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Timer Event...");
			}
		}, 500,500);
		
		
		addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
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
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	public static void main(String[] args) {
	
		LightControlGUI mywindow=new LightControlGUI();
		
		mywindow.setSize(new Dimension(400,300));
		mywindow.setTitle("Light control application");
		mywindow.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		Object s=ae.getSource();
		if(s==lightoff1)
		{
			lightstatus1.setBackground(new Color(255, 0, 0));
		}
		if(s==lighton1)
		{
			lightstatus1.setBackground(new Color(0, 255, 0));
		}
		if(s==lightoff2)
		{
			
		}
		if(s==lighton2)
		{
			
		}
	}

}
