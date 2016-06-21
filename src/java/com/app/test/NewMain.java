/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.app.test;

import com.library.NewTreeBuilder;
import com.library.Node;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.Vector;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 *
 * @author srihari
 */
public class NewMain {

    public static DefaultMutableTreeNode root, left, right;
    public static Vector<DefaultMutableTreeNode> leaves;
    public static HashMap<DefaultMutableTreeNode, Integer> hMap = new HashMap();
    public static HashMap<String, String> imgPath = new HashMap();
    public static int counter = 0;
    public static String contextPath = "";

    static {
        imgPath.put("Shoes","images\\Shoes");
        
        imgPath.put("Casual","images\\Shoes\\Casual");
        imgPath.put("Boots","images\\Shoes\\Casual\\Boots");
        imgPath.put("Canvas","images\\Shoes\\Casual\\Canvas");
        imgPath.put("Corporate Casuals","images\\Shoes\\Casual\\Corporate Casuals");
        imgPath.put("Dancing","images\\Shoes\\Casual\\Dancing");
        imgPath.put("Loafers","images\\Shoes\\Casual\\Loafers");
        imgPath.put("Party","images\\Shoes\\Casual\\Party");
        imgPath.put("Sneakers","images\\Shoes\\Casual\\Sneakers");
        
        
        imgPath.put("Sports","images\\Shoes\\Casual\\Sports");
        imgPath.put("Badminton","images\\Shoes\\Casual\\Sports\\Badminton");
        imgPath.put("Bowling","images\\Shoes\\Casual\\Sports\\Bowling");
        imgPath.put("Cricket","images\\Shoes\\Casual\\Sports\\Cricket");
        imgPath.put("Football","images\\Shoes\\Casual\\Sports\\Football");
        imgPath.put("Running","images\\Shoes\\Casual\\Sports\\Running");
        imgPath.put("Training and Gym","images\\Shoes\\Casual\\Sports\\Training and Gym");
        imgPath.put("Basketball","images\\Shoes\\Casual\\Sports\\Basketball");
        
        imgPath.put("Formal","images\\Shoes\\Formal");
        imgPath.put("Lace Up","images\\Shoes\\Formal\\Lace Up");
        imgPath.put("Monk Strap","images\\Shoes\\Formal\\Monk Strap");
        imgPath.put("Slip On","images\\Shoes\\Formal\\Slip On");
        
        
    }
    
    public static void init(String args) {
        contextPath = args;
        
//        System.out.println(System.getProperty("user.dir"));
        System.out.println(args);
//        root = new NewTreeBuilder().buildTree(null, "/web/images/Shoes");
        root = new NewTreeBuilder().buildTree(null, args+"/images/Shoes");
        Enumeration e = root.depthFirstEnumeration();
        leaves = new Vector();

        while (e.hasMoreElements()) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
            if (node.isLeaf()) {
                leaves.add(node);
            }
        }
        
//        testInputs();
    }

    public static void randomize() {
        left = (DefaultMutableTreeNode) leaves.get(new Random().nextInt(leaves.size()));
        right = left;

        while (right == left || right.getParent() == left.getParent()) {
            right = (DefaultMutableTreeNode) leaves.get(new Random().nextInt(leaves.size()));
        }

        System.out.println("Left: " + left + "\tRight: " + right);

        hMap.put(left, hMap.get(left) == null ? 1 : hMap.get(left) + 1);
        hMap.put(right, hMap.get(right) == null ? 1 : hMap.get(right) + 1);

//        System.out.println(hMap.toString());
    }

    public static void randomize(DefaultMutableTreeNode node) {
//        System.out.println("Node: " + node + "\tLeft:" + left + "\tRight: " + right + "\t" + (node == left) + "\t" + (node == right));

        if (node == left) {
            left = (DefaultMutableTreeNode) leaves.get(new Random().nextInt(leaves.size()));
        } else if (node == right) {
            right = (DefaultMutableTreeNode) leaves.get(new Random().nextInt(leaves.size()));
        }
//        while (right == left || right.getParent() == left.getParent()) {
//            randomize(node);
//        }

        System.out.println("Left: " + left + "\tRight: " + right);

        hMap.put(left, hMap.get(left) == null ? 1 : hMap.get(left) + 1);
        hMap.put(right, hMap.get(right) == null ? 1 : hMap.get(right) + 1);

//        System.out.println(hMap.toString());
    }

    public static void testInputs() {

//        for(DefaultMutableTreeNode n:leaves){
//            System.out.print(n+"\t");
//        }
//        System.out.println();
        DefaultMutableTreeNode input = null;
        randomize();
        Scanner in = new Scanner(System.in);
        int k = 9;
        for (int i = 0; i < 4; i++) {
            k = in.nextInt();
//            System.out.println("k: "+k+"\t"+"Left: " + left + "\tRight: " + right);
            if (k == 0) {
                randomize(right);
            } else if (k == 1) {
                randomize(left);
            }
        }
        System.out.println(hMap.toString());
    }

    public static String getPath(DefaultMutableTreeNode node)
    {
        return imgPath.get(node.toString())+"\\"+(new Random().nextInt(9)+1)+".jpeg";
    }
    
}
