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
from keras.metrics import top_k_categorical_accuracy
from keras.layers import Input
from keras.layers import Embedding
from keras.layers import merge
from keras.layers import Lambda
from keras.layers import Reshape
from keras.utils import to_categorical
from keras.models import Sequential
from keras.models import Model
from keras.layers.core import Dense, Dropout, Activation, Flatten
from keras.layers.embeddings import Embedding
from keras.layers.recurrent import SimpleRNN
from keras.layers.recurrent import LSTM
from keras.layers.recurrent import GRU

def show_train_history(train_history,train,validation):
    plt.plot(train_history.history[train])
    plt.plot(train_history.history[validation])
    plt.title('Train History')
    plt.ylabel(train)
    plt.xlabel('Epoch')
    plt.legend(['train','validation'], loc = 'upper left')
    plt.show()    

def top_1_categorical_accuracy(y_true, y_pred):
    return top_k_categorical_accuracy(y_true, y_pred, k=1)
def top_2_categorical_accuracy(y_true, y_pred):
    return top_k_categorical_accuracy(y_true, y_pred, k=2)
def top_3_categorical_accuracy(y_true, y_pred):
    return top_k_categorical_accuracy(y_true, y_pred, k=3)
def top_4_categorical_accuracy(y_true, y_pred):
    return top_k_categorical_accuracy(y_true, y_pred, k=4)
def top_5_categorical_accuracy(y_true, y_pred):
    return top_k_categorical_accuracy(y_true, y_pred, k=5)

#%%
group1_text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group1_CTS_Input_SP=9.txt",dtype=np.int)
group2_text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group2_CTS_Input_SP=9.txt",dtype=np.int)
group3_text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group3_CTS_Input_SP=9.txt",dtype=np.int)
group4_text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group4_CTS_Input_SP=9.txt",dtype=np.int)
group5_text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group5_CTS_Input_SP=9.txt",dtype=np.int)
group6_text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group6_CTS_Input_SP=9.txt",dtype=np.int)
group7_text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group7_CTS_Input_SP=9.txt",dtype=np.int)
#group4_text = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/_sequenceLength=9/Geolife_second_group4_onehot_category_Input_SP=9.txt",dtype=np.int)
#%%
group1_text = group1_text.reshape(2248,8,48)
group2_text = group2_text.reshape(2268,8,48)
group3_text = group3_text.reshape(2222,8,48)
group4_text = group4_text.reshape(2173,8,48)
#%%
group5_text = group5_text.reshape(2291,8,48)
group6_text = group6_text.reshape(2274,8,48)
group7_text = group7_text.reshape(520,8,48)
#%%
group1_label = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group1_CTS_Output_SP=9.txt",dtype=np.int)
group2_label = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group2_CTS_Output_SP=9.txt",dtype=np.int)
group3_label = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group3_CTS_Output_SP=9.txt",dtype=np.int)
group4_label = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group4_CTS_Output_SP=9.txt",dtype=np.int)
group5_label = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group5_CTS_Output_SP=9.txt",dtype=np.int)
group6_label = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group6_CTS_Output_SP=9.txt",dtype=np.int)
group7_label = np.loadtxt("C:/Users/Siuyi/Desktop/Siuyi/Siuyi/OSM/_sequenceLength=9/__new/OSM_sequence_group7_CTS_Output_SP=9.txt",dtype=np.int)


shuffle_indices = np.random.permutation(np.arange(len(group1_text)))
group1_text = group1_text[shuffle_indices]
group1_label = group1_label[shuffle_indices]
train_len = int( len(group1_text) * 0.8)
group1_train_text = group1_text[:train_len]
group1_train_label = group1_label[:train_len]
group1_test_text = group1_text[train_len:]
group1_test_label = group1_label[train_len:]

shuffle_indices = np.random.permutation(np.arange(len(group2_text)))
group2_text = group2_text[shuffle_indices]
group2_label = group2_label[shuffle_indices]
train_len = int( len(group2_text) * 0.8)
group2_train_text = group2_text[:train_len]
group2_train_label = group2_label[:train_len]
group2_test_text = group2_text[train_len:]
group2_test_label = group2_label[train_len:]

shuffle_indices = np.random.permutation(np.arange(len(group3_text)))
group3_text = group3_text[shuffle_indices]
group3_label = group3_label[shuffle_indices]
train_len = int( len(group3_text) * 0.8)
group3_train_text = group3_text[:train_len]
group3_train_label = group3_label[:train_len]
group3_test_text = group3_text[train_len:]
group3_test_label = group3_label[train_len:]

