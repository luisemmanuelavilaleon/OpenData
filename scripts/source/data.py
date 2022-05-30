
import pandas as pd
from sklearn.preprocessing import (MinMaxScaler,StandardScaler)
 
class Data():

    def __init__(self,path=None,data=None,skiprows=None,sep=",",header='infer',index = None):
        if isinstance(path, str):
            self.path = path
            raw_df = pd.read_csv(path,skiprows=skiprows,sep=sep,header="infer")
            self.dataframe = pd.DataFrame(data = raw_df.values, columns = raw_df.columns.values)
            self.columns_names = self.dataframe.columns.tolist()
        elif isinstance(data, pd.DataFrame):
            self.dataframe = pd.DataFrame(data)
        self.shape = self.dataframe.shape
        self.types = self.dataframe.dtypes.tolist()
        self.indexdf = index

    def get_selected_rows(self,index):
        """
        Parameters: 
            index: int, list or str

        Returns
            If index type is int return a single row from dataset
            If index type is list return a subset of selected rows from dataset
            If index type is str return a subset of selected rows from dataset
        """
        if isinstance(index, int) and index <= self.shape[0]:
            return self.dataframe.iloc[index]
        elif isinstance(index, list) and max(index) <= self.shape[0]:
            return self.dataframe.iloc[index]
        elif isinstance(index, str):
            raw_index = index.split(":")
            index_slice = list(map(int, raw_index))
            if index_slice[1] <= self.shape[0]:
                return self.dataframe.iloc[index_slice[0]:index_slice[1]] 

    def get_selected_columns(self,index):
        """
        Parameters:
            index: int, list or str

        Returns
            If index type is int return a single column from dataset
            If index type is list return a subset of selected columns from dataset
            If index type is str return a subset of selected columns from dataset    
        """
        if isinstance(index, int) and index <= self.shape[1]:
            return self.dataframe.iloc[:,index]
        elif isinstance(index, list) and max(index) <= self.shape[1]:
            return self.dataframe.iloc[:, index]
        if isinstance(index, str):
            raw_colums = index.split(':')
            column_slice = list(map(int,raw_colums))
            return self.dataframe.iloc[:,column_slice[0]: column_slice[1]]

    def drop_column(self, index_column):
        ""
        if max(index_column) <= self.dataframe.shape[1]:
            self.dataframe = self.dataframe.drop(columns=[self.columns_names[i] for i in index_column])
            self.shape = self.dataframe.shape
            self.columns_names = self.dataframe.columns.tolist()


    def drop_rows(self, index_row):
        if max(index_row) <= self.shape[0]:
            self.dataframe = self.dataframe.drop(index_row)
            self.shape = self.dataframe.shape


    def filter_num(self, index_column, value, filter_type):
        if filter_type == 0:
            return self.dataframe[self.dataframe[self.columns_names[index_column]] > value]
        if filter_type == 1:
            return self.dataframe[self.dataframe[self.columns_names[index_column]] >= value]
        if filter_type == 2:
            return self.dataframe[self.dataframe[self.columns_names[index_column]] < value]
        if filter_type == 3:
            return self.dataframe[self.dataframe[self.columns_names[index_column]] <= value]
        if filter_type == 4:
            return self.dataframe[self.dataframe[self.columns_names[index_column]] == value]
        if filter_type == 5:
            return self.dataframe[self.dataframe[self.columns_names[index_column]] != value]
        if filter_type == 6:
            return self.dataframe[(self.dataframe[self.columns_names[index_column]] > value[0]) & (self.dataframe[self.columns_names[index_column]] < value[1])]
        if filter_type == 7:
            return self.dataframe[(self.dataframe[self.columns_names[index_column]] >= value[0]) & (self.dataframe[self.columns_names[index_column]] <= value[1])]


    def summary(self):
        return self.dataframe.describe()

    def rename_column(self,old,new):
        self.dataframe.rename(columns={old:new})
        self.columns_names = self.dataframe.columns.tolist()


    def scale_column(self,index_column,type):
        desired_column = self.columns_names[index_column]
        data = self.dataframe[desired_column].values.reshape(-1,1)
        if type == 0:
            scaler = MinMaxScaler()
            scaler.fit(data)
            trans_data = scaler.transform(data)
            self.dataframe[desired_column+" Min-Max Scaled"] = trans_data
        elif type == 1:
            scaler = StandardScaler()
            scaler.fit(data)
            trans_data = scaler.transform(data)
            self.dataframe[desired_column+" Standard Scaled"] = trans_data
        self.columns_names = self.dataframe.columns.tolist()
        self.shape = self.dataframe.shape

    def count_na_values(self):
        return self.dataframe.isnull().sum(axis = 0)

    def save_csv(self):
        self.dataframe.to_csv('temp.csv',index=False)

    def info_to_json(self):
        return {
            'columns_names' : self.columns_names,
            'shape' : list(self.shape),
            'index': self.indexdf
        }

    def correlation(self):
        return self.dataframe.corr()