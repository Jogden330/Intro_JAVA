/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 8
 * a program that contains sevrial diffrent sorting algarithoms
 */
package data8;


public class Sort {
    
     private double[] list;
     private int time;
     private long end, start;
     
     /*
     Function: sort
     Author: jonatan Ogden
     Description: genaric constructor
     Inputs: N/a
     Outputs: N/a
     */
     public Sort()
     {
         
     }
     
     /*
     Function: sort
     Author: jonatan Ogden
     Description: an overloded constructor used to set the list
     Inputs: a double array used to set the list
     Outputs: N/a
     */
     public Sort(double[] list)
     {
         setList(list);
     }
      /*
     Function: insertionsort
     Author: jonatan Ogden
     Description: an overloded method used to set the list and call the insertionsort method
     Inputs: a double array used to set the list
     Outputs: a long that is the amout of time it tolk to sort in nano sceonds
     */
     public long insertionsort(double[] list)
     {
         setList(list);
         return insertionsort();
         
     }
      /*
     Function: insertionsort
     Author: jonatan Ogden
     Description: a meathod used for sorting by pionting to a place on the array and looking backword
     Inputs: N/A
     Outputs: a long that is the amout of time it tolk to sort in nano sceonds
     */
     public long insertionsort()
     {
         start = System.nanoTime();
         time = 0;
         double insert;
         int search;
         for (int i = 1; i < list.length; i++)
         {
             
             insert = list[i];
             search = i-1;
             while((search >= 0) && ( insert < list[search] ))
             {
                 list[search+1] = list[search];
                 search--;
                 time++;           
             }
             list[search+1] = insert;
         }
         end = System.nanoTime();
         return (end - start) / 1000;
     }
       /*
     Function: quickSort
     Author: jonatan Ogden
     Description: an overloded method used to set the list and call the quickSort method
     Inputs: a double array used to set the list
     Outputs: a long that is the amout of time it tolk to sort in nano sceonds
     */
     public long quickSort(double[] list)
     {
        setList(list);
        return quickSort();
     }
      /*
     Function: quickSort
     Author: jonatan Ogden
     Description: a public method used to call the private quickSort method and set some data
     Inputs: N/A
     Outputs: a long that is the amout of time it tolk to sort in nano sceonds
     */
     public long quickSort()
     {
         start = System.nanoTime();
         time = 0;
         quickSort(0,list.length-1);
         end = System.nanoTime();
         return (end - start) / 1000;
     }
       /*
     Function: quickSort
     Author: jonatan Ogden
     Description: a private method used to sort uing recershon
     Inputs: two ints that are positions on the array
     Outputs: N/A
     */
     private void quickSort(int left, int right)
     {
         int point,leftpoint,rightpoint;
         double pivot;
         time++;
         if(left<right)
         {
           point =  pivotPoint(left,right);
           swap(left,point);
           pivot = list[left];
           leftpoint = left + 1;
           rightpoint = right;
           while(leftpoint <= rightpoint)
           {
               while((leftpoint <= right) && (list[leftpoint]<= pivot))
                   leftpoint++;
               
               while((rightpoint >= left) && (list[rightpoint] > pivot))
                   rightpoint--;
               
               if(leftpoint<rightpoint)
               {
                   swap(leftpoint,rightpoint);
               }
           }
           swap(left,rightpoint);
           
           quickSort(left,rightpoint-1);
           
           quickSort(rightpoint+1,right);
           
         }
     }
        /*
     Function: pivotPoint
     Author: jonatan Ogden
     Description: a mrthod used to set a midle piont in the array so that the quick sort can quicly sort
     Inputs: two ints that represent to sides of the array
     Outputs: an int that is the middal value
     */
     private int pivotPoint(int l, int r)
     {
         return((l+r) / 2);
     }
     /*
     Function: selectSort
     Author: jonatan Ogden
     Description: an overloded method used to set the list and call the selectSort method
     Inputs: a double array used to set the list
     Outputs: a long that is the amout of time it tolk to sort in nano sceonds
     */
     public long selectSort(double[] list)
     {
         setList(list);
         return selectSort();
     }
      /*
     Function: selectSort
     Author: jonatan Ogden
     Description: a method used to sort an array by finding the smalist value and than puting it in its place
     Inputs: N/a
     Outputs: a long that is the amout of time it tolk to sort in nano sceonds
     */
     public long selectSort()
     {
        start = System.nanoTime();
        int min;
        time = 0;
        
        for(int i = 0; i < list.length; i++)
        {
            min = i;
            for(int x = i; x < list.length; x++)
            {
                if(list[x] < list[min])
                {
                    min = x;
                }
                time++;
            }
            swap(i,min);
            
        }
        end = System.nanoTime();
        return (end - start) / 1000;
     }
      /*
     Function: shellSort
     Author: jonatan Ogden
     Description: an overloded method used to set the list and call the shellSort method
     Inputs: a double array used to set the list
     Outputs: a long that is the amout of time it tolk to sort in nano sceonds
     */
     public long shellSort(double[] list)
     {
         setList(list);
         return shellSort();
     }
      /*
     Function: shellSort
     Author: jonatan Ogden
     Description: a sort meathod that is simaller to the insertionsort but stagers the intervals that it serches 
     Inputs: N/a
     Outputs: a long that is the amout of time it tolk to sort in nano sceonds
     */
     public long shellSort()
     {
         start = System.nanoTime();
         time = 0;
         double insert;
         int search;
         int interval = list.length/2;
         while(interval != 0)
         {
            for (int i = interval; i < list.length; i++)
             {
             
              insert = list[i];
              search = i-interval;
              while((search >= 0) && ( insert < list[search] ))
              {
                 list[search+interval] = list[search];
                 search = (search - interval);
                 time++;           
              }
                list[search+interval] = insert;
            }
            interval = interval/2;
         }
         end = System.nanoTime();
         return (end - start) / 1000;
     }
      /*
     Function: swap
     Author: jonatan Ogden
     Description: a method used to swap to values on an array 
     Inputs: to ints that are places on an array to be swoped
     Outputs: N/a
     */
     public void swap(int first, int second)
     {
         double temp = list[first];
         list[first] = list[second];
         list[second] = temp;
     }
     
       /*
     Function: show
     Author: jonatan Ogden
     Description: a method used to show the array 
     Inputs: N/a
     Outputs: N/a
     */
     public void show()
    {
         for(int x = 0; x < list.length; x++)
        {
            System.out.println(list[x]);
        }
    }
      /*
     Function: show
     Author: jonatan Ogden
     Description: a mutator method used to set the array
     Inputs: a double array used to set the list
     Outputs: N/a
     */
      void setList(double[] list)
    {
        this.list = new double[list.length];
        for(int i = 0; i < list.length; i++)
        {
            this.list[i] = (double)list[i];
        }
    }
       /*
     Function: time
     Author: jonatan Ogden
     Description: an assor method used to get the the amout of intervals it tolk to sort the array
     Inputs: N/a
     Outputs: an int the represents the amout of intervals it tolk to sort the array
     */
      public int getTime()
      {
          return time;
      }
        /*
     Function: getNanoTime
     Author: jonatan Ogden
     Description: an assor method used to get the the amout of time in nano seconds it tolk to sort the array
     Inputs: N/a
     Outputs: an long that represents the amout of the amout of time in nano seconds it tolk to sort the array
     */
      public long getNanoTime()
      {
          return (end - start) / 1000;
      }
}
