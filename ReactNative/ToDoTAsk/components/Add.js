import {TextInput, Button} from "react-native-paper";
import {Alert, FlatList, Text, TouchableOpacity, View} from "react-native";
import React, {useState, useEffect} from "react";
import Row from "./Row";
import styles from "../styles/Styles";
import AsyncStorage from '@react-native-async-storage/async-storage';

let nextId = 0;

export default function Add() {
    const [task, setTask] = useState('');
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        getData();
    }, []);

    const storeData = async (todos) => {
        try {
            await AsyncStorage.setItem('todos', JSON.stringify(todos));
        } catch (e) {
            console.error(e);
            Alert.alert('Error saving data');
        }
    }

    const getData = async () => {
        try {
            const value = await AsyncStorage.getItem('todos');
            if (value !== null) {
                setTodos(JSON.parse(value));
            }
        } catch (e) {
            console.error(e);
            Alert.alert('Error loading data');
        }
    }

    const addTask = () => {
        setTodos([...todos, {id: nextId++, task}]);
        setTask('');
    }

    const toggleTaskCompletion = (id) => {
        setTodos(todos.map(todo =>
            todo.id === id ? { ...todo, completed: !todo.completed } : todo
        ));
    }

    const renderItem = ({ item }) => (
        <TouchableOpacity onPress={() => toggleTaskCompletion(item.id)}>
            <Text style={[styles.taskText, item.completed && styles.completedTask]}>
                {item.task}
            </Text>
        </TouchableOpacity>
    );

    return (
        <View>
            <Row style={styles.inputContainer}>
                <TextInput
                    label="Add a task"
                    value={task}
                    onChangeText={text => setTask(text)}
                    style={styles.addTextInput}
                />
                <Button
                    mode='contained'
                    onPress={addTask}
                    style={styles.addButton}
                >Save</Button>
            </Row>
            <FlatList
                data={todos}
                keyExtractor={item => item.id.toString()}
                renderItem={renderItem}
                style={styles.taskList}
            />
        </View>
    )
}