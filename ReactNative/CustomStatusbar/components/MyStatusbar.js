import {Platform, StatusBar, View} from "react-native";
import React from "react";
import Constants from "expo-constants/src/Constants";

export default function MyStatusbar(props) {
    const backgroundColor = props.backgroundColor ? props.backgroundColor : '#fff'
    const statusBarHeight = Platform.OS === 'ios' ? Constants.statusBarHeight : 0

    return (
        <View style={{backgroundColor: backgroundColor, height: statusBarHeight}}>
            <StatusBar {...props} />
        </View>
    )
}