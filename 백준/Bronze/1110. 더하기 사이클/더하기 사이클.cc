#include <iostream>
using namespace std;

bool isIn0to9(int num){
    if(num <10){
        return true;
    }
    return false;
}
void split(int* arrPtr, int num){
        if(isIn0to9(num)){
            arrPtr[0] = 0;
            arrPtr[1] = num;
        }
        else{
            arrPtr[0] = num/10;
            arrPtr[1] = num%10;
        }
        // cout<<arrPtr[0]<<" "<<arrPtr[1]; //확인코드
}

int main(){
    int num;
    cin>>num;
    int count = 0;
    int firstSplit[2];
    split(firstSplit, num);
    int splitNum[2] = {-1, -1};
    int newSplitNum[2] = {-1, -1};
    // split(splitNum, num); //확인코드

    while(!(firstSplit[0]==newSplitNum[0] && firstSplit[1]==newSplitNum[1])){
        split(splitNum, num);
        int tempNum = splitNum[0]+splitNum[1];
        int tempArr[2];
        split(tempArr, tempNum);
        newSplitNum[0] = splitNum[1];
        newSplitNum[1] = tempArr[1];
        num = newSplitNum[0] * 10 + newSplitNum[1];
        count++;
    }
    cout<<count;
    return 0;
}