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

public class LightControl {

	/********
	 * Program Entry Point
	 * @param args command line parameters
	 */	
	public static void main(String[] args) throws Exception 
	{ 
		WiFiRelay s1,s2;
		
			s1=new WiFiRelay("172.17.90.40", 4210);
			s2=new WiFiRelay("172.17.90.40", 4211);
			
			
			s1.switchOff();
			System.out.println("Relay one off");
			
			s2.switchOff();
			System.out.println("Relay two off");
			
			
			
			if(s1.isOn()==0)
			{
				System.out.println("Switch1 is off");
			}else if(s1.isOn()==1){
				System.out.println("Switch1 is on");
			}else
			{
				System.out.println("Could not connect to switch1");
			}
	}

}
