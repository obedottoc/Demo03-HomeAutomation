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

import java.util.*;

public class LightControlMenu {

	public static void main(String[] args) throws Exception 
	{
		WiFiRelay s1,s2;
		Scanner sc=new Scanner(System.in);
		int option,status;
		
		s1=new WiFiRelay("172.17.90.40", 4210);
		s2=new WiFiRelay("172.17.90.40", 4211);
		while(true)
		{
			System.out.println("1. Switch on light 1");
			System.out.println("2. Switch off light 1");
			System.out.println("3. Switch on light 2");
			System.out.println("4. Switch off light 2");
			System.out.println("5. Light 1 status");
			System.out.println("6. Light 2 status");
			System.out.println("7. Exit");
			System.out.println("Enter Your Choice");			
			option=sc.nextInt();
			switch(option)
			{
			case 1:
				s1.switchOn();
				break;
			case 2:
				s1.switchOff();
				break;
			case 3:
				s2.switchOn();
				break;
			case 4:
				s2.switchOff();
				break;				
			case 5:
				status=s1.isOn();
				if(status==1)
				{
					System.out.println("Light 1 is on");
				}else if(status==0)
				{
					System.out.println("Light 1 is off");
				}else
				{
					System.out.println("Could not connect to WiFi switch");
				}			
				break;				
			case 6:
				status=s2.isOn();
				if(status==1)
				{
					System.out.println("Light 2 is on");
				}else if(status==0)
				{
					System.out.println("Light 2 is off");
				}else
				{
					System.out.println("Could not connect to WiFi switch");
				}								
				break;
			case 7:
				break;
			default:
				System.out.println("You have entered invalid option");
			}
			
			if(option==7)
			{
				System.out.println("Thankyou for using WiFi light control");
				break;
			}
		}
		

	}

}
