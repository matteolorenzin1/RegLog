/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client_a;

import java.net.*;
import java.io.*;
import java.util.Scanner;

public class Client_a {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        Socket clientSocket;
        PrintWriter out;
        BufferedReader in;
        Scanner sc;
        clientSocket = new Socket("192.168.56.1", 5000);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sc = new Scanner(System.in);
        String scelta, nome, psw, testo;
        boolean uscita = true;
        
       while (uscita) {
            System.out.println("vuoi registrare un nuovo utente o loggarti? [reg]"
                    + " / [log]");
            scelta = sc.next();
            if (scelta.equalsIgnoreCase("log")) {
                System.out.println("inserire user: ");
                nome = sc.next();
                System.out.println("inserire password: ");
                psw = sc.next();
                out.println(scelta);
                out.println(nome);
                out.println(psw);
                testo = in.readLine();
                System.out.println(testo);
                uscita = false;
            } else if (scelta.equalsIgnoreCase("reg")) {
                System.out.println("registra user: ");
                nome = sc.next();
                System.out.println("registra password: ");
                psw = sc.next();
                out.println(scelta);
                out.println(nome);
                out.println(psw);
                testo = in.readLine();
                System.out.println(testo);
            }
        } 

        in.close();
        out.close();
        clientSocket.close();
    }

}
