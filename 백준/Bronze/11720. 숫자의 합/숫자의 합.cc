#include <iostream>
using namespace std;

int main(){
    int len;
    cin>>len;
    char num[len+1];
    cin>>num;
    int sum=0;
    for(int i=0; i<len; i++){
        sum+=static_cast<int>(num[i])-48;
    }
    cout<<sum;

    return 0;
}