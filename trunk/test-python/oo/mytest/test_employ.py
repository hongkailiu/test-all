__author__ = 'ehongka'

import unittest
from employee import Employee


class TestUM(unittest.TestCase):

    def setUp(self):
        pass

    def test_trivial(self):
        self.assertEqual(3, 3)


if __name__ == '__main__':
    unittest.main()

