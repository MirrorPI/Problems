#include <iostream>
using namespace std;

int main(){
    int N; cin>>N;
    string stringNum = "666";
    int count = 0;
    int sixCount =0;
    int apoNum[10000] ={0};

    while(count!=10000){
        bool findApo = false;
        for(int j=0; j<stringNum.size(); ++j){
            if(stringNum[j] == '6'){
                sixCount++;
            }
            else{
                sixCount = 0;
            }
            if(sixCount == 3){
                int intNum = stoi(stringNum);
                apoNum[count++] = intNum;
                intNum++;
                stringNum = to_string(intNum);
                sixCount =0;
                findApo = true;
                break;
            }
        }
        if(findApo == false){
            int intNum = stoi(stringNum);
            intNum++;
            stringNum = to_string(intNum);
            sixCount =0;
        }
    }
    cout<<apoNum[N-1];
    return 0;
}