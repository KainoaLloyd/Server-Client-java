import java.io.*; 
import java.net.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Random; 

public class Server3 implements Runnable {
	Socket connectionSocket;
	public String clientUsage;
	private static Map <String, String> AddressBook;
	public Server3(Socket connetionSocket){
		this.connectionSocket = connectionSocket;
	}

	
public static void main(String argv[]) throws Exception { 
	AddressBook = populateMap();
		ServerSocket welcomeSocket = new ServerSocket(6689);
	while(true) { 

		Socket connectionSocket = welcomeSocket.accept(); 

	
		Server3 s = new Server3(connectionSocket);

		Thread threads = new Thread(s);

		
		threads.start();

	}
}
public void run(){
	//assigning random access code
	DataOutputStream out;
	BufferedReader in;
	Random rand = new Random();
	int  accessCode = rand.nextInt(300) + 50;
	int reqNum = 0;
		int limit = AssignMembership( accessCode);
		String clientData; 
		String Servermessage; 
	do{
		try{
			 if (limit <8){ // all non unlimited access has lower requests limit than 8
				 reqNum++;
			 }
			 
			 in = new BufferedReader(new InputStreamReader(this.connectionSocket.getInputStream())); 
			 out = new DataOutputStream(this.connectionSocket.getOutputStream()); 
			if (reqNum<limit){
				clientData = in.readLine(); 
				i
			}else{
				clientData = "exit";
				out.writeBytes(clientData);
				out.close();
				in.close();		
			}
			clientUsage = clientUsage+ "\n" + clientData;
			if (clientData == "http://clientsusage.co"){
				String info = clientUsage;
			}else{
				String info = returnWebsiteData(clientData);
			}
			Servermessage = "the message " + info + " was received by the server"; 
			
			
			out.writeBytes(Servermessage);

			
			System.out.println(Thread.currentThread().getName());

		} catch (IOException io) {
			io.printStackTrace();
		}

	}while ( reqNum <limit);

	//clientSocket.close();
	}

//returns membership status which is the number of requests allowed... 10 is for unlimited
public int AssignMembership( int n){
	int m;
	int last = n % 10;
	if (last%2 == 2){
		if (last == 0){
			 m = 3;
		}else{
			 m = 5;
		}
	}else{
		 m = 10;
	}
	return m;
}

//populaes dumby website data
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

//returns dumby website data
public String returnWebsiteData(String URL){
	return AddressBook.get(URL);
}
}


