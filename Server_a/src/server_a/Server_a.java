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
import java.util.Scanner;

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
        File myObj = new File("Credenziali.txt");
        Scanner myReader = new Scanner(myObj);
        String scelta, nome, psw, uscita = "", testo;
        boolean exit = true;
        while ( exit){
            scelta = in.readLine();
            if (scelta.equalsIgnoreCase("log")) {
                nome = in.readLine();
                psw = in.readLine();
                testo = nome + " " + psw;
                if (testo.equals(myReader.nextLine())) {
                    uscita = "ok";
                } else {
                    uscita = "errore";
                }
                out.println(uscita);
                exit = false;
            } else if (scelta.equalsIgnoreCase("reg")) {
                nome = in.readLine();
                psw = in.readLine();
                try {
                    myWriter.write(nome + " " + psw);
                    myWriter.close();
                    out.println("credenziali salvate");
                } catch (IOException e) {
                    out.println("errore ");
                }
            }
        }

        in.close();
        out.close();
        clientSocket.close();
    }

}
