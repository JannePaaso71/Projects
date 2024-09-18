import * as React from 'react';
import { Appbar } from 'react-native-paper';
import { StyleSheet } from 'react-native';

const MyAppbar = () => (
    <Appbar.Header style={styles.appbar} elevated>
        <Appbar.BackAction onPress={() => {}} />
        <Appbar.Content title="Title" />
        <Appbar.Action icon="calendar" onPress={() => {}} />
        <Appbar.Action icon="magnify" onPress={() => {}} />
    </Appbar.Header>
);

const styles = StyleSheet.create({
    appbar: {
        width: '100%',
    },
});

export default MyAppbar;