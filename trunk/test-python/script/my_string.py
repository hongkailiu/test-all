#!/usr/bin/python
# -*- coding: utf-8 -*-
print "nihao"


my_str = 'Hello World!'

print my_str           # Prints complete string
print my_str[0]        # Prints first character of the string
print my_str[2:5]      # Prints characters starting from 3rd to 5th
print my_str[2:]       # Prints string starting from 3rd character
print my_str * 2       # Prints string two times
print my_str + "TEST"  # Prints concatenated string


var_1 = 'Hello World!'

print "Updated String :- ", var_1[:6] + 'Python'

print var_1[11]

var_2 = var_1[:11] + '~'

print var_2

print "My name is %s and weight is %d kg!" % ('Zara', 21)


para_str = """this is a long string that is made up of
several lines and non-printable characters such as
TAB ( \t ) and they will show up that way when displayed.
NEWLINEs within the string, whether explicitly given like
this within the brackets [ \n ], or just a NEWLINE within
the variable assignment will also show up.
"""
print para_str

print 'C:\\nowhere'
print r'C:\\nowhere'

# https://www.python.org/dev/peps/pep-0263/
# http://stackoverflow.com/questions/2688020/how-to-print-chinese-word-in-my-code-using-python
print u'Hello, world!'
print u'哈哈'
# same as .encode('utf-8')
print u'哈哈'.encode('utf-8')
