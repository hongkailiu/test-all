#!/usr/bin/python

my_list = ['word', 786, 2.23, 'john', 70.2]
tiny_list = [123, 'john']

print my_list          # Prints complete list
print my_list[0]       # Prints first element of the list
print my_list[1:3]     # Prints elements starting from 2nd till 3rd
print my_list[2:]      # Prints elements starting from 3rd element
print tiny_list * 2  # Prints list two times
print my_list + tiny_list  # Prints concatenated lists

list_1 = ['physics', 'chemistry', 1997, 2000];
list_2 = [1, 2, 3, 4, 5, 6, 7];

print "list1[0]: ", list_1[0]
print "list2[1:5]: ", list_2[1:5]

# Updating Lists
my_list_1 = ['physics', 'chemistry', 1997, 2000];

print "Value available at index 2 : "
print my_list_1[2]
my_list_1[2] = 2001
print "New value available at index 2 : "
print my_list_1[2]

list_1 = ['physics', 'chemistry', 1997, 2000];

# Delete List Elements
print list_1
del list_1[2];
print "After deleting value at index 2 : "
print list_1

# traverse a list
for x in [1, 2, 3]:
    print x

