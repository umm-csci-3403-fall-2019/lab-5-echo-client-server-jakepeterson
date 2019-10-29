package echoserver;
import java.net.Socket;
import java.net.*;
import java.io.*;
public class EchoClient {

    public static final int portNumber = 6013;

    public static void main(String[] args) throws IOException{

        String server;

        if(args.length == 0){
            server = "127.0.0.1";
        }else{
            server = args[0];
        }

        try{
            //connect to server
            Socket socket = new Socket(server, portNumber);

            //get input stream
            InputStream input = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            //print input from the server
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }
            //flush and close the socket when done
            System.out.flush();
            socket.close();
         //error handling
        }catch (ConnectException ce){
            System.out.println("We were unable to connect to " + server);
            System.out.println("You should make sure the server is running.");
        }catch (IOException ioe){
            System.out.println("We caught an unexpected exception");
            System.err.println(ioe);
        }
    }

}