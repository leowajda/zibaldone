#include <stdio.h>
#include <stdlib.h>
#include <string.h>

void *aligned_realloc(void *, size_t, size_t, size_t);

int main(void) {

  int *p = malloc(sizeof(int) * 10);
  if (p == NULL) {
    printf("Error allocating 10 ints\n");
    exit(1);
  }

  *p = 42;
  printf("%d\n", *p);
  free(p);
  //*p = 3490; // ERROR: undefined behavior! Use after free()!

  int *a = calloc(sizeof(int), 10);
  for (int i = 0; i < 10; i++) {
    a[i] = i * 5;
    printf("%d\n", a[i]);
  }

  free(a);
}

void *aligned_realloc(void *ptr, size_t old_size, size_t alignment,
                      size_t size) {
  char *new_ptr = aligned_alloc(alignment, size);

  if (new_ptr == NULL)
    return NULL;

  size_t copy_size = old_size < size ? old_size : size; // get min

  if (ptr != NULL) {
    memcpy(new_ptr, ptr, copy_size);
  }

  free(ptr);
  return new_ptr;
}
