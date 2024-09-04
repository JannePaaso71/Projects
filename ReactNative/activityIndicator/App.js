import { StatusBar } from 'expo-status-bar';
import React,{useEffect, useState} from 'react'
import { StyleSheet, ActivityIndicator, View } from 'react-native';

export default function App() {
const [isLoading, setIsLoading] = useState(true)

    useEffect (() => {
        setTimeout(() => {
        setIsLoading(false);
        }, 10000)
    }, [])

  return (
    <View style={styles.container}>
    {isLoading &&
    <ActivityIndicator size="large" color="#0000ff" animating={true}/>

    }

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
