import pandas as pd
import json
import time
import os
import numpy as np
from visualization import (plot_hist,plot_scatter,plot_corrmat,plot_boxtplot,plot_piechart,qq_normalplot)
from data import Data


GET_SUBSET = 23 

path = r"C:/Users/Luis Emmanuel/Desktop/Admission_Predict.csv"
json_file = 'instruccion.opdata'


data = Data(path=path)
data.summary().to_json('resumen.json')
#print(data.columns_names)
#plot_corrmat(data.dataframe.corr(),columns = data.columns_names)
qq_normalplot(data.get_selected_columns(1))
#data.save_csv()
#print(data.dataframe.corr())
#plot_hist(data.dataframe['GRE Score'])
#plot_scatter(data.get_selected_columns(1),data.get_selected_columns(6))  
#data.dataframe.to_json('data.json')
#print(data.count_na_values())
#plot_boxtplot(data.dataframe['GRE Score']) 	
#plot_hist(data.dataframe['GRE Score'],title='GRE Score Histogram')
"""
while dTrue:
	if os.path.exists(json_file):
		raw_json = open('instruccion.opdata')
		inst = json.loads(raw_json.read())

		inst = dict(inst)
		print(inst)

		data = Data(inst['path'])
		data.drop_column(inst['indexs'])
		print(data.shape)
		print('no encontrado')
		raw_json.close()
		os.remove(json_file)

	else:
		c = c + 1
		if c == 10:
			break

	time.sleep(1)
	"""