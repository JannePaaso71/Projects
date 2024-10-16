import styles from "../styles/Styles";
import {View, TextInput, Text, TouchableOpacity} from "react-native";
import React, {useState, memo} from "react";


const AddTodos = ({add}) => {
    const [description, setDescription] = useState("");

    const save = () => {
        add(description);
        setDescription("");
    }

    return (
        <View style={styles.addTodosContainer}>
            <TextInput
                style={styles.addTodosTextInput}
                placeholder="Add a todo"
                value={description}
                onChangeText={setDescription}
            />
            <TouchableOpacity style={styles.addTodosButton} onPress={save}>
                <Text >Add</Text>
            </TouchableOpacity>
        </View>
    );
}

export default memo (AddTodos);