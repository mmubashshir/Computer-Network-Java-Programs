/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udpc;
import java.io.*;
import java.net.*;
/**
 *
 * @author Mubashshir
 */
public class Udpc {

   public static void main(String args[]) throws SocketException,IOException
{
    DatagramSocket dsock=new DatagramSocket(9876);
    DatagramPacket dpack;
    while(true){
        byte arr1[]=new byte[1024];
        dpack=new DatagramPacket(arr1,arr1.length);
        dsock.receive(dpack);
        byte arr2[]=dpack.getData();
        String stt=new String(arr2);
        System.out.println(stt);
    }
}
}