shuffle_indices = np.random.permutation(np.arange(len(group4_text)))
group4_text = group4_text[shuffle_indices]
group4_label = group4_label[shuffle_indices]
train_len = int( len(group4_text) * 0.8)
group4_train_text = group4_text[:train_len]
group4_train_label = group4_label[:train_len]
group4_test_text = group4_text[train_len:]
group4_test_label = group4_label[train_len:]

shuffle_indices = np.random.permutation(np.arange(len(group5_text)))
group5_text = group5_text[shuffle_indices]
group5_label = group5_label[shuffle_indices]
train_len = int( len(group5_text) * 0.8)
group5_train_text = group5_text[:train_len]
group5_train_label = group5_label[:train_len]
group5_test_text = group5_text[train_len:]
group5_test_label = group5_label[train_len:]

shuffle_indices = np.random.permutation(np.arange(len(group6_text)))
group6_text = group6_text[shuffle_indices]
group6_label = group6_label[shuffle_indices]
train_len = int( len(group6_text) * 0.8)
group6_train_text = group6_text[:train_len]
group6_train_label = group6_label[:train_len]
group6_test_text = group6_text[train_len:]
group6_test_label = group6_label[train_len:]

shuffle_indices = np.random.permutation(np.arange(len(group7_text)))
group7_text = group7_text[shuffle_indices]
group7_label = group7_label[shuffle_indices]
train_len = int( len(group7_text) * 0.8)
group7_train_text = group7_text[:train_len]
group7_train_label = group7_label[:train_len]
group7_test_text = group7_text[train_len:]
group7_test_label = group7_label[train_len:]

global_train_text = np.concatenate((group1_train_text, group2_train_text,group3_train_text,group4_train_text
                                    ,group5_train_text,group6_train_text,group7_train_text),axis = 0)
global_train_label = np.concatenate((group1_train_label, group2_train_label,group3_train_label,group4_train_label
                                     ,group5_train_label,group6_train_label,group7_train_label),axis = 0)
global_test_text = np.concatenate((group1_test_text, group2_test_text,group3_test_text,group4_test_text
                                   ,group5_test_text,group6_test_text,group7_test_text),axis = 0)
global_test_label = np.concatenate((group1_test_label, group2_test_label,group3_test_label,group4_test_label
                                    ,group5_test_label,group6_test_label,group7_test_label),axis = 0)
#%%
Global = []
Group = []
Att = []
TL = []
for i in range(0,3):
    if(i == 0):
        top_k_acc = top_1_categorical_accuracy
    if(i == 1):
        top_k_acc = top_3_categorical_accuracy
    if(i == 2):
        top_k_acc = top_5_categorical_accuracy
    if(i == 3):
        top_k_acc = top_4_categorical_accuracy
    if(i == 4):
        top_k_acc = top_5_categorical_accuracy
        #變數設置
    group_train_text = group7_train_text
    group_train_label = group7_train_label
    group_test_text = group7_test_text
    group_test_label = group7_test_label

    global_first_inputs = Input(shape = (8,48,))
    global_inputs = GRU(units = 32,return_sequences=False)(global_first_inputs)
    global_inputs = Dropout(0.35)(global_inputs)
    global_inputs = Dense(units=256,activation='relu')(global_inputs)
    global_inputs = Dropout(0.35)(global_inputs)
    global_outputs = Dense(units = 18,activation='softmax')(global_inputs)
    global_model = Model(inputs = global_first_inputs , outputs = global_outputs )

    group_first_inputs = Input(shape = (8,48,))
    group_inputs = GRU(units = 32,return_sequences=False)(group_first_inputs)
    group_inputs = Dropout(0.35)(group_inputs)
    group_inputs = Dense(units=256,activation='relu')(group_inputs)
    group_inputs = Dropout(0.35)(group_inputs)
    group_outputs = Dense(units = 18,activation='softmax')(group_inputs)
    group_model = Model(inputs = group_first_inputs , outputs = group_outputs)

    global_model.summary()
    group_model.summary()

    global_model.compile(loss = 'categorical_crossentropy',optimizer='adam',metrics='top_k_categorical_accuracy')
    group_model.compile(loss = 'categorical_crossentropy',optimizer='adam',metrics='top_k_categorical_accuracy')

    global_train_history = global_model.fit(global_train_text,global_train_label,batch_size=100,
                                            epochs=20,verbose=2,validation_split=0.2)
    global_model_weight = global_model.get_weights()

    group_train_history = group_model.fit(group_train_text,group_train_label,batch_size=100,
                                          epochs=100,verbose=2,validation_split=0.2)

    Tgroup_first_inputs = Input(shape = (8,48,))
    Tgroup_inputs = GRU(units = 32,return_sequences=False)(Tgroup_first_inputs)
    Tgroup_inputs = Dropout(0.35)(Tgroup_inputs)
    Tgroup_inputs = Dense(units=256,activation='relu')(Tgroup_inputs)
    Tgroup_inputs = Dropout(0.35)(Tgroup_inputs)
    Tgroup_outputs = Dense(units = 18,activation='softmax')(Tgroup_inputs)
    Tgroup_model = Model(inputs = Tgroup_first_inputs , outputs = Tgroup_outputs)
    Tgroup_model.set_weights(global_model_weight)
    Tgroup_model_weight = Tgroup_model.get_weights()
    Tgroup_model.summary()
    
    for layer in Tgroup_model.layers[:3]:
       layer.trainable = False

    Tgroup_model.compile(loss = 'categorical_crossentropy',optimizer='adam',metrics=[top_k_acc])

    Tgroup_train_history = Tgroup_model.fit(group_train_text,group_train_label,batch_size=100,
                                            epochs=20,verbose=2,validation_split=0.2)
    Tgroup_model_weight = Tgroup_model.get_weights()

