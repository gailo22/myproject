package myproject;

import java.util.Arrays;


class ReverseArrayTest {

    public static void reverArray(Object[] array) {
        if (array == null) throw new IllegalArgumentException("array is null");
        
        int i = 0;
        int j = array.length - 1;
        
        while (j > i) {
            Object tmp = array[i];
            array[i] = array[j];
            array[j] = tmp;
            
            i++;
            j--;
        }
    }
    
    public static void main(String[] args) {
        
        Object[] array = new Object[] { "A", "B", "C" };
        System.out.println(Arrays.toString(array));
        reverArray(array);
        System.out.println(Arrays.toString(array));
    }
}