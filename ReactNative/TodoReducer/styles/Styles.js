import { StyleSheet } from "react-native";

const styles = StyleSheet.create({
    appContainer: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
    },
    headerContainer: {
       backgroundColor: 'orange',
    },
    headerText: {
        fontSize: 24,
        fontWeight: 'bold',
    },
    searchContainer: {
        paddingHorizontal: 20,
        marginTop: 10,
        marginBottom: 10,
    },
    searchTextInput: {
        fontSize: 20,
        fontWeight: 'bold',
    },
    addTodosContainer: {
        alignItems: 'center',
        flexDirection: 'row',
        margin: 20,
    },
    addTodosTextInput: {
        flex: 1,
        height: 40,
        borderWidth: 1,
        padding: 10,
        fontSize: 20,
        fontWeight: 'bold',
        marginRight: 10,
        backgroundColor: 'dark-white',
    },
    addTodosButton: {
        height: 40,
        paddingHorizontal: 15,
        justifyContent: 'center',
        alignItems: 'center',
        borderWidth: 1,
        borderColor: '#000',
        borderRadius: 5,
        backgroundColor: 'dark-white',
    },
    todosFlatListContainer: {
        flex: 1,
        width: '100%',
        paddingHorizontal: 20,
        marginTop: 10,
    },
    todoItemContainer: {
        backgroundColor: 'dark-white',
        paddingVertical: 12,
        paddingHorizontal: 16,
        marginVertical: 6,
        marginHorizontal: 16,
        borderRadius: 5,
        flexDirection: 'row',
        alignItems: 'center',
    },
    todoItemText: {
        padding: 10,
        fontSize: 20,
    },
    completedTodo: {
        textDecorationLine: 'line-through',
        color: 'gray',
    },

});

export default styles;
