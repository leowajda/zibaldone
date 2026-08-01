#include <stdio.h>

int main(void) {

  char *s = "Hello World!";
  int i = 2;
  float f = 3.14;
  bool x = false;

  printf("%s i = %d and f = %f!\n", s, i, f);

  if (i || x) {
    // Technically just one bit of a char is used to represent the bool, so it
    // can either be zero or one. Except that what goes in the remaining
    // (padding) bits of the char is unspecified. For false, it must surely be
    // all zero. But for true, I’m uncertain that it must all be zero.
    printf("i is true, but true == 12 is %d\n", true == 12);
  }

  // With the comma operator, the value of the comma expression is the value of
  // the rightmost expression.
  int y = (1, 2, 3);
  printf("y is %d\n", y);

  printf("%zu\n", sizeof(2 + 7)); // Prints 4 on my system
  printf("%zu\n", sizeof(3.14));  // Prints 8 on my system
  printf("%zu\n", sizeof(int));   // Prints 4 on my system
  printf("%zu\n", sizeof(char));  // Prints 1 on all systems
  printf("%zu\n", sizeof(bool));  // Prints 1 on all systems
}
