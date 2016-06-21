/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.library;

import java.io.File;
import java.io.FileFilter;
import javax.swing.tree.*;

/**
 *
 * @author srihari
 */
public class NewTreeBuilder {

    public DefaultMutableTreeNode buildTree(DefaultMutableTreeNode root, String path) {
        DefaultMutableTreeNode child = null;
        File pwd = new File(path);
        if (root == null) {
            root = new DefaultMutableTreeNode(pwd.getName());
        }
        File[] f = pwd.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                //System.out.println(file.getPath());
                return file.isDirectory();
            }
        });
        for (File file : f) {
            root.add(buildTree(null, file.getPath()));
        }
        return root;
    }
}
