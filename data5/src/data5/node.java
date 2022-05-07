/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 5
 * an object to be placed on a tree  
 */
package data5;


public class node<T>
{
    private int data;
    private int numb = 1;
    private T info;
    private node left;
    private node right;
    private int height;
     /*
     Function: node
     Author: jonatan Ogden
     Description: an overloded constructor used to set the data section of the node object
     Inputs: an int that sets the data section of the node object
     Outputs: N/A
     */
    node(int data)
    {
        this.data = data;
    }
      /*
     Function: node
     Author: jonatan Ogden
     Description: an overloded constructor used to set and rearaged the data section of the node odject
     Inputs: an int that sets the data section of the node object and two node objects to set the right and left data sections of the node object
     Outputs: N/A
     */
     node(int data,node right, node left)
    {
        this.right = right;
        this.left = left;
        this.data = data;
    }
       /*
     Function: node
     Author: jonatan Ogden
     Description: an overloded constructor used to set and rearaged the data section of the node odject
     Inputs: an int and a genaric that sets the data section of the node object and two node objects to set the right and left data sections of the node object
     Outputs: N/A
     */
     node(int data,T info, node right, node left)
     {
        this.right = right;
        this.left = left;
        this.data = data;
        this.info = info;
     }
    /*
     Function: setData
     Author: jonatan Ogden
     Description: a mutator method used to set the data section
     Inputs: a genaric that is used to set the data section
     Outputs: n/a
     */
    void setData(int data)
    {
        this.data = data;
    }
    /*
     Function: getData
     Author: jonatan Ogden
     Description: an assessor method used to retrieve the data section
     Inputs: N/a
     Outputs: a generic that is the data section
     */
    int getData()
    {
        return data;
    }
    /*
     Function: setleft
     Author: jonatan Ogden
     Description: a mutator method that is used to set the next link in the tree
     Inputs: a node that is the next link on the tree
     Outputs: n/a
     */
    void setLeft(node left)
    {
        this.left = left;
    }
    /*
     Function: getleft
     Author: jonatan Ogden
     Description: a accessor  method that is used to see the next link in the tree
     Inputs: N/A
     Outputs: a node that is the next link on the tre
     */
    node getLeft()
    {
        return left;
    }
    /*
     Function: setright
     Author: jonatan Ogden
     Description: a mutator method that is used to set the next link in the tree
     Inputs: a node that is the next link on the tree
     Outputs: n/a
     */
    void setRight(node right)
    {
        this.right = right;
    }
    /*
     Function: getright
     Author: jonatan Ogden
     Description: a accessor  method that is used to see the next link in the tree
     Inputs: N/A
     Outputs: a node that is the next link on the tre
     */
    node getRight()
    {
        return right;
    }
    /*
     Function: getHight
     Author: jonatan Ogden
     Description: a accessor  method used to retreve the hight of the node object
     Inputs: n/a
     Outputs: an int value the represents the curnt hight of the node object
     */
    int getheight()
    {
        return height;
    }
    /*
     Function: setHight
     Author: jonatan Ogden
     Description: a mutator method used to set the hight of the node object
     Inputs: an int used to set the hight of the node object
     Outputs: n/a
     */
    void setheight(int height)
    {
        this.height = height;
    }
    /*
     Function: getInfo
     Author: jonatan Ogden
     Description: an assessor method used to set a gensric data tipe in the node object
     Inputs: n/a
     Outputs: a genaric object used to tereve data from the genaric data secton of the node object
     */
    T getInfo()
    {
     return info;   
    }
    /*
     Function: setinfo
     Author: jonatan Ogden
     Description: a assessor methos used to set the genaric data section of the node object
     Inputs: a genaric that is used to set the genaric data section of the node object
     Outputs: n/a
     */
    void setInfo(T info)
    {
        this.info = info;
    }
    /*
     Function: incressNumb 
     Author: jonatan Ogden
     Description: a simple method used to inress the numb data section of the node object
     Inputs: n/a
     Outputs: n/a
     */
    void incressNumb()
    {
        ++numb;
    }
          /*
     Function:  decresseNumb 
     Author: jonatan Ogden
     Description: a simple method used to decressw the numb data section of the node object
     Inputs: n/a
     Outputs: n/a
     */
    void decresseNumb()
    {
        --numb;
    }
            /*
     Function:  setNumb 
     Author: jonatan Ogden
     Description: a mutator method used to set the numb data section of the node object
     Inputs: an int used to set thr numb data section
     Outputs: n/a
     */
    void setNumb(int numb)
    {
        this.numb = numb;
    }
             /*
     Function:  getNumb 
     Author: jonatan Ogden
     Description: an assessor method used to get the numb data section of the node object
     Inputs: a/n
     Outputs: an int used to access the numb data section
     */
    int getNumb()
    {
        return numb;
    }
}
