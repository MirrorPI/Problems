#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main(){
    std::ios_base::sync_with_stdio(false); //c의 표준 입출력스트림(stdio)과 c++의 표준 입출력 스트림(iosteam)은 원래 동기화 되어 있어서 혼용할 수 있음 하지만 불필요할 때가 있어서 그 동기화를 해제, 단 이 코드를
    // 입력하면 c, c++의 입출력 함수를 혼용할 수 없음
    cin.tie(NULL); //cin이 작동되면 자동으로 cout의 버퍼를 비우는데 필요하지 않는 상황에서 성능에 영향을 줌, 그래서 둘의 연결을 해제 -> 단, 입출력 순서를 보장 받을 수 없음
    int N;
    cin>>N;
    if(N == 0){
        cout<<0;
        return 0;
    }
    else if(N == 1){
        cout<<1;
        return 0;
    }
    vector<string> fibonacciNums(N+1);
    fibonacciNums[0] = "0";
    fibonacciNums[1] = "1";

    for(int i = 2; i<=N; i++){
        string f1 = fibonacciNums[i-2];
        string f2 = fibonacciNums[i-1];

        string sum = "";
        int carry = 0, digitSum = 0;
        int f1Len = f1.size(), f2Len = f2.size();
        int len = f2.size();
        for(int j=0; j<len; j++){
            int f1Disit = j+1 > f1Len ? 0 : f1[f1Len-1-j] - '0';
            int f2Disit = f2[f2Len-1-j] - '0';
            int disitSum = f1Disit + f2Disit + carry;
            carry = disitSum / 10;
            sum = char(disitSum%10 + '0') + sum;
        }
        if(carry >= 1){
            sum = char(carry + '0') + sum;
        }

        fibonacciNums[i] = sum;
    }
    cout<<fibonacciNums[N];
    return 0;
}