#include <iostream>
using namespace std;
#define END 999

int main(){
    // abcde fghij klmno pqrst uvwxy z 97~122
    int n;
    cin>>n;
    string s;
    int count = 0;
    bool isG;
    int len;
 
    for(int i=0; i<n; i++){
        cin>>s;
        len= s.size();
        isG = true;
        int alpha[26] ={0};
        for(int j=0; j<len-1; j++){   
            if(s[j] != s[j+1]){
                alpha[s[j]-97] = END;
            }
            if(alpha[s[j+1]-97] == END){
                isG = false;
                break;
            }
        }
        if(isG == true){
            count++;
        }
    }
    cout<<count;
    return 0;
}