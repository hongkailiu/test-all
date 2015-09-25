#!/usr/bin/python


def kelvin_to_fahrenheit(temperature):
    """test exception"""
    assert (temperature >= 0), "Colder than absolute zero!"
    return ((temperature - 273) * 1.8) + 32


print kelvin_to_fahrenheit(273)
print int(kelvin_to_fahrenheit(505.78))
# will raise an exception
# print kelvin_to_fahrenheit(-5)

try:
    print kelvin_to_fahrenheit(-5)
except AssertionError, e:
    print "AssertionError with message", e.message
else:
    print "everything is fine"


# Here is an example related to RuntimeError.
# Here, a class is created that is sub-classed from RuntimeError.
# This is useful when you need to display more specific information when an exception is caught.
class NetworkError(RuntimeError):
    def __init__(self, arg):
        self.args = arg
        self.message = "test error message"

try:
    raise NetworkError("Bad hostname")
except NetworkError, e:
    print e.args, ":", e.message


