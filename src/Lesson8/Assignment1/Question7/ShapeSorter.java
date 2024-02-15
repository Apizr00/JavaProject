package Lesson8.Assignment1.Question7;

class ShapeSorter {

    static void sort(SortableShape[] shapes) {

        int n = shapes.length;
        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (shapes[j].area() > shapes[j + 1].area()) {

                    SortableShape temp = shapes[j];
                    shapes[j] = shapes[j + 1];
                    shapes[j + 1] = temp;
                }
            }
        }
    }
}
