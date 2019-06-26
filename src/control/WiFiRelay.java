/***
 * Program to interface relay connected to a ESP 8266 board
 * 
 * Developed by
 * C.Obed Otto,
 * Associate Professor,
 * Saveetha Engineering College.
 * E-mail: obedotto@saveetha.ac.in
 */
package control;

import java.net.*;

/*******
 * Program to control the relay connected to a ESP8266 board 
 * 
 * @author obedotto@saveetha.ac.in
 *
 */
public class WiFiRelay {
	
	DatagramSocket ds;
	byte buffer[]=new byte[10];
	String ipaddress;
	int port;
	
	/***
	 * Initialize WifiRelay with ipaddress and port
	 * @param ip IP address of ESP8266 board 
	 * @param po port at which program in ESP8266 is listening
	 */
	public WiFiRelay(String ip,int po)
	{
		try
		{			
			ipaddress=ip;
			port=po;
			ds=new DatagramSocket();
			ds.setSoTimeout(500);
		}catch(Exception ex)
		{
			System.out.println("Error:"+ex);
		}	
	}
	
	/***
	 * Send data to ESP8266 board
	 * @param data 0 for turn off, 1 for turn on and other for getting the status of the relay
	 * @return true if send succeeded, false if failed
	 */
	private boolean sendData(int data)
	{
		boolean status=false;
		try
		{
			buffer[0]=(byte)data;
			DatagramPacket dp=new DatagramPacket(buffer, 1,InetAddress.getByName(ipaddress),port);
					
			ds.send(dp);
			status=true;
			
		}catch(Exception ex)
		{
			status=false;
			System.out.println("Error:"+ex);
		}
		
		return status;
	}
	
	/****
	 * To receive data from ESP8266 board
	 * @return 0 if switch is off, 1 if the switch is on
	 */
	private Integer receiveData()
	{
		Integer result=null;
		try		
		{
			DatagramPacket dp=new DatagramPacket(buffer, 10);
			byte d[]=new byte[10];
			ds.receive(dp);
			d=dp.getData();
			result=(int)d[0];
		}catch(SocketTimeoutException timout)
		{
			result=null;
		}
		catch(Exception ex)
		{
			result=null;
			System.out.println("Error:"+ex);
		}
		
		return result;				
	}
	
	/********
	 * To turn on the relay
	 * @return true if succeeded, false if failed.
	 */
	public boolean switchOn()
	{
		return this.sendData(1);
	}
	
	
	/*****
	 * To turn off the relay
	 * @return true if succeeded, false if failed.
	 */
	public boolean switchOff()
	{
		return this.sendData(0);
	}	
	
	
	/********
	 * To find the status of the relay
	 * @return 1 if it is on, 0 if it is off and other if failed to connect.
	 */
	public int isOn()
	{
		int status=2,i=0;
		Integer data;
		
		try
		{
			this.sendData(2);
			while(i<3)
			{
				data=this.receiveData();
				if(data!=null)
				{
					if(data==0)
					{
						status=0;
					}else if(data==1)
					{
						status=1;
					}
					break;				
				}
				Thread.sleep(1000);
				i++;
			}
		}catch(Exception ex)
		{
			
		}
		return status;
	}
}
