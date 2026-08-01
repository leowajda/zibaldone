#include <stdio.h>

// const qualifiers on value parameters are ignored when determining if a
// prototype matches a definition.
void foo(int);

int main(void) {
  const int x = 2;
  // x = 4; can't assign to a constant

  int arr[] = {1, 2};
  const int *arr_ptr_a = arr;
  arr_ptr_a++; // can modify the pointer
  // *arr_ptr = 3; cannot modify the value through this pointer

  int *const arr_ptr_b = arr;
  // arr_ptr_b++; cannot modify the pointer
  *arr_ptr_b = 3; // can modify the value through this pointer

  char **a;
  a++;
  (*a)++;

  char **const b;
  // b++; ERROR
  (*b)++;

  char *const *c;
  c++;
  // (*c)++; ERROR

  char *const *const d;
  // d++; ERROR
  // (*d)++; ERROR
}

void foo(const int x) {
  printf("%d\n", x + 30); // OK, doesn't modify "x"
}
