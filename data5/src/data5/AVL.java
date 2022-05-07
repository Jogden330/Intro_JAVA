/*
 * @author Jonathan Ogden 
 * CSIC 211
 * 0211330
 * assignment 5
 * a tree disined to fined information quicly and to rearange itslef to be more ifitiont
 */
package data5;


/**
 *
 * @author The Meat Man
 */
public class AVL<T> {
    
    private node root;
    
    private static final int ALLOWED_IMBALANCE = 1;
       /*
     Function: AVL
     Author: jonatan Ogden
     Description: a constructor useto set the tree to null
     Inputs: N/a
     Outputs: N/a
     */
    public AVL()
      {
          this.root = null;          
     }
     /*
     Function:  rotateWithLeftChild
     Author: jonatan Ogden
     Description: a method that rotats the positions of a node
     Inputs: a node to be rotated
     Outputs: a rotated node
     */
     private node rotateWithLeftChild( node k2 )
    {
        node k1 = k2.getLeft();
        k2.setLeft(k1.getRight());
        k1.setRight(k2);
        k2.setheight (Math.max(  height(k2.getLeft()),  height(k2.getRight()) ) + 1);
        k1.setheight (Math.max( height(k1.getLeft()),  height(k2) ) + 1);
        return k1;
    }
      /*
     Function:  doubleWithLeftChild
     Author: jonatan Ogden
     Description: a method that rotats the positions of a node twice
     Inputs: a node to be rotated
     Outputs: a rotated node
     */
     private node doubleWithLeftChild( node k3 )
    {
        k3.setLeft (rotateWithRightChild( k3.getLeft()));
        return rotateWithLeftChild( k3 );
    }
       /*
     Function:  rotateWithRightChild
     Author: jonatan Ogden
     Description: a method that rotats the positions of a node
     Inputs: a node to be rotated
     Outputs: a rotated node
     */
     private node rotateWithRightChild( node k1 )
    {
        node k2 = k1.getRight();
        k1.setRight(k2.getLeft());
        k2.setLeft(k1);
        k1.setheight (Math.max(  height(k2.getLeft()),  height(k2.getRight()) ) + 1);
        k2.setheight (Math.max( height(k1.getLeft()),  height(k2)) + 1);
        return k2;
    }
     /*
     Function: doubleWithRightChild
     Author: jonatan Ogden
     Description: a method that rotats the positions of a node twice
     Inputs: a node to be rotated
     Outputs: a rotated node
     */
     private node doubleWithRightChild( node k1 )
    {
        k1.setRight(rotateWithLeftChild( k1.getRight() ));
        return rotateWithRightChild( k1 );
    }
     /*
     Function: insert
     Author: jonatan Ogden
     Description: a public metod used to call the private insert method 
     Inputs: a int and a genaric that will be past to the private insert method
     Outputs: N/A
     */
    
