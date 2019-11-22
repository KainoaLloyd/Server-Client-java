import java.io.*;
import java.net.*;
import java.util.*;
public class Client {
	private static String clientN;
	private static int clientAccess;
	Client(int n, int a){
		clientN = "client" + n;
		clientAccess = a;
	}
	

	public static void main(String[] args) throws Exception{
		//Client client = new Client();
		//client.run();
	//}
 // public Client (int code, String name){
		//int c = code;
	//	int n = name;
	//}
	//public void startRunning(int code, String name) throws Exception
	
	//{
		BufferedReader local;
		PrintWriter out;
		BufferedReader in;
		
		
		
//assigned name
		/*public String assignName(int i){
			String clientName = "Client" + Integer.toString(i);
		}*/
		
		/*String clientName = clientN;
		int accessCode = clientAccess;
		int last = accessCode % 10;
		if (last%2 == 2){
			if (last == 0){
				int membership = 0;
			}else{
				int membership = 2;
			}
		}else{
			int membership = 1;
		}*/
		try{
		Socket socket = new Socket("localhost", 6689);
		System.out.println("Client Started");
		System.out.println("Enter messages .. \nEnter CTRL+C to close connection");
		local = new BufferedReader(new InputStreamReader(System.in)); //new'
		out = new PrintWriter(socket.getOutputStream(), true);
		in  = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		boolean exit = false;
		while(exit == false){
		//write to server
			
			System.out.println("Please enter a message that you would like to send to the server");
			String localdata = local.readLine();
			if  (localdata == "exit"){
				exit = true;
			}
			//data_writer.println(localdata);
			String remotedata = in.readLine(); // we read if any data has been received from server
			System.out.println("Data reveiced at Client side : " +remotedata);
			if (remotedata == "exit"){
				exit = true;
			}
		}
		}catch(Exception e){
			System.out.println("Exception caught");
			e.printStackTrace();
		}
		
		//String message = "text sent to server";
		//out.println(message);
		//out.flush();
		//Read from server
		//String data = in.readLine();
		
		
		
		
		
		
		//Closing the socket
		//Close PrintWriter
		//out.close();
		//Close BufferReader:
		//in.close();
		//Close Socket
		//socket.close();
		//from youtube
		/*String message = in.readLine();
		System.out.println(message);
		*/
		
	}
}
