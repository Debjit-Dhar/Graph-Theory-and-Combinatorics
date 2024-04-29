#include <iostream>
#include <algorithm>
#include <string>
#include <vector>
#include <numeric>
using namespace std;
//IMPLEMENT FLUERY ALGORITHM TO GENERATE EULERIAN TRAIL OF AN EULERIAN GRAPH
string etgenerator() {
    int n;
    cin >> n;
    vector<vector<int>> a(n, vector<int>(n, 0));
    int i, j;
    for (i = 0; i < n; i++) {
        for (j = 0; j < n; j++) {
            cout << "Enter\n";
            cin >> a[i][j];
        }
    }
    
    int v = 0;
    bool flag;
    string etrail = "";
    int nov = n;
    
    while (nov != 1) 
    {
        
        flag = false;
        
        for (j = 0; j < n; j++) 
        {
            if (a[v][j] >= 1) 
            {
                if (accumulate(a[v].begin(), a[v].end(), 0) == 1)
                {
                    etrail += to_string(v) + "-> ";
                    a[v][j] -= 1;
                    a[j][v] -= 1;
                    cout<<"Gone "<<v<<" "<<j<<endl;
                    v = j;
                    cout<<"Current v is: "<<v<<endl;
                    flag = true;
                    nov--;
                    break;
                    
                } 
                else 
                {
                    if(accumulate(a[j].begin(),a[j].end(),0)>1)
                    {
                        etrail += to_string(v) + "-> ";
                        a[v][j] -= 1;
                        a[j][v] -= 1;
                        cout<<"Gone "<<v<<" "<<j<<endl;
                        v = j;
                        cout<<"Current v is: "<<v<<endl;
                        flag = true;
                        
                        
                        break;
                        
                    }
                    else
                        continue;
                }
            }
            
        }
        if (!flag)
        {
            if(v<n-1)
            v++;
            else
            v=0;
        }
        
    }
    
    
    etrail+=to_string(v);
    return etrail;
}

int main() {
    cout << "The Eulerian Trail is\n";
    cout << etgenerator();

    return 0;
}
