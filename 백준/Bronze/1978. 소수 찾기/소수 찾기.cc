#include <iostream>
using namespace std;

int main(){
    int N;
    cin>>N;
    int num;
    int count;
    int prime = 0;
    for(int i=0; i<N; i++){
        count = 0;
        cin>>num;
        if(num == 2){
            prime++;
        }
        else if(num>2){
            for(int j=2; j<num; j++){
                if(num%j == 0){
                    count++;
                    break;
                }
            }
            if(count == 0){
                prime++;
            }
        }
    }
    cout<<prime;
    return 0;
}