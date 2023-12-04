// Client.java: A simple client program.

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String args[]) throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        String input = reader.readLine();
        // Splitting the input line to get the port number
        String[] parts = input.split(" ");
        // The second part should be the host
        String host = parts[1];
        // The third part should be the port number
        String port = parts[2];
        // Open your connection to a server at host and port
        Socket client = new Socket(host, Integer.parseInt(port));
        // Get the input stream associated with the socket
        InputStream is = client.getInputStream();
        // Get the output writer associated with the socket
        PrintWriter pr = new PrintWriter(client.getOutputStream());
        // Get the buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        // Get an input from console to be processed
        String inputToProcess = reader.readLine();
        // Send data to server
        pr.println(inputToProcess);
        pr.flush();
        // Get the result from server
        String result = br.readLine();
        System.out.println(result);
        // When done, just close the connection and exit
        client.close();
        reader.close();
    }
}