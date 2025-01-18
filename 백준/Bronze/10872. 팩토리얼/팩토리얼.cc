#include <iostream>
using namespace std;

int main(){
    int N; 
    cin>>N;
    //12! < 2,100,000,000
    int factorial = 1;
    if(N == 0){
        cout<<factorial;
        return 0;
    }
    for(int i=1; i<=N; i++){
        factorial *= i;
    }
    cout<<factorial;
    return 0;

}