#include <iostream>
using namespace std;

int main(){
    int students[30];
    for(int i=0; i<30; i++){
        students[i] = 0;
    }
    int sub[28];
    for(int j=0; j<28; j++){
        scanf("%d", &sub[j]);
        students[sub[j]-1] = sub[j];
    }
    for(int i=0; i<30; i++){
        if(students[i]==0){
            printf("%d\n",i+1);
        }
    }

    return 0;
}