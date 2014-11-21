package ByrdSocket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.net.ServerSocket;

/**
 *
 * @author ibyrd
 */
public class MomaByrd {

    ServerSocket socks;

    public MomaByrd(int Port) {
        Mouths connection = new Mouths();
        try {
            socks = new ServerSocket(Port);
        } catch (IOException ex) {
            System.err.println("Port " + Port + " is in use already! Stopping...");
            System.exit(-1);
        }
        try {
            System.out.println("Connection Class Created!");
            System.out.println("Waiting for connection...");
            connection.sock = socks.accept();
            System.out.println("Connection has been accepted.");
            connection.SetUp();
            System.out.println("Object streams are declared.\nConnection is complete!");
            String msg;
            try {
                while ((msg = connection.in.readObject().toString()) != null) {
                    System.out.println(msg);
                }
            } catch (IOException ex) {
                System.err.println("Lost Client's Stream.");
            } catch (ClassNotFoundException ex) {
                System.err.println("How the fuck would it not be able to find a java native class...");
            }
        } catch (IOException ex) {
            System.err.println("Connection failed to complete! Stopping...");
            System.exit(-1);
        }
        System.out.println("Server closing.");
        try {
            socks.close();
        } catch (IOException ex) {
            System.err.println("Server Socket Failed to close. Stopping...");
            System.exit(-1);
        }
        System.out.println("Closing connection...");
        try {
            connection.in.close();
            connection.out.close();
        } catch (IOException ex) {
            System.err.println("Could not close Object Streams. Stopping...");
            System.exit(-1);
        }
        System.out.println("Connection Closed!");
    }
}
