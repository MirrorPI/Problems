#include <iostream>
#include <cstring>
using namespace std;

int main(){
    string s;
    getline(cin, s);
    int cnt = 0;
    int len = s.size();
    for(int i=0; i<len; i++){
        if(s[i]==' '){
            cnt++;
        }
    }
    if(s[0] == ' '){
        cnt--;
    }
    if(s[len-1] != ' '){
        cnt++;
    }
    cout<<cnt;
    return 0;
}