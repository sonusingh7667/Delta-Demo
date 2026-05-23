Q1.	Write a program in python to find weight matrix for hetero-associative memory network for input vectors and corresponding output vectors.
import numpy as np

# Input vectors
X1 = np.array([1, -1, 1])
X2 = np.array([-1, 1, -1])

# Corresponding output vectors
Y1 = np.array([1, 1])
Y2 = np.array([-1, -1])

# Weight matrix calculation
W = np.outer(Y1, X1) + np.outer(Y2, X2)

print("Weight Matrix:")
print(W)



Q2. Write a program in python to find weight matrix for auto-associative memory to store the patterns .Also verify that weight matrix is correct or not.        

import numpy as np

# Patterns to be stored
X1 = np.array([1, 1, -1])
X2 = np.array([1, -1, 1])
X3 = np.array([-1, 1, 1])

patterns = [X1, X2, X3]

# Weight matrix calculation
W = np.zeros((3, 3))

for p in patterns:
    W += np.outer(p, p)

# Remove self-connections
np.fill_diagonal(W, 0)

print("Weight Matrix:")
print(W)

# Verification
for i, p in enumerate(patterns):
    y = np.dot(W, p)
    y = np.where(y >= 0, 1, -1)
    print(f"\nInput Pattern X{i+1}: {p}")
    print("Retrieved Pattern:", y)

    if np.array_equal(p, y):
        print("Pattern Verified")
    else:
        print("Pattern Not Verified")




Q3. Write a program in python to convert a crisp set S into fuzzy sets using triangular function, trapezoidal function and gaussian function and also plot the corresponding graphs of fuzzy sets. 

import numpy as np
import matplotlib.pyplot as plt

# Crisp set
x = np.arange(0, 11, 1)

# Triangular Membership Function
def triangular(x, a, b, c):
    return np.maximum(np.minimum((x-a)/(b-a), (c-x)/(c-b)), 0)

# Trapezoidal Membership Function
def trapezoidal(x, a, b, c, d):
    return np.maximum(np.minimum(np.minimum((x-a)/(b-a), 1),
                                 (d-x)/(d-c)), 0)

# Gaussian Membership Function
def gaussian(x, mean, sigma):
    return np.exp(-((x-mean)**2)/(2*sigma**2))

# Membership values
tri = triangular(x, 2, 5, 8)
trap = trapezoidal(x, 1, 3, 7, 9)
gauss = gaussian(x, 5, 1.5)

# Display membership values
print("Triangular Fuzzy Set:")
print(tri)

print("\nTrapezoidal Fuzzy Set:")
print(trap)

print("\nGaussian Fuzzy Set:")
print(gauss)

# Plot graphs
plt.figure(figsize=(8,5))
plt.plot(x, tri, label='Triangular')
plt.plot(x, trap, label='Trapezoidal')
plt.plot(x, gauss, label='Gaussian')

plt.title("Fuzzy Membership Functions")
plt.xlabel("x")
plt.ylabel("Membership Value")
plt.legend()
plt.grid(True)
plt.show()




Q4. Write a program in python to implement a neural network which take inputs of 9 inputs and give 1 output. Train it with these two input vectors [1,4,6,2,11, 4, 14, 15, 17],[2,4,6,8,10, 12, 14, 16, 18] and output for these two inputs are [0,1]. Predict output for these three input vectors by using the same trained model. [2,4,5,6,7,8,10,14, 12], [2,3,4,5,12,6,8,9,2], [2,4,6,8,10,12, 14, 16, 18]




import numpy as np
from sklearn.neural_network import MLPClassifier

# Training data
X_train = np.array([
    [1,4,6,2,11,4,14,15,17],
    [2,4,6,8,10,12,14,16,18]
])

y_train = np.array([0,1])

# Create and train neural network
model = MLPClassifier(hidden_layer_sizes=(5,),
                      max_iter=1000,
                      random_state=1)

model.fit(X_train, y_train)

# Test data
X_test = np.array([
    [2,4,5,6,7,8,10,14,12],
    [2,3,4,5,12,6,8,9,2],
    [2,4,6,8,10,12,14,16,18]
])

# Predict outputs
predictions = model.predict(X_test)

print("Predicted Outputs:")
for i, p in enumerate(predictions, start=1):
    print(f"Input Vector {i}: {p}")



Q5. WAP in python to convert crisp set in fuzzy sets and plot graph also using membership functions:
1. Triangular MF 
2. Trapezium MF 
3. Gaussian MF 



import numpy as np
import matplotlib.pyplot as plt

# Crisp Set
x = np.linspace(0, 10, 100)

# Triangular Membership Function
def triangular(x, a, b, c):
    return np.maximum(np.minimum((x-a)/(b-a),
                                 (c-x)/(c-b)), 0)

# Trapezium (Trapezoidal) Membership Function
def trapezium(x, a, b, c, d):
    return np.maximum(np.minimum(np.minimum((x-a)/(b-a), 1),
                                 (d-x)/(d-c)), 0)

# Gaussian Membership Function
def gaussian(x, mean, sigma):
    return np.exp(-((x-mean)**2)/(2*sigma**2))

# Fuzzy Sets
tri = triangular(x, 2, 5, 8)
trap = trapezium(x, 1, 3, 7, 9)
gauss = gaussian(x, 5, 1.5)

