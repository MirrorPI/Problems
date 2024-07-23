#include <iostream>
using namespace std;

int main(){
    int a[100][100] ={0};
    int n;
    cin>>n;
    int x, y;
    for(int i=0; i<n; i++){
        cin>>x>>y;
        for(int j=x; j<x+10; j++){
            for(int k=y; k<y+10; k++){
                a[j][k] = 1;
            }
        }
    }
    int area = 0;
    for(int i=0; i<100; i++){
        for(int j=0; j<100; j++){
            area += a[i][j];
        }
    }
    cout<<area;
    return 0;
}