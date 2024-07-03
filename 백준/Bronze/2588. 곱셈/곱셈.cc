#include <iostream>
using namespace std;

int main(){
    int A, B;
    int BH, BT, BU;
    scanf("%d %d", &A, &B);
    BH = B/100;
    BT = (B%100)/10;
    BU = B%10;

    printf("%d\n%d\n%d\n%d",BU*A, BT*A, BH*A, B*A);

    return 0;
}