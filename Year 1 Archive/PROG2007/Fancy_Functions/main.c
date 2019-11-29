//Author = Mason Fraser

#include <stdio.h>
#include <math.h>
#include <assert.h>
#include <string.h>
#include <stdlib.h>
#define MAX 15

double bisect(double a, double b, double (*f)(double));
int palindrome();
char* reverse(char *str);

int main() {
    printf("%lf", bisect(0, 3, cos));
    printf("%d", palindrome());

}


int palindrome() {
    int cnt = 0;
    char buf[MAX];
    printf("\nEnter your string: ");
    fgets(buf, MAX, stdin);
    printf("%s", buf);
    for (int i = 0; i < strlen(buf) -1; i++) {
        ++cnt;
    }
    buf[cnt] = '\0';
    char* myrev = reverse(&buf[0]);
    int succ =0;
    for(int i = 0; i < cnt; i++) {
        if(buf[i] != myrev[i]) {
            succ = 1;
        }
    }

    if (succ == 1) {
        puts("Not a pal :(");
        return 0;
    }else{
        puts("YOU FOUND A PAL! :)");
        return 1;
    }
}


char* reverse(char *str) {
    char* reversed = (char*) malloc(sizeof(char) * strlen(str) + 1);
    int j = 0;
    for (int i = (int) (strlen(str) - 1); i >= 0; i--, j++) {
        reversed[j] = str[i];
    }
    reversed[j + 1] = '\0';
    return reversed;
}


double bisect(double a, double b, double (*f)(double)) {
    double s = (a + b) / 2.0;
    assert(f(a) * f(b) < 0);

    while ((b-a)/2 >= 0.0000001) {

        if (f(s) == 0) {
            printf("You got luck!");
        }
        else if (f(a) * f(s) < 0) {
            b = s;
        } else {
            a = s;
        }
        s = (a + b) / 2.0;
    }
    return s;
}


