import {View, Text} from "react-native";
import React from "react";
import styles from "../styles/Styles";

export default function Header(){
    return (
        <View style={styles.headerContainer}>
            <Text style={styles.headerText}>TodoList with useReducer</Text>
        </View>
    );
}