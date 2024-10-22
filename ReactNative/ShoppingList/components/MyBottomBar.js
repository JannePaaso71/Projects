import React from 'react';
import {View, Text} from 'react-native';
import styles from "../styles/Styles";

export default function MyBottomBar({totalProducts, collectedProducts}) {
    return (
        <View style={styles.bottomBar}>
            <Text style={styles.bottomBarText}>
                Total Products: {totalProducts} | Collected: {collectedProducts}
            </Text>
        </View>
    )
}