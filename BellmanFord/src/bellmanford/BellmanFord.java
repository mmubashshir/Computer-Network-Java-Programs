/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bellmanford;

/**
 *
 * @author Mubashshir
 */
import java.util.Scanner;
public class BellmanFord
{
    private int n;
    private int distance[];
    public static final int MAX_VALUE=999;
    public BellmanFord(int num_vertices)
    {
        this.n=num_vertices;
        distance=new int[num_vertices+1];
    }
    public void bellmanFord(int s,int cost[][])
    {
        for(int node=1;node<=n;node++)
        {
            distance[node]=MAX_VALUE;
        }
        distance[s]=0;
        for(int node=1;node<=n;node++)
        {
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(cost[i][j]!=MAX_VALUE)
                        if(distance[j]>distance[i]+cost[i][j])
                            distance[j]=distance[i]+cost[i][j];                         
                }
            }
        }
        for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=n;j++)
                {
                    if(cost[i][j]!=MAX_VALUE)
                        if(distance[j]>distance[i]+cost[i][j])
                            System.out.println("The graph contins negative edge cycle\n");                         
                }
            }
        for(int vertex=1;vertex<=n;vertex++)
        {
            System.out.println("The distance from"+s+" to "+vertex+" is "+distance[vertex]);
        }
    }
    public static void main(String arg[])
    {
        int n,source=0;
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the Number of adjacency matrix\n");
        n=sc.nextInt();
        int cost[][]=new int[n+1][n+1];
        System.out.println("Enter the adjacency matrix\n");
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=n;j++)
            {
                cost[i][j]=sc.nextInt();
                if(i==j)
                {
                    cost[i][j]=0;
                    continue;
                }
                if(cost[i][j]==0)
                {
                    cost[i][j]=MAX_VALUE;
                }
            }
        }
        System.out.println("Enter the source vertex\n");
        source=sc.nextInt();
        BellmanFord bell=new BellmanFord(n);
        bell.bellmanFord(source, cost);
        sc.close();
    }
}