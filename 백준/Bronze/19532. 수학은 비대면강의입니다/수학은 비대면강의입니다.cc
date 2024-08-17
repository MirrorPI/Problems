#include <iostream>
using namespace std;

int main(){
    int a, b, c; cin>>a>>b>>c;
    int d, e, f; cin>>d>>e>>f;
    int x, y;

    if(a == 0){
        y = c/b;
        x = (f*b - e*c)/(b*d);
    }
    else{
        if(d==0){
            y = f/e;
            x=(c*e-f*b)/(a*e);

        }
        else{
            y = (a*f - c*d)/(a*e - b*d);
            x = (c-b*y)/a;
        }
    }


    cout<<x<<" "<<y;

    return 0;
}