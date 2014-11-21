package ByrdSocket;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import com.sun.corba.se.pept.transport.Acceptor;
import com.sun.corba.se.pept.transport.Connection;
import com.sun.corba.se.pept.transport.EventHandler;
import com.sun.corba.se.spi.orbutil.threadpool.Work;
import java.io.IOException;
import java.net.ServerSocket;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 *
 * @author ibyrd
 */
public class MomaByrd {

    private ServerSocket socks;
    private <Chick> chicks;
    /**
     * Sets the chicks list to an arraylist for more common use.
     * Used when you want to just open a server quickly and with little fuss or
     * when you want to track your own connections.
     * <p>
     * See {@link java.net.ServerSocket#ServerSocket(int)}
     * </p>
     * @param Port The port the server will open on.
     */
    public MomaByrd(int Port) {
        chicks = new ArrayList<Chick>();
        try {
            socks = new ServerSocket(Port);
        } catch (IOException ex) {
            System.err.println(Arrays.toString(ex.getStackTrace()));
            System.exit(74);
        }
    }
    public MomaByrd(int Port, Map chicks){
        this.chicks = chicks;
        
    }
        try {
            Chick newChick = new Chick();
            newChick.sock = socks.accept();
            newChick.SetUp();
        } catch (IOException ex) {
            System.err.println(Arrays.toString(ex.getStackTrace()));
            System.exit(74);
        }
        
//        Object msg;
//        try {
//            while ((msg = chicks.in.readObject().toString()) != null) {
//
//            }
//        } catch (IOException | ClassNotFoundException ex) {
//            System.err.println(Arrays.toString(ex.getStackTrace()));
//        }
//        try {
//            chicks.in.close();
//            chicks.out.close();
//        } catch (IOException ex) {
//            System.err.println(Arrays.toString(ex.getStackTrace()));
//            System.exit(74);
//        }
    
    private void closeServerSocket(){
        try {
            socks.close();
        } catch (IOException ex) {
            System.err.println(Arrays.toString(ex.getStackTrace()));
            System.exit(74);
        }
    }
}
