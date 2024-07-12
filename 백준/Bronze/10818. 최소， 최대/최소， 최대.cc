#include <iostream>
using namespace std;

int main(){
    int n;
    scanf("%d", &n);
    int nums[n];
    int max = -1000000;
    int min = 1000000;
    for(int i=0; i<n; i++){
        scanf("%d",&nums[i]);

        if(min > nums[i]){
            min = nums[i];
        }

        if(max < nums[i]){
            max = nums[i];
        }
    }
    printf("%d %d", min, max);

}