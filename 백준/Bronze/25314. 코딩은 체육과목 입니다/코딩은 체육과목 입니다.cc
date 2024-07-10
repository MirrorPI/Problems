#include <iostream>
using namespace std;

int main(){
    std::ios_base::sync_with_stdio(false); //c의 표준 입출력스트림(stdio)과 c++의 표준 입출력 스트림(iosteam)은 원래 동기화 되어 있어서 혼용할 수 있음 하지만 불필요할 때가 있어서 그 동기화를 해제, 단 이 코드를
    // 입력하면 c, c++의 입출력 함수를 혼용할 수 없음
    cin.tie(NULL); //cin이 작동되면 자동으로 cout의 버퍼를 비우는데 필요하지 않는 상황에서 성능에 영향을 줌, 그래서 둘의 연결을 해제 -> 단, 입출력 순서를 보장 받을 수 없음
    int a;
    cin>>a;
    int longNum = a/4;
    string longString = "";

    for(int i=0; i<longNum; i++){
        longString += "long ";
    }
    longString += "int";
    cout<<longString;
    
    return 0;
}