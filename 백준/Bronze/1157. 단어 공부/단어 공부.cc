#include <iostream>
using namespace std;

int main(){

    //65~90 A~Z
    //97~122 a~z
    int alpha[26] = {0};
    string a;
    cin>>a;
    int len = a.size();
    for(int i=0; i<len; i++){
        if(a[i] > 90){
            alpha[a[i]-97]++;
        }
        else{
            alpha[a[i]-65]++;
        }
    }
    int max = alpha[0];
    for(int i=1; i<26; i++){
        if(max < alpha[i]){
            max=alpha[i];
        }
    }
    int maxCnt=0;
    int maxIndex;
    for(int i=0; i<26; i++){
        if(max == alpha[i]){
            maxCnt++;
            maxIndex = i;
        }
    }
    char last = maxIndex+65;
    if(maxCnt > 1){
        cout<<'?';
    }
    else{
        cout<<last;
    }
    return 0;
}