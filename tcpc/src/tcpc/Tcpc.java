/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcpc;

/**
 *
 * @author Mubashshir
 */
import java.io.*;
import java.net.*;
public class Tcpc {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SocketException,IOException{
        // TODO code application logic here
        Socket s=new Socket("127.0.0.1",1024);
        BufferedReader k=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter Filename\n");
        String filename=k.readLine();
        DataOutputStream d=new DataOutputStream(s.getOutputStream());
        d.writeBytes(filename+"/n");
        BufferedReader i=new BufferedReader(new InputStreamReader(s.getInputStream()));
        String st;
        st=i.readLine();
        if(st.equals("Yes"))
        {
            while((st=i.readLine())!=null)
                d.writeBytes(st);
            i.close();
            d.close();
            s.close();
        }
    }
    
}
