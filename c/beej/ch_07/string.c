#include <stdio.h>
#include <string.h>

void print_string(char *, int);
int my_strlen(char*);

int main(void) {

  char *s = "Hello World!"; // Actually "Hello World!\0" behind the scenes
  char z[] = "Hello World!";

  print_string(s, 13);

  // s[0] = 'z'; BAD NEWS: tried to mutate a string literal!
  z[0] = 'z'; // No problem

  print_string(z, 13);

  printf("The string is %zu bytes long.\n", strlen(z));
  printf("The string is %d chars long.\n", my_strlen(z));

  char t[100];
  strcpy(t, s);
  t[0] = 'z';

  printf("original = %s, copy = %s\n", s, t);
}

int my_strlen(char *s) {
    int count = 0;
    while (s[count] != '\0')
        count++;
    return count;
}

void print_string(char *s, int len) {
  int i;
  for (i = 0; i < len; i++) {
    printf("%c", s[i]);
  }
  printf("\n");
}
