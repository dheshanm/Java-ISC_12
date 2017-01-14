import java.util.*;

/**
 * Created by D'codex on December 2016.
 */
public class Tree {
    node binaryTree[],duplicate0[],duplicate1[],duplicate2[];
    int count;int rootID,height,depth;
    String siblingPairs,leaves,Traversal;
    Tree(int count0){
        binaryTree =new node[count0];
        duplicate0=new node[count0];
        for(int i=0;i<count0;i++){
            binaryTree[i]=new node();
            duplicate0[i]=new node();
        }
        count=count0;
        rootID=0;
        height=0;depth=0;
        leaves="";siblingPairs="";Traversal="";
    }
    public Tree copy(Tree copy){
        Tree new0=new Tree(copy.count);
        new0.binaryTree=copy.binaryTree;
        return new0;
    }
    void finalise(){
        for(int i=0;i<count;i++){
            if(binaryTree[i].childrenNodeCount==0)
                leaves=leaves+" "+String.valueOf(binaryTree[i].fetchID());
            if(binaryTree[i].childrenNodeCount==2){
                siblingPairs=siblingPairs+" "+binaryTree[i].fetchSiblingID();
            }
        }
        StringTokenizer st=new StringTokenizer(leaves);
        while(st.hasMoreElements()){
            int counter=1;
            int leafID=Integer.valueOf(st.nextToken());
            //System.out.println(leafID);
            node temp=binaryTree[leafID];
            while(!temp.isRootPrimary){
                counter=counter+1;
                temp=binaryTree[Integer.valueOf(temp.fetchRoot())];
            }
            if(counter>height) {
                height = counter;
                depth=height-1;
            }
        }
        {
            duplicate0=binaryTree;
            int t = 0;
            node temp = duplicate0[0];
            while (t < count) {
                if (temp.hasLeft) {
                    temp = duplicate0[Integer.parseInt(temp.leftNodeID)];
                }
                else {
                    if(!temp.hasLeft&&temp.hasRight) {
                        Traversal = Traversal + " " + temp.Data;
                        t = t + 1;
                        duplicate0[Integer.parseInt(temp.fetchID())].TraversalStatus=true;
                        duplicate0[Integer.parseInt(temp.fetchRoot())].hasLeft = false;
                        duplicate0[Integer.parseInt(temp.fetchRoot())].hasLeft = false;
                        temp = duplicate0[Integer.parseInt(temp.rightNodeID)];
                    }
                    else if(!duplicate0[Integer.parseInt(temp.fetchRoot())].hasRight){
                        temp = duplicate0[Integer.parseInt(temp.parentID)];
                    }
                    else if(!temp.hasLeft&&!temp.hasRight){
                        Traversal = Traversal + " " + temp.Data;
                        t = t + 1;
                        duplicate0[Integer.parseInt(temp.fetchID())].TraversalStatus=true;
                        duplicate0[Integer.parseInt(temp.fetchRoot())].hasLeft = false;
                        //temp=binaryTree[Integer.parseInt(temp.parentID)];
                        int i0=0;
                        while(duplicate0[Integer.parseInt(temp.fetchID())].TraversalStatus) {
                            temp = duplicate0[Integer.parseInt(temp.parentID)];
                            i0++;
                            if(i0>=5)
                                break;
                        }
                    }
                }
            }
        }
    }
}