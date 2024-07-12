#include <iostream>
using namespace std;

int main(){
    int n;
    scanf("%d", &n);
    
    int nums[n];
    for(int i=0; i<n; i++){
        scanf("%d",&nums[i]);
    }

    int v;
    int count = 0;
    scanf("%d", &v);
    for(int i=0; i<n; i++){
        if(nums[i]==v){
            count++;
        }
    }

    printf("%d", count);

    return 0;
}