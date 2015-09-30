__author__ = 'ehongka'


class Employee:
    """Common base class for all employees"""
    emp_count = 0

    def __init__(self, name, salary):
        self.name = name
        self.salary = salary
        Employee.emp_count += 1

    @staticmethod
    def display_count():
        print "Total Employee %d" % Employee.emp_count

    def display_employee(self):
        print "Name : ", self.name,  ", Salary: ", self.salary

    @staticmethod
    def get_count():
        return Employee.emp_count

