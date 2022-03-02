/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package writing;

import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author lorenzin.matteo
 */
public class Writing {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        FileWriter myWriter = new FileWriter("filename.txt");
        try {
            myWriter.write("Files in Java might be tricky, but it is fun enough!");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
        try {
            myWriter.write("sdf");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
        }
    }

}
