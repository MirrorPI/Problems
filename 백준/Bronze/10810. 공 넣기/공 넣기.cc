#include <iostream>
using namespace std;

int main(){
    int N, M;
    scanf("%d %d", &N, &M);
    int basket[N];
    int a, b, c;

    for(int i=0; i<N; i++){
        basket[i] = 0;
    }

    for(int j=0; j<M; j++){
        scanf("%d %d %d",&a, &b, &c);
        for(int k=a; k<=b; k++){
            basket[k-1] = c;
        }
    }

    for(int l=0; l<N; l++){
        printf("%d ",basket[l]);
    }

    return 0;
}