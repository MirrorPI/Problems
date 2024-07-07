#include <iostream>
using namespace std;

int main(){
    int y;
    int yoon = 0;

    scanf("%d", &y);
    if(y%400 ==0){
        yoon = 1;
    }
    else if(y%4 ==0){
        if(y%100 != 0){
            yoon = 1;
        }
    }

    printf("%d", yoon);
    return 0;
}