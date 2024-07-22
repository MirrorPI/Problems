#include <iostream>
using namespace std;

int main(){
    int a[9][9];
    int maxI = 0;
    int maxJ = 0;
    int maxValue = 0;
    for(int i=0; i<9; i++){
        for(int j=0; j<9; j++){
            cin>>a[i][j];
            if(maxValue < a[i][j]){
                maxValue = a[i][j];
                maxI = i;
                maxJ = j;
            }
        }
    }
    cout<<maxValue<<"\n"<<maxI+1<<' '<<maxJ+1;
    return 0;
}