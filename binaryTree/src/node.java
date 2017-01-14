import java.util.*;

/**
 * Created by D'codex on December 2016.
 */
public class node {
    boolean hasLeft,hasRight;
    boolean isRootPrimary,isRoot,TraversalStatus;
    String Data;
    String nodeID,leftNodeID,rightNodeID,parentID;
    boolean HasLeftUA,HasRightUA;
    int childrenNodeCount;
    node(){
        hasLeft=false;
        hasRight=false;
        Data="";
        childrenNodeCount=0;
        TraversalStatus=false;
    }
    void check(){
        if(hasLeft||hasRight)
            isRoot=true;
    }
    String fetchRoot(){
        return parentID;
    }
    String fetchID(){
        return nodeID;
    }
    String fetchSiblingID(){
        return "("+String.valueOf(leftNodeID)+" "+String.valueOf(rightNodeID)+")";
    }
}