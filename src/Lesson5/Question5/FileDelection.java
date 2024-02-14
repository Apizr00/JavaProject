package Lesson5.Question5;

import java.io.File;

class FileDeletion extends FileOperation {

    @Override
    void performFileOperation(String fileName) {

        File fileToDelete = new File(fileName);

        if (fileToDelete.exists()) {

            if (fileToDelete.delete()) {

                System.out.println("File deleted successfully.");

            } else {

                System.out.println("Unable to delete the file.");
            }

        } else {

            System.out.println("File not found.");
        }
    }
}
