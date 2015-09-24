#!/usr/bin/python


def print_me(my_str):
    """This prints a passed string into this function"""
    print my_str
    return


print_me("asf")


# Function definition is here
def print_info(arg1, *var_tuple):
    """This prints a variable passed arguments"""
    print "Output is: "
    print arg1
    for var in var_tuple:
        print var
    return

# Now you can call print_info function
print_info(10)
print_info(70, 60, 50)

# Function definition is here
# not a good practice according to pep8
# http://docs.quantifiedcode.com/python-code-patterns/correctness/assigning_a_lambda_to_a_variable.html
my_sum = lambda arg1, arg2: arg1 + arg2


# Now you can call sum as a function
print "Value of total : ", my_sum(10, 20)
print "Value of total : ", my_sum(20, 20)

