import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;

public class OU3
{

  public static class TheShortestPath {
    // The method intermediateStations returns a vector of the
// intermediate stations that are on the shortest path .
// The ordinal number of the first station is located in
// index 1 of the vector , and the second station on index 2.

    // The method length returns the length of the shortest path .
    public static double length(int a[],
                                int b[][],
                                int c[],
                                int nofStationsZ2,
                                int nofStationsZ3) {
      double shortest_path_length = a[1] + b[1][1] + c[1];

      for (int i = 1; i <= nofStationsZ2; i++) {
        for (int j = 1; j <= nofStationsZ3; j++) {
          if ((a[i] + b[i][j] + c[j]) < shortest_path_length) {
            shortest_path_length = (a[i] + b[i][j] + c[j]);
          }
        }
      }

      return shortest_path_length;

    }

    public static int [] intermediateStations(int[] a,
                                              int[][] b,
                                              int[] c) {
      double shortest_path_length = a[1] + b[1][1] + c[1];
      int [] indexIntermediateStations = new int [2];
      int x = 1;
      int y = 1;
      for (int i = 1; i < a.length; i++) {
        for (int j = 1; j < c.length; j++) {
          if ((a[i] + b[i][j] + c[j]) < shortest_path_length) {
            shortest_path_length = (a[i] + b[i][j] + c[j]);
            x = i;
            y = j;
          }
        }

      }
      indexIntermediateStations [0] = x;
      indexIntermediateStations [1] = y;
      return indexIntermediateStations;
      //return "[X, U" + (x) + ", V" + (y) + ", Y]";
    }
  }

  public static void main(String[] args)
  {
    System .out . println (" Stations \n");

    // input tools
    Scanner in = new Scanner ( System .in );
    in. useLocale ( Locale.US );

    // Enter the number of stations in Zone 2 & 3
    System .out . print (" number of stations in Zone 2 : ");
    int nofStationsZ2 = in. nextInt ();
    System .out . print (" number of stations in Zone 3 : ");
    int nofStationsZ3 = in. nextInt ();

    // storage space for length data
    int[] a = new int[ nofStationsZ2 + 1 ];
    int[][] b = new int[ nofStationsZ2 + 1 ][ nofStationsZ3 + 1 ];
    int[] c = new int[ nofStationsZ3 + 1 ];

    // read the distances

    // distance between station X and stations in Zone 2
    for (int station = 1; station <= nofStationsZ2 ; station ++)
    {
      System . out. println (" distances between station X and U" + station + ":");
        a[ station ] = in. nextInt ();
    }

    // distance between stations in Zone 2 & 3
    for (int stationz2 = 1; stationz2 <= nofStationsZ2 ; stationz2 ++)
    {
      for (int stationz3 = 1; stationz3 <= nofStationsZ3 ; stationz3 ++)
      {
        System . out. println (" distances between station U" + stationz2 + " and V" + stationz3 + ":");
        b[ stationz2 ] [ stationz3] = in. nextInt ();
      }
    }

    // distance between stations in Zone 3 & station Y
    for (int station = 1; station <= nofStationsZ3 ; station ++)
    {
      System.out.println(" distances between station V" + station + " and Y: ");
      c[ station ] = in.nextInt();
    }


    //prints out shortest path and it's length
    System.out.println(" The shortest path is " + TheShortestPath.length ( a, b, c, nofStationsZ2, nofStationsZ3 ) +
            " km long and consists of the path between stations " +
            Arrays.toString(TheShortestPath.intermediateStations(a, b, c)));
  }

}