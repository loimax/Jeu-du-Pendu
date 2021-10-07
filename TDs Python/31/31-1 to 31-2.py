
F = 10
C = 0
assert F >= -459.67
assert C >= -273,15
def fahrenheit_to_celsius(F):
    C = (F-32)*5/9
    return C

def celsius_to_fahrenheit(C):
    F = (9/5) * C + 32
    return F

def isalmost(n,m,d=1):
    abs(n-m)<=d

assert isalmost ( fahrenheit_to_celsius(-459.67) , -273.15 , 1e-13 )

# C = fahrenheit_to_celsius(F)

# print(C)
# print(F)
