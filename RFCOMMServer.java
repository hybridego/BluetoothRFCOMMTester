
import java.io.*;
import javax.microedition.io.*;
import javax.bluetooth.*;
//import com.patco.hexdump;
public class RFCOMMServer {
   static final byte STX = (0x02);
   static final byte CR = (0x0d);
   static final byte ETX = (0x03);
    static HexDump hexdump;
    public static void main(String args[]) {
      hexdump = new HexDump();
      try {
         

         System.out.println("starting");
         StreamConnectionNotifier service = (StreamConnectionNotifier) Connector.open("btspp://localhost:" 
                            + new UUID("BAE0D0C0B0A00095570605040302011",false).toString() 
                            + ";name=helloService");

         System.out.println("doaccept");
         StreamConnection conn = (StreamConnection) service.acceptAndOpen();
         System.out.println("Connected");

         DataInputStream in = new DataInputStream(conn.openInputStream());
         DataOutputStream out = new DataOutputStream(conn.openOutputStream());
for(int i = 0;i<100;i++)
{
         System.out.println("blockonrecv");
     //    String received = in.readUTF();	 // Read from client
byte[] b;
int len;
b = new byte[256];
          len = in.read(b);	 // Read from client
         String str;
         str = new String(b,"UTF-8");
         System.out.println("receiveddataoflength:len>"+len+"<"+"val>"+str+"<");

 	if(b[0] == 'V')
	{
                byte[] bOut;
		bOut = new byte[11];
		bOut[0] = STX;
                bOut[1] = 'N';
		bOut[2] = 'E';
                bOut[3] = 'a';
                bOut[4] = 'b';
		bOut[5] = 'c';
		bOut[6] = 'V';
		bOut[7] = '1';
		bOut[8] = '.';
		bOut[9] = '1';
		bOut[10] = ETX;

         	out.write(bOut);	 // Send Echo to client
         	System.out.println("versionresponse back to client");
	}

        if((b[0] == 'B') && (b[1] == 'U') && (b[2] == 'Z') &&(b[3]=='0') )
        {
                byte[] bOut;
                bOut = new byte[3];
                bOut[0] = STX;
                bOut[1] = '0';
                bOut[2] = ETX;

                out.write(bOut);         // Send Echo to client
                System.out.println("buz0response back to client");
        }

        if((b[0] == 'B') && (b[1] == 'U') && (b[2] == 'Z') &&(b[3]=='1') )
        {
                byte[] bOut;
                bOut = new byte[3];
                bOut[0] = STX;
                bOut[1] = '1';
                bOut[2] = ETX;

                out.write(bOut);         // Send Echo to client
                System.out.println("buz1response back to client");
        }
        if((b[0] == 'A') && (b[1] == 'L') && (b[2] == '1') )
        {
                byte[] bOut;
                bOut = new byte[3];
                bOut[0] = STX;
                bOut[1] = '1';
                bOut[2] = ETX;

                out.write(bOut);         // Send Echo to client
                System.out.println("al1response back to client");
        }
        if((b[0] == 'A') && (b[1] == 'L') && (b[2] == '0') )
        {
                byte[] bOut;
                bOut = new byte[3];
                bOut[0] = STX;
                bOut[1] = '0';
                bOut[2] = ETX;

                out.write(bOut);         // Send Echo to client
                System.out.println("al0response back to client");
        }
        if((b[0] == 'D') && (b[1] == 'I') && (b[2] == 'S') )
        {
                byte[] bOut;
                bOut = new byte[14];
                bOut[0] = STX;
                bOut[1] = 'I';
                bOut[2] = '1';
                bOut[3] = '1';
                bOut[4] = '.';
                bOut[5] = '3';
                bOut[6] = 'W';
                bOut[7] = '1';
                bOut[8] = '9';
                bOut[9] = '.';
                bOut[10] = '5';
                bOut[11] = 'm';
                bOut[12] = 'l';
                bOut[13] = ETX;

                out.write(bOut);         // Send Echo to client
                System.out.println("disresponse back to client");
        }
        if((b[0] == 'D') && (b[1] == 'I') && (b[2] == 'A') )
        {
                byte[] bOut;
                bOut = new byte[6];
                bOut[0] = STX;
                bOut[1] = '2';
                bOut[2] = '.';
                bOut[3] = '1';
                bOut[4] = '3';
                bOut[5] = ETX;

                out.write(bOut);         // Send Echo to client
                System.out.println("diaresponse back to client");
        }
	
} 
         conn.close();
         service.close();

      } catch (IOException e) {	System.err.print(e.toString());   }
   }
}

