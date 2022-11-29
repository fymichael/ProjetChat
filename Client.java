import java.net.*;
import java.io.*;

public class Client {
	static int port = 1212;
	public static void main(String[] args) throws Exception {
		Socket s=new Socket("localhost",port);
		DataInputStream d_in=new DataInputStream(s.getInputStream());
		DataOutputStream d_out = new DataOutputStream(s.getOutputStream());
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

		String str="",str2="";
		while(!str.equals("stop")) {
			System.out.print("--> : ");
			str=br.readLine();
			d_out.writeUTF(str);
			System.out.println("waiting for Client response");
			d_out.flush();
			str2=d_in.readUTF();
			System.out.println("Server : "+str2);
		}

		d_out.close();
		s.close();
	}
}
