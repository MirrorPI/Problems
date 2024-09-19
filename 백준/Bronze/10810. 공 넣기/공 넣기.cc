#include <iostream>
#include <vector>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m; cin>>n>>m;
    vector<int> basket(n, 0);

    for(int i=0; i<m; i++){
        int a, b, c; cin>>a>>b>>c;
        for(int j=a; j<=b; j++){
            basket[j-1] = c;
        }
    }
    for(int num : basket){
        cout<<num<<' ';
    }
    return 0;
}