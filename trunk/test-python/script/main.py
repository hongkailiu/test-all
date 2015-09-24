#!/usr/bin/python

import sys; x = 'foo'; sys.stdout.write(x + '\n')

print "Hello, Python!"

if True:
    print "Answer"
    print "True"
else:
    print "False"
# print "False"

word = 'word'
sentence = "This is a sentence."
paragraph = """This is a paragraph. It is
made up of multiple lines and sentences."""

total = 1 + \
        2 + \
        3

print total

days = ['Monday', 'Tuesday', 'Wednesday',
        'Thursday', 'Friday']

print days


counter = 100          # An integer assignment
miles = 1000.0       # A floating point
name = "John"       # A string

print counter
print miles
print name

a = b = c = 1
print a
print b
print c

a, b, c = 1, 2, "john"
print a
print b
print c

var1 = 1
var2 = 10
print var1
print var2

del var1, var2

print "a"
# not defined error if not commented out
# print var1
# print var2
print "b"


