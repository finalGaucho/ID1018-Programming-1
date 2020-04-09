import java . util .*; // Scanner , Locale
    class Temperatures
    {
        public static void main ( String [] args )
        {
            System .out . println (" TEMPERATURES \n");
// input tools
            Scanner in = new Scanner ( System .in );
            in. useLocale ( Locale .US );
// enter the number of weeks and measurements
            System .out . print (" number of weeks : ");
            int nofWeeks = in. nextInt ();
            System .out . print (" number of measurements per week : ");
            int nofMeasurementsPerWeek = in. nextInt ();
// storage space for temperature data
            double [][] t = new double [ nofWeeks + 1][ nofMeasurementsPerWeek + 1];
// read the temperatures
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                System . out. println (" temperatures - week " + week + ":");
                for (int reading = 1; reading <= nofMeasurementsPerWeek ; reading ++)
                    t[ week ][ reading ] = in. nextDouble ();
            }
            System .out . println ();
// show the temperatures
            System .out . println (" the temperatures :");
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                for (int reading = 1; reading <= nofMeasurementsPerWeek ; reading ++)
                    System . out. print (t[ week ][ reading ] + " ");
                System . out. println ();
            }
            System .out . println ();
// the least , greatest and average temperature - weekly
            double [] minT = new double [ nofWeeks + 1];
            double [] maxT = new double [ nofWeeks + 1];
            double [] sumT = new double [ nofWeeks + 1];
            double [] avgT = new double [ nofWeeks + 1];
// compute and store the least , greatest and average
// temperature for each week .
// *** WRITE YOUR CODE HERE ***
            //Min Weekly Temperature
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                double compareFirst = t[week][1];
                for (int reading = 2; reading <= nofMeasurementsPerWeek; reading ++) {
                    if (t[week][reading] < compareFirst) {
                        compareFirst = t[week][reading];
                    }
                }
                minT [week] = compareFirst;
            }

            //Max Weekly Temperature
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                double compareFirst = t[week][1];
                for (int reading = 2; reading <= nofMeasurementsPerWeek; reading ++)
                {
                    if (t[week][reading] > compareFirst) {
                        compareFirst = t[week][reading];
                    }
                }
                maxT [week] = compareFirst;
            }

            //Sum Temperatures of each week
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                double sum = 0;
                for (int reading = 1; reading <= nofMeasurementsPerWeek; reading++)
                {
                    sum+=t[week][reading];
                }
                sumT [week] = sum;
            }

            //Average Temperature for each week
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                avgT [week] = sumT [week] / nofMeasurementsPerWeek;
            }





// show the least , greatest and average temperature for
// each week
// *** WRITE YOUR CODE HERE ***
            System .out . println (" the least temperature for each week:");
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                System.out.println("week "+week+": "+ minT [week] );
            }
            System .out . println ();

            System .out . println (" the greatest temperature for each week:");
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                System.out.println("week "+week+": "+ maxT [week] );
            }
            System .out . println ();

            System .out . println (" the average temperature for each week:");
            for (int week = 1; week <= nofWeeks ; week ++)
            {
                System.out.println("week "+week+": "+ avgT [week] );
            }
            System .out . println ();

// the least , greatest and average temperature - whole period
            double minTemp = minT [1];
            double maxTemp = maxT [1];
            double sumTemp = sumT [1];
            double avgTemp = 0;
// compute and store the least , greatest and average
// temperature for the whole period
// *** WRITE YOUR CODE HERE ***
            //Min Temperature Whole Period
            for (int week = 2; week <= nofWeeks ; week ++)
            {
                if (minT[week] < minTemp)
                {
                    minTemp = minT[week];
                }
            }

            //Max Temperature Whole Period
            for (int week = 2; week <= nofWeeks ; week ++)
            {
                if (maxT[week] > maxTemp)
                {
                    maxTemp = maxT[week];
                }
            }

            //Sum Temperature Whole Period
            double sumAvgTemp = 0;
            for (int week = 1; week <= nofWeeks; week++)
            {
                sumAvgTemp+= avgT[week];
            }

            //Average Temperature Whole Period
            avgTemp = sumAvgTemp / nofWeeks ;





// show the least , greatest and average temperature for
// the whole period
// *** WRITE YOUR CODE HERE ***
            System .out . println ("The least temperature for the whole period: "+minTemp);
            System .out . println ("The greatest temperature for the whole period: "+maxTemp);
            System .out . println ("The average temperature for the whole period: "+avgTemp);
            System .out . println ();
        }
    }
