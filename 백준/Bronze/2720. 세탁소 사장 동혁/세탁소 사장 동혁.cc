#include <iostream>
using namespace std;

int main(){
    int T;
    cin>>T;
    int money;
    int num[4];
    int coin[4] = {25, 10, 5, 1};
    for(int i=0; i<T; i++){
        cin>>money;
        for(int j=0; j<4; j++){
            num[j] = money/coin[j];
            money %= coin[j];
            cout<<num[j]<<' ';
        }
    }
    return 0;
}