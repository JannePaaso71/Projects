import React, {useState} from 'react'
import {Button, StyleSheet, TextInput, View} from 'react-native'

export default function Add ({add}){
    const [name, setName] = useState('')

    const save = () => {
        add(name)
        setName('')
    }
    return (
        <View style={styles.container}>
            <TextInput
                style={styles.form}
                value={name}
                onChangeText={text => setName(text)}
                placeholder="Item name.."
            />
            <Button
                title="Save"
                onPress={save}
            />
        </View>
    );
}

const styles = StyleSheet.create({
    container: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        marginBottom: 16
    },
    orm: {
        flex: 1,
        marginRight: 10,
        borderWidth: 1,
        borderColor: 'gray',
        paddingHorizontal: 8,
    },
})