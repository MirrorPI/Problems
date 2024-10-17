#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    int n, m; 
    cin>>n>>m;
    unsigned int sum = 0;
    int h = 0;
    int myTree = 0;
    


    vector<int> tree(n+1, 0);  //tree's height 0 ~ 1,000,000,000 
    for(int i=1; i<=n; i++){
        cin>>tree[i]; 
        sum += tree[i];
    }

    if(sum == m){
        cout<<h;
        return 0;
    }
    else{
        sort(tree.begin() + 1, tree.end());
        h = tree[n];

        for(int i=0; i<n; i++){
            int gap = tree[n-i]-tree[n-i-1];
            for(int j=1; j<= gap; j++){
                h--;
                myTree += i+1;
                
                if(myTree >= m){
                    cout<<h;
                    return 0;
                }
            }
        }
    }
}