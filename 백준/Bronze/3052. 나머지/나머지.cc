#include <iostream>
using namespace std;

int main(){
    int remainders[42][2];

    for(int i=0; i<42; i++){
        remainders[i][0] = i;
        remainders[i][1] = 0;
    }

    int a;
    for(int i=0; i<10; i++){
        scanf("%d", &a);
        for(int j=0; j<42; j++){
            if(a%42 == remainders[j][0]){
                remainders[j][1] =1;
            }
        }
    }
    int count = 0;
    for(int i=0; i<42; i++){
        if(remainders[i][1] == 1){
            count++;
        }
    }

    printf("%d", count);

    return 0;
}