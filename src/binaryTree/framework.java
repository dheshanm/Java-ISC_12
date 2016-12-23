package binaryTree;
import java.util.*;

/**
 * Created by D'codex on December 2016.
 */
public class framework {
    public Tree intialize(){
        System.out.print("Enter the Number of Nodes in the Binary Tree    :");
        Scanner in=new Scanner(System.in);
        int count=in.nextInt();String parentID="";
        Tree bTree=new Tree(count);
        int ID=0;int i=0;
        while(i<count){
            Scanner in0=new Scanner(System.in);
            System.out.println("Details for node#"+i);
            System.out.print("Enter Data  :");
            bTree.binaryTree[i].Data=in0.nextLine();
            bTree.binaryTree[i].nodeID=String.valueOf(ID);
            if(i!=0){
                boolean flag = true;
                while (flag) {
                    System.out.print("Enter the node's Parent:");
                    parentID = in0.nextLine();
                    if (bTree.binaryTree[Integer.valueOf(parentID)].childrenNodeCount >= 2) {
                        System.out.println("Parent Node is Full");
                    }
                    else {
                        bTree.binaryTree[Integer.valueOf(parentID)].childrenNodeCount=bTree.binaryTree[Integer.valueOf(parentID)].childrenNodeCount+1;
                        bTree.binaryTree[i].parentID=parentID;
                        flag=false;
                    }
                }
                System.out.print("Is the node Parent's Left?");
                String temp=in0.next();
                if(temp.equalsIgnoreCase("yes")||temp.equalsIgnoreCase("y")){
                    int t=Integer.valueOf(parentID);
                    bTree.binaryTree[t].hasLeft=true;
                    bTree.binaryTree[t].leftNodeID=bTree.binaryTree[i].nodeID;
                }
                else {
                    int t=Integer.valueOf(parentID);
                    bTree.binaryTree[t].hasRight = true;
                    bTree.binaryTree[t].rightNodeID=bTree.binaryTree[i].nodeID;
                }
            }
            else {
                bTree.binaryTree[i].isRootPrimary = true;
                bTree.binaryTree[i].parentID="0";
                bTree.binaryTree[i].isRoot=true;
            }
            bTree.binaryTree[i].check();
            System.out.println("_________________________________________________________");
            i=i+1;ID=ID+1;
        }
        bTree.finalise();
        return bTree;
    }
    public void displayAll(Tree bTree){
        System.out.println("Running a Full Analysis on the Binary Tree");
        System.out.println("Printing nodes Details");
        for(int i=0;i<bTree.count;i++){
            System.out.println("Node #"+i);
            System.out.println("PrimaryRoot                 :"+bTree.binaryTree[i].isRootPrimary);
            System.out.println("isRoot                      :"+bTree.binaryTree[i].isRoot);
            System.out.println("Data                        :"+bTree.binaryTree[i].Data);
            System.out.println("Number of Children Nodes    :"+bTree.binaryTree[i].childrenNodeCount);
            System.out.println("hasLeft                     :"+bTree.binaryTree[i].hasLeft);
            if(bTree.binaryTree[i].hasLeft)
                System.out.println("LeftNodeID                  :"+bTree.binaryTree[i].leftNodeID);
            System.out.println("hasRight                    :"+bTree.binaryTree[i].hasRight);
            if(bTree.binaryTree[i].hasRight)
                System.out.println("RightNodeID                 :"+bTree.binaryTree[i].rightNodeID);
            System.out.println("parentID                    :"+bTree.binaryTree[i].fetchRoot());
            System.out.println("SiblingPairs (if any)       :"+bTree.binaryTree[i].fetchSiblingID());
            System.out.println("____________________________________________________________________________");
        }
        System.out.println("Tree Specifications");
        System.out.println("Total No. of Nodes              :"+bTree.count);
        System.out.println("Height of Tree                  :"+bTree.height);
        System.out.println("Depth of Tree                   :"+bTree.depth);
        System.out.println("Leaves                          :"+bTree.leaves.trim());
        System.out.println("Sibling Pairs                   :"+bTree.siblingPairs.trim());
        System.out.println("Traversal                       :"+bTree.Traversal);
        System.out.println("Traversal Pre-Order             :"+bTree.TraversalPre);
    }
}