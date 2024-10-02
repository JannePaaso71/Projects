import { Appbar } from "react-native-paper";
import React from "react";
import styles from "../styles/Styles";

const MyAppbar = () => (
    <Appbar.Header style={styles.appbar}>
        <Appbar.Content title="Todo List" />
    </Appbar.Header>
);

export default MyAppbar;
