#include <iostream>
using namespace std;

int main(){
    int P; cin>>P;
    int x, y;
    int minX = 10000;
    int maxX = -10000;
    int minY = 10000;
    int maxY = -10000;
    for(int i=0; i<P; i++){
        cin>>x>>y;
        if(minX >= x){
            minX = x;
        }
        if(maxX <= x){
            maxX = x;
        }
        if(minY >= y){
            minY = y;
        }
        if(maxY <= y){
            maxY = y;
        }
    }
    cout<<(maxX-minX) * (maxY-minY);
    return 0;
}