/**
 * Created by D'codex on January 2017.
 */
public class Traversal {
    Tree in;
    Traversal(Tree inp){
        in=inp;
        {
            int t = 0;
            node temp = in.duplicate0[0];
            while (t < in.count) {
                if (temp.hasLeft) {
                    temp = in.duplicate0[Integer.parseInt(temp.leftNodeID)];
                }
                else {
                    if(!temp.hasLeft&&temp.hasRight) {
                        in.Traversal = in.Traversal + " " + temp.Data;
                        t = t + 1;
                        in.duplicate0[Integer.parseInt(temp.fetchID())].TraversalStatus=true;
                        in.duplicate0[Integer.parseInt(temp.fetchRoot())].hasLeft = false;
                        in.duplicate0[Integer.parseInt(temp.fetchRoot())].hasLeft = false;
                        temp = in.duplicate0[Integer.parseInt(temp.rightNodeID)];
                    }
                    else if(!in.duplicate0[Integer.parseInt(temp.fetchRoot())].hasRight){
                        temp = in.duplicate0[Integer.parseInt(temp.parentID)];
                    }
                    else if(!temp.hasLeft&&!temp.hasRight){
                        in.Traversal = in.Traversal + " " + temp.Data;
                        t = t + 1;
                        in.duplicate0[Integer.parseInt(temp.fetchID())].TraversalStatus=true;
                        in.duplicate0[Integer.parseInt(temp.fetchRoot())].hasLeft = false;
                        //temp=binaryTree[Integer.parseInt(temp.parentID)];
                        int i0=0;
                        while(in.duplicate0[Integer.parseInt(temp.fetchID())].TraversalStatus) {
                            temp = in.duplicate0[Integer.parseInt(temp.parentID)];
                            i0++;
                            if(i0>=5)
                                break;
                        }
                    }
                }
            }
        }
        System.out.println(in.Traversal);
    }
}
