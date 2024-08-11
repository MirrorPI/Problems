#include <iostream>
using namespace std;

int main(){
    int a, b, c, k;
    cin>>a>>b;
    cin>>c;
    cin>>k;

    if(a<=c){
        if(a*k+b <= c*k){
            cout<<1;
        }
        else{
            cout<<0;
        }
    }
    else{
        cout<<0;
    }
    return 0;
}