    public void insert( int x, T info )
    {
        setRoot(insert( x, getRoot(), info ));
    }
      /*
     Function: incert
     Author: jonatan Ogden
     Description: a private metod used to set a node on the tree in its proper position
     Inputs: an int to fined and set the postiton of the node and a node that is the starting piont of the method and a genaric that if the info section of the node
     Outputs: N/a
     */
    private node insert(int x, node t, T info)
    {
        if(t == null)
        {
            return new node<T>(x,info,null, null);
        }
        if(x < t.getData())
        {
            t.setLeft(insert(x, t.getLeft(),(T) info));
        }
        else if (x > t.getData())
        {
            t.setRight(insert(x, t.getRight(),(T) info));
        }
        return balance(t);
    }
       /*
     Function: Balance
     Author: jonatan Ogden
     Description: a method that takes a node and rearanges it so that it is better balaned
     Inputs: a node to be balenced
     Outputs: an node that has been balanced
     */
    private node balance(node t)
    {
        if(t == null)
        {
            return t;
        }
        if(( height(t.getLeft())  -  height(t.getRight())) > ALLOWED_IMBALANCE ) {
            if( height(t.getLeft().getLeft()) >=  height(t.getLeft().getRight())) 
            {
                t = rotateWithLeftChild( t );
            }
            else
            {
                t = doubleWithLeftChild( t );
            }
        }
        else
        if( ( height(t.getRight()) -  height(t.getLeft())) > ALLOWED_IMBALANCE ) {
            if(  height(t.getRight().getRight()) >=  height(t.getRight().getLeft()))
            {
                t = rotateWithRightChild( t );
            }
            else 
            {
                t = doubleWithRightChild( t );
            }
        }

        t.setheight(Math.max(  height(t.getLeft()), height(t.getRight()) ) + 1);
        return t;
    }
    /*
     Function: insert
     Author: jonatan Ogden
     Description: a public metod used to call the private checkBalance method 
     Inputs: N/A
     Outputs: N/A
     */
    public void checkBalance( )
    {
        checkBalance( getRoot() );
    }
     /*
     Function: checkBalance
     Author: jonatan Ogden
     Description: checks to see if a tree is the same hight on all sides
     Inputs: an node that is the starting position of the meathod
     Outputs: an int that is the hight of the tree
     */
    private int checkBalance( node t )
    {
        if( t == null )
        {
            return -1;
        }
        
        if( t != null )
        {
            int hl = checkBalance( t.getLeft() );
            int hr = checkBalance( t.getRight() );
            if( Math.abs(  height(t.getLeft()) -  height(t.getRight()) ) > 1 ||
                    height(t.getLeft()) != hl ||  height(t.getRight()) != hr ) 
            {
                System.out.println( "im sorry thare was a problem" );
            }
        }
        
        return t.getheight();
    }
    /*
     Function: remove
     Author: jonatan Ogden
     Description: a private metod used to remove a node in the tree
     Inputs: an int to be secred for and a node that is the starting point of the method
     Outputs: the node to be removed
     */
    private node remove( int x, node  t )
    {
        if( t == null ) 
        {
            
            return t;
        }   
        
        if( x < t.getData() )
        {
            t.setLeft(remove( x, t.getLeft() ));
        }
        else if( x  > t.getData() ) 
        {
            t.setRight(remove( x, t.getRight() ));
        }
        else if( t.getLeft() != null && t.getRight()!= null )
        {
            t.setData(findMin( t.getRight()).getData());
            t.setRight( remove( t.getData(), t.getRight() ));
        }
        else
        {
            t = ( t.getLeft() != null ) ? t.getLeft() : t.getRight();
        }
        return balance( t );
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
     Function: contains
     Author: jonatan Ogden
     Description: a private metod used to see if a node exists in the tree also cheeps trake of the emount of times a node was acessesed
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
     Function: Height
     Author: jonatan Ogden
     Description: a method used to determen how meany spaces up a tree a node it 
     Inputs: a node to be checked
     Outputs: an int representing its place on the tree
     */
     private int height( node t )
    {
        return t == null ? -1 : t.getheight();
    }
      /*
     Function: findMix
     Author: jonatan Ogden
     Description: a private metod used fined the lowist value in the tree 
     Inputs: a node that is the strating position on the tree
     Outputs: an node that is the lowist value on the tree
     */
     
      private node findMin( node t )
    {
        if( t == null ) 
        {
            return t;
        }

        while( t.getLeft() != null ) 
        {
            t = t.getLeft();
        }
        return t;
    }      /*
     Function: findMix
     Author: jonatan Ogden
     Description: a public metod used to call the private findMix method 
     Inputs: an int that is the node reterunds data section
     Outputs: N/A
     */
     public int findMix()
    {
        return this.findMin(this.root).getData();
    }
   /*
     Function: findMax
     Author: jonatan Ogden
     Description: a private metod used fined the hist value in the tree 
     Inputs: a node that is the strating position on the tree
     Outputs: an int that is the highs value on the tree
     */
         private node findMax( node t )
    {
        if( t == null ) 
        {
            return t;
        }

        while( t.getRight() != null ) 
        {
            t = t.getRight();
        }
        return t;
    }
          /*
     Function: findMax
     Author: jonatan Ogden
     Description: a public metod used to call the private findMax method 
     Inputs: an int that is the node reterunds data section
     Outputs: N/A
     */
     public int findMax()
    {
        return this.findMax(this.root).getData();
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
        this.printTree(getRoot());
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
            System.out.println(n.getData() + " " + n.getInfo());
            
            printTree(n.getLeft());
            printTree(n.getRight());
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
