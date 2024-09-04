import { StatusBar } from 'expo-status-bar';
import React, { useState } from 'react';
import {Button, StyleSheet, Text, TextInput, View} from 'react-native';

export default function App() {
  const [age, setAge] = useState(" ")
  const [upper, setUpper] = useState(0)
  const [lower, setLower] = useState(0)

  const calculate = () => {
      const fixAge = age.replace(',','.')
        const lowResult = (220 - fixAge) * 0.65
        setLower(Math.round(lowResult))
        const upResult = (220 - fixAge) * 0.85
        setUpper(upResult)
  }

  return (
    <View style={styles.container}>
      <Text style={styles.field}>Age</Text>
      <TextInput
          style={styles.field}
          value={age}
          onChangeText={(text) => setAge(text)}
          keyboardType='decimal-pad'
      />
      <Text style={styles.field}>Limits</Text>
      <Text style={styles.field}>{lower} - {upper.toFixed(0)}</Text>
      <Button title="Calculate" onPress={calculate}></Button>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    marginTop: 50,
    marginLeft: 20,
  },
  field: {
    marginBottom: 10,

  },
});
