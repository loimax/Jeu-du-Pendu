# 31.3.1 Greatest root
import math

a = 1
b = 8
c = 3

def greatest_root(a, b, c):

    delta = b**2- (4*a*c)
    assert delta > 0

    sqrtDelta = math.sqrt(delta)

    r1 = (-b - sqrtDelta) / (2 * a)
    r2 = (-b + sqrtDelta) / (2 * a)

    x = max(r2,r1)
    
    if (a*(x**2) + b*x + c == 0):
        return x
    else:
        return None

# print(greatest_root(a,b,c))

# 31.3.2 Real roots

def roots(a,b,c):

    # for (a,b,c) in range (-5,5):
        delta = b**2- (4*a*c)
        assert delta > 0

        sqrtDelta = math.sqrt(delta)

        r1 = (-b - sqrtDelta) / (2 * a)
        r2 = (-b + sqrtDelta) / (2 * a)
    
        return r1,r2
print(roots(a,b,c))
# assert roots(a,b,c) == greatest_root(a,b,c)