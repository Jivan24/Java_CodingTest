# Problem 1

Find the maximum number of items that can be ordered in the given amount. Solution for the same is defined in class `PlaceOrder.java` file.


# Problem 2

You are required to write a class that implements a namespace structure. e.g

                       /
                   /   |   \
                  a    b    f
                 / \   |
                c   d  e
Each node has a value and possibly children. The class has the following API which you need to implement:

### create(path, value): 
`createPath in FolderStructure.java file`

where path is something like /a/c and value is the value to be stored in the node. All the nodes leading up to the last one should already exist, and the last one must not exist, else create should raise an error. In the above example, that means create(/a/c/g, “foo”) should work, but create(/f/g/h, “bar”) should raise an error.

### set_value(path, value):
`setPath in FolderStructure.java file`

This api sets the value of a node. If path doesn’t address a valid node in the namespace, set_value should throw an error.

