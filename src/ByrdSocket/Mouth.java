package ByrdSocket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author ibyrd
 */
public class Mouth {

    Socket socks;
    ObjectOutputStream out;
    ObjectInputStream in;

    public Mouth(String IP, int Port) {
        try {
            socks = new Socket(IP, Port);
        } catch (UnknownHostException ex) {
            System.err.println("Host Could Not Be ID'd.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("Port " + Port + " is unavailable or another IOException Occured!");
            System.exit(-1);
        }
        try {
            in = new ObjectInputStream(socks.getInputStream());
            out = new ObjectOutputStream(socks.getOutputStream());
            System.out.println("Sending Message to Server!");
            System.out.println("Client is closing resources!");
            socks.close();
            in.close();
            out.close();
            System.out.println("Client is Done!");
        } catch (IOException ex) {
            System.err.println("Failed to declare Object Streams... Stopping...");
            System.exit(-1);
        }
    }
}
