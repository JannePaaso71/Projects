import React, { useEffect } from "react";
import {StyleSheet, View, Text, BackHandler} from "react-native";
import styles from "../styles/Styles";

export default function SecondScreen({route, navigation}) {
    useEffect(() => {
        BackHandler.addEventListener('hardwareBackPress', close);
        return () => {
            BackHandler.removeEventListener('hardwareBackPress', close);
        }
    }, []);

    close = () => {
        navigation.goBack(null);
        return true;
    }

    return (
        <View style={styles.container}>
            <Text>Second Screen</Text>
            <Text>{route.params?.message}</Text>
        </View>
    );
}
