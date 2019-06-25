package control;

public class LightControl {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WiFiRelay s1,s2;
		
			s1=new WiFiRelay("172.17.65.195", 4210);
			s2=new WiFiRelay("172.17.65.195", 4211);
			
			
			s1.switchOff();
			System.out.println("Relay one off");
			/*
			s2.switchOff();
			System.out.println("Relay two off");
			*/
			
			
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
