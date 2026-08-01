#include <stdio.h>

// The full type name is struct car
struct car {
  char *name;
  float price;
  int speed;
};

void set_price(struct car *, float);

int main(void) {
  // Similar to array initializers;
  // Any missing field designators are initialized to zero
  struct car saturn = {.name = "Saturn SL/2", .speed = 175};
  set_price(&saturn, 799.99);

  printf("Name: %s\n", saturn.name);
  printf("Price (USD): %f\n", saturn.price);
  printf("Top Speed (km): %d\n", saturn.speed);

  // shallow copy
  struct car saturn_copy = saturn;
  printf("original = %p, copy = %p\n", &saturn, &saturn_copy);
}

void set_price(struct car *car, float new_price) {
    // works but not idiomatic 
    // (*car).price = price; 
    car->price = new_price;
}
