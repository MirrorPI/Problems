#include <iostream>
using namespace std;

int main(){
    int n;
    int lastIndex;


    while(true){
        int r[2000] = {0};
        int sum = 0;
        int count = 0;
        cin>>n;
        if(n == -1){
            break;
        }
        for(int i=1; i<n; i++){
            if(n%i == 0){
                r[count] = i;
                sum += i;
                lastIndex = count++;
            }
        }
        if(n == sum){
            cout<<n<<" = ";
            for(int i=0; i<count;i++){
                cout<<r[i];
                if(i == lastIndex){
                    break;
                }
                    cout<<" + ";
                }

        }
        else{
            cout<<n<<" is NOT perfect.";
        }
        cout<<"\n";
    }
    return 0;
}