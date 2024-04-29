//Number of spanning trees of undirected graph
import java.util.*;
class Spanning 
{
    static int span(int n)
    {
        int st=0,s=0,t=0;
        ArrayList<ArrayList<Integer>> l=Laplacian.laplacian(n);
        l.remove(s);
        for(int i=0;i<l.size();i++)
            l.get(i).remove(t);
        st=(int)Math.pow(-1,s+t+2)*determinant(l,l.size());
        System.out.print("Number of Spanning Trees= "+st);
        return st;
    }
    private static int determinant(ArrayList<ArrayList<Integer>>a,int n) {
        int det = 0;
      
        if (n == 1) {
          // Base case: 1x1 matrix
          det = a.get(0).get(0);
        } else if (n == 2) {
          // Base case: 2x2 matrix
          det = a.get(0).get(0) * a.get(1).get(1) - a.get(0).get(1) * a.get(1).get(0);
        } else {
          // Recursive case: nxn matrix
          for (int i = 0; i < n; i++) 
          {
            ArrayList<ArrayList<Integer>> submatrix = new ArrayList<ArrayList<Integer>>(n);
            for (int k = 0; k < n; k++) {
                ArrayList<Integer> row = new ArrayList<>();
                for (int j = 0; j < n; j++) {
                    row.add(0); 
                }
                submatrix.add(row);
            }
            for (int j = 1; j < n; j++) 
            {
              int sub_i = 0;
              for (int k = 0; k < n; k++)
               {
                if (k == i) {
                  continue;
                }
                submatrix.get(sub_i).set(j - 1, a.get(j).get(k));
                sub_i++;
              }
            }
            det += a.get(0).get(i) * determinant(submatrix, n - 1) * (i % 2 == 0 ? 1 : -1);
          }
        }
      
        return det;
      }
}
class MainClass
{
    public static void main(String args[])
    {
        int n;
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        Spanning.span(n);
        sc.close();
    }
}