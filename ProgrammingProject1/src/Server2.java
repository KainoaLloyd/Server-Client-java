import java.io.*;
import java.net.*;
import java.util.HashMap;
import java.util.Map;

public class Server2 implements Runnable {

	
    private int serverPort   = 8080;
    private ServerSocket serverSocket = null;
    private boolean isStopped = false;
    private Thread runningThread= null;
	
    public void run(){
        synchronized(this){
            this.runningThread = Thread.currentThread();
        }
        openServerSocket();
        //while we haven't stopped the server
        while(! isStopped()){
            Socket clientSocket = null;
            try {
            	
            	//wait for client
                clientSocket = this.serverSocket.accept();
            } catch (IOException e) {
                if(isStopped()) {
                    System.out.println("Server Stopped.") ;
                    return;
                }
                throw new RuntimeException(
                    "Error accepting client connection", e);
            }
            new Thread(new Worker(clientSocket, "Multithreaded Server")).start();
        }
        System.out.println("Server Stopped.");
    }

    private void processClientRequest(Socket clientSocket)
    throws Exception {
        InputStream  input  = clientSocket.getInputStream();
        OutputStream output = clientSocket.getOutputStream();
        long time = System.currentTimeMillis();

        /*byte[] responseDocument = "<html><body>" +
                "Singlethreaded Server: " +
                time +
                "</body></html>".getBytes("UTF-8");

        byte[] responseHeader =
            "HTTP/1.1 200 OK\r\n" +
            "Content-Type: text/html; charset=UTF-8\r\n" +
            "Content-Length: " + responseDocument.length +
            "\r\n\r\n".getBytes("UTF-8");

        output.write(responseHeader);
        output.write(responseDocument);*/
        output.close();
        input.close();
        System.out.println("Request processed: " + time);
    }

    private synchronized boolean isStopped() {
        return this.isStopped;
    }

    public synchronized void stop(){
        this.isStopped = true;
        try {
            this.serverSocket.close();
        } catch (IOException e) {
            throw new RuntimeException("Error closing server", e);
        }
    }

    private void openServerSocket() {
        try {
            this.serverSocket = new ServerSocket(this.serverPort);
        } catch (IOException e) {
            throw new RuntimeException("Cannot open port 8080", e);
        }
    
}
    
}
