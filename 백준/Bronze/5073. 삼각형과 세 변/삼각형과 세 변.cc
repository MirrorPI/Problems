#include <iostream>
using namespace std;

int main(){
    int a, b, c;
    int temp;
    while(true){
        cin>>a>>b>>c;
        if(a==0 && b==0 && c==0){
            break;
        }
        if(a > b){
            temp = b;
            b = a;
            a = temp;
        }
        if(a>c){
            temp = c;
            c= a;
            a= temp;
        }
        if(b > c){
            temp = c;
            c= b;
            b = temp;
        }
        if(a + b <= c){
            cout<<"Invalid"<<"\n";
        }
        else{
            if(a==b && b==c){
                cout<<"Equilateral"<<"\n";
            }
            else if(a==b || b==c || c == a){
                cout<<"Isosceles"<<"\n";
            }
            else{
                cout<<"Scalene"<<"\n";
            }
        }
    }
    return 0;
}