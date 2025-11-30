def inv_triangle(n, space):
    s = space
    for i in range(1, space + 1):
        print(" " * i, end="")

        print("*" * ((s * 2) - 1), end="")

        print(" " * (n + (i * 2)), end="")

        print("*" * ((s * 2) - 1))

        s -= 1


def main():
    n = int(input("Enter an odd number greater than 1: "))

    if n <= 1 or n % 2 == 0:
        print("Please enter an odd number greater than 1.")
        return

    space = ((n + 1) // 2) - 1
    s = space
    for i in range(space + 1):
        print(" " * (n + s), end="")
        print("*" * (i * 2 + 1))
        s -= 1


    for i in range(1, n - 1):
        print(" " * n, end="")
        print("@", end="")
        print(" " * (n - 2), end="")
        print("@")

    print("*" * n, end="")
    print("@", end="")
    print(" " * (n - 2), end="")
    print("@", end="")
    print("*" * n)

    inv_triangle(n, space)

main()
