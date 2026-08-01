#include <stdio.h>

// C guarantees contiguous row-major storage for multidimensional arrays,
// enabling compile-time offset calculation for element access.
void print_2D_array(int[/* row is not needed in the stride calculation */][5]);

int main(void) {
  int a[2][5] = {{0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}};
  print_2D_array(a);
}

void print_2D_array(int a[][5]) {
  int row, col;
  for (row = 0; row < 2; row++) {
    for (col = 0; col < 5; col++) {
      printf("(%d,%d) = %d\n", row, col, a[row][col]);
    }
  }
}
