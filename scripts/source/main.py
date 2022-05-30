from data import Data
from visualization import (plot_hist, plot_scatter, plot_boxtplot, plot_corrmat, plot_piechart, qq_normalplot,plot_classes)
import os
import json
import time
from statistic import (shapiro, linear_regression,statistic,svm,tree)

c = 0

indexdf = 0

datasets = []

json_file = '../instructions/inst.json'

def menu(inst):
	if inst['id_inst'] == 0:
		data = Data(inst['path'], index = indexdf)
		resp = json.dumps(data.info_to_json())
		datasets.append(data)
		with open("../instructions/resp.json", "w") as outfile:
			outfile.write(resp)
	if inst['id_inst'] == 1:
		index = inst['id_df']
		column = inst['column']
		title = inst["title"]
		x_label = inst["x_label"]
		y_label = inst["y_label"]
		plot_hist(datasets[index].get_selected_columns(column),title = title, x_label= x_label, y_label = y_label)
	if inst["id_inst"] == 2:
		index = inst['id_df']
		column_1 = inst['column_1']
		column_2 = inst['column_2']
		title = inst["title"]
		x_label = inst["x_label"]
		y_label = inst["y_label"]
		plot_scatter(datasets[index].get_selected_columns(column_1), datasets[index].get_selected_columns(column_2),title=title,x_label= x_label,y_label= y_label)
	if inst["id_inst"] == 3:
		index = inst['id_df']
		title = inst["title"]
		plot_corrmat(datasets[index].correlation(),datasets[index].columns_names,title=title)
	if inst["id_inst"] == 4:
		index = inst['id_df']
		column = inst["column"]
		title = inst["title"]
		plot_boxtplot(datasets[index].get_selected_columns(column),title=title)
	if inst["id_inst"] == 5:
		index = inst['id_df']
		column = inst["column"]
		title = inst["title"]
		plot_piechart(datasets[index].get_selected_columns(column), title= title)
	if inst['id_inst'] == 6:
		index = inst['id_df']
		column_1 = inst['column_1']
		column_2 = inst['column_2']
		target = inst['target']
		title = inst['title']
		x_label = inst['x_label']
		y_label = inst['y_label']
		plot_classes(datasets[index].get_selected_columns(column_1),datasets[index].get_selected_columns(column_2),datasets[index].get_selected_columns(target), title=title, x_label=x_label, y_label=y_label)
	if inst['id_inst'] == 7:
		index = inst['id_df']
		column_1 = inst['column_1']
		column_2 = inst['column_2']
		target = inst['target']
		kernel = inst['kernel']
		C = inst['C']
	if inst['id_inst'] == 8:
		index = inst['id_df']
		column_1 = inst['column_1']
		column_2 = inst['column_2']
		target = inst['target']
		criterion = inst['criterion']
		tree(datasets[index].get_selected_columns(column_1),datasets[index].get_selected_columns(column_2),datasets[index].get_selected_columns(target), criterion = criterion)
	if inst['id_inst'] == 9:
		index = inst['id_df']
		column = inst['column']
		resp = json.dumps(shapiro(datasets[index].get_selected_columns(column)))
		with open("../instructions/resp.json", "w") as outfile:
			outfile.write(resp)
	if inst['id_inst'] == 10:
		index = inst['id_df']
		column = inst['column']
		statistic(datasets[index].get_selected_columns(column))
	if inst['id_inst'] == 12:
		index = inst['id_df']
		X_col = inst['indepent']
		y_col = inst['target']
		X = datasets[index].get_selected_columns(X_col)
		y = datasets[index].get_selected_columns(y_col)
		linear_regression(X, y)
		#resp = json.dumps(shapiro(datasets[index].get_selected_columns(column)))
		#with open("../instructions/resp.json", "w") as outfile:
		#outfile.write(resp)
	if inst['id_inst'] == 13:
		index = inst['id_df']
		column = inst['column']
		statistic(datasets[index].get_selected_columns(column))


while True:
	if os.path.exists(json_file):
		raw_json = open(json_file)
		inst = json.loads(raw_json.read())
		inst = dict(inst)
		menu(inst)
		raw_json.close()
		os.remove(json_file)
		print(c)
	else:
		c = c + 1
		print(c)
		if c == 100:
			break	
		time.sleep(1)




