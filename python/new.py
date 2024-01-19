import numpy as np
import pandas as pd


# arr1=np.array([[1,2,3],[3,2,1],[2,2,2]])
# arr2=np.array([[1,2,3],[3,2,1], [2,2,2]])
# pr=np.dot(arr1,arr2)


# matrix_a = np.array([[1, 2], [3, 4]])
# matrix_b = np.array([[1, 2], [3, 4]])
# product_matrix = np.dot(matrix_a, matrix_b)


data= pd.read_csv('./pokemon_data.csv')


# a=[1,7,2]
# var=pd.Series(a)

g={
    'first score': [100, 90, np.nan, 95],
    'second score': [30, 45, 56, np.nan],
    'third score': [np.nan, 40, 80, 98]

}

df=pd.DataFrame(g)

# print(data.head())

# print(data.tail())

# print(data.sample())

# print(data.info(4))

# print(data.columns)

# print(data.describe())

# print(data.nunique())

print(df.shape())




