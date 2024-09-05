import { StatusBar } from 'expo-status-bar';
import React, { useState } from 'react';
import { StyleSheet, Switch, Text, View } from 'react-native';

export default function App() {
  const [isEnabled, setIsEnabled] = React.useState(false);
    const toggleSwitch = () => setIsEnabled(previousState => !previousState);

  return (
    <View style={styles.container}>
      <View style={styles.fields}>
      <Text>Enable</Text>
        <Switch
          value={isEnabled}
          onValueChange={toggleSwitch}
        />

      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',

    justifyContent: 'center',
  },
  fields: {
    flexDirection: 'row',
    justifyContent: 'space-between',

  }
});
