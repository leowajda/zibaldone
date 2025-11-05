package cracking_the_coding_interview.ch_16;

public class LivingPeople {

    private static final int START_YEAR = 1_900;
    private static final int END_YEAR   = 2_000;

    private record Person(int birthYear, int deathYear) { }

    private static int livingPeople(Person[] people) {

        int[] delta = new int[END_YEAR - START_YEAR + 2];
        for (var person : people) {
            delta[person.birthYear - START_YEAR]++;
            delta[person.deathYear - START_YEAR + 1]--;
        }

        int maxYear = 0, maxCount = 0;
        int count = 0;

        for (int year = 0; year < delta.length; year++) {
            count += delta[year];
            if (count > maxCount) {
                maxCount = count;
                maxYear  = year;
            }
        }

        return START_YEAR + maxYear;
    }

}
