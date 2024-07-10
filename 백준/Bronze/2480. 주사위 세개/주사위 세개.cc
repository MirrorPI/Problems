#include <iostream>
using namespace std;

int main(){
    int a, b, c;
    int reward;
    scanf("%d %d %d",&a, &b, &c);

    if(a==b && b==c){
        reward = 10000 + a*1000;
    }
    else{
        if(a==b || a==c){
            reward = 1000 + a*100;
        }
        else if(b==c){
            reward = 1000 + b*100;
        }
        else{
            int high;
            if(a > b){
                if(a > c){
                    high = a;
                }
                else{
                    high = c;
                }
            }
            else{
                if(b > c){
                    high = b;
                }
                else{
                    high = c;
                }
            }
            reward = 100*high;
        }
    }
    printf("%d", reward);

    return 0;
}