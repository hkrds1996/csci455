#include <iostream>
#include <sstream>
#include <string>
#include <vector>

using std::cin;
using std::cout;
using std::vector;
using std::string;


vector<int> readVals();
void printVals( vector<int> v );
vector<int> valsGT0(vector<int> v);
int findLast(vector<int> v, int target);

int main(){
    vector<int> vTemplate = readVals();
    cout << "Vector : ";
    printVals(vTemplate);
    int target = 7;
    int index = findLast(vTemplate, target);
    cout << "The last instance of " << target << " at position " << index << "\n";
    return 0;
}

std::vector<int> valsGT0(vector<int> v){
    std::vector<int> vTemplate;
    int size = v.size();
    for(int i = 0; i < size; ++i){
        if(v[i] > 0){
            vTemplate.push_back(v[i]);
        }
    }
    return vTemplate;
}



std::vector<int> readVals(){
    std::string s;
    std::getline(std::cin, s);
    std::stringstream ss;
    std::vector<int> v;
    ss << s;
    int i = 0;
    while(ss >> i){        
        v.push_back(i);
    }
    return v;
}

void printVals( vector<int> v ){
    int size = v.size();
    for(int i = 0; i < size -1; ++i){
        cout << v[i] << " ";
    }
    if(size != 0){
        cout << v[size - 1];
    }
    cout << "\n";    
}

int findLast(vector<int> v, int target){
    int size = v.size();
    int result = -1;
    for(int i = size -1; i >= 0; i--){
        if(v[i] == target){
            result = i;
            break;
        }
    }
    return result;
}