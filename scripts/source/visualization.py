import numpy as np
import pandas as pd
import matplotlib.pyplot as plt
import matplotlib.colors as mcolors
import statsmodels.api as sm

plt.style.use('seaborn-bright')

COMP_COLORS = '#263238'

COLORS = {
	0: 'lightcoral',
	1: 'brown',
	2: 'salmon',
	3: 'firebrick',
	4: 'limegreen',
	5: 'coral',
	6: 'lightgreen',
	7: 'darkorange',
	8: 'turquoise',
	9: 'lightseagreen',
	10: 'deepskyblue',
	11: 'steelblue',
	12: 'royalblue',
	13: 'slateblue',
	14: 'mediumslateblue',
	15: 'darkviolet',
	16: 'mediumvioletred',
	17: 'hotpink',
	18: 'orchid'
}

MARKERS = {
	0 : 'o',
	1 : 'v',
	2 : '1',
	3 : '8',
	4 : 's',
	5 : 'p',
	6 : 'P',
	7 : '*',
	8 : '+',
	9 :'x'
}

def get_rand_color():
	return COLORS[np.random.randint(0, len(COLORS))]

def plot_hist(data,title='Histogram', y_label = 'Frequency', x_label = 'Bins'):
	bins =int(1 + 3.332 + np.log2(data.shape[0]))
	ax = plt.axes()
	ax.set_facecolor('white')
	ax.spines['right'].set_color('none')
	ax.spines['left'].set_color(COMP_COLORS)
	ax.spines['bottom'].set_color(COMP_COLORS)
	ax.spines['top'].set_color('none')
	ax.tick_params(axis='x', colors=COMP_COLORS)
	ax.tick_params(axis='y', colors=COMP_COLORS)
	ax.hist(data,bins=bins,rwidth=0.9,color = get_rand_color())
	ax.set_title(title)
	plt.xlabel(x_label, color = COMP_COLORS)
	plt.ylabel(y_label, color = COMP_COLORS)
	plt.savefig('../charts/'+data.name+' hist.png')

def plot_scatter(x,y,title="Scatter",x_label = 'x', y_label = 'y'):
	ax = plt.axes()
	ax.set_facecolor('white')
	ax.set_axisbelow(True)
	ax.spines['right'].set_color('none')
	ax.spines['left'].set_color(COMP_COLORS)
	ax.spines['bottom'].set_color(COMP_COLORS)
	ax.spines['top'].set_color('none')
	ax.tick_params(axis='x', colors=COMP_COLORS)
	ax.tick_params(axis='y', colors=COMP_COLORS)
	ax.scatter(x, y,color =get_rand_color(), marker='o',alpha = 0.9)
	ax.set_title(title)
	plt.xlabel(x_label, color = COMP_COLORS)
	plt.ylabel(y_label, color = COMP_COLORS)
	plt.grid(True,color='#bdbdbd')
	plt.axis('tight')
	path = '../charts/'+'Scatter.png'
	plt.savefig(path)

def plot_corrmat(data,columns, title = 'Correlation Matrix'):
	ticks = len(columns)
	fig = plt.figure()
	ax = fig.add_subplot(111)
	ax.tick_params(labelbottom=True)
	ax.spines['right'].set_color(COMP_COLORS)
	ax.spines['left'].set_color(COMP_COLORS)
	ax.spines['bottom'].set_color(COMP_COLORS)
	ax.spines['top'].set_color(COMP_COLORS)
	mat = ax.matshow(data)
	fig.colorbar(mat)
	ax.set_xticks(np.arange(len(columns)))
	ax.set_yticks(np.arange(len(columns)))
	ax.set_xticklabels(columns, rotation = 90)
	ax.set_yticklabels(columns)
	plt.title(title)
	plt.tight_layout()
	plt.savefig('corrmat.png')

