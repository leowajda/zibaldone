#include <stdio.h>

void increment(int *);

int main(void) {
  int i = 10;  // i's type is "int"
  int *p = &i; // p's type is "pointer to an int", or "int-pointer"

  printf("The value of i is %d\n", i);
  printf("And its address is %p\n", (void *)p);

  *p = 20;

  printf("The value of i is %d\n", i);
  printf("And its address is %p\n", (void *)p);

  increment(p);

  printf("The value of i is %d\n", i);
  printf("And its address is %p\n", (void *)p);

  printf("%zu\n", sizeof(int)); // Prints size of an 'int'
  printf("%zu\n", sizeof(p));   // p is type 'int *', so prints size of 'int*'
  printf("%zu\n", sizeof(*p));  // *p is type 'int', so prints size of 'int'
}

void increment(int *p) { *p = *p + 1; }
