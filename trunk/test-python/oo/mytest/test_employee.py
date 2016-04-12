import unittest
from employee import Employee

__author__ = 'ehongka'


class TestEmployeeMethods(unittest.TestCase):

    unit_under_test = None

    def setUp(self):
        print "setUp***"
        TestUM.unit_under_test = Employee("tom", 1000)

    def test_trivial(self):
        self.assertEqual(3, 3)

    def test_get_count(self):
        self.assertEqual(Employee.get_count(), 1)


if __name__ == '__main__':
    unittest.main()

