import java.net.*;  
import java.io.*; 

public class Serveur {

	private static int port = 1212;
		public static void main(String[] args) throws Exception {
			ServerSocket SocketServer=new ServerSocket(port);
			Socket s=SocketServer.accept();
			DataInputStream d_in=new DataInputStream(s.getInputStream());
			DataOutputStream d_out=new DataOutputStream(s.getOutputStream());
			BufferedReader br=new 
			BufferedReader(new InputStreamReader(System.in));

			String str="",str2="";
			while(!str.equals("stop")) {
				System.out.println("waiting for Server response");
				str=d_in.readUTF();
				System.out.println("client says: "+str);
				System.out.print("--> : ");
				str2=br.readLine();
				d_out.writeUTF(str2);
				d_out.flush();
			}
			d_in.close();
			s.close();
			SocketServer.close();
		}
	}
