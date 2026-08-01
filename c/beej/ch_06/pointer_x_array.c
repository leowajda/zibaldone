#include <stdio.h>

void double_array(int *, int);

int main(void) {

  int a[5] = {1, 2, 3, 4, 5};
  int *p = &a[0];
  int *r = a;

  printf("%d\n", *p);
  printf("%d\n", *r); // same

  double_array(a, 5);

  int i = 0;
  for (; i < 5; i++) {
      printf("%d\n", a[i]);
  }
}

void double_array(int *p, int len) {

    int i;
    for (i = 0; i < len; i++) {
        // equivalent to p[i] *= 2;
        *p *= 2;
        p++;
    }
}
