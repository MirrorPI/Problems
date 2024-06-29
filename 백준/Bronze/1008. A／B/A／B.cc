#include <iostream>
using namespace std;
#include <iomanip> 
int main(){
    int A, B;
    double C;
    cin>>A>>B;
    C = (double)A/(double)B;
    cout<<fixed<<setprecision(15)<<C;

    return 0;
}