#include <iostream>
using namespace std;

int main(){
    string num1;
    string num2;
    string big;

    cin>>num1>>num2;

    if(num1[2] == num2[2]){
        if(num1[1] == num2[1]){
            if(num1[0]>num2[0]){
                big = num1;
            }
            else{
                big = num2;
            }
        }
        else if(num1[1]>num2[1]){
            big = num1;
        }
        else{
            big = num2;
        }
    }
    else if(num1[2] > num2[2]){
        big = num1;
    }
    else{
        big = num2;
    }
    cout<<big[2]<<big[1]<<big[0];
    return 0;
}