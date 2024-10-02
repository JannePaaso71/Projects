import {Platform, StyleSheet} from 'react-native';
import Constants from "expo-constants/src/Constants";


const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
        marginTop: Platform.OS === "android" ? Constants.statusBarHeight : 0,
    },
    map: {
        height: "100%",
        width: "100%",
    }
})

export default styles;