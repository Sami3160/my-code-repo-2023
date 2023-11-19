import javax.swing.*;
import javax.swing.tree.*;

public class JTreeDemo
{
int samiii;
    public static void main(String[] args) 
{
	JPanel p1=new JPanel();
        JFrame JFrameMain = new JFrame();
        JFrameMain.setVisible(true);
        JFrameMain.setSize(400,400);
        JFrameMain.setTitle("I am groot :D");
 
//tree 1 data (C:)
DefaultMutableTreeNode root1Node = new DefaultMutableTreeNode("C:");       
DefaultMutableTreeNode intelNode =    new DefaultMutableTreeNode("Intel");
DefaultMutableTreeNode perflogNode = new DefaultMutableTreeNode("Perflog");
DefaultMutableTreeNode programNode =    new DefaultMutableTreeNode("Program files");
DefaultMutableTreeNode userNode = new DefaultMutableTreeNode("User");
DefaultMutableTreeNode i5SubNode = new DefaultMutableTreeNode("intel temp");
DefaultMutableTreeNode perfSubNode = new DefaultMutableTreeNode("perflog temp");
DefaultMutableTreeNode progSubNode = new DefaultMutableTreeNode("Program temp");
DefaultMutableTreeNode uSubNode = new DefaultMutableTreeNode("User temp");
intelNode.add(i5SubNode);
perflogNode.add(perfSubNode);
programNode.add(progSubNode);
userNode.add(uSubNode);

root1Node.add(intelNode);
root1Node.add(perflogNode); 
root1Node.add(programNode);
root1Node.add(userNode); 


//tree 2 data (D:)
DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("D:");       
DefaultMutableTreeNode javaprgmNode =    new DefaultMutableTreeNode("Java Programs");
DefaultMutableTreeNode ajpprgmNode = new DefaultMutableTreeNode("AJP Programs");
DefaultMutableTreeNode steNode =    new DefaultMutableTreeNode("STE Test Cases");
DefaultMutableTreeNode osyNode = new DefaultMutableTreeNode("OSY");
DefaultMutableTreeNode cssNode = new DefaultMutableTreeNode("CSS Programs");
 
DefaultMutableTreeNode jSubNode = new DefaultMutableTreeNode("Java temp");
DefaultMutableTreeNode aSubNode = new DefaultMutableTreeNode("AJP temp");
DefaultMutableTreeNode sSubNode = new DefaultMutableTreeNode("STE temp");
DefaultMutableTreeNode oSubNode = new DefaultMutableTreeNode("OSY temp");
DefaultMutableTreeNode cSubNode = new DefaultMutableTreeNode("CSS temp");
javaprgmNode.add(jSubNode);
ajpprgmNode.add(aSubNode);
steNode.add(sSubNode);
osyNode.add(oSubNode);
cssNode.add(cSubNode);

rootNode.add(javaprgmNode);
rootNode.add(ajpprgmNode); 
rootNode.add(steNode);
rootNode.add(osyNode);
rootNode.add(cssNode);


//displaying part... :/
JTree tree1=new JTree(root1Node);
JTree tree = new JTree(rootNode); 
p1.setBounds(-2,170,133,210);
p1.add(tree);
JFrameMain.add(p1);

JFrameMain.add(tree1);

    }
}