def plot_boxtplot(data, title = 'BoxPlot'):
	red_square = dict(marker='o', markeredgecolor = 'firebrick')
	fig = plt.figure()
	ax = fig.add_subplot(111)
	bplot = ax.boxplot(data, notch = True, vert = False, flierprops = red_square, whis = 0.75, patch_artist=True,medianprops=dict(color='black'))
	patch = bplot['boxes'][0]
	ax.xaxis.grid(True)
	patch.set_facecolor(get_rand_color())
	ax.set_title(title)
	path = '../charts/' + 'boxplot.png'
	plt.savefig(path)

def plot_piechart(data, title ='Pie charts'):
	fig = plt.figure()
	ax = fig.add_subplot(111)
	weights = data.value_counts()
	index = weights.index
	weights = weights.values
	labels = []
	for i in range(len(index)):
		labels.append(str(index[i]) + '\n' + str(weights[i]))
	theme = plt.get_cmap('rainbow')
	ax.set_prop_cycle("color", [theme(1. * i / len(weights)) for i in range(len(weights))])
	_,_,autotexts = ax.pie(weights, labels=labels, autopct='%1.1f%%', wedgeprops={'linewidth': 3.0, 'edgecolor': 'white'})
	for autotext in autotexts:
		autotext.set_color('white')
	plt.axis('equal')
	plt.title(title)
	path = '../charts/' + 'Pie.png'
	plt.savefig(path)

def qq_normalplot(data):
	fig = sm.qqplot(data, fit=True, line = '45', color = 'salmon')
	plt.title(data.name)
	plt.grid(True,color='#bdbdbd')
	path = '../charts/'+data.name+' '+'qqnormal.png'
	plt.savefig(path)
	return path 

def regression_plot(x,y,x_max,x_min,coef,title="Regression Model",x_label = 'x', y_label = 'y'):
	x_val = np.arange(x_min,x_max)
	y_predict = coef[0] + coef[1] * x_val
	ax = plt.axes()
	ax.set_facecolor('white')
	ax.set_axisbelow(True)
	ax.spines['right'].set_color('none')
	ax.spines['left'].set_color(COMP_COLORS)
	ax.spines['bottom'].set_color(COMP_COLORS)
	ax.spines['top'].set_color('none')
	ax.tick_params(axis='x', colors=COMP_COLORS)
	ax.tick_params(axis='y', colors=COMP_COLORS)
	ax.scatter(x, y,color =get_rand_color(), marker='o',alpha = 0.9, label = 'data')
	plt.plot(x_val,y_predict, color = 'maroon',linewidth = 2, label = 'Regression')
	ax.set_title(title)
	plt.legend()
	plt.xlabel(x_label, color = COMP_COLORS)
	plt.ylabel(y_label, color = COMP_COLORS)
	plt.grid(True,color='#bdbdbd')
	plt.axis('tight')
	path = '../charts/'+'Regression.png'
	plt.savefig(path)
	return path

def plot_classes(x_1,x_2,target,title='Classes',x_label = "x", y_label = "y"):
	ax = plt.axes()
	ax.set_facecolor('white')
	ax.set_axisbelow(True)
	ax.spines['right'].set_color('none')
	ax.spines['left'].set_color(COMP_COLORS)
	ax.spines['bottom'].set_color(COMP_COLORS)
	ax.spines['top'].set_color('none')
	ax.tick_params(axis='x', colors=COMP_COLORS)
	ax.tick_params(axis='y', colors=COMP_COLORS)
	labels = np.unique(target)
	n_labels = len(labels)
	markers = np.random.choice(len(MARKERS),n_labels,replace=False)
	print(markers)
	colors = np.random.choice(len(COLORS), n_labels, replace=False)
	print(colors)
	for i in range(n_labels):
		ax.scatter(x_1[target == labels[i]],x_2[target == labels[i]], label = labels[i], color = COLORS[colors[i]], marker=MARKERS[markers[i]])
	ax.set_title(title)
	plt.legend()
	plt.xlabel(x_label, color = COMP_COLORS)
	plt.ylabel(y_label, color = COMP_COLORS)
	path = '../charts/'+'classes.png'
	plt.savefig(path)
	return path	

