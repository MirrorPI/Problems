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
    for(int i=0; i<M; i++){
        scanf("%d %d",&a, &b);
        while(a<b){
            temp = basket[a-1];
            basket[a-1] = basket[b-1];
            basket[b-1] = temp;
            a++;
            b--;
        }
    }
    for(int i=0; i<N; i++){
        printf("%d ",basket[i]);
    }

    return 0;
}