#include <iostream>
using namespace std;


int main(){
    // a~z 97~122
    int num[26];
    for(int i=0; i<26; i++){
        num[i] = -1;
    }
    string s;
    cin>>s;
    int len = s.length();
    for(int i=len-1; i>=0; i--){ 
        num[s[i]-97] = i;
    }
    for(int i=0; i<26; i++){
        cout<<num[i]<<" ";
    }

    return 0;
}