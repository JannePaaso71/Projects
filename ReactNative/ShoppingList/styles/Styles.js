import { StyleSheet} from "react-native";

const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#ffebcc',
        alignItems: 'center',
        justifyContent: 'flex-start',
        margin: 8
},
    form: {
        flexDirection: 'row',
        justifyContent: 'space-between',
        alignItems: 'center',
        width: '100%',
        marginTop: 16,
        marginBottom: 16
    },
    textInput: {
        flex: 1,
        marginRight: 10,
        padding: 10,
        backgroundColor: '#fff',
        borderColor: '#ccc',
        borderWidth: 1,
        borderRadius: 5,
    },
    text: {
        flex: 1,
        marginRight: 10,
        padding: 10,
        backgroundColor: '#fff',
        borderColor: '#ccc',
        borderWidth: 1,
        borderRadius: 5,
    },
    addButton: {
        padding: 10,
        backgroundColor: '#ff9900',
        borderColor: '#ccc',
        borderWidth: 1,
        borderRadius: 5,
        alignItems: 'center',
        justifyContent: 'center'
    },
    addButtonText: {
        color: '#fff',
        fontSize: 16,
        fontWeight: 'bold'
    },
    collectedText: {
        textDecorationLine: 'line-through',
        color: '#999'
    },
    myAppBar: {
        backgroundColor: '#ff9900',
        width: '100%',
        height: 60,
        justifyContent: 'center',
        alignItems: 'center',
        elevation: 10,
        shadowColor: 'black',
    },
    myAppBArText: {
        fontSize: 24,
        fontWeight: 'bold',
        color: '#fff'
    },
    bottomBar: {
        width: '100%',
        padding: 10,
        backgroundColor: '#f0f0f0',
        borderTopColor: '#ccc',
        borderTopWidth: 1,
        alignItems: 'center',
    },
    bottomBarText: {
        fontSize: 16,
        color: '#333',
    },
});

export default styles;