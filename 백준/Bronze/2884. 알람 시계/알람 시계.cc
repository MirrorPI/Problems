#include <iostream>
using namespace std;

int main(){
    int h, m;
    scanf("%d %d", &h, &m);
    if(m < 45){
        if(h == 0){
            h = 23;
        }
        else{
            h -= 1;
        }
        m = 15 + m;
    }
    else{
        m -= 45;
    }
    printf("%d %d",h,m);

    return 0;
}