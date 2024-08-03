#include <iostream>
using namespace std;

int main(){
    int x, y;
    int w, h;
    cin>>x>>y>>w>>h;
    int minX;
    int minY;
    if(x >= w-x){
        minX = w-x;
    }
    else{
        minX = x;
    }
    if(y >= h-y){
        minY = h-y;
    }
    else{
        minY = y;
    }
    if(minX >= minY){
        cout<<minY;
    }
    else{
        cout<<minX;
    }
    return 0;
}