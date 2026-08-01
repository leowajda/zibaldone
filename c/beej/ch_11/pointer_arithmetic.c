#include <stdio.h>
#include <stdlib.h>

int my_strlen(char *);
void *my_memcpy(void *, void *, int);

struct animal {
  char *name;
  int leg_count;
};

int compare(const void *a, const void *b);

int main(void) {
  int sentinel = 999;
  int a[] = {1, 2, 3, 4, 5, sentinel /* sentinel */};

  int *p = a;

  printf("%d\n", *p);       // 1
  printf("%d\n", *(p + 1)); // 2

  while (*p != sentinel) {
    printf("ptr = %p, value = %d\n", p, *p);
    p++;
  }

  char *s = "Hello World!";
  printf("s.length = %d\n", my_strlen(s));

  // a[b] == *(a + b)
  p = a;
  for (int i = 0; i < 6; i++) {
    printf("a[i] = %d\n", a[i]);
    printf("p[i] = %d\n", p[i]);
    printf("*(a + i) = %d\n", *(a + i));
    printf("*(p + i) = %d\n", *(p + i));
    printf("================\n");
  }

  char m[] = "Goats!";
  char n[100];

  // void *memcpy(void *s1, void *s2, size_t n);
  // Copy 7 bytes--including the NUL terminator!
  my_memcpy(n, m, (my_strlen(m) * sizeof(char)) + 1);
  printf("%s\n", n);

  char ch = 'X'; // A single char
  void *ptr = &ch;
  char *ch_ptr = ptr;

  // printf("%c\n", *ptr); ERROR--cannot dereference void*!
  printf("%c\n", *ch_ptr); // Prints "X"

  struct animal animals[] = {{.name = "Dog", .leg_count = 4},
                             {.name = "Monkey", .leg_count = 2},
                             {.name = "Antelope", .leg_count = 4},
                             {.name = "Snake", .leg_count = 0}};

  // Call qsort() to sort the array.
  // qsort() needs to be told exactly what to sort this data by,
  // and we'll do that inside the compar() function.
  // This call is saying: qsort array a, which has 4 elements,
  // and each element is sizeof(struct animal) bytes big,
  // and this is the function that will compare any two elements.
  qsort(animals, 4, sizeof(struct animal), compare);

  for (int i = 0; i < 4; i++) {
    printf("(idx = %d, .name = %s, .leg_count = %d)\n", i, animals[i].name,
           animals[i].leg_count);
  }
}

int compare(const void *a, const void *b) {
  const struct animal *animal_a = a;
  const struct animal *animal_b = b;

  if (animal_a->leg_count > animal_b->leg_count)
    return 1;

  if (animal_a->leg_count < animal_b->leg_count)
    return -1;

  return 0;
}

void *my_memcpy(void *dest, void *source, int byte_count) {
  char *s = source;
  char *d = dest;

  while (byte_count--) {
    *d = *s;
    d++;
    s++;
  }

  return dest;
}

int my_strlen(char *s) {
  char *p = s;

  while (*p != '\0')
    p++;

  return p - s;
}
