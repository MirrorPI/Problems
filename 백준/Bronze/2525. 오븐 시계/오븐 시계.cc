#include <iostream>
using namespace std;

int main(){
    int h, m;
    int t;

    scanf("%d %d %d",&h, &m, &t);

    int th = t/60;
    int tm = t - th*60;

    if(m+tm >= 60){
        h += 1;
        m = m + tm - 60;
    }
    else{
        m += tm;
    }

    if(h+th > 23){
        h = h+th - 24;
    }
    else{
        h += th;
    }

    printf("%d %d",h,m);

    return 0;
}