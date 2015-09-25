#!/usr/bin/python

# Open a file
name = "../file/foo.txt"
fo = open(name, "wb")
print "Name of the file: ", fo.name
print "Closed or not : ", fo.closed
print "Opening mode : ", fo.mode
print "Softspace flag : ", fo.softspace

fo.write("Python is a great language.\nYeah its great!!\n")

fo.close()


# Open a file
fo = open(name, "r+")
my_str = fo.read(10);
print "Read String is : ", my_str
# Close opened file
fo.close()
