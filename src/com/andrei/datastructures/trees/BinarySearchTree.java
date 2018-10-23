package com.andrei.datastructures.trees;

import com.sun.istack.internal.NotNull;

/**
 * Binary search tree Data Structure implementation
 *
 * @param <E> type of nodes
 */
public class BinarySearchTree<E extends Comparable<E>> {
    private BSTNode<E> root;
    private int size;

    /**
     * Insert value into a BST
     *
     * @param value value to be inserted
     */
    public void insert(@NotNull E value) {
        root = insertRecursive(root, value);
    }

    private BSTNode<E> insertRecursive(BSTNode<E> root, @NotNull E value) {
        if (value == null) {
            throw new IllegalArgumentException("Value is null");
        }

        if (root == null) {
            root = new BSTNode<>(value);
            size++;
            return root;
        }

        int compareResult = value.compareTo(root.getData());

        if (compareResult < 0) {
            root.setLeft(insertRecursive(root.getLeft(), value));
        } else {
            root.setRight(insertRecursive(root.getRight(), value));
        }

        return root;
    }

    /**
     * Get the count of items
     *
     * @return items count
     */
    public int count() {
        return size;
    }

    /**
     * Print tree in inorder
     */
    private void printInOrder() {
        //ldr
        if (root == null) {
            return;
        }
        printValues(root.getLeft());
        System.out.println(root.getData().toString());
        printValues(root.getRight());
    }

    /**
     * Print tree in post order
     */
    private void printPostOrder() {
        //lrd
        printValues(root.getLeft());
        printValues(root.getRight());
        System.out.println(root.getData().toString());
    }

    /**
     * Print in pre order
     */
    private void printPreOrder() {
        //dlr
        System.out.println(root.getData().toString());
        printValues(root.getLeft());
        printValues(root.getRight());
    }

    private void printValues(BSTNode<E> root) {
        if (root == null) {
            return;
        }
        printValues(root.getLeft());
        System.out.println(root.getData().toString());
        printValues(root.getRight());
    }

    /**
     * Delete tree
     */
    public void delete() {
        this.size = 0;
        this.root = null;
    }

    /**
     * Check if the tree contains the element
     *
     * @param value element to be checked
     * @return true if the element exists in the tree, false otherwise
     */
    public boolean contains(E value) {
        return contains(root, value);
    }

    private boolean contains(BSTNode<E> root, E value) {
        if (root == null) {
            return false;
        }

        int compare = value.compareTo(root.getData());
        if (compare < 0) {
            return contains(root.getLeft(), value);
        } else if (compare > 0) {
            return contains(root.getRight(), value);
        } else {
            return true;
        }
    }

    /**
     * Get the height of the tree
     *
     * @return the height of the tree
     */
    public int getHeight() {
        return findHeight(root);
    }

    private int findHeight(BSTNode<E> root) {
        if (root == null) {
            return -1;
        }

        return Math.max(findHeight(root.getLeft()), findHeight(root.getRight())) + 1;
    }

    /**
     * Get the minimum value of the tree
     *
     * @return min value in the tree
     */
    public E min() {
        BSTNode<E> minNode = min(root);
        return min(root) != null ? minNode.getData() : null;
    }

    private BSTNode<E> min(BSTNode<E> root) {
        if (root == null) {
            return null;
        }

        if (root.getLeft() == null) {
            return root;
        }

        return min(root.getLeft());
    }

    /**
     * Get the max value in the tree
     *
     * @return the max value in the tree
     */
    public E max() {
        return max(root);
    }

    private E max(BSTNode<E> root) {
        if (root == null) {
            return null;
        }

        if (root.getRight() == null) {
            return root.getData();
        }

        return max(root.getRight());
    }

    /**
     * Check if the tree is binary tree
     *
     * @return true if the tree is binary tree, false otherwise
     */
    public boolean isBinarySearchTree() {
        return isBinarySearchTree(root);
    }

    private boolean isSubtreeLesser(BSTNode<E> root, E value) {
        if (root == null) return true;

        int compare = root.getData().compareTo(value);
        return compare < 0 && isSubtreeLesser(root.getLeft(), value) && isSubtreeLesser(root.getRight(), value);
    }

    private boolean isSubtreeGreater(BSTNode<E> root, E value) {
        if (root == null) return true;

        int compare = root.getData().compareTo(value);
        return compare >= 0 && isSubtreeGreater(root.getLeft(), value) && isSubtreeGreater(root.getRight(), value);
    }

    private boolean isBinarySearchTree(BSTNode<E> root) {
        if (root == null) return true;

        return isSubtreeLesser(root.getLeft(), root.getData()) && isSubtreeGreater(root.getRight(), root.getData()) &&
                isBinarySearchTree(root.getLeft()) && isBinarySearchTree(root.getRight());
    }

    /**
     * Delete the value from the tree if exists
     *
     * @param value the value to be deleted
     */
    public void deleteValue(E value) {
        root = delete(root, value);
    }

    private BSTNode<E> delete(BSTNode<E> root, E value) {
        if (root == null) return null;
        int compare = value.compareTo(root.getData());
        if (compare < 0) {
            root.setLeft(delete(root.getLeft(), value));
        } else if (compare > 0) {
            root.setRight(delete(root.getRight(), value));
        } else {
            //Case 1 leaf node/ no child
            if (root.getLeft() == null && root.getRight() == null) {
                root = null;
                size--;
            }
            // Case 2: One child
            else if (root.getLeft() == null) {
                root = root.getRight();
                size--;
            } else if (root.getRight() == null) {
                root = root.getLeft();
                size--;
            }
            // Case 3: 2 children
            else {
                BSTNode<E> temNode = min(root.getRight());
                root.setData(temNode.getData());
                root.setRight(delete(root.getRight(), temNode.getData()));
            }
            System.out.println(root);
        }

        return root;
    }

    /**
     * Get the successor value from the tree of the given value
     *
     * @param value successor of the value that should be found
     * @return null if not exists, the successor otherwise
     */
    public E getSuccessor(E value) {
        BSTNode<E> current = find(root, value);
        if (current == null) return null;

        // Case 1: Node has right subtree
        if (current.getRight() != null) {
            return min(current.getRight()).getData();
        }
        // Case 2: No right subtree
        else {
            BSTNode<E> successor = null;
            BSTNode<E> ancestor = root;

            while (ancestor != current) {
                int compare = current.getData().compareTo(ancestor.getData());
                if (compare < 0) {
                    successor = ancestor;
                    ancestor = ancestor.getLeft();
                } else {
                    ancestor = ancestor.getRight();
                }
            }
            return successor != null ? successor.getData() : null;
        }
    }

    private BSTNode<E> find(BSTNode<E> root, E value) {
        if (root == null) {
            return null;
        }

        int compare = value.compareTo(root.getData());
        if (compare < 0) {
            return find(root.getLeft(), value);
        } else if (compare > 0) {
            return find(root.getRight(), value);
        } else {
            return root;
        }
    }
}
