#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int n;
    int num;
    scanf("%d", &n);
    int max = -1000000;
    int min = 1000000;

    for(int i=0; i<n; i++){
        scanf("%d", &num);

        if(max < num){
            max = num;
        }

        if(min > num){
            min = num;
        }
    }
    printf("%d %d", min, max);

    return 0;
}