import styles from "../styles/Styles";
import {TextInput, View} from "react-native";
import React from "react";

export default function Search({search, setSearch}){
    return (
        <View style={styles.searchContainer}>
            <TextInput
                value={search}
                onChangeText={text => setSearch(text)}
                style={styles.searchTextInput}
                placeholder="Search"
            />
        </View>
    );
}