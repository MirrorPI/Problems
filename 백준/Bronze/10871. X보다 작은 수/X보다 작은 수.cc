#include <iostream>
using namespace std;

int main(){
    int n, x;
    scanf("%d %d",&n, &x);
    int nums[n];
    for(int i=0; i<n; i++){
        scanf("%d", &nums[i]);
        if(nums[i]<x){
            printf("%d ", nums[i]);
        }
    }
    return 0;
}