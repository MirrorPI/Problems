#include <iostream>
using namespace std;

int main(){
    string s;
    cin>>s;
    int len = s.size();
    int i=0;
    int count=0;
    while(i<len){
        if(s[i]=='c'){
            if(s[i+1]=='='){
                i += 2;
                count++;
            }
            else if(s[i+1]=='-'){
                i += 2;
                count++;
            }
            else{
                i++;
                count++;
            }
        }
        else if(s[i]=='d'){
            if(s[i+1]=='z'){
                if(s[i+2]=='='){
                    i += 3;
                    count++;
                }
                else{
                    i += 2;
                    count += 2;
                }
            }
            else if(s[i+1]=='-'){
                i += 2;
                count++;
            }
            else{
                i++;
                count++;
            }
        }
        else if(s[i]=='l'){
            if(s[i+1]=='j'){
                i += 2;
                count++;
            }
            else{
                i++;
                count++;
            }
        }
        else if(s[i]=='n'){
            if(s[i+1]=='j'){
                i += 2;
                count++;
            }
            else{
                i++;
                count++;
            }
        }
        else if(s[i]=='s'){
            if(s[i+1]=='='){
                i += 2;
                count++;
            }
            else{
                i++;
                count++;
            }
        }
        else if(s[i]=='z'){
            if(s[i+1]=='='){
                i += 2;
                count++;
            }
            else{
                i++;
                count++;
            }
        }
        else{
            i++;
            count++;
        }
    }
    cout<<count;
    return 0;
}