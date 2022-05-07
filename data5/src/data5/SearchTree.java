/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 5
 * a tree disined to fined information quicly
 */
package data5;


public class SearchTree{
    
    private node root;
      /*
     Function: SearchTree
     Author: jonatan Ogden
     Description: a constructor useto set the tree to null
     Inputs: N/a
     Outputs: N/a
     */
    public SearchTree()
    {
        this.root = null;
    }
    /*
     Function: incert
     Author: jonatan Ogden
     Description: a private metod used to set a node on the tree in its proper position
     Inputs: an int to fined and set the postiton of the node and a node that is the starting piont of the method
     Outputs: N/a
     */
    private void insert(int data, node n)
    {
        if(this.root == null)
        {
            this.root = new node(data);
        }
        else if(data < n.getData())
        {
            if(n.getLeft() != null) 
            {
                insert(data,n.getLeft());
            }else {
                n.setLeft(new node(data));
            }
        }
        else if(data > n.getData())
        {
            if(n.getRight() != null)
            {
                insert(data,n.getRight());
            } else {
                n.setRight(new node(data));
            }
        }      
    }
    /*
     Function: make empty
     Author: jonatan Ogden
     Description: a private metod used to make the first node in the tree void with delences all of the nodes on the tree
     Inputs: N/A
     Outputs: N/a
     */
    
   public void makeEmpty( )
    {
        root = null;
    }
   /*
     Function: remove
     Author: jonatan Ogden
     Description: a private metod used to remove a node in the tree
     Inputs: an int to be secred for and a node that is the starting point of the method
     Outputs: the node to be removed
     */
    private node remove(int data, node n)
    {
        if(this.root == null)
        {
         return n;   
        }
        if(data < n.getData())
        {
           n.setLeft(this.remove(data, n.getLeft())); 
        }
        else if(data > n.getData())
        {
            n.setRight(this.remove(data, n.getRight()));
        }
        else if(n.getLeft() != null && n.getRight() != null)
        {
            n.setData(findMin(n.getRight()));
            remove(n.getData(),n.getRight());
        }
        else
        {
            n = (n.getLeft() != null) ? n.getLeft() : n.getRight();
            
        }
        return n;
    }
     /*
     Function: remove
     Author: jonatan Ogden
     Description: a public metod used to call the private remove( method 
     Inputs: N/A
     Outputs: an int to be pased to the privater remove method
     */
    public void remove(int data)
    {
        this.remove(data, this.root);
    }
     /*
     Function: findMix
     Author: jonatan Ogden
     Description: a private metod used fined the smallist value in the tree 
     Inputs: a node that is the strating position on the tree
     Outputs: an int that is the smallist value on the tree
     */
    private int findMin(node n)
    {
        if(n.getLeft() == null)
        {
            return n.getData();
        } else {
            return findMin(n.getLeft());
        }
    }
     /*
     Function: findMix
     Author: jonatan Ogden
     Description: a public metod used to call the private findMix method 
     Inputs: an int that is returned from the privat findmix method
     Outputs: N/A
     */
    public int findMin()
    {
        return this.findMin(this.root);
    }
     /*
     Function: findMax
     Author: jonatan Ogden
     Description: a private metod used fined the hist value in the tree 
     Inputs: a node that is the strating position on the tree
     Outputs: an int that is the highs value on the tree
     */
    private int findMax(node n)
    {
        if(n.getLeft() == null)
        {
            return n.getData();
        } else {
            return findMax(n.getRight());
        }  
    }
     /*
     Function: findMax
     Author: jonatan Ogden
     Description: a public metod used to call the private findMax method 
     Inputs: an int that is returned from the privat findmax method
     Outputs: N/A
     */
     public int findMax()
    {
        return this.findMax(this.root);
    }
      /*
     Function: insert
     Author: jonatan Ogden
     Description: a public metod used to call the private insert method 
     Inputs: a int that will be past to the private insert method
     Outputs: N/A
     */
    public void insert(int data)
    {
        this.insert(data, this.root);
    }
     /*
     Function: contains
     Author: jonatan Ogden
     Description: a private metod used to see if a node exists in the tree 
     Inputs: a int to be cecked and a node object for a starting point
     Outputs: a bullean to show if the node exists in the tree
     */
    private boolean contains(int data, node n)
    {
        if(n == null)
        {
            return false;
        }
        else if(data < n.getData())
        {
            return contains(data,n.getRight());
        }
        else if(data > n.getData())
        {
            return contains(data, n.getLeft());
        }
        else
        {
            n.incressNumb();
            return true;
        }
    }
      /*
     Function: contains
     Author: jonatan Ogden
     Description: a public metod used to call the private contains method 
     Inputs: a int that will be past to the private contains method
     Outputs: a bullean the it passed from the private contains method
     */
    public boolean contains(int data)
    {
        return this.contains(data, this.root);
    }
       /*
     Function: printTree
     Author: jonatan Ogden
     Description: a  metod used to print the data sections of every node in the trfee
     Inputs: a node object that will be the starting pont of the printtree method
     Outputs: N/a
     */
    private void printTree(node n)
    {
        if(n != null)
        {
            System.out.println(n.getData());
            printTree(n.getLeft());
            printTree(n.getRight());
        }
    }
      /*
     Function: printTree
     Author: jonatan Ogden
     Description: a public metod used to call the private printtree method
     Inputs: N/A
     Outputs: N/a
     */
    public void printTree()
    {
        this.printTree(root);
    }
    /*
     Function: isEmpty
     Author: jonatan Ogden
     Description: checks to see if the tree is empty
     Inputs: N/A
     Outputs: a boolean to tell is the tree is empty or not
     */
    boolean isEmpty()
    {
        return this.root == null;
    }
    /*
     Function: getRoot
     Author: jonatan Ogden
     Description: an assessor metod used to get the root data section of th tree
     Inputs: N/A
     Outputs: a node object that is the root of the tree
     */
    public node getRoot()
    {
        return root;
    }
    /*
     Function: setRoot
     Author: jonatan Ogden
     Description: a mutator metod used to set the root data section of th tree
     Inputs: a node object that is the root of the tree
     Outputs: N/a
     */
    void setRoot(node root)
    {
        this.root = root;
    }
 
}
