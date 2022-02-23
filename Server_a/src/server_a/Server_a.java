/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package server_a;

import java.net.*;
import java.io.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Server_a {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket;
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        serverSocket = new ServerSocket(5000);
        clientSocket = serverSocket.accept();
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        FileWriter myWriter = new FileWriter("Credenziali.txt");
        String scelta, nome, psw;

        scelta = in.readLine();
        if (scelta.equalsIgnoreCase("log")) {

        } else if (scelta.equalsIgnoreCase("reg")) {
            nome = in.readLine();
            psw = in.readLine();
            myWriter.write(nome + " " + psw);
            myWriter.close();
            
        }
        
        in.close();
        out.close();
        clientSocket.close();
    }

}
