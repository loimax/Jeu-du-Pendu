def f(x) : return x**2 - 2
def di(f, a, b, d=1e-16):
    z = (a + b) / 2
    while (f(z) != 0):
        pass
    return z

res = di(f, 1, 2)
print(res)





