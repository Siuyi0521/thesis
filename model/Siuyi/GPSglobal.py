import urllib.request
import os
import tarfile
import numpy as np
import keras
import matplotlib.pyplot as plt

from keras.utils import np_utils
from keras.preprocessing import sequence
from keras.preprocessing.text import Tokenizer

from numpy import array
from numpy import argmax
from sklearn.preprocessing import LabelEncoder
from sklearn.preprocessing import OneHotEncoder
from keras.layers import Input
from keras.layers import Embedding
from keras.layers import merge
from keras.utils import to_categorical
from keras.models import Sequential
from keras.layers.core import Dense, Dropout, Activation, Flatten
from keras.layers.embeddings import Embedding
from keras.layers.recurrent import SimpleRNN
from keras.layers.recurrent import LSTM
from keras.layers.recurrent import GRU
#%%
def show_train_history(train_history,train,validation):
    plt.plot(train_history.history[train])
    plt.plot(train_history.history[validation])
    plt.title('Train History')
    plt.ylabel(train)
    plt.xlabel('Epoch')
    plt.legend(['train','validation'], loc = 'upper left')
    plt.show()    
#%%
final_text = [[0 for i in range(4)] for j in range(5753)] 
text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/Geolife_second_onehot_Input.txt",dtype=np.int)
         #%%
for i in range(0,5753):
    final_text[i] = np.split(text[i], 4, axis=0)
    c = np.array(final_text)
#%%
label = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/Geolife_first_category_label.txt",dtype=np.int)
#%%
shuffle_indices = np.random.permutation(np.arange(len(text)))
c = c[shuffle_indices]
label = label[shuffle_indices]
train_len = int( len(c) * 0.8)
train_text = c[:train_len]
train_label = label[:train_len]
test_text = c[train_len:]
test_label = label[train_len:]
#%%
model = Sequential()
#%%
#model.add(Embedding(output_dim=32,input_dim=157,input_length=4))
#model.add(Dropout(0.2))
#%%
model.add(LSTM(units=32,input_dim=157,input_length=4))
#%%
model.add(Dense(units=256,activation='relu'))
model.add(Dropout(0.35))
#%%
model.add(Dense(units = 18,activation='sigmoid'))
#%%
model.summary()
#%%
model.compile(loss = 'categorical_crossentropy',optimizer='adam',metrics=['top_k_categorical_accuracy'])
#%%
train_history = model.fit(train_text,train_label,batch_size=100,
                          epochs=20,verbose=2,validation_split=0.2)
#%%
show_train_history(train_history,'loss','val_loss')
show_train_history(train_history,'top_k_categorical_accuracy','val_top_k_categorical_accuracy')
#%%
scores = model.evaluate(test_text, test_label, verbose=1)
scores[1]
#%%
predict = model.predict(test_text)
#%%
predict[:1]
test_label[:1]