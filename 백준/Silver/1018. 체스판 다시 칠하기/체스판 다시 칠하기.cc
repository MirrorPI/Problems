#include <iostream>
using namespace std;

int main(){
    int N, M; cin>>N>>M;
    char chess[N][M];
    int wStartCount;
    int bStartCount;
    int minCount = 64;
    int count;


    for(int i=0; i<N; ++i){
        for(int j=0; j<M; ++j){
            cin>>chess[i][j];
        }
    }

    for(int i=0; i<=N-8; ++i){
        for(int j=0; j<=M-8; ++j){
            wStartCount = 0;
            bStartCount = 0;
            count = 0;
            for(int k=i; k<i+8; ++k){
                for(int l=j; l<j+8; ++l){
                    if((k+l-i-j)%2 == 0){
                        if(chess[k][l] != 'W'){
                            wStartCount++;
                        }
                    }
                    else{
                        if(chess[k][l] != 'B'){
                            wStartCount++;
                        }
                    }
                    if((k+l-i-j)%2 == 0){
                        if(chess[k][l] != 'B'){
                            bStartCount++;
                        }
                    }
                    else{
                        if(chess[k][l] != 'W'){
                            bStartCount++;
                        }
                    }
                }

            }
            if(wStartCount < bStartCount){
                count = wStartCount;
            }
            else{
                count = bStartCount;
            }
            if(count < minCount){
                minCount = count;
            }
        }
    }
    cout<<minCount;
    return 0;
}