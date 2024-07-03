#include <iostream>
using namespace std;

int main(){
    int A, B;
    int BHundreds, BTens, BUnits;
    cin>>A>>B;
    BHundreds = B/100;
    BTens = (B-BHundreds*100)/10;
    BUnits = (B-BHundreds*100-BTens*10);

    cout<<A*BUnits<<endl;
    cout<<A*BTens<<endl;
    cout<<A*BHundreds<<endl;
    cout<<A*B;

    return 0;
}