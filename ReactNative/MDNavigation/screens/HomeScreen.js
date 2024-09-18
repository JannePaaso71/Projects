import React, { useLayoutEffect, useState } from "react";
import {StyleSheet, View, Text, TextInput} from "react-native";
import Ionicons from 'react-native-vector-icons/Ionicons';
import styles from "../styles/Styles";


export default function HomeScreen({navigation}) {
    const [message, setMessage] = useState('Testing');

    return (
        <View style={styles.container}>
            <Text>Home Screen</Text>
        </View>
    );
}
