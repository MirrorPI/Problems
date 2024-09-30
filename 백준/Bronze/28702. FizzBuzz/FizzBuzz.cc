#include <iostream>
using namespace std;

int check(string str){
    if(str == "Fizz"){
        return 3;
    }
    else if(str == "Buzz"){
        return 5;
    }
    else if(str == "FizzBuzz"){
        return 15;
    }
    return 0;
}
void result(int n){
    if(n%3==0 && n%5==0){
        cout<<"FizzBuzz";
        return;
    }
    else if(n%3 == 0){
        cout<<"Fizz";
        return;
    }
    else if(n%5 ==0){
        cout<<"Buzz";
        return;
    }
    cout<<n;
}

int main(){
    string str1, str2, str3;
    cin>>str1>>str2>>str3;

    if(check(str1) == 0){
        int num = stoi(str1);
        result(num+3);
        return 0;
    }
    else if(check(str2) == 0){
        int num = stoi(str2);
        result(num+2);
        return 0;
    }
    else if(check(str3) == 0){
        int num = stoi(str3);
        result(num+1);
        return 0;
    }
}