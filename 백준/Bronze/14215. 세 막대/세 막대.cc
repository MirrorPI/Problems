#include <iostream>
using namespace std;

int main(){
    int a, b, c;
    int temp;
    cin>>a>>b>>c;
    if(a>b){
        temp = a;
        a = b;
        b = temp;
    }
    if(a>c){
        temp = a;
        a = c;
        c = temp;
    }
    if(b>c){
        temp = c;
        c = b;
        b = temp;
    }
    if(a+b>c){
        cout<<a+b+c;
    }
    else{
        c = a+b -1;
        cout<<a+b+c;
    }
    return 0;
}