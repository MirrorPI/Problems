#include <iostream>
using namespace std;

int main(){
    int x, y;
    int q;
    
    scanf("%d %d",&x, &y);
    if(x>0){
        if(y>0){
            q = 1;
        }
        else{
            q = 4;
        }
    }
    else{
        if(y>0){
            q = 2;
        }
        else{
            q = 3;
        }
    }
   
    printf("%d", q);

    return 0;
}