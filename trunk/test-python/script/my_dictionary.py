#!/usr/bin/python

# Python's dictionaries are kind of hash table type.
# my_dict = {}
# http://stackoverflow.com/questions/8406242/why-does-pycharms-inspector-complain-about-d
my_dict = dict()
my_dict['one'] = "This is one"
my_dict[2] = "This is two"

tiny_dict = {'name': 'john', 'code': 6734, 'dept': 'sales'}


print my_dict['one']       # Prints value for 'one' key
print my_dict[2]           # Prints value for 2 key
print tiny_dict          # Prints complete dictionary
print tiny_dict.keys()   # Prints all the keys
print tiny_dict.values()  # Prints all the values

my_dict = {'Name': 'Zara', 'Age': 7, 'Class': 'First'};

print "my_dict['Name']: ", my_dict['Name']
print "my_dict['Age']: ", my_dict['Age']

# traverse a dictionary
for key in my_dict.keys():
    print my_dict.get(key)

