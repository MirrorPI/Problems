#include <iostream>
using namespace std;

int main(){
    int T;
    cin >> T;
    string str;
    int len;
    for(int i=0; i<T; i++){
        cin>>str;
        len = str.length();
        cout<<str[0]<<str[len-1]<<endl;
    }   

    return 0;
}