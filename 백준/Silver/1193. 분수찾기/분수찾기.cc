#include <iostream>
using namespace std;

int main(){
    int n;
    cin>>n;
    int line;
    int i=1;

    while(true){
        if(n<=i*(i+1)/2){
            break;
        }
        i++;
    }
    int m = i*(i+1)/2;
    int l = m-n;
    if(i%2 == 1){
        cout<<1+l<<"/"<<i-l;
    }
    else{
        cout<<i-l<<"/"<<1+l;
    }
    return 0;
}