/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package udps;

/**
 *
 * @author Mubashshir
 */
import java.io.*;
import java.net.*;
public class Udps{
    public static void main(String[] args) throws Exception{
        BufferedReader inFromUser=new BufferedReader(new InputStreamReader(System.in));
        new BufferedReader(new InputStreamReader(System.in));
        DatagramSocket serverSocket=new DatagramSocket();
        System.out.println("Server is ready");
        byte[] sendData=new byte[1024];
        byte[] recieveData=new byte[1024];
        InetAddress address=InetAddress.getLocalHost();
        String sentence=inFromUser.readLine();
        sendData=sentence.getBytes();
        DatagramPacket sendPacket=new DatagramPacket(sendData,sendData.length,address,9876);
        serverSocket.send(sendPacket);
    }
}