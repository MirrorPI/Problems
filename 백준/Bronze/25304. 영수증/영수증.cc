#include <iostream>
using namespace std;

int main(){
    int totalPrice;
    int groceries;
    int price;
    int howMany;
    int checkPrice = 0;

    scanf("%d %d",&totalPrice, &groceries);
    for(int i=0; i<groceries; i++){
        scanf("%d %d",&price, &howMany);
        
        checkPrice += price*howMany;
    }
    if(totalPrice == checkPrice){
        printf("Yes");
    }
    else{
        printf("No");
    }

    return 0;
}