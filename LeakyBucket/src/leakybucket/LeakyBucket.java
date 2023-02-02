/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leakybucket;

/**
 *
 * @author Mubashshir
 */
import java.io.*;
import java.util.Scanner;
class LeakyBucket{
    public static int min(int x,int y)
    {
        if(x<y)
            return x;
        else
            return y;
    }
    public static void main(String arg[])
    {
        Scanner sc=new Scanner(System.in);
        int drop=0,mini,count=0,cap,n,i;
        int inp[]=new int[25];
        int process;
        System.out.println("Enter the bucket size\n");
        cap=sc.nextInt();
        System.out.println("Enter the output rate\n");
        process=sc.nextInt();
        System.out.println("Enter the number of packets to be sent\n");
        n=sc.nextInt();
        System.out.println("Enter the packets to be sent\n");
        for(i=0;i<n;i++)
            inp[i]=sc.nextInt();
        System.out.println("Second | Packets Recieved | Packets Sent | Packets Left | Packets Left\n");
        System.out.println("----------------------------------------------------------------------\n");
        for(i=0;i<n;i++)
        {
           count+=inp[i];
           if(count>cap)
           {
               drop=count-cap;
               count=cap;
           }
           System.out.print(i+1);
           System.out.print("\t\t"+inp[i]);
           mini=min(count,process);
           System.out.print("\t\t"+mini);
           count=count-mini;
           System.out.print("\t\t"+count);
           System.out.print("\t\t"+drop);
           drop=0;
           System.out.println();

        }
        for(;count!=0;i++)
        {
           if(count>cap)
           {
               drop=count-cap;
               count=cap;
           }
           System.out.print(i+1);
           System.out.print("\t\t0");
           mini=min(count,process);
           System.out.print("\t\t"+mini);
           count=count-mini;
           System.out.print("\t\t"+count);
           System.out.print("\t\t"+drop);
           System.out.println();

        }
    }
}