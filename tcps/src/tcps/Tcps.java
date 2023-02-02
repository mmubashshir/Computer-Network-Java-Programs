/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcps;

/**
 *
 * @author Mubashshir
 */
import java.io.*;
import java.net.*;

public class Tcps {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        ServerSocket se=new ServerSocket(1024);
        Socket q=se.accept();
        System.out.println("Connection established Successfully\n");
        BufferedReader v=new BufferedReader(new InputStreamReader(q.getInputStream()));
        DataOutputStream dr=new DataOutputStream(q.getOutputStream());
        String g=v.readLine();
        FileReader f=null;
        BufferedReader ff=null;
        File r=new File(g);
        boolean b;
        if(r.exists())
            b=true;
        else
            b=false;
        if(b==true)
            dr.writeBytes("Yes \n");
        else
            dr.writeBytes("No \n");
        if(b==true)
        {
            f=new FileReader(g);
            ff=new BufferedReader(f);
            String qq;           
        
        while((qq=ff.readLine())!=null){
            dr.writeBytes(qq+"/n");
        }
        dr.close();
        ff.close();
        v.close();
        se.close();
        q.close();
        f.close();
    }
    }
}
