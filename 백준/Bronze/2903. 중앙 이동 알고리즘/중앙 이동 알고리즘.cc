#include <iostream>
using namespace std;

int main(){
    int N;
    cin>>N;
    int n = 2;
    for(int i=0; i<N; i++){
        n = n+(n-1);
    }
    n*=n;
    cout<<n;
    return 0;
}