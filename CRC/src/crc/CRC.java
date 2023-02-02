/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crc;

/**
 *
 * @author Mubashshir
 */
import java.util.Scanner;
class CRC{
    public static void main(String arg[]){
        Scanner sc=new Scanner(System.in);
        int m,g[],d[],n,z[],r[],msb,i,j,k,e,p,c[];
        System.out.print("Enter the no of data bits\n");
        n=sc.nextInt();
        System.out.print("Enter the no of generator bits\n");
        m=sc.nextInt();
        d=new int[n+m];
        g=new int[m];
        c=new int[n+m];
        System.out.print("Enter the data bits\n");
        for(i=0;i<n;i++)
            d[i]=sc.nextInt();
        System.out.print("Enter the generator bits\n");
        for(j=0;j<m;j++)
            g[j]=sc.nextInt();
        for(i=0;i<m-1;i++)
            d[n+i]=0;
        r=new int[m+n];
        for(i=0;i<m;i++)
            r[i]=d[i];
        z=new int[m];
        for(i=0;i<m;i++)
            z[i]=r[i];
        for(i=0;i<n;i++)
        {
            k=0;
            msb=r[i];
            for(j=i;j<m+i;j++)
            {
                if(msb==0)
                    r[j]=xor(r[j],z[k]);
                else
                    r[j]=xor(r[j],g[k]);
                k++;
            }
            r[m+i]=d[m+i];            
        }
        System.out.print("The code bits added are\n");
        for(i=n;i<n+m-1;i++){
            d[i]=r[i];
            System.out.print(d[i]);
        }
        for(i=0;i<n+m-1;i++){            
            System.out.print(d[i]);
            c[i]=d[i];
        }  
        System.out.println("Do you want to mae an error Yes(0)/No(1)?");
        e=sc.nextInt();
        if(e==0)
        {
            System.out.print("Enter the position\n");
            p=sc.nextInt();
            if(d[p]==0)
                d[p]=1;
            else
                d[p]=0;
        }
        else
            System.out.print("No erro detected\n");
        for(i=0;i<n+m-1;i++)
        {
            if(c[i]==d[i]);
            else
            {
                System.out.print("Erroneous Data\n");
                for(i=0;i<n+m-1;i++)
                    System.out.print(d[i]);
                System.out.print("Error detected\n");
                break;
            }
        }        
    }
    public static int xor(int x,int y)
        {
            if(x==y)
                return(0);
            else
                return 1;
        }
}