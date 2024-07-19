#include <iostream>
using namespace std;

int main(){
    string a;
    cin>>a;
    int len = a.size();
    int count=0;
    for(int i=0; i<len; i++){
        if(a[i]==a[len-i-1]){
            count++;
        }
    }
    if(count == len){
        cout<<1;
    }
    else{
        cout<<0;
    }

    return 0;
}