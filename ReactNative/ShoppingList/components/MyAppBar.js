import { View, Text } from 'react-native';
import styles from "../styles/Styles";

export default function MyAppBar() {
    return (
        <View style={styles.myAppBar}>
            <Text style={styles.myAppBArText}>Shopping List</Text>
        </View>
    )
}