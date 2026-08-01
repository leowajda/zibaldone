#include <stdio.h>

void read_by_char(char *);
void read_by_line(char *);
void read_by_scan(char *);
void read_by_byte(char *);

int main(void) {
  read_by_char("hello.txt");
  read_by_line("quote.txt");
  read_by_scan("whales.txt");

  FILE *p = stdout;
  fputc('B', p);
  fputc('\n', p);
  fprintf(p, "meaning of life = %d\n", 42);
  fputs("Hello World!\n", p);

  unsigned char bytes[13] = {72,  101, 108, 108, 111, 44, 32,
                             119, 111, 114, 108, 100, 33};
  p = fopen("output.bin", "wb"); // wb mode for "write binary"
  fwrite(bytes, sizeof(char), sizeof(bytes) / sizeof(char), p);
  fclose(p);

  read_by_byte("output.bin");
}

void read_by_byte(char *file_name) {
  FILE *f = fopen(file_name, "rb");
  unsigned char c;

  while (fread(&c, sizeof(char), sizeof(c) / sizeof(char), f) > 0) {
    printf("%c", c);
  }

  printf("\n");
  fclose(f);
}

void read_by_line(char *file_name) {
  FILE *f = fopen(file_name, "r");
  char buffer[1024];
  int line_counter;

  while (fgets(buffer, sizeof(buffer), f) != NULL) {
    printf("%d: %s", ++line_counter, buffer);
  }

  printf("\n");
  fclose(f);
}

void read_by_scan(char *file_name) {
  FILE *f = fopen(file_name, "r");

  char name[1024];
  float length;
  int mass;

  while (fscanf(f, "%s %f %d", name, &length, &mass) != EOF) {
    printf("whale=%s, tonnes=%d, meters=%.1f\n", name, mass, length);
  }

  fclose(f);
}

void read_by_char(char *file_name) {
  FILE *f = fopen(file_name, "r");
  int c;

  while ((c = fgetc(f)) != EOF) {
    printf("%c", c);
  }

  printf("\n");
  fclose(f);
}
