package com.hongkailiu.test.app.tree;

import java.util.List;

import com.hongkailiu.test.app.helper.CollectionHelper;
import com.hongkailiu.test.app.helper.CollectionHelperImpl;

//public class BinarySearchTree<T extends Comparable<T>> {
public class BinarySearchTree<T extends Comparable<T>> extends BinaryTree<T> {
	
	private BinarySearchTree<T> left;
	private BinarySearchTree<T> right;
	
	public BinarySearchTree<T> getLeft() {
		return left;
	}

	public void setLeft(BinarySearchTree<T> left) {
		super.setLeft(left);
		this.left = left;
	}

	public BinarySearchTree<T> getRight() {
		return right;
	}

	public void setRight(BinarySearchTree<T> right) {
		super.setRight(right);
		this.right = right;
	}


	private static CollectionHelper helper = CollectionHelperImpl.getInstance();

	public BinarySearchTree(T value) {
        super(value);
    }
	
	public BinarySearchTree(T value, BinarySearchTree<T> left, BinarySearchTree<T> right) {
        super(value,left,right);
        this.left = left;
        this.right = right;
    }

	@Override
    protected void validate() {
    	super.validate();
    	List<T> list1 = depthFirstTraversalInOrder();
    	if (!helper.isOrdered(list1)) {
    		throw new IllegalArgumentException("not ordered");
    	}
    	List<T> list2 = helper.removeDuplicate(list1);
    	if (!helper.elementsEqual(list1, list2)) {
    		throw new IllegalArgumentException("duplicate elements not allowed");
    	}
	}

	@Override
	public boolean search(final T toFind) {
		if (toFind.equals(value)) {
            return true;
        }

        if (toFind.compareTo(value) < 0 && left != null) {
            return left.search(toFind);
        }

        return right != null && right.search(toFind);
    }
    
    public void insert(final T toInsert) {
    	if (value.equals(toInsert)) {
    		// do nothing since no duplicates allowed in BST
    	} else if (toInsert.compareTo(value) < 0) {
            if (left == null) {
            	setLeft(new BinarySearchTree<T>(toInsert, null, null));
            } else {
            	left.insert(toInsert);
            }
        } else {
            if (right == null) {
            	setRight(new BinarySearchTree<T>(toInsert, null, null));
            } else {
            	right.insert(toInsert);
            }
        }
    	validate();
    }
    
    /**
     * ref.
     * https://www.cs.cmu.edu/~adamchik/15-121/lectures/Trees/code/BST.java
     * http://www.algolist.net/Data_structures/Binary_search_tree/Removal
     * hongkai: more to test
     * @param toDelete
     */
    @Override
    public BinarySearchTree<T> delete(final T toDelete) {
    	BinarySearchTree<T> result = this;
    	if (toDelete.equals(value)) {
			if (left != null && right != null) {
				BinarySearchTree<T> rightMost = findRightMost(left);
				value = rightMost.value;
				setLeft(left.delete(rightMost.value));
				//return this;
			} else {
				if (left == null) {
					//return right;
					result = right;
				} else {
					//return left;
					result = left;
				}
			}

		} else if (toDelete.compareTo(value) < 0) {
			if (left == null) {
				//return this;
			} else {
				setLeft(left.delete(toDelete));
				//return this;
			}
		} else {
			if (right == null) {
				//return this;
			} else {
				setRight(right.delete(toDelete));
				//return this;
			}
		}
    	validate();
    	return result;
    }

    
    private BinarySearchTree<T> findRightMost(final BinarySearchTree<T> root) {
    	if (root==null){
    		return null;
    	}
    	BinarySearchTree<T> result = root;
    	while (result.right!=null) {
    		result = result.right;
    	}
		return result;
	}

}
