#include <iostream>
using namespace std;

int main(){
    long long int n; cin>>n;
    long long int sum = 0;

    for(int i=1; i<=n-2; i++){
        sum += (n-i-1)*(n-i)/2;
    }
    cout<<sum<<endl;
    cout<<3;
    return 0;
}