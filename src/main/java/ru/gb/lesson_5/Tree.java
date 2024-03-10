package ru.gb.lesson_5;
import java.io.File;

public class Tree {

    /**
     * TODO: TODO: Доработать метод print, необходимо распечатывать директории и файлы
     *
     * @param args
     */
    public static void main(String[] args) {
        print(new File("."), "", true);
    }

    static void print(File file, String indent,  boolean isLast) {
        System.out.print(indent);
        if (isLast) {
            System.out.print("└─");
            indent += "  ";
        } else {
            System.out.print("├─");
            indent += "│ ";
        }
        System.out.println(file.getName());

        File[] files = file.listFiles();
        if (files == null)
            return;

        int subDirTotal = 0;
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                subDirTotal++;
            }
        }
        int subFileTotal = 0;
        for (int j = 0; j <files.length; j++){
            if (files[j].isFile()){
                subFileTotal++;
            }
        }

        int subDirCounter = 0;
        for (int i = 0; i < files.length; i++){
            if (files[i].isDirectory())
            {
                print(files[i], indent, subDirTotal  == ++subDirCounter);
            }
        }
        int subDirCounter2 = 0;
        for (int j = 0; j < files.length; j++){
            if (files[j].isFile())
            {
                print(files[j], indent, subFileTotal  == ++subDirCounter);
            }
        }


    }

}
