import AsyncStorage from "@react-native-async-storage/async-storage";

const TODOS_KEY = "todos";

export const storeData = async (todos) => {
    try {
        await AsyncStorage.setItem(TODOS_KEY, JSON.stringify(todos));
    } catch (e) {
        console.error("Error saving todos", e);
    }
};

export const getData = async () => {
    try {
        const value = await AsyncStorage.getItem(TODOS_KEY);
        return value ? JSON.parse(value) : null;
    } catch (e) {
        console.error("Error loading todos", e);
    }
};
