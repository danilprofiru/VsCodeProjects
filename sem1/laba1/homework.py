a = float(input("Введите коэффициент a: "))
b = float(input("Введите коэффициент b: "))
c = float(input("Введите коэффициент c: "))

def f(a, b, c):
    if a == 0:
        x = -(c) / b
        print('Уравнение имеет один корень: x = {}'.format(x))
    else:
        if c == 0:
            disc = (b ** 2) - (4 * a)
        else:
            disc = (b ** 2) - (4 * a * c)
        if disc > 0:
            x1 = (-b + disc ** 0.5) / (2 * a)
            x2 = (-b - disc ** 0.5) / (2 * a)
            print('Корни уравнения: x1 = {}, x2 = {}'.format(x1,x2))
        elif disc == 0:
            x = -b / (2 * a)
            print('Уравнение имеет один корень: x = {}'.format(x))
        else:
            print('Уравнение не имеет действительных корней')

f(a, b, c)