/*
 * Class: CMSC203  
 * Instructor: Ahmed Tarek
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming assignment independently.
 * I have not copied the code from a student or any source.
 * I have not given my code to any student.
 * Salim Musah
 */
public class HolidayBonus

{
     // definition of the method calculateHolidayBonus
     // pass in a two dimensional ragged array of doubles,
     // bonus for high, bonus for low, and bouns for others.
     // and returns the an array of doubles which represents
     // the holiday bonuses for each of the stores in the district.
     public static double[] calculateHolidayBonus(double[][] data, double high,
              double low, double other)
     {
          double[][] holidayBonusArr = new double[data.length][];
          
          for (int i = 0; i < data.length; i++)
          {
              holidayBonusArr[i] = new double[data[i].length];
          }
          
          for (int i = 0, j = 0; i < holidayBonusArr.length; i++, j++)
          {
              int highIndex = TwoDimRaggedArrayUtility.getHighestInColumnIndex(data, i);
              int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,i);
              if (i < holidayBonusArr[j].length)
              {
                   holidayBonusArr[highIndex][i] = high;
                   holidayBonusArr[lowIndex][i] = low;
                   if (j == highIndex || j == lowIndex)
                        continue;
                   else
                   {
                        holidayBonusArr[j][i] = other;
                   }
              }
          }

          double[] holidayBonusPerStore = new double[data.length];
          
          for (int i = 0; i < holidayBonusArr.length; i++)
          {
              for (int j = 0; j < holidayBonusArr[i].length; j++)
              {
                   holidayBonusPerStore[i] += holidayBonusArr[i][j];
              }
          }
          return holidayBonusPerStore;
     }

     // definition of the method calculateTotalHolidayBonus
     // pass in a two dimensional ragged array of doubles,
     // bonus for high, bonus for low, and bouns for others.
     // returns a double which represents the total of all Holiday Bonuses for
     // the District.

     public static double calculateTotalHolidayBonus(double[][] data,
              double high, double low, double other)
     {
          double[][] holidayBonusArr = new double[data.length][];

          for (int i = 0; i < data.length; i++)
          {
              holidayBonusArr[i] = new double[data[i].length];
          }

          for (int i = 0, j = 0; i < holidayBonusArr.length; i++, j++)
          {
              int highIndex = TwoDimRaggedArrayUtility
                        .getHighestInColumnIndex(data, i);
              int lowIndex = TwoDimRaggedArrayUtility.getLowestInColumnIndex(data,i);
              
              if (i < holidayBonusArr[j].length)
              {
                   holidayBonusArr[highIndex][i] = high;
                   holidayBonusArr[lowIndex][i] = low;

                   if (j == highIndex || j == lowIndex)
                        continue;
                   else
                   {
                        holidayBonusArr[j][i] = other;
                   }
              }
          }
          double holidayTotal = 0.0;
          
          for (int i = 0; i < holidayBonusArr.length; i++)
          {
              for (int j = 0; j < holidayBonusArr[i].length; j++)
              {
                   holidayTotal += holidayBonusArr[i][j];
              }
          }
          return holidayTotal;
     }
}