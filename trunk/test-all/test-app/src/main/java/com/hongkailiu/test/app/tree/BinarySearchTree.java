package com.hongkailiu.test.app.tree;

import java.util.List;

import com.hongkailiu.test.app.helper.CollectionHelper;
import com.hongkailiu.test.app.helper.CollectionHelperImpl;


public class BinarySearchTree<T extends Comparable<T>> {
	
	private CollectionHelper helper = CollectionHelperImpl.getInstance();

	private SimpleTree<T> tree;

	public SimpleTree<T> getTree() {
		return tree;
	}

	public BinarySearchTree(SimpleTree<T> tree) {
        super();
        this.tree = tree;
        validate();
    }

    private void validate() {
    	List<T> list1 = tree.getValuesInOrder();
    	if (!helper.isOrdered(list1)) {
    		throw new IllegalArgumentException("not ordered");
    	}
    	List<T> list2 = helper.removeDuplicate(list1);
    	if (!helper.elementsEqual(list1, list2)) {
    		throw new IllegalArgumentException("duplicate elements not allowed");
    	}
	}

	public boolean search(final T toFind) {
        return search(tree, toFind);
    }
    
    private boolean search(final SimpleTree<T> tree, final T toFind) {
    	if (tree==null) {
    		return false;
    	}
        if (toFind.equals(tree.value)) {
            return true;
        }

        if (toFind.compareTo(tree.value) < 0 && tree.left != null) {
            return search(tree.left, toFind);
        }

        return tree.right != null && search(tree.right, toFind);
    }
    
    public void insert(final T toInsert) {
    	this.tree = insert(this.tree, toInsert);
    	validate();
    }

    private SimpleTree<T> insert(final SimpleTree<T> tree, final T toInsert) {
    	if (tree==null) {
    		return new SimpleTree<T>(toInsert, null,null);
    	} else if (toInsert.compareTo(tree.value) < 0) {
            if (tree.left == null) {
            	tree.left = new SimpleTree<T>(toInsert, null, null);
            } else {
            	insert(tree.left,toInsert);
            }
            return tree;
        } else {
            if (tree.right == null) {
            	tree.right = new SimpleTree<T>(toInsert, null, null);
            } else {
            	insert(tree.right,toInsert);
            }
            return tree;
        }
    }
    
    public void delete(final T toDelete) {
    	this.tree = delete(tree, toDelete);
    	validate();
    }
    
    /**
     * ref.
     * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
     * http://www.algolist.net/Data_structures/Binary_search_tree/Removal
     * hongkai: more to test
     * @param toDelete
     */
	private SimpleTree<T> delete(final SimpleTree<T> tree, final T toDelete) {
		if (tree==null) {
    		return null;
    	} else if (toDelete.compareTo(tree.value) == 0) {
			if (tree.left != null && tree.right != null) {
				SimpleTree<T> rightMost = findRightMost(tree.left);
				tree.value = rightMost.value;
				tree.left = delete(tree.left, rightMost.value);
				return tree;
			} else {
				if (tree.left == null) {
					return tree.right;
				} else {
					return tree.left;
				}
			}

		} else if (toDelete.compareTo(tree.value) < 0) {
			if (tree.left == null) {
				return tree;
			} else {
				tree.left  = delete(tree.left, toDelete);
				return tree;
			}
		} else {
			if (tree.right == null) {
				return tree;
			} else {
				tree.right = delete(tree.right, toDelete);
				return tree;
			}
		}
	}
    
    private SimpleTree<T> findRightMost(final SimpleTree<T> root) {
    	if (root==null){
    		return null;
    	}
    	SimpleTree<T> result = root;
    	while (result.right!=null) {
    		result = result.right;
    	}
		return result;
	}

}
