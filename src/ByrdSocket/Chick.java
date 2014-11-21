package ByrdSocket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author ibyrd
 */
public class Chick {

    Socket sock;
    ObjectOutputStream out;
    ObjectInputStream in;
    BufferedReader buffRead;

    public void SetUp() throws IOException {
        out = new ObjectOutputStream(sock.getOutputStream());
        in = new ObjectInputStream(sock.getInputStream());
        buffRead = new BufferedReader(new InputStreamReader(in));
    }
}
