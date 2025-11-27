public class SplayTree {
    Node root;
    void rotateZIGright(Node node1){
        Node node2 =node1.left;
        if(node2!=null){
            node1.left=node2.right;
            if(node2.right!=null){
                node2.right.parent=node1;
            }
            node2.parent=node1.parent;
        }
        if(node1.parent==null){
            root=node2;
        } else if (node1 ==node1.parent.left) {
            node1.parent.left= node2;
        }else
            node1.parent.right = node2;

        if(node2!= null)
            node2.right=node1;

        node1.parent=node2;
    }
    void rotateZIGleft(Node node1){
        Node node2= node1.right;
        if(node2!=null){
            node1.right=node2.left;
            if(node2.left!=null){
                node2.left.parent=node1;
            }
            node2.parent=node1.parent;
        }
        if(node1.parent==null){
            root=node2;
        }else if(node1==node1.parent.right){
            node1.parent.right=node2;
        }else
            node1.parent.left=node2;

        if(node2!=null)
            node2.left=node1;

        node1.parent=node2;
    }
    void splay(Node node){
        while(node.parent!=null){
            //ZIG rotation(left or right)
            if(node.parent.parent==null){
                if(node.parent.left==node){
                    rotateZIGright(node.parent);
                }else
                    rotateZIGleft(node.parent);
            }
            //ZIG-ZIG rotation
            else if (node.parent.left==node && node.parent.parent.left==node.parent) {
                rotateZIGright(node.parent.parent);
                rotateZIGright(node.parent);
            } else if (node.parent.right==node && node.parent.parent.right==node.parent) {
                rotateZIGleft(node.parent.parent);
                rotateZIGleft(node.parent);
            //ZIG-ZAG rotation
            }else{
                if(node.parent.left==node){
                    rotateZIGright(node.parent);
                    rotateZIGleft(node.parent);
                }else{//node.parent.right==node
                    rotateZIGleft(node.parent);
                    rotateZIGright(node.parent);
                }
            }
        }
    }
    boolean search(int value){
        Node temp = root;
        Node last =null;
        while(temp!=null){
            last=temp;
            if(value < temp.value){
                temp=temp.left;
            } else if (value>temp.value) {
                temp=temp.right;

            }else{//value was found
                splay(temp);
                System.out.println("Found value: "+temp.value);
                return true;
            }
        }
        if(last!=null){//didn't find value
            splay(last);//splay the latest
        }
        return false;
    }
    public void insertValue(int value){
        Node current_node=root;
        Node father=null;
        while(current_node!=null){
            father=current_node;
            if(value<current_node.value){
                current_node=current_node.left;
            } else if (value>current_node.value) {
                current_node=current_node.right;

            }else{
                splay(current_node);//value already exists
                return;
            }
        }
        current_node= new Node(value);
        current_node.parent=father;
        if(father==null){
            root=current_node;
        } else if (value< father.value) {
            father.left=current_node;

        }else
            father.right=current_node;

        splay(current_node);
    }
    void removeValue(int value){
        if(!search(value))
            return;

        Node leftTree=root.left;
        Node rightTree=root.right;
        if(leftTree!=null){
            leftTree.parent=null;
        }
        if(rightTree!=null){
            rightTree.parent=null;
        }
        if(leftTree==null){
            root=rightTree;
            return;
        }
        Node max_value= leftTree;
        while(max_value.right!=null)
            max_value=max_value.right;

        splay(max_value);
        max_value.right=rightTree;
        if(rightTree!=null)
            rightTree.parent=max_value;

        root=max_value;
    }
    public void printInOrder(){
        printInOrder(root);
        System.out.println();
    }
    public void printInOrder(Node root){
        if(root==null)
            return;
        printInOrder(root.left);
        System.out.print(root.value+" ");
        printInOrder(root.right);
    }
    public void printpreOrder(){
        printpreOrder(root);
        System.out.println();
    }
    public void printpreOrder(Node root){
        if(root==null)
            return;
        System.out.print(root.value+" ");
        printpreOrder(root.left);

        printpreOrder(root.right);
    }
    public void printpostOrder(){
        printpostOrder(root);
        System.out.println();
    }
    public void printpostOrder(Node root){
        if(root==null)
            return;

        printpostOrder(root.left);

        printpostOrder(root.right);
        System.out.print(root.value+" ");
    }
}
