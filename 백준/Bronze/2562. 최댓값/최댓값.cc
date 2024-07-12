#include <iostream>
#include <algorithm>
using namespace std;

int main(){
    int size = 9;
    int nums[9];

    for(int i=0; i<9; i++){
        scanf("%d", &nums[i]);
    }

    int* maxPointer = max_element(nums, nums+size);
    int maxIndex = maxPointer - nums;

    printf("%d\n%d", *maxPointer, maxIndex+1);

    return 0;
}