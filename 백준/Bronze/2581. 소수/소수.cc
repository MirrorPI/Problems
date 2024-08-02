#include <iostream>
using namespace std;

int main(){
    int N, M;
    cin>>N>>M;
    int primeNum[2000] = {0};
    int prime = 0;

    int sum =0;
    for(int i = N; i<=M; i++){
        bool isBreak = false;
        if(i == 1){
            isBreak = true;
            continue;
        }
        else if(i == 2 || i== 3){
            primeNum[prime++] = i;
            sum += i;
        }
        else{
            for(int j=2; j*j<=i; j++){
                if(i%j == 0){
                    isBreak = true;
                    break;
                }
            }
            if(isBreak == false){
                primeNum[prime++] = i;
                sum += i; 
            }

        }
    }
    if(prime == 0){
        cout<<-1;
    }

    else{
        cout<<sum<<"\n"<<primeNum[0];
    }
    return 0;
}