#include <iostream>
#include <cstring>
using namespace std;

int main(){
    int len[5];
    char a[5][15];
    
    for(int i=0; i<5; i++){
        cin>>a[i];
        len[i] = strlen(a[i]);
        for(int j=len[i]; j<15; j++){
            a[i][j] = '\0';
        }
    }
    for(int i=0; i<15; i++){
        for(int j=0; j<5; j++){
            if(a[j][i] != '\0'){
                cout<<a[j][i];
            }

        }
    }

    return 0;
}