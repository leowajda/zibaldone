#include <stdio.h>

void foo(int *);

int main(void) {

  int i;
  float f[4]; // Declare an array of 4 floats

  f[0] = 3.14159; // Indexing starts at 0, of course.
  f[1] = 1.41421;
  f[2] = 1.61803;
  f[3] = 2.71828;

  for (i = 0; i < 4; i++) {
    printf("f[%d] = %f\n", i, f[i]);
  }

  // Because there is no initializer, the elements have indeterminate values;
  // They contain whatever bits happen to be in that stack memory.
  int x[12];                                // 12 ints
  printf("%zu\n", sizeof(x));               // 48 total bytes
  printf("%zu\n", sizeof(int));             // 4 bytes per int
  printf("%zu\n", sizeof(x) / sizeof(int)); // 48/4 = 12 ints!

  foo(x);

  //  this operation merely yields the byte count; it does not instantiate an
  //  actual array in memory.
  printf("%d\n", sizeof(double[48]));

  int a[/* no need to set the size */] = {22, 37, 3490, 18, 95};
  for (i = 0; i < 5; i++) {
    printf("%d\n", a[i]);
  }

  // Make the first element zero, and then make the rest zero, as well
  int b[100] = {0};

  // [0, 11, 22, 0, 0, 55, 66, 77, 0, 0]
  int c[10] = {0, 11, 22, [5] = 55, 66, 77};
}

// correct syntax but confusing, `int* x` is the correct expression to use
void foo(int x[12]) {
  printf("%zu\n", sizeof(x));               // 8?! What happened to 48?
  printf("%zu\n", sizeof(int));             // 4 bytes per int
  printf("%zu\n", sizeof(x) / sizeof(int)); // 8/4 = 2 ints?? WRONG.
}
