import { StatusBar } from 'expo-status-bar';
import React, { useState } from 'react';
import { StyleSheet, Button, View, Alert, Text} from 'react-native';

export default function App() {
    const [ok, setOk] = useState(false);

    const showAlert = () =>{
        Alert.alert(
        "My alert",
        "This is my first alert",
        [
            {
                text: "Ok",
                onPress: () => setOk(true)
            },
            {
                text: "Cancel",
                onPress: () => setOk(false)

            }
        ]
        )
    }
  return (
    <View style={styles.container}>
        <Button title="Press Me" onPress={showAlert} />
        <Text>{ok===true ? "Ok" : "Cancel"}</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    backgroundColor: '#fff',
    alignItems: 'center',
    justifyContent: 'center',
  },
});
