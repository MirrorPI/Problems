#include <iostream>
using namespace std;

int main(){
    int a, b;
    cin>>a>>b;
    int arr[100];
    int n = 0;
    for(int i=1; i<=a; i++){
        if(a%i == 0){
            arr[n++]=i;
        }
    }
    if(b>n){
        cout<<"0";
    }
    else{
        cout<<arr[b-1];
    }
    return 0;
}