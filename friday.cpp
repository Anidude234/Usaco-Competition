/*
USER: anialaw1
LANG: C++
TASK: friday
*/
#include <fstream>
#include <iostream>
using namespace std;
ifstream fin("friday.in"); ofstream fout("friday.out");

int days[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int fdays[7] = {0, 0, 0, 0, 0, 0, 0};

bool leap(int year){
  return (year % 100 == 0 && year % 400 == 0 || year % 100 != 0 && year % 4 == 0);
}

int main(){
    int N;
    fin >> N;
    int year = 1900;
    int day = 2;
    for(int year = 1900; year < 1900 + N; year++){
        for(int month = 0; month < 12; month++){
            int daysInMonth = days[month];
            if(month == 1 && leap(year)) daysInMonth++;
            for(int d = 1; d <= daysInMonth; d++){
                if(d == 13) fdays[day]++;
                day = (day + 1) % 7;
            }
        }
    }
    for(int i = 0; i < 7; i++){
        fout << (i ? " " : "") << fdays[i];
    }
    fout << endl;
}
