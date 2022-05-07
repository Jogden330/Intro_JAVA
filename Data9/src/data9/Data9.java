/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package data9;

/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 9
 * a progra used to test a graph
 */
public class Data9 {

    Graphs g = new Graphs();
    /*
     Function: Data9
     Author: jonatan Ogden
     Description: a method used to test the graph
     Inputs: N/a
     Outputs:  N/a
     */
    public Data9()
    {
        g.addCity("Canyon Lake");
        g.addCity("Sun City");
        g.addCity("Lank Elsenore");
        g.addCity("Murietta");
        g.addCity("Menifee");
        g.addCity("temecula");
        
        g.addlink("Canyon Lake", "Sun City");
        g.addlink("Canyon Lake", "Lank Elsenore");
        g.addlink("Sun City", "Menifee");
        g.addlink("Lank Elsenore", "Murietta");
        g.addlink("Murietta", "Menifee");
        g.addlink("Menifee", "temecula");
        g.addlink("temecula", "Murietta");
        
        g.show();
        System.out.println(" ");
        g.DepthFirstTraversal();
    }
     /*
     Function: main
     Author: jonatan Ogden
     Description: a method used to start the data9 meathod
     Inputs: N/a
     Outputs:  N/a
     */
    public static void main(String[] args) {
        Data9 d9 = new Data9();
                
       }
}
