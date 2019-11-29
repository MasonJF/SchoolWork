#include <stdio.h>

int main() {
    const int N=5;
    int a[N];

    for (int i=0; i < N; i++)
        a[i] = i+1;

    for (int i=0; i < N; i++ )
        printf("\n%d ", a[i]);

    return 0;
}