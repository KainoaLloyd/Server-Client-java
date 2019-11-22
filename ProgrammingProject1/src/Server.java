import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Server {
	private ObjectOutputStream output;
	private ObjectInputStream input;
	//private ServerSocket server;
	//private Socket connection;
	//private String[][] serverRequests = new String[][];
	private static Map <String, String> AddressBook;
	public static void main(String argv[]) throws Exception{
		//set the port number
		int port = 6789;
		AddressBook = populateMap();
		Server myServer = new Server();
		myServer.run();
	}
	public static Map <String, String> populateMap(){
		Map <String, String> m = new HashMap<String, String>();
			m.put("http:://www.abc.com/ab", "Characters A-Z");
			m.put("http:://www.b.com",  "website b");
			m.put("http:://www.c.com",  "website c");
			m.put("http:://www.d.com",  "website d");
			m.put("http:://www.e.com",  "website e");
			m.put("http:://www.f.com",  "website f");
			m.put("http:://www.g.com",  "website g");
			m.put("http:://www.h.com",  "website h");
		return m;
	}
	public String returnWebsiteData(String URL){
		return AddressBook.get(URL);
	}
	public void run()throws Exception{
		int numRequests = 0;
		int limit = 10;
		boolean exit = false;
		//maybe in a while loop
		do{
		//try{
		ServerSocket serverSocket = new ServerSocket(6500);
				
		
				System.out.print("waiting to connect...");				
				Socket clientSocket = serverSocket.accept();  //wait for connection//connection
				System.out.print("now connected...");
				
				//clientSocket.getInetAddress().getHotstName()  //shows host name
				
				
			//set up streams..getsteream to  send and recieve data
			PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			//new bostton put out.flush() here
			InputStreamReader IR = new InputStreamReader(clientSocket.getInputStream());
			BufferedReader in = new BufferedReader(IR);
	//	}finally{
			//
	//	}
	
			/*
			private void whileChatting() thows IOException{
			String mess = " You are now connected"
			sendMessage(message);
			do{
			try{
				message = (String) input.readObject();
				showMessage("\n" +message);
			}catch(ClassNotFoundException classNotFoundException){
				showMessage("\n idk what user sent");
				//have conversation
			}while(!message.equals("client-end")
		*/
		//Read from Client and process the input //initate connection
		String data = "message that should be sent"; //protocol.processInput(in.readLine());
		//write to Client
		out.println(data);
		out.flush();
		}while(numRequests <= limit || exit == true);
		//Closing the socket
		//Close PrintWriter
		out.close();
		//Close BufferReader
		in.close();
		//CloseClient Socket
		clientSocket.close();
		//Close ServerSocket
		serverSocket.close();
		}
		/*String message = in.readLine();
		System.out.println(message);
		
		if (message !=null){
			PrintStream PS = new PrintStream(clientSocket.getOutputStream());
			PS.println("message recieved!");
		
		}*/
	}

//constructor
/*class HttPRequest implements Runnable{
	//Establish the listen sockt.
	//?
	
	//process HTTP service requests in an infinite loop.
	while (true){
		//Listen for a TCP connection request.
		//?
		
		
	}*/
/*
 finally{
 closeEverything();
 }
 
 private void closeEverything(){
 	showMessage("\n Closing connections... \n");
 	ableToType(false); //probably not going to use
 	try{
 		out.close()
 		in.close();
 		clientSocket.close();
 	}catch{
 	IOException ioException){
 		ioException.printStrackTrace();
 	}
 }
 
 //send  a message to client
  private void sendMessage(String message){
  	try{
  		out.writeObject("SERVER -"+message); //sends message to client
  		out.flush();
  		showMessage("\nSERVER -" + message); //shows message on this server
  	}catch(IOException ioException){
  		//send message in client saying " Error can't send this."
  }
  //update server chat
   private void showMessage(final String){
   	 new Runnable(){
   	 	public void run(){
   	 		//print message
   	 	}
   	 }
  	}
 */




