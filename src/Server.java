// Server.java: A simple server program.

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String args[]) throws IOException {
        // Enter data using BufferReader
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Reading data using readLine
        String input = reader.readLine();
        // Splitting the input line to get the port number
        String[] parts = input.split(" ");
        // The second part should be the port number
        String port = parts[1];
        // Register service on port
        ServerSocket server = new ServerSocket(Integer.parseInt(port));
        // Wait and accept a connection
        Socket client = server.accept();
        // Get the input stream associated with the socket
        InputStream is = client.getInputStream();
        // Get the output writer associated with the socket
        PrintWriter pr = new PrintWriter(client.getOutputStream());
        // Get the buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        // Get the input from client
        String inputString = br.readLine();
        // Get the output string
        StringBuilder outputString = new StringBuilder();
        // Reverse the input and reverse the case
        for (int i = inputString.length() - 1; i >= 0; i--) {
            outputString.append(Character.isUpperCase(inputString.charAt(i)) ?
                    Character.toLowerCase(inputString.charAt(i)) :
                    Character.toUpperCase(inputString.charAt(i)));
        }
        // Send data to client
        pr.println(outputString);
        pr.flush();
        // Close everything
        client.close();
        reader.close();
    }
}