#include <iostream>
using namespace std;

int main(){
    int N; cin>>N;
    int result = -1;

    if(N == 4 || N == 7){
    }
    else if(N%5 == 0){
        result = N/5;
    }
    else if(N%5 == 1){
        result = N/5 -1 + 2;
    }
    else if(N%5 == 2){
        result = N/5 -2 + 4;
    }
    else if(N%5 == 3){
        result = N/5 + 1;
    }
    else{
        result = N/5 - 1 + 3;
    }
    cout<<result;
}