#include <iostream>
using namespace std;

int main(){
    int T;
    cin>>T;
    string s;
    int n;
    for(int i=0; i<T; i++){
        cin>>n>>s;
            
        for(int j=0; j<s.length(); j++){
            for(int k=0; k<n; k++){
                cout<<s[j];
            }
        
        }
        cout<<"\n";
    }  

    return 0;
}