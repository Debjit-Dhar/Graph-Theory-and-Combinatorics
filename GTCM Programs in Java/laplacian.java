import java.util.*;
class Laplacian
{
    static ArrayList<ArrayList<Integer>> laplacian(int n)
    {
        Scanner sc=new Scanner(System.in);
        ArrayList<ArrayList<Integer>> a=new ArrayList<ArrayList<Integer>>(n);
        int i,j;
        for (i = 0; i < n; i++) {
            ArrayList<Integer> row = new ArrayList<>(n);
            for (j = 0; j < n; j++) {
                System.out.print("Enter");
                row.add(sc.nextInt());
            }
            a.add(row);
        }
        System.out.println("Adjacency Matrix is:");
        for(ArrayList<Integer> row:a)
        {
            for(int x:row)
            {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        ArrayList<ArrayList<Integer>> l=new ArrayList<ArrayList<Integer>>(n);
        int sum=0;
        for(i=0;i<n;i++)
        {
            sum=0;
            ArrayList<Integer> row = new ArrayList<>(n);
            for(j=0;j<n;j++)
                sum+=a.get(i).get(j);
            System.out.println("sum "+i+"= "+sum);
            for(j=0;j<n;j++)
               if(i==j)
                row.add(sum);
               else
                row.add(-a.get(i).get(j));
            l.add(row);
        }
        System.out.println("Laplacian Matrix is:");
        for(ArrayList<Integer> row:l)
        {
            for(int x:row)
            {
                System.out.print(x+" ");
            }
            System.out.println();
        }
        sc.close();
        return l;
    }
}
class MainClass
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter order of graph");
        int n=sc.nextInt();
        Laplacian.laplacian(n);
        sc.close();
    }
}