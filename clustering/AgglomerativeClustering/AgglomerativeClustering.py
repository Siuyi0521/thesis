# -*- coding: utf-8 -*-
"""
Created on Tue Jun 19 16:19:46 2018

@author: Siuyi
"""
import numpy as np
from sklearn.cluster import AgglomerativeClustering
fw = open("C:/Users/Siuyi/Desktop/Siuyi/AgglomerativeClustering/LCSSimilarity.txt","r")
#userSimlarity = [[0 for i in range(91)] for j in range(91)] 
#line = []
#userSimlarity = []
#for i in range(0,91):
line = fw.readlines()
a = []
for i in range(0,2000):
    a.append(line[0].split(', '))
for i in range(0,2000):
    a[i] = a[i][:2000]
for i in range(0,2000):
    for j in range(0,2000):
        a[i][j] = float(a[i][j])
for i in range(0,2000):
    a[i][i] = 0

    #userSimlarity[i] = line[i].split(', ')
#%%
data_matrix = [[0,0.8,0.9],[0.8,0,0.2],[0.9,0.2,0]]
model = AgglomerativeClustering(affinity='precomputed', n_clusters=10,linkage='complete').fit(a)
b = model.labels_
group1 = []
group2 = []
group3 = []
group4 = []
group5 = []
group6 = []
group7 = []
group8 = []
group9 = []
group10 = []
group11 = []
for i in range(0,2000):
    if(model.labels_[i] == 0):
        group1.append(i)
    if(model.labels_[i] == 1):
        group2.append(i)
    if(model.labels_[i] == 2):
        group3.append(i)
    if(model.labels_[i] == 3):
        group4.append(i)
    if(model.labels_[i] == 4):
        group5.append(i)
    if(model.labels_[i] == 5):
        group6.append(i)
    if(model.labels_[i] == 6):
        group7.append(i)
    if(model.labels_[i] == 7):
        group8.append(i)
    if(model.labels_[i] == 8):
        group9.append(i)
    if(model.labels_[i] == 9):
        group10.append(i)
    if(model.labels_[i] == 10):
        group11.append(i)
print(str(group1))
print(str(group2))
print(str(group3))
print(str(group4))
print(str(group5))
print(str(group6))
print(str(group7))
print(str(group8))
print(str(group9))
print(str(group10))
print(str(group11))
print(model.labels_)