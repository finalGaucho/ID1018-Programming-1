import java.util.*;

public class EU22 {

    public static void main(String[] args) {
      int[] list = {7, 3, 1, 9, 8, 6, 4, 2, 5, 3};
      int n = list.length;
      System.out.println(Arrays.toString(exchangeSort(n,list)));
    }

    public static int[] exchangeSort(int n, int[] list) {
      int i = 0;
      int temp;
      int j;
      while (i < n) {
        j = i + 1;
        while (j < n){
          if ( list[j] < list[i]) {
            temp = list[i];
            list[i] = list[j];
            list[j] = temp;
          }
          j++;
        }
        i++;
      }
      return list;
    }
  }
