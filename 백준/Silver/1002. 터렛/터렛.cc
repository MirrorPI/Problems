#include <iostream>
using namespace std;

int main(){
    int testCase;
    cin>>testCase;
    int x1, y1, r1, x2, y2, r2; //조규현, 백승환
    for(int i=0; i<testCase; i++){
        cin>>x1>>y1>>r1>>x2>>y2>>r2;
        int distanceSqu = (x1-x2)*(x1-x2) + (y1-y2)*(y1-y2); //sqrt()를 이용해서 길이를 구하면 실수로 반환 -> 실수는 소수점이 무한히 저장될 수 없어서 정확도 떨어짐(약간만 달라도 '=='는 false를 반환)
                                                             //또는 저장하는 방식의 차이 때문에 '=='가 원하는 결과가 나오지 않을 수 있음(0.1 + 0.2 == 0.3 -> return false)
                                                             //부동소수점 방식으로 저장하기 때문에 10진수로는 유한소수 이지만 2진수로는 무한소수로 계산됨 -> 그래서 근사값을 저장하기에 원하는 계산결과가 나오지 않음
                                                             //결론 - 제곱근으로 계산하지 않고 거리의 제곱 그 자체를 이용함
        int rprSqu = (r1 + r2) * (r1 + r2); //반경의 합의 제곰
        int rmrSqu = (r1 - r2) * (r1 - r2); //반경의 차의 제곱

        if(distanceSqu > rprSqu){ //두 원이 떨어져 교점이 없는 경우, 0
            cout<<0<<endl;
        }
        else if(distanceSqu == rprSqu){ //두 원이 바깥쪽에서 접하는 경우, 1
            cout<<1<<endl;
        }
        else if(distanceSqu < rmrSqu){ //큰 원 안의 작은 원이 접하지 않는 경우, 0
            cout<<0<<endl;
        }
        else if(distanceSqu == rmrSqu){ 
            if(distanceSqu == 0){ //두 원이 완전히 겹치는 경우, -1
                cout<<-1<<endl;
            }
            else{ //두 원이 안에서 접하는 경우, 1
                cout<<1<<endl; 
            }
        }
        else{ //두 원이 교점 2개를 가지는 경우, 2
            cout<<2<<endl;
        }
    }
    return 0;
}