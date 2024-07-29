#include <iostream>
using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    int A, B, V;
    cin>>A>>B>>V;
    int h = A-B;
    int last = V-A;
    int day;
    if(last%h ==0){
        day =last/h + 1;
    }
    else{
        day = last/h +2;
    }

    cout<<day;
    return 0;
}