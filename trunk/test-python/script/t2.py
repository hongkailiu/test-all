#!/usr/bin/python


def get_province_name(address):
    words = address.split(',')
    l = len(words)
    if l < 3:
        return "unknown"
    else:
        return words[l-3].strip()


def get_province_names(addresses):
    return map(get_province_name, addresses)

a = "333 Abc Street, QC, H4R 2X6, Canada"
b = "Apt 206-26 Bcd Street, NY, 12345, USA"

print a + ": " + get_province_name(a)
print b + ": " + get_province_name(b)

print "a, b: " + ", ".join(get_province_names([a, b]))




