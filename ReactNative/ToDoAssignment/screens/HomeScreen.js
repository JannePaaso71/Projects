import React, { useState, useEffect } from "react";
import { View } from "react-native";
import MyAppbar from "../components/MyAppbar";
import AddTask from "../components/AddTask";
import TaskList from "../components/TaskList";
import styles from "../styles/Styles";
import { getData, storeData } from "../utils/AsyncStorageUtils";

let nextId = 0;

const HomeScreen = () => {
    const [todos, setTodos] = useState([]);

    useEffect(() => {
        loadData();
    }, []);

    const loadData = async () => {
        const storedTodos = await getData();
        if (storedTodos) {
            setTodos(storedTodos);
        }
    };

    const addTask = (task) => {
        const newTodos = [...todos, { id: nextId++, task, completed: false }];
        setTodos(newTodos);
        storeData(newTodos);
    };

    const toggleTaskCompletion = (id) => {
        const updatedTodos = todos.map((todo) =>
            todo.id === id ? { ...todo, completed: !todo.completed } : todo
        );
        setTodos(updatedTodos);
        storeData(updatedTodos);
    };

    return (
        <View style={styles.container}>
            <MyAppbar />
            <AddTask onAddTask={addTask} />
            <TaskList tasks={todos} onToggleCompletion={toggleTaskCompletion} />
        </View>
    );
};

export default HomeScreen;
