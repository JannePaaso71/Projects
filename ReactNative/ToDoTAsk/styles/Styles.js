import {StyleSheet} from "react-native";

const styles = StyleSheet.create({
    safeAreaView: {
        flex: 1,
        backgroundColor: '#fff',
    },
    appbar: {
        backgroundColor: "orange",
        justifyContent: 'center',
        alignItems: 'center',
    },
    inputContainer: {
        flexDirection: 'row',
        marginBottom: 16,
    },
    taskText: {
        padding: 8,
        fontSize: 16,
        borderBottomWidth: 1,
        borderBottomColor: '#ccc',
    },
    taskList: {
        marginTop: 16,
    },
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
    row: {
        flexDirection: 'row',
        alignItems: 'center',
    },
    addTextInput: {
        flex: 1,
        marginRight: 8,
    },
    addButton: {
        justifyContent: 'center',
    },
    completedTask: {
        textDecorationLine: 'line-through',
        textDecorationStyle: 'solid',
        color: 'gray',
    }
});

export default styles;