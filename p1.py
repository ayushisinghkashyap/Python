import numpy as np
def compute_shape(data):
    arr = np.array(data)
    print("Array:")
    print(arr)
    print("Shape:", arr.shape)
    print("-" * 40)

matrix = [
    [1, 2, 3],
    [4, 5, 6]
]
compute_shape(matrix)
tensor = [
    [
        [1, 2],
        [3, 4]
    ],
    [
        [5, 6],
        [7, 8]
    ]
]
compute_shape(tensor)
