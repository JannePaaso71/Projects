import {StyleSheet} from "react-native";

export const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    header: {
        fontSize: 24,
        fontWeight: 'bold',
        textAlign: 'center',
        padding: 20,
    },
    text: {
        fontSize: 16,
        fontWeight: 'bold',
        padding: 10,
        color: 'black',
    },
    image: {
        width: 200,
        height: 200,
        borderRadius: 10,
        marginTop: 20,
    },
    button: {
        marginTop: 20,
        backgroundColor: 'blue',
        borderRadius: 5,
        paddingVertical: 10,
        paddingHorizontal: 20,
        alignItems: 'center',
    },
    buttonText: {
        color: 'white',
        fontWeight: 'bold',
    },
    cocktailContainer: {
        marginTop: 20,
        alignItems: 'center',
    },
    cocktailText: {
        fontSize: 16,
        fontWeight: 'bold',
        textAlign: 'center',
    },
    modalContainer: {
        flex: 1,
        justifyContent: 'center',
        alignItems: 'center',
        backgroundColor: 'light-red',
    },
    modalContent: {
        width: 300,
        padding: 20,
        backgroundColor: 'yellow',
        borderRadius: 10,
        alignItems: 'center',
        borderWidth: 1,
        borderColor: 'red',
    },
    errorMessage: {
        marginBottom: 20,
        textAlign: 'center',
        color: 'red',
        borderWidth: 1,
        borderColor: 'red',
        padding: 10,
        borderRadius: 5,
        backgroundColor: 'white',
    },
})