#    show_train_history(global_train_history,'loss','val_loss')
#    show_train_history(global_train_history,'top_k_categorical_accuracy','val_top_k_categorical_accuracy')
#    show_train_history(global_train_history,'loss','val_loss')
#    show_train_history(global_train_history,'accuracy','val_accuracy')
#    
    show_train_history(group_train_history,'loss','val_loss')
    show_train_history(group_train_history,'top_k_categorical_accuracy','val_top_k_categorical_accuracy')
    show_train_history(group_train_history,'loss','val_loss')
    show_train_history(group_train_history,'accuracy','val_accuracy')
    
    global_scores =global_model.evaluate(global_test_text, global_test_label, verbose=1)
    global_scores[1]
    
    group_scores =group_model.evaluate(group_test_text, group_test_label, verbose=1)
    group_scores[1]
    
    Tgroup_scores =Tgroup_model.evaluate(group_test_text, group_test_label, verbose=1)
    Tgroup_scores[1]
    
    group_to_global_scores =global_model.evaluate(group_test_text, group_test_label, verbose=1)
    group_to_global_scores[1]
    
    global_train_predict = global_model.predict(group_train_text)
    group_train_predict = group_model.predict(group_train_text)
    train_predict = np.concatenate((global_train_predict, group_train_predict),axis = -1)
    
    global_test_predict = global_model.predict(group_test_text)
    group_test_predict = group_model.predict(group_test_text)
    test_predict = np.concatenate((global_test_predict, group_test_predict),axis = -1)
    
    
    def slice(x,index):
        return x[ : , index]
    
    inputs1 = Input(shape = (18,))
    attention_probs1 = Dense(1, activation='tanh', name='attention_probs1')(inputs1)
    inputs2 = Input(shape = (18,))
    attention_probs2 = Dense(1, activation='tanh', name='attention_probs2')(inputs2)
    concat = keras.layers.Concatenate()([attention_probs1,attention_probs2])
    softmax = Dense(units = 2)(concat)
    softmax = Activation('softmax')(softmax)
    new_attention_probs1 = Lambda(slice , arguments = {'index':0})(softmax)
    new_attention_probs2 = Lambda(slice , arguments = {'index':1})(softmax)
    attention_mul1 = keras.layers.Multiply()([inputs1, new_attention_probs1])
    attention_mul2 = keras.layers.Multiply()([inputs2, new_attention_probs2])
    add = keras.layers.Add()([attention_mul1, attention_mul2])
    model = Model(inputs = [inputs1, inputs2],outputs = add)
    model.summary()
    
    
    model.compile(loss = 'categorical_crossentropy',optimizer='adam',metrics=[top_k_acc])
    
    train_history = model.fit([global_train_predict,group_train_predict],group_train_label,batch_size=100,
                              epochs=20,verbose=2,validation_split=0.2)
    model.get_weights()
    
    scores =model.evaluate([global_test_predict,group_test_predict], group_test_label,verbose=1)
    scores[1]
    
    Global.append(group_to_global_scores[1])
    Group.append(group_scores[1])
    Att.append(scores[1])
    TL.append(Tgroup_scores[1])
    
print(Global)
print(Group)
print(Att)
print(TL)