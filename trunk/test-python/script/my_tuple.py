#!/usr/bin/python


###
# Tuples can be thought of as read-only lists.
# A tuple is a sequence of immutable Python objects.
###

my_tuple = ( 'word', 786, 2.23, 'john', 70.2)
tiny_tuple = (123, 'john')

print my_tuple           # Prints complete list
print my_tuple[0]        # Prints first element of the list
print my_tuple[1:3]      # Prints elements starting from 2nd till 3rd
print my_tuple[2:]       # Prints elements starting from 3rd element
print tiny_tuple * 2   # Prints list two times
print my_tuple + tiny_tuple  # Prints concatenated lists