# Plot Graphs
plt.figure(figsize=(8,5))

plt.plot(x, tri, label='Triangular MF')
plt.plot(x, trap, label='Trapezium MF')
plt.plot(x, gauss, label='Gaussian MF')

plt.title("Membership Functions")
plt.xlabel("Crisp Set Elements")
plt.ylabel("Membership Value")
plt.legend()
plt.grid(True)

plt.show()





Q6. Draw the line graph of fuzzy sets A and B
1.	(A⋃B)c 
2.	Ac U Bc
3.	(A INTERSECTION B)c
4.	Ac  INTERSECTION Bc



import numpy as np
import matplotlib.pyplot as plt

# Universe of discourse
x = np.arange(0, 6)

# Fuzzy Sets A and B
A = np.array([0.1, 0.3, 0.5, 0.7, 0.9, 1.0])
B = np.array([0.2, 0.4, 0.6, 0.8, 1.0, 0.5])

# Complements
Ac = 1 - A
Bc = 1 - B

# 1. (A U B)c
union = np.maximum(A, B)
comp_union = 1 - union

# 2. Ac U Bc
Ac_union_Bc = np.maximum(Ac, Bc)

# 3. (A ∩ B)c
intersection = np.minimum(A, B)
comp_intersection = 1 - intersection

# 4. Ac ∩ Bc
Ac_intersection_Bc = np.minimum(Ac, Bc)

# Plot Graphs
plt.figure(figsize=(10,6))

plt.plot(x, comp_union, marker='o', label='(A U B)c')
plt.plot(x, Ac_union_Bc, marker='s', label='Ac U Bc')
plt.plot(x, comp_intersection, marker='^', label='(A ∩ B)c')
plt.plot(x, Ac_intersection_Bc, marker='d', label='Ac ∩ Bc')

plt.title("Fuzzy Set Operations")
plt.xlabel("x")
plt.ylabel("Membership Value")
plt.legend()
plt.grid(True)

plt.show()




Q7. Let X = {0, 1,2,3,4,5,6,…………………………………., 19}  and Y = {0, 1,2,3,4,…………, 14}.
       Convert these sets into fuzzy sets : P1 using triangular membership function with a = 5 , b = 10, c =18 from set X ; Q1 using triangular membership function with a = 3 , b = 9, c =16 from set Y; P2 using triangular membership function with a = 4 , b = 10, c =17 from set X.
Let the rule is : if P1  then  Q1. 
Now with General Modus Ponen rule for fuzzy logic for given values of P1, Q1  and P2 , find the value of Q2


import numpy as np

# Universe sets
X = np.arange(0, 20)
Y = np.arange(0, 15)

# Triangular Membership Function
def triangular(x, a, b, c):
    mu = np.zeros(len(x))
    for i in range(len(x)):
        if a <= x[i] <= b:
            mu[i] = (x[i] - a) / (b - a)
        elif b < x[i] <= c:
            mu[i] = (c - x[i]) / (c - b)
    return mu

# Fuzzy Sets
P1 = triangular(X, 5, 10, 18)
Q1 = triangular(Y, 3, 9, 16)
P2 = triangular(X, 4, 10, 17)

print("P1 =", P1)
print("Q1 =", Q1)
print("P2 =", P2)

# Fuzzy Relation R = P1 -> Q1 (Mamdani Min Implication)
R = np.zeros((len(X), len(Y)))

for i in range(len(X)):
    for j in range(len(Y)):
        R[i, j] = min(P1[i], Q1[j])

# General Modus Ponens
Q2 = np.zeros(len(Y))

for j in range(len(Y)):
    temp = []
    for i in range(len(X)):
        temp.append(min(P2[i], R[i, j]))
    Q2[j] = max(temp)

print("\nQ2 =")
print(Q2)





Q8. . Write a program in python to implement defuzzification of a fuzzy set using centroid, bisector, mean of maximum, smallest of maximum and largest of maximum methods. First create a fuzzy set using triangular membership function.


import numpy as np
import matplotlib.pyplot as plt

# Universe of discourse
x = np.arange(0, 11, 1)

# Triangular Membership Function
def triangular(x, a, b, c):
    return np.maximum(np.minimum((x-a)/(b-a),
                                 (c-x)/(c-b)), 0)

# Create fuzzy set
mu = triangular(x, 2, 5, 8)

# Plot fuzzy set
plt.plot(x, mu, marker='o')
plt.title("Triangular Fuzzy Set")
plt.xlabel("x")
plt.ylabel("Membership Value")
plt.grid(True)
plt.show()

# 1. Centroid Method
centroid = np.sum(x * mu) / np.sum(mu)

# 2. Bisector Method
area = np.sum(mu)
cum_area = np.cumsum(mu)
bisector = x[np.where(cum_area >= area/2)[0][0]]

# Maximum membership value
max_mu = np.max(mu)
max_points = x[mu == max_mu]

# 3. Mean of Maximum (MOM)
mom = np.mean(max_points)

# 4. Smallest of Maximum (SOM)
som = np.min(max_points)

# 5. Largest of Maximum (LOM)
lom = np.max(max_points)

print("Centroid =", centroid)
print("Bisector =", bisector)
print("Mean of Maximum (MOM) =", mom)
print("Smallest of Maximum (SOM) =", som)
print("Largest of Maximum (LOM) =", lom)

