#include <iostream>
#include <cmath>
using namespace std;

int main(){
    long long int n = 0;
    string a;
    int m;
    cin>>a>>m;
    int len = a.size();
    int temp = len;

    for(int i=0; i<len; i++){
        if(48<=a[i] && a[i]<=57){
            n += (a[i]-48)*pow(m, --temp);
        }
        else{
            n += (a[i]-55)*pow(m,--temp);
        }
    }
    cout<<n;
    return 0;
}