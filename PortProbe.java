//***** Socket basics: first, "blocking" sockets
import java.net.Socket;
import java.net.UnknownHostException; 
import java.io.IOException;
 
 public class PortProbe {
     public static void main(String[ ] args) {
         if (args.length < 1) {
            System.err.println("Usage: PortProbe <IP address>");
            return;
         }
         String host = args[0];
         // port numbers for common services
         int[ ] ports = {
              7,     // ping
             13,     // daytime
             21,     // ftp
             23,     // telnet
             71,     // finger
             80,     // http
            119,     // nntp (news)
            161      // snmp
         };
         // Probe each port.
         for (int i = 0; i < ports.length; i++) {
             try {
                 Socket sock = new Socket(host, ports[i]);
                 System.out.println(host + " listening on port " + ports[i]);
                 sock.close();
             }
             catch(UnknownHostException e) {
                 System.err.println(e);
                 return;
             }
             catch(IOException e) {
                 System.out.println(host + " not listening on port " 
                     + ports[i]);
             }
         }
     }
 }       
