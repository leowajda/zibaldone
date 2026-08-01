typedef int antelope, bagel, mushroom; // These are all "int"

struct animal {
  char *name;
  int leg_count;
  int speed;
}

// original name new name
//           |        |
//           v        v
//      |-----------| |----|
typedef struct animal animal;

// original name
//           |
//           v
//      |--------------|
typedef struct animal_v2 {
  char *name;
  int leg_count;
  int speed;
} animal_v2;

// anonymous name
//           |
//           v
typedef struct {
  char *name;
  int leg_count;
  int speed;
} animal_v3;

int main(void) {
  mushroom x = 10;
  bagel y = 10;
  antelope z = 2;

  struct animal a; // This works;
  animal b;        // This also works because "animal" is an alias

  struct animal_v2 c; // Thisw works;
  animal_v2 d;        // This also works because "animal_v2" is an alias

  animal_v3 e; // This also works because "animal_v3" is an alias

  // Make type five_ints an array of 5 ints, not used in practice
  typedef int five_ints[5];
  five_ints array = {11, 22, 33, 44, 55};
}
