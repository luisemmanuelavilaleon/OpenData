import numpy as np
from scipy import stats
from sklearn.linear_model import LinearRegression
from visualization import (qq_normalplot,regression_plot)
import pandas as pd
import matplotlib.pyplot as plt

def shapiro(data):
	shapiro_test = stats.shapiro(data)
	pathqq = qq_normalplot(data)
	print(shapiro_test.statistic)
	print(shapiro_test.pvalue)
	return {
	'statistic': shapiro_test.statistic,
	'p_value': shapiro_test.pvalue, 
	'path': pathqq
	}

def linear_regression(X,y):
	x_copy = X.values.reshape(-1, 1)
	model = LinearRegression()
	model.fit(x_copy,y)
	x_min,x_max = x_copy.min(),x_copy.max()
	coef = (model.intercept_, model.coef_[0])
	print(model.intercept_)
	print(model.coef_[0])
	print(model.score(x_copy, y))
	path = regression_plot(x_copy,y,x_max,x_min,coef)

def statistic(data):
	name = data.name
	mean = np.mean(data)
	median = np.median(data)
	var = np.var(data)
	std = np.std(data)
	minv,q1,q2,q3,maxv = data.describe()[3:]
	print(name)
	print(mean)
	print(median)
	print(var)
	print(std)
	print(minv)
	print(q1)
	print(q2)
	print(q3)
	print(maxv)

def svm(x_1,x_2,target,kernel,C):
	from sklearn.model_selection import train_test_split
	from sklearn.preprocessing import LabelEncoder
	from sklearn.preprocessing import StandardScaler

	encoder = LabelEncoder()
	encoder.fit(target)
	y = encoder.transform(target)

	X = pd.concat([x_1,x_2], axis = 1)
	X_train, X_test, y_train, y_test = train_test_split(
		X,
		y,
		test_size= 0.2,
		random_state= 42,
		stratify=y
	)

	sc = StandardScaler()
	sc.fit(X_train.values)
	X_train_std = sc.transform(X_train.values)

	sc = StandardScaler()
	sc.fit(X_test.values)
	X_test_std = sc.transform(X_test)

	from mlxtend.plotting import plot_decision_regions
	from sklearn.svm import SVC
	
	svm = SVC(kernel = kernel, gamma = 0.2,  C = C).fit(X_train_std,y_train)
	plot_decision_regions(X_train_std, y_train, clf=svm, legend=2)
	plt.xlabel('Feature 1')
	plt.ylabel('Feature 2')
	plt.title('SVM')
	plt.savefig('../charts/svm.png')
	print(svm.score(X_test_std, y_test))


def tree(x_1,x_2,target,criterion):
	from sklearn.model_selection import train_test_split
	from sklearn.preprocessing import LabelEncoder
	from sklearn.preprocessing import StandardScaler

	encoder = LabelEncoder()
	encoder.fit(target)
	y = encoder.transform(target)

	X = pd.concat([x_1,x_2], axis = 1)
	X_train, X_test, y_train, y_test = train_test_split(
		X,
		y,
		test_size= 0.2,
		random_state= 42,
		stratify=y
	)

	sc = StandardScaler()
	sc.fit(X_train.values)
	X_train_std = sc.transform(X_train.values)

	sc = StandardScaler()
	sc.fit(X_test.values)
	X_test_std = sc.transform(X_test)

	from mlxtend.plotting import plot_decision_regions
	from sklearn.tree import DecisionTreeClassifier

	tree = DecisionTreeClassifier(criterion=criterion, max_depth= 4, random_state=1)
	tree.fit(X_train_std, y_train)

	plot_decision_regions(X_train_std, y_train, clf=tree, legend=2)
	plt.xlabel('Feature 1')
	plt.ylabel('Feature 2')
	plt.title('Tree')
	plt.savefig('../charts/tree.png')
	print(tree.score(X_test_std, y_test))

	from pydotplus import graph_from_dot_data
	from sklearn.tree import export_graphviz
	import graphviz

	dot_data = export_graphviz(tree,
                           filled=True, 
                           rounded=True,
                           class_names=['Setosa', 
                                        'Versicolor',
                                        'Virginica'],
                           feature_names=['petal length', 
                                          'petal width'],
                           out_file='treeb.png') 
	graph = graph_from_dot_data(dot_data) 
	graph.write_png('../charts/btree.png') 
