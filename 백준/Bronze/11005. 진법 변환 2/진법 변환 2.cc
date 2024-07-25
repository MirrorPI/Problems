#include <iostream>
#include <cmath>
using namespace std;

int main(){
    long long int n;
    int m;
    cin>>n>>m;
    int len=0;
    int num[100];
    
    while(pow(m, len)<=n) {
        len++;
        num[len-1] = n%static_cast<int>(pow(m, len));
        n -= num[len-1];
        num[len-1] = num[len-1]/static_cast<int>(pow(m, len-1));
    }

    for(int i=len-1; i>=0; i--){
        if(num[i]>9){
            cout<<static_cast<char>(num[i]+55);
        }
        else{
            cout<<num[i];
        }

    }
    return 0;
}