import * as React from 'react';
import { Appbar } from 'react-native-paper';
import Ionicons from "react-native-vector-icons/Ionicons";

const MyAppbar = ({ navigation, route }) => (
    <Appbar.Header elevated>
        {route.name === 'Second' ? (
            <Appbar.Action
                icon={() => <Ionicons name="arrow-back" size={24} />}
                onPress={() => navigation.goBack()}
            />
        ) : null}
        <Appbar.Content title="MD Nav Demo" />
        {route.name === 'Home' ? (
            <Appbar.Action
                icon={() => <Ionicons name="arrow-forward" size={24} />}
                onPress={() => navigation.navigate('Second', { message: '' })}
            />
        ) : null}
    </Appbar.Header>
);

export default MyAppbar;