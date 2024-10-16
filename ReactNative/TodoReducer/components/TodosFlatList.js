import styles from "../styles/Styles";
import {FlatList, Text, TouchableOpacity, View} from "react-native";

export default function TodosFlatList({todos, toggle, remove}) {

    return (
        <View style={styles.todosFlatListContainer}>
            <FlatList
                data={todos}
                keyExtractor={(item) => item.id}
                renderItem={({item}) => (
                    <TouchableOpacity
                        onPress={() => toggle(item.id)}
                        onLongPress={() => remove(item.id)}
                        style={styles.todoItemContainer}
                    >
                        <Text style={[styles.todoItemText, item.completed && styles.completedTodo]}>
                            {item.description}
                        </Text>
                    </TouchableOpacity>
                )}
            />
        </View>
    );
}