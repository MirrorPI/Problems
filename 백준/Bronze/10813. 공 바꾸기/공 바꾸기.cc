#include <iostream>
using namespace std;

int main(){
    int N, M;
    scanf("%d %d", &N, &M);

    int basket[N];
    for(int i=0; i<N; i++){
        basket[i] = i+1;
    }

    int a, b;
    int temp;
    for(int j=0; j<M; j++){
        scanf("%d %d", &a, &b);
        temp = basket[a-1];
        basket[a-1] = basket[b-1];
        basket[b-1] = temp;
    }

    for(int k=0; k<N; k++){
        printf("%d ", basket[k]);
    }

    return 0;
}