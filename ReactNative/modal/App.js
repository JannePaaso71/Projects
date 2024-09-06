import { StatusBar } from 'expo-status-bar';
import React, {useState} from 'react';
import {Alert, Modal, StyleSheet, Text, Pressable, View} from 'react-native';

const App = () => {
  const [modalVisible, setModalVisible] = useState(false);
  const [buttonVisible, setButtonVisible] = useState(true);
  return (
      <View style={styles.centeredView}>
        <Modal
            animationType="slide"
            transparent={true}
            visible={modalVisible}
            onRequestClose={() => {
              Alert.alert('Modal has been closed.');
              setModalVisible(!modalVisible);

            }}>
            <View style={styles.topView}>
              <View style={styles.modalView}>
                <Text style={styles.modalText}>This is modal</Text>
                  <Pressable
                    style={[styles.button, styles.buttonClose]}
                    onPress={() => {
                      setModalVisible(!modalVisible)
                      setButtonVisible(true)
                    }}>
                    <Text style={styles.textStyle}>Close</Text>
                  </Pressable>
              </View>
            </View>
        </Modal>
        {buttonVisible && (
            <Pressable
                style={[styles.button, styles.buttonOpen]}
                onPress={() => {
                  setModalVisible(true)
                  setButtonVisible(false)
                }
                }>
              <Text style={styles.textStyle}>Show Modal message</Text>
            </Pressable>
        )}
      </View>
  );
};

const styles = StyleSheet.create({
  centeredView: {
    flex: 1,
    justifyContent: 'center',
    alignItems: 'center',
    width: '100%',
  },
  topView: {
    flex: 1,
    justifyContent: 'flex-start',
    alignItems: 'center',
    width: '100%',
    marginTop: 50,
  },
  modalView: {
    Width: '100%',
    backgroundColor: 'lightgray',

    padding: 35,
    alignItems: 'center',
    shadowColor: 'gray',
    shadowOffset: {
      width: 0,
      height: 2,
    },
    shadowOpacity: 0.25,
    shadowRadius: 4,
    elevation: 5,
  },
  button: {
    padding: 10,
    elevation: 2,
  },
  buttonOpen: {
    backgroundColor: 'white',
  },
  buttonClose: {
    backgroundColor: 'lightgray',
  },
  textStyle: {
    color: 'black',
    fontWeight: 'bold',
    textAlign: 'center',
  },
  modalText: {
    marginBottom: 15,
    textAlign: 'center',
  },
});

export default App;