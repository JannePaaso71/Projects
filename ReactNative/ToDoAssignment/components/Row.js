import { View } from "react-native";
import React from "react";
import styles from "../styles/Styles";

const Row = ({ children, style }) => (
    <View style={[styles.row, style]}>
        {children}
    </View>
);

export default Row;
