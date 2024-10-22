import {Button, StyleSheet, TextInput, View, Text, SafeAreaView} from "react-native";
import {useState} from "react";
import { signIn} from "../firebase/Auth";


export default function Login(){
const [userName, setUserName] = useState('')
const [password, setPassword] = useState('')

    const login = async => {
    if(userName && password) {

    }
    }

    return (
        <SafeAreaView style={styles.container}>
            <Text>Login</Text>
            <View style={styles.form}>
                <Text style={styles.title}>Login</Text>
                <TextInput
                    style={styles.input}
                    placeholder={'Email'}
                />
                <TextInput
                    style={styles.input}
                    placeholder={'Password'}
                    secureTextEntry={true}
                />
                <Button title={'Login'} onPress={login}/>
            </View>
        </SafeAreaView>
    )
}

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
        margin: 16
    },
    form: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        width: '100%',
        marginBottom: 16,
        marginTop: 16
    },
    message: {
        margin: 16,
        padding: 16,
        backgroundColor: '#f9f9f9',
        borderRadius: 8,
        borderWidth: 1,
        borderColor: '#ccc'
    },
    title: {
        fontSize: 12
    }
});