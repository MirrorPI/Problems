#include <iostream>
using namespace std;

int main(){
    int N; cin>>N;
    int arr[1000] = {0};
    int count = 0;
    for(int i=2; i<=N; i++){
        if(N%i == 0){
            arr[count++] = i;
        }
    }

    for(int i=0; i<count;){
        if(N%arr[i]==0){
            cout<<arr[i]<<"\n";
            N /= arr[i];
            continue;
        }
        i++;
    }
    return 0;
}