#include <iostream>
using namespace std;

int main(){
    int chess[6] = {1, 1, 2, 2, 2, 8};
    int num;
    for(int i=0; i<6; i++){
        cin>>num;
        cout<<chess[i]-num<<' ';
    }
    return 0;
}