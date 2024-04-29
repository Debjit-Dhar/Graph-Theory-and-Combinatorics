//Check whether a graph is eulerian
#include <stdio.h>
#include <stdlib.h>
int iseulerian()
{
    int n;
    printf("Enter number of vertices\n");
    scanf("%d",&n);
    int **a=(int**)malloc(sizeof(int*)*n);
    int i,j;
    for(i=0;i<n;i++)
        *(a+i)=(int*)malloc(sizeof(int)*n);
    for(i=0;i<n;i++)
    {
        for(j=0;j<n;j++)
        {
            printf("Enter");
            scanf("%d",&a[i][j]);
        }
    }
    int deg=0;
    for(i=0;i<n;i++)
    {
        deg=0;
        for(j=0;j<n;j++)
            deg+=a[i][j];
        if(deg%2!=0)
            return 0;
    }
    return 1;
}
int main()
{
    if(iseulerian())
        printf("Eulerian graph\n");
    else
        printf("Not eulerian graph\n");
    return 0;
}