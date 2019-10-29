package echoserver;

import java.io.*;
import java.io.PrintWriter;
import java.net.*;

public class EchoServer {
    public static final int portNumber = 6013;

    public static void main(String[] args) {
        try {
            //listen for specified port
            ServerSocket sock = new ServerSocket(portNumber);
            System.out.println("Started server on port " + portNumber);


            //run forever
            while (true) {
                //wait for a connection
                Socket client = sock.accept();
                System.out.println("Got a request");
                int input=0;
                InputStream in = client.getInputStream();
                OutputStream out  = client.getOutputStream();
                while((input= in.read())!=-1){
                    out.write(input);
                }
                out.flush();
                //close the client
                client.close();
                }
            }catch(IOException ioe){
                System.out.println("We caught an unexpected exception");
                System.err.println(ioe);
            }
        }
    }
