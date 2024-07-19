#include <iostream>
using namespace std;

int main(){
    int a;
    cin>>a;

    for(int i=0; i<2*a-1; i++){
        if(i<a){
            for(int j=0; j<a-i-1; j++){
                cout<<' ';
            }
            for(int k=0; k<2*i+1; k++){
                cout<<"*";
            }
        }
        else{
            for(int j=0; j<i-a+1; j++){
                cout<<' ';
            }
            for(int k=0; k<4*a-3-2*i; k++){
                cout<<"*";
            }
        }
        cout<<endl;
    }
    return 0;
}