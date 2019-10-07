#include <iostream>
using namespace std;
void ari(int *, int);

int main() {

    const int N{20};
    std::cout << "Hello, World!" << std::endl;
    int a[N];
    for (int i = 0; i < 3; ++i) {
        cout << "a is: "<< *a << endl;
    }

    ari(a, N);

    return 0;
}