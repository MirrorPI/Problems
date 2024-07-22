#include <iostream>
using namespace std;
#include <iomanip> 

int main(){
    string sub;
    string point;
    double num = 0.0;
    double sumNum = 0.0;
    double sumPoint = 0.0;
    for(int i=0; i<20; i++){
        cin>>sub>>num>>point;
        if(point == "A+"){
            sumNum += num;
            sumPoint += num*4.5;
        }
        else if(point =="A0"){
            sumNum += num;
            sumPoint += num*4.0;
        }
        else if(point == "B+"){
            sumNum += num;
            sumPoint += num*3.5;
        }
        else if(point == "B0"){
            sumNum += num;
            sumPoint += num*3.0;
        }
        else if(point == "C+"){
            sumNum += num;
            sumPoint += num*2.5;
        }
        else if(point == "C0"){
            sumNum += num;
            sumPoint += num*2.0;
        }
        else if(point == "D+"){
            sumNum += num;
            sumPoint += num*1.5;
        }
        else if(point == "D0"){
            sumNum += num;
            sumPoint += num*1.0;
        }
        else if(point == "P"){
            continue;
        }
        else if(point =="F"){
            sumNum += num;
        }
    }
    cout<<fixed<<setprecision(10)<<sumPoint/sumNum;
}