#include <iostream>
using namespace std;

int main(){
    int nums[9];
    int max;
    int maxIndex = 1;

    for(int i=0; i<9; i++){
        scanf("%d", &nums[i]);
    }
    max = nums[0];
    for(int j=1; j<9; j++){
        if(max < nums[j]){
            max = nums[j];
            maxIndex = j+1;
        }
    }

    printf("%d\n%d", max, maxIndex);
}