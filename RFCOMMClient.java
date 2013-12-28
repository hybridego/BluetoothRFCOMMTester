import java.io.*;
import javax.microedition.io.*;
import javax.bluetooth.*;

public class RFCOMMClient {

 public static void main( String args[] ) {
   try {

      System.out.println("connecting\r\n");
      StreamConnection conn = (StreamConnection) 
          Connector.open("btspp://0012D25ABDE4:3");

      System.out.println("connected\r\n");
      DataOutputStream out = new DataOutputStream(
                                              conn.openOutputStream());
      DataInputStream in = new DataInputStream(
                                              conn.openInputStream());

      System.out.println("Send:hello\r\n");
      out.writeUTF("Hello");               // Write server
      System.out.println("Sent:hello\r\n");
      String received = in.readUTF();	// Read server
      System.out.println(received);
      
      conn.close();
   } 
   catch ( IOException e ) { System.err.print(e.toString()); }
 }
}
