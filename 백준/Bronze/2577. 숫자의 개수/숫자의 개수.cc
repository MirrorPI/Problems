#include <iostream>
#include <cmath>
using namespace std;

int main(){
    int A, B, C;
    cin>>A>>B>>C;

    int ABC = A*B*C;
    string ABCs = to_string(ABC);
    int len = ABCs.size();
    int digitCount[10] = {0};
    for(int i=0; i<len; i++){
        digitCount[ABCs[i]-'0']++;
    }
    for(int i=0; i<10; i++){
        cout<<digitCount[i]<<"\n";
    }
    return 0;
}