#include "aux_func.c"


//Mainline Calls functions from aux.c and handles array inputs
int main () {
    int i, n;
    int number[30];
    printf("total integer values in array:\n ");
    scanf("%d", &n);
    printf("Enter the values: \n");
    for (i = 0; i < n; i++) {
        scanf("%d", &number[i]);
        puts("Ascending");
        sortFunctionASN(number, i + 1);
        puts("\n");
        puts("Decending");
        sortFunctionDSN(number, i + 1);
    }
    avgArray(number, n);
    normArray(number, n);

}