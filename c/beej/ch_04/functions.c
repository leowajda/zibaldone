#include <stdio.h>

int foo(void); // This is the prototype!

int main(void) {
    int i = foo();
    printf("%d\n", i); // 42
}

int foo(void) {
    return 42;
}